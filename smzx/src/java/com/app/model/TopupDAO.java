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
public class TopupDAO {

    public static void add(int cardNumber, double amount, String type, int staffId) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        String sql = "insert into topup (cardNumber, amount, type, staffId) values (?,?,?,?) ";
        try {
            conn = ConnectionManager.getConnection();

            preStmt = conn.prepareStatement(sql);

            preStmt.setInt(1, cardNumber);
            preStmt.setDouble(2, amount);
            preStmt.setString(3, type);
            preStmt.setInt(4, staffId);
            preStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt);
        }
    }

    public static ArrayList<Topup> retrieveByCardNumber(int cardNumber) {
        ArrayList<Topup> topupList = new ArrayList<Topup>();

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        String sql = "select * from topup where cardNumber = ?";
        try {
            conn = ConnectionManager.getConnection();
            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, cardNumber);
            rs = preStmt.executeQuery();

            while (rs.next()) {
                Timestamp timestamp = rs.getTimestamp(1);
                cardNumber = rs.getInt(2);
                double amount = rs.getDouble(3);
                String type = rs.getString(4);
                int staffId = rs.getInt(5);
                Topup topup = new Topup(timestamp, cardNumber, amount, type, staffId);
                topupList.add(topup);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);

        }

        return topupList;
    }

    public static ArrayList<Topup> retrieveByStaffId(int staffId) {
        ArrayList<Topup> topupList = new ArrayList<Topup>();

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        String sql = "select * from topup where staffId = ?";
        try {
            conn = ConnectionManager.getConnection();
            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, staffId);
            rs = preStmt.executeQuery();

            while (rs.next()) {
                Timestamp timestamp = rs.getTimestamp(1);
                int cardNumber = rs.getInt(2);
                double amount = rs.getDouble(3);
                String type = rs.getString(4);
                Topup topup = new Topup(timestamp, cardNumber, amount, type, staffId);
                topupList.add(topup);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);

        }

        return topupList;
    }

    public static ArrayList<Topup> retrieveByTimeAndStaffId(int staffId, String startDate, String endDate) {
        ArrayList<Topup> topupList = new ArrayList<Topup>();

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        String sql = "select * from topup where staffId = ? and dateTime >= ? and dateTime <= ? order by dateTime";
        try {
            conn = ConnectionManager.getConnection();
            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, staffId);
            preStmt.setString(2, startDate + " 00:00:00");
            preStmt.setString(3, endDate + " 23:59:59");
            rs = preStmt.executeQuery();

            while (rs.next()) {
                Timestamp timestamp = rs.getTimestamp(1);
                int cardNumber = rs.getInt(2);
                double amount = rs.getDouble(3);
                String type = rs.getString(4);
                Topup topup = new Topup(timestamp, cardNumber, amount, type, staffId);
                topupList.add(topup);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);

        }

        return topupList;
    }
}
