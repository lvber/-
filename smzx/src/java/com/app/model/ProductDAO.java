/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.controller.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Wang Ziteng
 */
public class ProductDAO {
    public static void add(String name, double cost, double moneyTaken) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        String sql = "insert into product (name, cost, moneytaken) values (?,?,?) ";
        try {
            conn = ConnectionManager.getConnection();

            preStmt = conn.prepareStatement(sql);

            preStmt.setString(1, name);
            preStmt.setDouble(2, cost);
            preStmt.setDouble(3, moneyTaken);
            preStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt);
        }
    }
    
    public static ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        String sql = "select * from product ";
        try {
            conn = ConnectionManager.getConnection();

            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double cost = rs.getDouble(3);
                double moneyTaken = rs.getDouble(4);
                //ArrayList<String> services = ProductAndServiceDAO.retrieveByProductId(id);
                
                products.add(new Product(id, name, cost, moneyTaken));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt);
        }
        return products;
    }
    
    public static void update(int id, String name, double cost, double moneyTaken) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        String sql = "update product set name = ?, cost=?,moneytaken=?  where id = ? ";
        try {
            conn = ConnectionManager.getConnection();

            preStmt = conn.prepareStatement(sql);

            preStmt.setString(1, name);
            preStmt.setDouble(2, cost);
            preStmt.setDouble(3, moneyTaken);
            preStmt.setInt(4, id);
            preStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt);
        }
        
    }
    
    
    
    public static void delete(int id) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        String sql = "delete from product where id = ? ";
        try {
            conn = ConnectionManager.getConnection();
            preStmt = conn.prepareStatement(sql);
            preStmt.setDouble(1, id);
            preStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt);
        }
        
    }
    
    public static Product retrieveById(int productId) {
        Product product = null;
        
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        String sql = "select * from product where id = ?";
        try {
            conn = ConnectionManager.getConnection();

            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, productId);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double cost = rs.getDouble(3);
                double moneyTaken = rs.getDouble(4);
               // ArrayList<String> services = ProductAndServiceDAO.retrieveByProductId(id);
                
                product = new Product(id, name, cost, moneyTaken);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt);
        }
        return product;
        
    }
    
    public static int getProductId(String name) {
        int id = -1;
        
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        String sql = "select id from product where name = ? ";
        try {
            conn = ConnectionManager.getConnection();

            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1,name);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt);
        }
        return id;
        
    }
    
    public static double retrieveMoneyTakenByProductId(int id) {
        double moneyTaken = 0.0;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        String sql = "select moneyTaken from product where id = ? ";
        try {
            conn = ConnectionManager.getConnection();

            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1,id);
            rs = preStmt.executeQuery();
            while (rs.next()) {
                moneyTaken = rs.getInt(1);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt);
        }
        return moneyTaken;
    }
}

