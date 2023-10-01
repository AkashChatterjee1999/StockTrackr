package com.stocktrackr.api.v100.provider.restfulServices.controllers;


import com.stocktrackr.api.v100.provider.data.enums.OrderType;
import com.stocktrackr.api.v100.provider.domain.exceptions.AllStockTrackrExceptions;
import com.stocktrackr.api.v100.provider.domain.exceptions.StockTrackrBaseException;
import com.stocktrackr.api.v100.provider.restfulServices.response.stockResponses.AllOrdersResponse;
import com.stocktrackr.api.v100.provider.restfulServices.response.stockResponses.AllStockSymbolsResponse;
import com.stocktrackr.api.v100.provider.restfulServices.response.stockResponses.BaseResponse;
import com.stocktrackr.api.v100.provider.restfulServices.response.stockResponses.GenreicStatusResponse;
import com.stocktrackr.api.v100.provider.restfulServices.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/stocks")
public class StockControllers {

    private final StockService stockServiceInstance;
    StockControllers(StockService stockServiceInstance) { this.stockServiceInstance = stockServiceInstance; }

    @GetMapping(path = "/symbols")
    public BaseResponse<AllStockSymbolsResponse> getAllStockSymbols(@RequestParam(name = "like") @Nullable String ilike) {
        if(ilike == null) ilike = "";
        AllStockSymbolsResponse response = this.stockServiceInstance.searchStockSymbols(ilike.trim());
        return new BaseResponse<>(response);
    }

    @PostMapping(path = "/subscribe")
    public void subscribeStock(@RequestBody String stockSymbol) {}

    @GetMapping(path = "/subscribed")
    public void getAllSubscribeStocks(@RequestBody String stockSymbol,
                                                         @RequestParam(name = "stockType") @Nullable String stockType) {}

    @PostMapping(path = "/order")
    public void createOrder(@RequestBody String stockSymbol, @RequestBody int quantity, @RequestBody OrderType orderType,
                                             @RequestBody boolean isMarketPriceOrder, @RequestBody boolean isTargetedHigh,
                                             @RequestBody float targetedPrice) {}

    @GetMapping(path = "/order")
    public void getOrders() {}

    @PutMapping(path = "/order/{orderID}/cancel")
    public void cancelOrder(@PathVariable String orderID) {}

    @PostMapping(path = "/alert")
    public void registerStockAlert() {}

    @PutMapping(path = "/alert/{alertID}")
    public void updateStockAlert(@PathVariable String alertID, @RequestBody(required = false) Float priceForAlert,
                                                  @RequestBody(required = false) Boolean isGoDownAlert,
                                                  @RequestBody(required = false) Boolean toDeactivate) {}

}
