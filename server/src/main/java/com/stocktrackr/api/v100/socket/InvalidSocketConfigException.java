package com.stocktrackr.api.v100.socket;

public class InvalidSocketConfigException extends Exception {

    InvalidSocketConfigException() {
        super("InvalidSocketConfigException: The socket handler mappings are  invalid, please retry");
    }
}
