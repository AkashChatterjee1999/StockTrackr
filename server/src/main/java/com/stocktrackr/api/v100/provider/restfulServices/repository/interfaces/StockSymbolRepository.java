package com.stocktrackr.api.v100.provider.restfulServices.repository.interfaces;

import com.stocktrackr.api.v100.provider.data.enums.models.StockSymbol;
import org.springframework.data.repository.CrudRepository;

public interface StockSymbolRepository extends CrudRepository<StockSymbol, Long> {
    StockSymbol findBySymbol(String stockSymbol);
}
