package com.stocktrackr.api.v100.provider.restfulServices.repository.interfaces;

import com.stocktrackr.api.v100.provider.data.enums.models.StockPriceHistory;
import org.springframework.data.repository.CrudRepository;
import com.stocktrackr.api.v100.provider.models.*;

public interface StockPriceHistoryRepository extends CrudRepository<StockPriceHistory, Long> { }
