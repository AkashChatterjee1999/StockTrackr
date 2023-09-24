package com.stocktrackr.api.v100.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/insights")
public class InsightControllers {

    @GetMapping(path = "/detailed")
    public void getDetailedInsights() {}

    @GetMapping(path = "/crypto")
    public void getCryptoInsightsRt() {}

    @GetMapping(path = "/stock")
    public void getStocksInsightsRt() {}

    @GetMapping(path = "/stock/{stockSymbol}")
    public void getStockCandleViewRt(@PathVariable String stockSymbol) {}

}
