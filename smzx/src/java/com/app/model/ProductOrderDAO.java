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
public class ProductOrderDAO {
    public static ArrayList<ProductOrder> getProductOrderByTimeAndStaffId(int id,String startDate,String endDate) {
       ArrayList<ProductOrder> list = new ArrayList<>();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            conn = ConnectionManager.getConnection();
            stmt = conn.prepareStatement("select * from `productorder` where staffId = ? and dateTime >= ? and dateTime <= ? order by dateTime");
            stmt.setInt(1, id);
            stmt.setString(2, startDate + " 00:00:00");
            stmt.setString(3, endDate + " 23:59:59");
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
}
