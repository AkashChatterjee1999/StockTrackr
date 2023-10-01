package com.stocktrackr.api.v100.controllers;

import com.stocktrackr.api.v100.socket.SocketMapping;
import com.stocktrackr.api.v100.socket.StockTrackrSocketHandler;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;

import java.io.IOException;

public class InsightControllers {

    @SocketMapping(path = "/socket-api/v1/insights/detailed")
    public void getDetailedInsights(String URI, WebSocketMessage<?> message) throws IOException {
        WebSocketMessage<?> ms = new TextMessage("hello world");
        StockTrackrSocketHandler.socketMappings.get("/socket-api/v1/insights/detailed")
                .getFirst().sendMessage(ms);
    }

    @SocketMapping(path = "/socket-api/v1/insights/crypto")
    public void getCryptoInsightsRt(String URI, WebSocketMessage<?> message) throws IOException {
        WebSocketMessage<?> ms = new TextMessage("Hello sweet heart, Dipannita, My Tatun !!");
        StockTrackrSocketHandler.socketMappings.get("/socket-api/v1/insights/crypto")
                .getFirst().sendMessage(ms);
    }

    @SocketMapping(path = "/socket-api/v1/insights/stock")
    public void getStocksInsightsRt(String URI, WebSocketMessage<?> message) throws IOException {
        WebSocketMessage<?> ms = new TextMessage("hello world");
        StockTrackrSocketHandler.socketMappings.get("/socket-api/v1/insights/stock")
                .getFirst().sendMessage(ms);
    }

    @SocketMapping(path = "/socket-api/v1/insights/stock/ohlc")
    public void getStockCandleViewRt(String URI, WebSocketMessage<?> message) throws IOException {
        WebSocketMessage<?> ms = new TextMessage("hello world");
        StockTrackrSocketHandler.socketMappings.get("/socket-api/v1/insights/stock/ohlc")
                .getFirst().sendMessage(ms);
    }

}
