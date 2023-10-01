package com.stocktrackr.api.v100.provider.restfulServices.repository.interfaces;

import com.stocktrackr.api.v100.provider.data.enums.models.StockSymbol;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockSymbolRepository extends CrudRepository<StockSymbol, Long> {
    StockSymbol findBySymbol(String stockSymbol);
    List<StockSymbol> findStockSymbolsByNameContainingIgnoreCaseOrderByID(String like);
}
