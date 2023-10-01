package com.stocktrackr.api.v100.provider.restfulServices.service;

import com.stocktrackr.api.v100.provider.data.enums.OrderType;
import com.stocktrackr.api.v100.provider.domain.exceptions.StockTrackrBaseException;
import com.stocktrackr.api.v100.provider.restfulServices.repository.StockRepository;
import com.stocktrackr.api.v100.provider.restfulServices.response.stockResponses.AllOrdersResponse;
import com.stocktrackr.api.v100.provider.restfulServices.response.stockResponses.AllStockSymbolsResponse;
import com.stocktrackr.api.v100.provider.restfulServices.response.stockResponses.GenreicStatusResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class StockService {

    private final StockRepository stockRepositoryInstance;
    StockService(StockRepository stockRepositoryInstance) { this.stockRepositoryInstance = stockRepositoryInstance; }

    public AllStockSymbolsResponse searchStockSymbols(@RequestParam(name = "like") String like) throws StockTrackrBaseException {

    }

    @PostMapping(path = "/subscribe")
    public GenreicStatusResponse subscribeStock(@RequestBody String stockSymbol) {}

    @GetMapping(path = "/subscribed")
    public AllStockSymbolsResponse getAllSubscribeStocks(@RequestBody String stockSymbol,
                                      @RequestParam(name = "stockType") @Nullable String stockType) {}

    @PostMapping(path = "/order")
    public GenreicStatusResponse createOrder(@RequestBody String stockSymbol, @RequestBody int quantity, @RequestBody OrderType orderType,
                            @RequestBody boolean isMarketPriceOrder, @RequestBody boolean isTargetedHigh,
                            @RequestBody float targetedPrice) {}

    @GetMapping(path = "/order")
    public AllOrdersResponse getOrders() {}

    @PutMapping(path = "/order/{orderID}/cancel")
    public GenreicStatusResponse cancelOrder(@PathVariable String orderID) {}

    @PostMapping(path = "/alert")
    public GenreicStatusResponse registerStockAlert() {}

    @PutMapping(path = "/alert/{alertID}")
    public GenreicStatusResponse updateStockAlert(@PathVariable String alertID, @RequestBody(required = false) Float priceForAlert,
                                 @RequestBody(required = false) Boolean isGoDownAlert,
                                 @RequestBody(required = false) Boolean toDeactivate) {}

}
