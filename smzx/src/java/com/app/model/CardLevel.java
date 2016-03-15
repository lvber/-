/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

/**
 *
 * @author Wang Ziteng
 */
public class CardLevel {
    String type;
    double discount;
    int minCharge;
    
    public CardLevel(String type, double discount, int minCharge) {
        this.type = type;
        this.discount = discount;
        this.minCharge = minCharge;
    }
    
    public String getType() {
        return type;
    }
    
    public double getDiscount() {
        return discount;
    }
    
    public int getMinCharge() {
        return minCharge;
    }
    
    public void setCardType(String type) {
        this.type = type;
    }
    
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    public void setMinCharge(int minCharge) {
        this.minCharge = minCharge;
    }
}
