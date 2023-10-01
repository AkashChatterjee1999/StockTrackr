package com.stocktrackr.api.v100.provider.restfulServices.repository.interfaces;

import com.stocktrackr.api.v100.provider.data.enums.models.StockPrice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockPriceRepository extends CrudRepository<StockPrice, Long> { }