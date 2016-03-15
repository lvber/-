/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Staff;
import com.app.model.StaffDAO;
import java.util.ArrayList;

/**
 *
 * @author lvbowen
 */
public class StaffManager {
    
    public static ArrayList<Staff> getAll(){
        return StaffDAO.getAll();
    }
    
    public static void add(String name, String gender, String phone, double salary, String status) {
        StaffDAO.add(name, gender, phone,salary, status);
    }
    
    public static void update(int id2, String name, String gender, String phone, double salary, String status) {
        StaffDAO.update(id2, name, gender, phone,salary, status);
    }
    
}
