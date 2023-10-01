package com.stocktrackr.api.v100.provider.realtimeServices.messaging;

import com.stocktrackr.api.v100.client.StockPriceResponse;
import com.stocktrackr.api.v100.provider.realtimeServices.websocket.controllers.InsightControllers;
import com.stocktrackr.api.v100.provider.domain.utils.Pair;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.socket.TextMessage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class KafkaMessageConsumer {

    private Map<String, Pair<Long, StockPriceResponse>> minuteInstancePriceCandle = new HashMap<>();

    public void messageProcessor(String message, KafkaMessageProducer.Topics topic) {
        StockPriceResponse response = StockPriceResponse.deserialize(message);
        if(!this.minuteInstancePriceCandle.containsKey(response.stockSymbol)) {
            response.openPrice = response.currentPrice;
            this.minuteInstancePriceCandle.put(response.stockSymbol, new Pair<>(
                    System.currentTimeMillis(), new StockPriceResponse(response.currentPrice, response.previousClosePrice,
                    response.currentPrice, response.currentPrice, 0.00f, response.stockSymbol)));
        } else if (!response.isNull()) {
            StockPriceResponse previousStockPrice = this.minuteInstancePriceCandle.get(response.stockSymbol).getSecondValue();
            if (System.currentTimeMillis() - this.minuteInstancePriceCandle.get(response.stockSymbol).getFirstValue() >= 60000) {
                StockPriceResponse newCandleResponse = new StockPriceResponse(response.currentPrice, previousStockPrice.currentPrice,
                        response.currentPrice, response.currentPrice, 0.00f, response.stockSymbol);
                newCandleResponse.openPrice = response.currentPrice;
                this.minuteInstancePriceCandle.put(response.stockSymbol, new Pair<>(System.currentTimeMillis(), newCandleResponse));

                // Hence, we got a candle (previousStockPrice) at this point
                // Once we gert that we can supply it to a websocket (for candle) and write to DB
                InsightControllers.getEntityPriceCandleBarSubscribers(response.stockSymbol).forEach(session -> {
                    if(session.isOpen()) {
                        try { session.sendMessage(new TextMessage(response.toString())); }
                        catch (IOException e) { e.printStackTrace(); }
                    }
                });
                // TODO: add a DBWriter call (2nd) here.

            } else {
                previousStockPrice.currentPrice = response.currentPrice;
                previousStockPrice.highPrice = Math.max(previousStockPrice.highPrice, response.currentPrice);
                previousStockPrice.lowPrice = Math.min(previousStockPrice.lowPrice, response.currentPrice);
                previousStockPrice.deltaChange = (float) (Math.round(
                        ((response.currentPrice - previousStockPrice.previousClosePrice) / previousStockPrice.previousClosePrice) * 100.0 * 100.0) / 100.0
                );
            }
        }

        // if this message a @notNull message then sent that to webSocket as well
        if(!response.isNull()) {
            // get all the available websocket connection for this stockSymbol
            // and then iterate over them and notify them (yes iterate)
            InsightControllers.getEntityPriceSubscribers(response.stockSymbol).forEach(session -> {
                if(session.isOpen()) {
                    try { session.sendMessage(new TextMessage(response.toString())); }
                    catch (IOException e) { e.printStackTrace(); }
                }
            });
        }

    }

    @KafkaListener(id = "myGroup", topics = "REGULAR")
    public void regularStockPriceListener(String in) {
        messageProcessor(in, KafkaMessageProducer.Topics.REGULAR_STOCK);
    }

    @KafkaListener(id = "myGroup", topics = "CRYPTO")
    public void regularCryptoPriceListener(String in) {
        messageProcessor(in, KafkaMessageProducer.Topics.CRYPTO);
    }

}
