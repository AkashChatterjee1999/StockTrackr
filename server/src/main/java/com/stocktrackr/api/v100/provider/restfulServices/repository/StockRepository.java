package com.stocktrackr.api.v100.provider.restfulServices.repository;

import com.stocktrackr.api.v100.provider.data.enums.models.StockSymbol;
import com.stocktrackr.api.v100.provider.restfulServices.repository.interfaces.StockSymbolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockRepository {

    private StockSymbolRepository stockSymbolRepo;
    StockRepository(StockSymbolRepository stockSymbolRepo) {
        this.stockSymbolRepo = stockSymbolRepo;
    }

    public List<StockSymbol> getAllStockSymbols() {
        return (List<StockSymbol>) this.stockSymbolRepo.findAll();
    }

    public List<StockSymbol> getFilteredStockSymbols(String ilike) {
        return this.stockSymbolRepo.findStockSymbolsByNameContainingIgnoreCaseOrderByID(ilike);
    }

    public StockSymbol getStockSymbol(String stockSymbol) {
        return this.stockSymbolRepo.findBySymbol(stockSymbol);
    }


}
