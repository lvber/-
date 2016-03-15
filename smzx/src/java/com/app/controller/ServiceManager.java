/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Service;
import com.app.model.ServiceDAO;
import java.util.ArrayList;

/**
 *
 * @author lvbowen
 */
public class ServiceManager {

    public static void add(String name, double price, String type) {
        ServiceDAO.add(name, price, type);
    }

    public static ArrayList<Service> retrieveAll() {
        return ServiceDAO.retrieveAll();
    }

    public static void update(int id, String detail, double price, String type) {
        ServiceDAO.update(id, detail, price, type);

    }
}
