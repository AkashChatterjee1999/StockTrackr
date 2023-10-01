package com.stocktrackr.api.v100.provider.realtimeServices.websocket;

public class InvalidSocketConfigException extends Exception {

    InvalidSocketConfigException() {
        super("InvalidSocketConfigException: The socket handler mappings are  invalid, please retry");
    }
}
