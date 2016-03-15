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
public class Order {

    private int id;
    private Timestamp timestamp;
    private int staffId;
    private int staffId2;
    private int cardNumber;
    private int serviceId;
    private double amount;
    private String type;

    public Order(int id, Timestamp timestamp, int staffId, int staffId2, int cardNumber, int serviceId, double amount, String type) {
        this.id = id;
        this.timestamp = timestamp;
        this.staffId = staffId;
        this.staffId2 = staffId2;
        this.cardNumber = cardNumber;
        this.serviceId = serviceId;
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

    public int getStaffId2() {
        return staffId2;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public int getServiceId() {
        return serviceId;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}
