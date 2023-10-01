package com.stocktrackr.api.v100.provider.restfulServices.response.stockResponses;

import com.stocktrackr.api.v100.provider.data.enums.models.StockSymbol;

import java.util.List;

public class AllStockSymbolsResponse {

    public List<StockSymbol> allStocks;
    public AllStockSymbolsResponse(List<StockSymbol> allStocks) { this.allStocks = allStocks; }

}
