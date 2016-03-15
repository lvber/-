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
public class PrinterMessage {

    private String brand;
    private String phone;
    private int orderId;
    private Timestamp timestamp;
    private String detail;
    private double price;
    private String paymentType;
    private String staffName;
    private int cardNumber;
    private double balance;

    public PrinterMessage() {
        this.brand = "尚美造型";
        this.phone = "15129223353";
    }

    public PrinterMessage(int orderId, Timestamp timestamp, String detail, double price, String paymentType, String staffName, int cardNumber, double balance) {
        this.brand = "尚美造型";
        this.phone = "15129223353";
        this.orderId = orderId;
        this.timestamp = timestamp;
        this.detail = detail;
        this.price = price;
        this.paymentType = paymentType;
        this.staffName = staffName;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public String getPhone() {
        return phone;
    }

    public String getBrand() {
        return brand;
    }

    public int getOrderId() {
        return orderId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getDetail() {
        return detail;
    }

    public double getPrice() {
        return price;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getStaffName() {
        return staffName;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
