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
public class StaffDAO {

    public static ArrayList<Staff> getAll() {
        ArrayList<Staff> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("select * from staff order by id");
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new Staff(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6)));
            }
        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
        }

        return list;
    }

    public static Staff retrieveById(int id) {
        Staff staff = null;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement preStmt = null;
        String sql = "select * from staff where id = ? ";
        try {
            conn = ConnectionManager.getConnection();

            preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, id);
            rs = preStmt.executeQuery();

            while (rs.next()) {
                staff = new Staff(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, preStmt, rs);
            return staff;
        }
    }

    public static void add(String name, String gender, String phone, double salary, String status) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("insert into staff (name, gender, phoneNumber, status, salary) values (?, ?, ?, ?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, gender);
            stmt.setString(3, phone);
            stmt.setString(4, status);
            stmt.setDouble(5, salary);
            stmt.execute();

        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
        }

    }

    public static void update(int id2, String name, String gender, String phone, double salary, String status) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("update staff set name=?, gender=?, phoneNumber=?, status=?, salary=? where id=?");

            stmt.setString(1, name);
            stmt.setString(2, gender);
            stmt.setString(3, phone);
            stmt.setString(4, status);
            stmt.setDouble(5, salary);
            stmt.setInt(6, id2);
            stmt.executeUpdate();

        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
        }

    }
}
