package com.stocktrackr.api.v100.entities;

import com.stocktrackr.api.v100.enums.OrderStatus;
import com.stocktrackr.api.v100.enums.OrderType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "stockOrders")
public class StockOrder {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long ID;

    // foreign key
    @Column(name = "stockSymbolID", nullable = false) private Long stockSymbolID;
    // foreign key
    @Column(name = "userID", nullable = false) private Long userID;
    @Column(name = "quantity", nullable = false) private int quantity;
    @Column(name = "orderType", nullable = false) private OrderType orderType;
    @Column(name = "isMarketPriceOrder") private boolean isMarketPriceOrder;
    @Column(name = "isTargetedHigh") private boolean isTargetedHigh;
    @Column(name = "targetedPrice") private float targetedPrice;
    @Column(name = "purchasedDateTime", nullable = false) private Date purchasedDateTime;
    @Column(name = "orderStatus", nullable = false) private OrderStatus orderStatus;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public boolean isMarketPriceOrder() {
        return isMarketPriceOrder;
    }

    public void setMarketPriceOrder(boolean marketPriceOrder) {
        isMarketPriceOrder = marketPriceOrder;
    }

    public boolean isTargetedHigh() {
        return isTargetedHigh;
    }

    public void setTargetedHigh(boolean targetedHigh) {
        isTargetedHigh = targetedHigh;
    }

    public float getTargetedPrice() {
        return targetedPrice;
    }

    public void setTargetedPrice(float targetedPrice) {
        this.targetedPrice = targetedPrice;
    }

    public Date getPurchasedDateTime() {
        return purchasedDateTime;
    }

    public void setPurchasedDateTime(Date purchasedDateTime) {
        this.purchasedDateTime = purchasedDateTime;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
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
