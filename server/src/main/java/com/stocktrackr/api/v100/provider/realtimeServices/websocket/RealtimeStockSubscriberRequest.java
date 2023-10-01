package com.stocktrackr.api.v100.provider.realtimeServices.websocket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RealtimeStockSubscriberRequest {

    public String stockSymbol;

    RealtimeStockSubscriberRequest(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    @Override
    public String toString() {
        return "{" +
                "\n \"stockSymbol\": \"" + stockSymbol + "\"" +
                "\n}";
    }

    public static RealtimeStockSubscriberRequest deserialize(String jsonifiedResponse) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson.fromJson(jsonifiedResponse, RealtimeStockSubscriberRequest.class);
    }

}
