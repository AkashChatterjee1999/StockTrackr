package com.stocktrackr.api.v100.provider.restfulServices.repository;

import com.stocktrackr.api.v100.provider.data.enums.models.StockSymbol;
import com.stocktrackr.api.v100.provider.restfulServices.repository.interfaces.StockSymbolRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StockRepository {

    @Autowired
    private StockSymbolRepository stockSymbolRepo;

    StockRepository(StockSymbolRepository stockSymbolRepo) {
        this.stockSymbolRepo = stockSymbolRepo;
    }

    public List<StockSymbol> getAllStockSymbols() {
        return (List<StockSymbol>) this.stockSymbolRepo.findAll();
    }

    public StockSymbol getStockSymbol(String stockSymbol) {
        return this.stockSymbolRepo.findBySymbol(stockSymbol);
    }


}
