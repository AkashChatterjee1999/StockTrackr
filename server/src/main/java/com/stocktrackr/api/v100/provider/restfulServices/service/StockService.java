package com.stocktrackr.api.v100.provider.restfulServices.service;

import com.stocktrackr.api.v100.provider.data.enums.OrderType;
import com.stocktrackr.api.v100.provider.data.enums.models.StockSymbol;
import com.stocktrackr.api.v100.provider.domain.exceptions.StockTrackrBaseException;
import com.stocktrackr.api.v100.provider.restfulServices.repository.StockRepository;
import com.stocktrackr.api.v100.provider.restfulServices.response.stockResponses.AllOrdersResponse;
import com.stocktrackr.api.v100.provider.restfulServices.response.stockResponses.AllStockSymbolsResponse;
import com.stocktrackr.api.v100.provider.restfulServices.response.stockResponses.GenreicStatusResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Service
public class StockService {

    private final StockRepository stockRepositoryInstance;
    StockService(StockRepository stockRepositoryInstance) { this.stockRepositoryInstance = stockRepositoryInstance; }

    public AllStockSymbolsResponse searchStockSymbols(String like) {
        List<StockSymbol> allStockSymbols;
        if(Objects.equals(like, "")) allStockSymbols = this.stockRepositoryInstance.getAllStockSymbols();
        else allStockSymbols = this.stockRepositoryInstance.getFilteredStockSymbols(like);
        return new AllStockSymbolsResponse(allStockSymbols);
    }

//    public GenreicStatusResponse subscribeStock(@RequestBody String stockSymbol) {}
//
//    public AllStockSymbolsResponse getAllSubscribeStocks(@RequestBody String stockSymbol,
//                                      @RequestParam(name = "stockType") @Nullable String stockType) {}
//
//    public GenreicStatusResponse createOrder(@RequestBody String stockSymbol, @RequestBody int quantity, @RequestBody OrderType orderType,
//                            @RequestBody boolean isMarketPriceOrder, @RequestBody boolean isTargetedHigh,
//                            @RequestBody float targetedPrice) {}
//
//    public AllOrdersResponse getOrders() {}
//
//    public GenreicStatusResponse cancelOrder(@PathVariable String orderID) {}
//
//    public GenreicStatusResponse registerStockAlert() {}
//
//    public GenreicStatusResponse updateStockAlert(@PathVariable String alertID, @RequestBody(required = false) Float priceForAlert,
//                                 @RequestBody(required = false) Boolean isGoDownAlert,
//                                 @RequestBody(required = false) Boolean toDeactivate) {}

}
