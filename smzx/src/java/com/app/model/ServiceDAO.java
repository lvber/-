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
 * @author lvbowen
 */
public class ServiceDAO {

    public static void add(String detail, double price, String type) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        String sql = "insert into service (detail, price, type) values (?,?,?) ";
        try {
            conn = ConnectionManager.getConnection();

            preStmt = conn.prepareStatement(sql);

            preStmt.setString(1, detail);
            preStmt.setDouble(2, price);
            preStmt.setString(3, type);
            preStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt);
        }
    }

    public static ArrayList<Service> retrieveAll() {
        ArrayList<Service> services = new ArrayList<Service>();

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        String sql = "select * from service";
        try {
            conn = ConnectionManager.getConnection();
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String detail = rs.getString(2);
                double price = rs.getDouble(3);
                String type = rs.getString(4);
                Service service = new Service(id, detail, price, type);
                services.add(service);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
            return services;
        }
    }

    public static Service retrieveById(int id) {
        Service service = null;

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        String sql = "select * from service where id = ?";
        try {
            conn = ConnectionManager.getConnection();
            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, id);
            rs = preStmt.executeQuery();

            while (rs.next()) {
                id = rs.getInt(1);
                String detail = rs.getString(2);
                double price = rs.getDouble(3);
                String type = rs.getString(4);
                service = new Service(id, detail, price, type);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
            return service;
        }
    }

    public static void update(int id, String detail, double price, String type) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("update service set detail=?, price=?, type = ? where id=?");

            stmt.setString(1, detail);
            stmt.setDouble(2, price);
            stmt.setString(3, type);
            stmt.setInt(4, id);
            stmt.executeUpdate();

        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
        }

    }
    
    public static ArrayList<String> retrieveAllDetails() {
        ArrayList<String> details = new ArrayList<>();

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        String sql = "select detail from service";
        try {
            conn = ConnectionManager.getConnection();
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();

            while (rs.next()) {
                String detail = rs.getString(1);
                details.add(detail);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
            return details;
        }
    }
}
