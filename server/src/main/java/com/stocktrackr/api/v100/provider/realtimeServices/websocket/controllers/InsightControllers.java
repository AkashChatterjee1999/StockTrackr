package com.stocktrackr.api.v100.provider.realtimeServices.websocket.controllers;

import com.stocktrackr.api.v100.provider.realtimeServices.websocket.RealtimeStockSubscriberRequest;
import com.stocktrackr.api.v100.provider.realtimeServices.websocket.SocketMapping;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InsightControllers {

    private static HashMap<String, ArrayList<WebSocketSession>> entityPriceSubscribers = new HashMap<>();
    private static HashMap<String, ArrayList<WebSocketSession>> candleBarsSubscribers = new HashMap<>();

    private InsightControllers(){}

    // provides realtime connection for getting stock price of any symbol
    @SocketMapping(path = "/realtime/v1/entityPrice")
    public void subscribeToEntityPrice(WebSocketSession session, WebSocketMessage<String> message) throws IOException {
        try {
            RealtimeStockSubscriberRequest requestBody = RealtimeStockSubscriberRequest.deserialize(message.getPayload());
            synchronized (InsightControllers.class) {

                // TODO: check whether this stockSymbol is valid or not...

                if(!entityPriceSubscribers.containsKey(requestBody.stockSymbol))
                    entityPriceSubscribers.put(requestBody.stockSymbol, new ArrayList<>());
                entityPriceSubscribers.get(requestBody.stockSymbol).add(session);
            }
            session.sendMessage(new TextMessage("Subscribed Successfully!"));
        } catch(Exception err) { session.sendMessage(new TextMessage("Invalid stockSymbol")); }
    }

    @SocketMapping(path = "/realtime/v1/stockCandles")
    public void subscribeToStockCandles(WebSocketSession session, WebSocketMessage<String> message) throws IOException {
        // check from the list of stockSymbol (all regular, crypto everything)
        // if not then say not valid, else say subscribed
        try {
            RealtimeStockSubscriberRequest requestBody = RealtimeStockSubscriberRequest.deserialize(message.getPayload());
            synchronized (InsightControllers.class) {

                // TODO: check whether this stockSymbol is valid or not...

                if(!candleBarsSubscribers.containsKey(requestBody.stockSymbol))
                    candleBarsSubscribers.put(requestBody.stockSymbol, new ArrayList<>());
                candleBarsSubscribers.get(requestBody.stockSymbol).add(session);
            }
            session.sendMessage(new TextMessage("Subscribed Successfully!"));
        } catch(Exception err) { session.sendMessage(new TextMessage("Invalid stockSymbol")); }

    }

    public static List<WebSocketSession> getEntityPriceSubscribers(String stockSymbol) {
        if(entityPriceSubscribers.containsKey(stockSymbol))
            return entityPriceSubscribers.get(stockSymbol);
        else return new ArrayList<>();
    }

    public static List<WebSocketSession> getEntityPriceCandleBarSubscribers(String stockSymbol) {
        if(candleBarsSubscribers.containsKey(stockSymbol))
            return candleBarsSubscribers.get(stockSymbol);
        else return new ArrayList<>();
    }

}
