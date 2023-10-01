package com.stocktrackr.api.v100.client;

import com.stocktrackr.api.v100.provider.realtimeServices.messaging.KafkaMessageProducer;
import com.stocktrackr.api.v100.provider.domain.utils.Utils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class StockPriceFetcher implements CurrentEntityPriceFetcher {

    private static final int limit = 5000;
    private final String stockSymbol;
    private final KafkaMessageProducer.Topics kafkaTopicName;
    private final KafkaMessageProducer producer;

    StockPriceFetcher(String stockSymbol, KafkaMessageProducer.Topics kafkaTopicName){
        this.stockSymbol = stockSymbol;
        this.kafkaTopicName = kafkaTopicName;
        this.producer = KafkaMessageProducer.getInstance();
    }

    @Override
    public void run() {
        StockPriceResponse price = this.fetchPrice();
        this.producer.sendMessage(this.kafkaTopicName, this.stockSymbol, price);
    }

    @Override
    public StockPriceResponse fetchPrice() {
        try {
            Document doc = Jsoup.connect("https://www.google.com/finance/quote/" + this.stockSymbol).get();

            String currentPriceStr = doc.selectXpath("/html/body/c-wiz[2]/div/div[4]/div/main/div[2]/div[1]/div[1]/c-wiz/div/div[1]/div/div[1]/div/div[1]/div/span/div/div").text();
            if(currentPriceStr.equals("")) currentPriceStr = "0.00";

            String previousClosePriceStr = doc.selectXpath("/html/body/c-wiz[2]/div/div[4]/div/main/div[2]/div[2]/div/div/div[2]/div").text();
            if(previousClosePriceStr.equals("")) previousClosePriceStr = "0.00";

            String[] priceRangeStr = doc.selectXpath("/html/body/c-wiz[2]/div/div[4]/div/main/div[2]/div[2]/div/div/div[3]/div").text().split(" - ");
            if(priceRangeStr.length < 2) priceRangeStr = new String[]{"0.00", "0.00"};
            System.gc();

            String highPriceStr = "", lowPriceStr = "";
            highPriceStr = priceRangeStr[0];
            lowPriceStr = priceRangeStr[1];

            float currentPrice = Utils.sanitizeStringAndGetFloat(currentPriceStr);
            float previousClosePrice = Utils.sanitizeStringAndGetFloat(previousClosePriceStr);
            float highPrice = Utils.sanitizeStringAndGetFloat(highPriceStr);
            float lowPrice = Utils.sanitizeStringAndGetFloat(lowPriceStr);
            float deltaChange = (float) (Math.round(((currentPrice - previousClosePrice)/previousClosePrice)*100.0*100.0)/100.0);

            return new StockPriceResponse(currentPrice, previousClosePrice, highPrice, lowPrice, deltaChange, this.stockSymbol);
        } catch(Exception err) {
            err.printStackTrace();
            return new StockPriceResponse(0.00f, 0.00f, 0.00f, 0.00f, 0.00f, this.stockSymbol);
        }
    }

}
