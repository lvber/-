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
import java.util.Map;

/**
 *
 * @author lvbowen
 */
public class MemberDAO {

    public static void add(String name, String gender, String phone, double balance, String cardLevel) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        String sql = "insert into member (name, gender, phoneNumber, type, balance) values (?,?,?,?,?) ";
        try {
            conn = ConnectionManager.getConnection();

            preStmt = conn.prepareStatement(sql);

            preStmt.setString(1, name);
            preStmt.setString(2, gender);
            preStmt.setString(3, phone);
            preStmt.setString(4, cardLevel);
            preStmt.setDouble(5, balance);

            preStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt);
        }
    }

    public static void update(int cardNumber, String name, String gender, String phone, double balance, String type) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        String sql = "update member set name = ? , phoneNumber = ?, gender = ? , type = ? where cardNumber = ?";
        try {
            conn = ConnectionManager.getConnection();

            preStmt = conn.prepareStatement(sql);

            preStmt.setString(1, name);
            preStmt.setString(2, phone);
            preStmt.setString(3, gender);
            preStmt.setString(4, type);
            preStmt.setInt(5, cardNumber);

            preStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt);
        }
    }

    public static void updateBalance(int cardNumber, double balance) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        String sql = "update member set balance = ? where cardNumber = ?";
        try {
            conn = ConnectionManager.getConnection();

            preStmt = conn.prepareStatement(sql);

            preStmt.setDouble(1, balance);
            preStmt.setInt(2, cardNumber);
            preStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt);
        }
    }

    public static void topup(int cardNumber, double amount, double balance) {
        Connection conn = null;
        PreparedStatement preStmt = null;
        String sql = "update member set balance = ? where cardNumber = ?";
        try {
            conn = ConnectionManager.getConnection();

            preStmt = conn.prepareStatement(sql);

            preStmt.setDouble(1, amount + balance);
            preStmt.setInt(2, cardNumber);

            preStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt);
        }
    }

    public static ArrayList<Member> retrieveAll() {
        ArrayList<Member> members = new ArrayList<Member>();

        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        String sql = "select * from member";
        try {
            conn = ConnectionManager.getConnection();
            preStmt = conn.prepareStatement(sql);
            rs = preStmt.executeQuery();

            while (rs.next()) {
                int cardNumber = rs.getInt(1);
                String name = rs.getString(2);
                String gender = rs.getString(3);
                String phoneNumber = rs.getString(4);
                String type = rs.getString(5);
                double balance = rs.getDouble(6);
                Member member = new Member(cardNumber, name, gender, phoneNumber, type, balance);
                members.add(member);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
            return members;
        }

    }

    public static Member retrieveByPhone(String phone) {
        Member member = null;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        String sql = "select cardNumber, name, gender, phoneNumber, type, balance from member  where phoneNumber = ? ";
        try {
            conn = ConnectionManager.getConnection();

            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, phone);
            rs = preStmt.executeQuery();

            while (rs.next()) {
                int cardNumber = rs.getInt(1);
                String name = rs.getString(2);
                String gender = rs.getString(3);
                String phoneNumber = rs.getString(4);
                String type = rs.getString(5);
                double balance = rs.getDouble(6);
                member = new Member(cardNumber, name, gender, phoneNumber, type, balance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
            return member;
        }
    }

    public static Member retrieveByCardNumber(int cardNumber) {
        Member member = null;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        String sql = "select cardNumber, name, gender, phoneNumber, type, balance from member  where cardNumber = ? ";
        try {
            conn = ConnectionManager.getConnection();

            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, cardNumber);
            rs = preStmt.executeQuery();

            while (rs.next()) {
                cardNumber = rs.getInt(1);
                String name = rs.getString(2);
                String gender = rs.getString(3);
                String phoneNumber = rs.getString(4);
                String type = rs.getString(5);
                double balance = rs.getDouble(6);
                member = new Member(cardNumber, name, gender, phoneNumber, type, balance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
            return member;
        }
    }

    public static ArrayList<Member> retrieveByName(String name) {
        ArrayList<Member> members = new ArrayList<Member>();
        Member member = null;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        String sql = "select cardNumber, name, gender, phoneNumber, type, balance from member  where name like ? ";
        try {
            conn = ConnectionManager.getConnection();

            preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, "%" + name + "%");
            rs = preStmt.executeQuery();

            while (rs.next()) {
                int cardNumber = rs.getInt(1);
                name = rs.getString(2);
                String gender = rs.getString(3);
                String phoneNumber = rs.getString(4);
                String type = rs.getString(5);
                double balance = rs.getDouble(6);
                member = new Member(cardNumber, name, gender, phoneNumber, type, balance);
                members.add(member);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
            return members;
        }
    }
}
