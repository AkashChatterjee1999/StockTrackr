package com.stocktrackr.api.v100.provider.data.enums.models;


import com.stocktrackr.api.v100.provider.data.enums.StockType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Time;
import java.util.Date;
import java.util.TimeZone;


@Entity
@Table(name = "stockSymbols")
public class StockSymbol {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID;

    @Column(name = "name", nullable = false) private String name;
    @Column(name = "symbol", nullable = false, unique = true) private String symbol;
    @Column(name = "region", nullable = false) private String region;
    @Column(name = "gmtMarketOpenTime", nullable = false)  private Time gmtMarketOpenTime;
    @Column(name = "gmtMarketCloseTime", nullable = false) private Time gmtMarketCloseTime;
    @Column(name = "marketTimezone", nullable = false) private TimeZone timezone;
    @Column(name = "stockType", nullable = false) private StockType stockType;
    @Column(name = "currency", nullable = false) private String currency;
    @Column(name = "sector", nullable = false) private String sector;
    @Column(name = "createdAt", nullable = false) @CreationTimestamp private Date createdAt;
    @Column(name = "updatedAt", nullable = false) @UpdateTimestamp private Date updatedAt;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getGmtMarketOpenTime() {
        return gmtMarketOpenTime;
    }

    public void setGmtMarketOpenTime(Time gmtMarketOpenTime) {
        this.gmtMarketOpenTime = gmtMarketOpenTime;
    }

    public Date getGmtMarketCloseTime() {
        return gmtMarketCloseTime;
    }

    public void setGmtMarketCloseTime(Time gmtMarketCloseTime) {
        this.gmtMarketCloseTime = gmtMarketCloseTime;
    }

    public TimeZone getTimezone() {
        return timezone;
    }

    public void setTimezone(TimeZone timezone) {
        this.timezone = timezone;
    }

    public StockType getStockType() {
        return stockType;
    }

    public void setStockType(StockType stockType) {
        this.stockType = stockType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
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
