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
public class CardLevelDAO {

    public static ArrayList<CardLevel> getAll() {
        ArrayList<CardLevel> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("select * from cardlevel order by minCharge");
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new CardLevel(rs.getString(1), rs.getDouble(2), rs.getInt(3)));
            }
        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
        }

        return list;
    }

    public static CardLevel retrieveByType(String cardType) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        CardLevel card = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("select * from cardlevel where type = ?");
            stmt.setString(1, cardType);
            rs = stmt.executeQuery();
            while (rs.next()) {
                card = new CardLevel(rs.getString(1), rs.getDouble(2), rs.getInt(3));
            }
        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
            return card;
        }

    }

    public static void deleteByType(String cardType) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("delete from cardlevel where type = ?");
            stmt.setString(1, cardType);
            stmt.executeUpdate();

        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
        }

    }

    public static void add(String cardType, double discount, int minCharge) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("insert into cardlevel (type, discount, minCharge) values (?, ?, ?)");
            stmt.setString(1, cardType);
            stmt.setDouble(2, discount);
            stmt.setInt(3, minCharge);
            stmt.execute();

        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
        }

    }

    public static void update(String cardType, double discount, int minCharge) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("update cardlevel set discount=?, minCharge=? where type=?");

            stmt.setDouble(1, discount);
            stmt.setInt(2, minCharge);
            stmt.setString(3, cardType);

            stmt.executeUpdate();

        } catch (SQLException e) {

        } finally {
            ConnectionManager.close(conn, stmt, rs); //if I add this line, some time the data can not be added
        }
    }
}
