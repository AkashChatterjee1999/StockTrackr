package com.stocktrackr.api.v100.socket;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface SocketMapping {
    String path() default "";
}
