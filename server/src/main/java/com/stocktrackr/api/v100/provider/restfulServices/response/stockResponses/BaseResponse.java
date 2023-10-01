package com.stocktrackr.api.v100.provider.restfulServices.response.stockResponses;

import com.stocktrackr.api.v100.provider.domain.exceptions.StockTrackrBaseException;

public class BaseResponse<T> {

    String status;
    String errorCode;
    String errorDescription;
    T response;

    BaseResponse(StockTrackrBaseException exception) {
        this.status = "ERROR";
        this.errorCode = exception.getErrorMessage();
        this.errorDescription = exception.getErrorDescription();
    }

    public BaseResponse(T response) {
        this.status = "SUCCESS";
        this.response = response;
    }

}
