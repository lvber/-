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
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author lvbowen
 */
public class OrderDAO {

    public static void addProductOrder(int staffId, int cardNumber, int productId, double amount, String type) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        String sql = "insert into `productOrder` (staffId, cardNumber, productId, cost, type) values (?,?,?,?,?) ";
        try {
            conn = ConnectionManager.getConnection();

            preStmt = conn.prepareStatement(sql);

            preStmt.setInt(1, staffId);
            preStmt.setInt(2, cardNumber);
            preStmt.setInt(3, productId);
            preStmt.setDouble(4, amount);
            preStmt.setString(5, type);

            preStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt);
        }
    }

    public static void add(int staffId, int staffId2, int cardNumber, int serviceId, double amount, String type) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        String sql = "insert into `order` (staffId, staffId2, cardNumber, serviceId, amount, type) values (?,?,?,?,?,?) ";
        try {
            conn = ConnectionManager.getConnection();

            preStmt = conn.prepareStatement(sql);

            preStmt.setInt(1, staffId);
            preStmt.setInt(2, staffId2);
            preStmt.setInt(3, cardNumber);
            preStmt.setInt(4, serviceId);
            preStmt.setDouble(5, amount);
            preStmt.setString(6, type);

            preStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt);
        }
    }

    public static ArrayList<ProductOrder> getAllProductOrder() {
        ArrayList<ProductOrder> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("select * from `productorder` order by dateTime");
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new ProductOrder(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getDouble(6), rs.getString(7)));
            }
        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
        }

        return list;
    }

    public static ArrayList<Order> getAll() {
        ArrayList<Order> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("select * from `order` order by dateTime");
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7), rs.getString(8)));
            }
        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
        }

        return list;
    }

    public static ArrayList<ProductOrder> getAllProductOrderByStaffId(int id) {
        ArrayList<ProductOrder> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("select * from `productorder` where staffId = ? order by dateTime");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new ProductOrder(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getDouble(6), rs.getString(7)));
            }
        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
        }

        return list;
    }

    public static ArrayList<Order> getAllByStaffId(int id) {
        ArrayList<Order> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("select * from `order` where staffId = ? order by dateTime");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7), rs.getString(8)));
            }
        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
        }
        return list;
    }

    public static ArrayList<ProductOrder> getAllProductOrderByCardNumber(int id) {
        ArrayList<ProductOrder> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("select * from `productorder` where cardNumber = ? order by dateTime");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new ProductOrder(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getDouble(6), rs.getString(7)));
            }
        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
        }

        return list;
    }

    public static ArrayList<Order> retreveByCardNumber(int id) {
        ArrayList<Order> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("select * from `order` where cardNumber = ? order by dateTime");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7), rs.getString(8)));
            }
        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
        }

        return list;

    }

    public static ArrayList<Order> getOrderByTime(String startDate, String endDate) {
        ArrayList<Order> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("select * from `order` where dateTime >= ? && dateTime <= ? order by dateTime");
            stmt.setString(1, startDate + " 00:00:00");
            stmt.setString(2, endDate + " 23:59:59");
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7), rs.getString(8)));
            }
        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
        }

        return list;

    }

    public static ArrayList<Order> getOrderByTimeAndStaffId(int id, String startDate, String endDate) {
        ArrayList<Order> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("select * from `order` where staffId = ? and dateTime >= ? and dateTime <= ? order by dateTime");
            stmt.setInt(1, id);
            stmt.setString(2, startDate + " 00:00:00");
            stmt.setString(3, endDate + " 23:59:59");
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7), rs.getString(8)));
            }
        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
        }

        return list;

    }

    public static ArrayList<Order> getOrderByTimeAndStaffId2(int id, String startDate, String endDate) {
        ArrayList<Order> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("select * from `order` where staffId2 = ? and dateTime >= ? and dateTime <= ? order by dateTime");
            stmt.setInt(1, id);
            stmt.setString(2, startDate + " 00:00:00");
            stmt.setString(3, endDate + " 23:59:59");
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7), rs.getString(8)));
            }
        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs);
        }

        return list;

    }

    public static Order retreveById(int id) {
        Order order = null;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("select * from `order` where id = ? order by dateTime");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                order = new Order(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7), rs.getString(8));
            }
        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
        }

        return order;
    }

    public static Order retrieveLastOrder() {
        Order order = null;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM `order` WHERE `id` = (select max(id) from `order`)");

            rs = stmt.executeQuery();
            while (rs.next()) {
                order = new Order(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getDouble(7), rs.getString(8));
            }
        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
        }

        return order;

    }
}
