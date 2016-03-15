/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

/**
 *
 * @author lvbowen
 */
public class Member {
    private int cardNumber;
    private String name;
    private String gender;
    private String phoneNumber;
    private String type;
    private double balance;

    public Member(int cardNumber, String name, String gender, String phoneNumber, String type, double balance) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.balance = balance;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBalence(double balance) {
        this.balance = balance;
    }
    
    
}
