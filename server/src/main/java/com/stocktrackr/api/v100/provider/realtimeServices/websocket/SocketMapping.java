package com.stocktrackr.api.v100.provider.realtimeServices.websocket;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SocketMapping {
    String path() default "";
}
