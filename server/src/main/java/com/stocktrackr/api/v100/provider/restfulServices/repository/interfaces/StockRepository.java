package com.stocktrackr.api.v100.provider.restfulServices.repository.interfaces;

import com.stocktrackr.api.v100.provider.data.enums.models.StockPrice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.stocktrackr.api.v100.provider.models.*;

@Repository
public interface StockRepository extends CrudRepository<StockPrice, Long> { }