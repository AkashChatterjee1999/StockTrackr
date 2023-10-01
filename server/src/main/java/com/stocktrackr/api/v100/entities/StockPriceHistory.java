package com.stocktrackr.api.v100.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "stockPriceHistory")
public class StockPriceHistory {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID;

    // foreign key
    @Column(name = "stockSymbolID", nullable = false) private Long stockSymbolID;
    @Column(name = "openPrice", nullable = false) private float openPrice;
    @Column(name = "highPrice", nullable = false) private float highPrice;
    @Column(name = "lowPrice", nullable = false) private float lowPrice;
    @Column(name = "currentPrice", nullable = false) private float currentPrice;
    @Column(name = "percentChange") private float percentChange;
    @Column(name = "previousClose") private float previousClose;
    @Column(name = "createdAt", nullable = false) @CreationTimestamp private Date createdAt;
    @Column(name = "updatedAt", nullable = false) @UpdateTimestamp private Date updatedAt;


    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Long getStockSymbolID() {
        return stockSymbolID;
    }

    public void setStockSymbolID(Long stockSymbolID) {
        this.stockSymbolID = stockSymbolID;
    }

    public float getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(float openPrice) {
        this.openPrice = openPrice;
    }

    public float getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(float highPrice) {
        this.highPrice = highPrice;
    }

    public float getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(float lowPrice) {
        this.lowPrice = lowPrice;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public float getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(float percentChange) {
        this.percentChange = percentChange;
    }

    public float getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(float previousClose) {
        this.previousClose = previousClose;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }



}
