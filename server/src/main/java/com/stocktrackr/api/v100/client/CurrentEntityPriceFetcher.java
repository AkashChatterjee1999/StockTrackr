package com.stocktrackr.api.v100.client;

import java.io.IOException;

public interface CurrentEntityPriceFetcher extends Runnable {
    public StockPriceResponse fetchPrice();
}
