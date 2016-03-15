/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Product;
import com.app.model.ProductDAO;
import java.util.ArrayList;

/**
 *
 * @author lvbowen
 */
public class ProductManager {
    public static ArrayList<Product> retrieveAll(){
        return ProductDAO.getAllProducts();
    }
}
