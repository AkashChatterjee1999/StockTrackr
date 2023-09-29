package com.stocktrackr.api.v100.provider.utils;

public class Pair<F, V> {

    private final F firstValue;
    private final V secondValue;

    public Pair(F first, V second) {
        this.firstValue = first;
        this.secondValue = second;
    }

    public F getFirstValue() { return firstValue; }
    public V getSecondValue() { return secondValue; }
}
