/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import java.sql.Timestamp;

/**
 *
 * @author lvbowen
 */
public class ProductOrder {
    
    private int id;
    private Timestamp timestamp;
    private int staffId;
    private int cardNumber;
    private int productId;
    private double amount;
    private String type;

    public ProductOrder(int id, Timestamp timestamp, int staffId, int cardNumber, int productId, double amount, String type) {
        this.id = id;
        this.timestamp = timestamp;
        this.staffId = staffId;
        this.cardNumber = cardNumber;
        this.productId = productId;
        this.amount = amount;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public int getStaffId() {
        return staffId;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getProductId() {
        return productId;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
    
    
}
