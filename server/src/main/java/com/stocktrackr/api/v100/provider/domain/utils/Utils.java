package com.stocktrackr.api.v100.provider.domain.utils;

public class Utils {

    public static Float sanitizeStringAndGetFloat(String s) {
        StringBuilder res = new StringBuilder();
        for(char x: s.toCharArray()) {
            if(Character.isDigit(x) || x == '.') res.append(x);
        }
        return Float.parseFloat(res.toString());
    }

}
