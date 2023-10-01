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
    public BaseResponse<?> searchStockSymbols(@RequestParam(name = "like") String like) {
        try {
            if(like == null) like = "";
            AllStockSymbolsResponse response = this.stockServiceInstance.searchStockSymbols(like.trim());
            return new BaseResponse<>(response);

        } catch(Exception err) {
            if(err instanceof StockTrackrBaseException) return new BaseResponse<>(err);
            else {
                err.printStackTrace();
                return new BaseResponse<>(AllStockTrackrExceptions.unexpectedError);
            }
        }
    }

    @PostMapping(path = "/subscribe")
    public BaseResponse<?> subscribeStock(@RequestBody String stockSymbol) {}

    @GetMapping(path = "/subscribed")
    public BaseResponse<?> getAllSubscribeStocks(@RequestBody String stockSymbol,
                                                         @RequestParam(name = "stockType") @Nullable String stockType) {}

    @PostMapping(path = "/order")
    public BaseResponse<?> createOrder(@RequestBody String stockSymbol, @RequestBody int quantity, @RequestBody OrderType orderType,
                                             @RequestBody boolean isMarketPriceOrder, @RequestBody boolean isTargetedHigh,
                                             @RequestBody float targetedPrice) {}

    @GetMapping(path = "/order")
    public BaseResponse<?> getOrders() {}

    @PutMapping(path = "/order/{orderID}/cancel")
    public BaseResponse<?> cancelOrder(@PathVariable String orderID) {}

    @PostMapping(path = "/alert")
    public BaseResponse<?> registerStockAlert() {}

    @PutMapping(path = "/alert/{alertID}")
    public BaseResponse<?> updateStockAlert(@PathVariable String alertID, @RequestBody(required = false) Float priceForAlert,
                                                  @RequestBody(required = false) Boolean isGoDownAlert,
                                                  @RequestBody(required = false) Boolean toDeactivate) {}

}
