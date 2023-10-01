package com.stocktrackr.api.v100.provider.domain.exceptions;

public class AllStockTrackrExceptions {

    public static final StockTrackrBaseException invalidStockSymbol = new StockTrackrBaseException("invalidStockSymbol", "Stock Symbol supplied is not valid, please check");
    public static final StockTrackrBaseException unexpectedError = new StockTrackrBaseException("unexpectedError", "Some unexpected error has occurred");

}
