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
public class Topup {
    private Timestamp timestamp;
    private int cardNumber;
    private double amount;
    private String type;
    private int staffId;

    public Topup(Timestamp timestamp, int cardNumber, double amount, String type, int staffId) {
        this.timestamp = timestamp;
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.type = type;
        this.staffId = staffId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public int getStaffId() {
        return staffId;
    }
    
    
}
