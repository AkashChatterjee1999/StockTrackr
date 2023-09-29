package com.stocktrackr.api.v100.provider.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "stockAlerts")
public class StockAlert {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID;

    // foreign key
    @Column(name = "stockSymbolID", nullable = false) private Long stockSymbolID;
    // foreign key
    @Column(name = "userID", nullable = false) private Long userID;
    @Column(name = "priceForAlert", nullable = false) private float priceForAlert;
    @Column(name = "isGoDownAlert", nullable = false) private boolean isGoDownAlert;
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

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public float getPriceForAlert() {
        return priceForAlert;
    }

    public void setPriceForAlert(float priceForAlert) {
        this.priceForAlert = priceForAlert;
    }

    public boolean isGoDownAlert() {
        return isGoDownAlert;
    }

    public void setGoDownAlert(boolean goDownAlert) {
        isGoDownAlert = goDownAlert;
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
