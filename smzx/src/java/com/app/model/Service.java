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
public class Service {

    private int id;
    private String detail;
    private double price;
    private String type;

    public Service(int id, String detail, double price, String type) {
        this.id = id;
        this.detail = detail;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getDetail() {
        return detail;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
    
    
}
