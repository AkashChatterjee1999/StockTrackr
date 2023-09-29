package com.stocktrackr.api.v100.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class StockPriceResoponse {

    public String stockSymbol;
    public float currentPrice;
    public float previousClosePrice;
    public float highPrice;
    public float lowPrice;
    public float deltaChange;
    public float openPrice = 0.00f;

    StockPriceResoponse(float currentPrice, float previousClosePrice, float highPrice, float lowPrice,
                        float deltaChange, String stockSymbol) {
        this.stockSymbol = stockSymbol;
        this.currentPrice = currentPrice;
        this.previousClosePrice = previousClosePrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.deltaChange = deltaChange;
    }

    @Override
    public String toString() {
        return "{" +
                "\n \"stockSymbol\": \"" + stockSymbol + "\"" +
                ", \n \"currentPrice\": " + currentPrice +
                ", \n \"previousClosePrice\": " + previousClosePrice +
                ", \n \"highPrice\": " + highPrice +
                ", \n \"lowPrice\": " + lowPrice +
                ", \n \"deltaChange\": " + deltaChange +
                "\n}";
    }

    public boolean isNull() {
        return this.currentPrice == 0.00f && this.lowPrice == 0.00f && this.highPrice == 0.00f
                && this.deltaChange == 0.00f && this.previousClosePrice == 0.00f;
    }

    public static StockPriceResoponse deserialize(String jsonifiedResponse) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson.fromJson(jsonifiedResponse, StockPriceResoponse.class);
    }
}
