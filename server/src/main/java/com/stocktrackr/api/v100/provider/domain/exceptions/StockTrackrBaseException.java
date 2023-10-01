package com.stocktrackr.api.v100.provider.domain.exceptions;

public class StockTrackrBaseException extends Exception {

    private String errorMessage;
    private String errorDescription;

    StockTrackrBaseException(String errorMessage, String errorDescription) {
        this.errorMessage = errorMessage;
        this.errorDescription = errorDescription;
    }

    public String getErrorMessage() { return errorMessage; }
    public String getErrorDescription() { return errorDescription; }

    @Override
    public String toString() {
        return "StockTrackrBaseException {\n" +
                "errorMessage= '" + errorMessage + '\'' +
                "\n, errorDescription= '" + errorDescription + '\'' +
                "\n}\n\n";
    }
}
