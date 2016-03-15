/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import java.util.ArrayList;

/**
 *
 * @author Wang Ziteng
 */
public class Product {
    private int id;
    private String name;
    private double cost;
    private double moneyTaken;
    //ArrayList<String> serviceNames;
    
    public Product(int id, String name, double cost, double moneyTaken){
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.moneyTaken = moneyTaken;
        //this.serviceNames = serviceNames;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    //public void setMoneyTaken(double moneyTaken) {
    //    this.moneyTaken = moneyTaken;
    //}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public double getMoneyTaken() {
        return moneyTaken;
    }
    
   // public void addServiceName(ArrayList<String> services) {
    //    serviceNames = services;
    //}
    
    //public ArrayList<String> getServiceName() {
    //    return serviceNames;
   // }
    
    /*public boolean belongToServiceOrNot(String serviceName) {
        boolean belong = false;
        for(String service: serviceNames) {
            if(service.equals(serviceName)) {
                belong = true;
            }
        }
        return belong;
    }*/
}
