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
public class Staff {
    private int staffId;
    private String name;
    private String gender;
    private String phoneNumber;
    private String status;
    private double salary;
    
    public Staff(int staffId, String name, String gender, String phoneNumber, String status, double salary) {
        this.staffId = staffId;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.salary = salary;
    } 
    
    public int getStaffId() {
        return staffId;
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
    
    public String getStatus() {
        return status;
    }
    
    public void setStaffId(int staffId) {
        this.staffId = staffId;
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
    
    public void setStatus(String status) {
        this.status = status;
    }

    public double getSalary() {
        return salary;
    }
    
    
}
