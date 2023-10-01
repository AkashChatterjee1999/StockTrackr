package com.stocktrackr.api.v100.provider.restfulServices.response.stockResponses;

import com.stocktrackr.api.v100.provider.domain.exceptions.StockTrackrBaseException;

public class BaseResponse<T> {

    public String status;
    public String errorCode;
    public String errorDescription;
    public T response;

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
