/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Member;
import com.app.model.MemberDAO;
import com.app.model.Order;
import com.app.model.OrderDAO;
import java.util.ArrayList;

/**
 *
 * @author lvbowen
 */
public class OrderManager {

    public static String addProductOrder(int staffId, int cardNumber, int productId, double amount, String type) {
        if (cardNumber != 0) {
            Member member = MemberManager.retrieveByCardNumber(cardNumber);
            double balance = member.getBalance();
            if (balance >= amount) {
                double newBalance = balance - amount;
                MemberDAO.updateBalance(cardNumber, newBalance);
                OrderDAO.addProductOrder(staffId, cardNumber, productId, amount, type);
                return "success";
            } else {
                return "failed";
            }
        } else {
            OrderDAO.addProductOrder(staffId, cardNumber, productId, amount, type);
            return "success";
        }
    }

    public static String add(int staffId, int staffId2, int cardNumber, int serviceId, double amount, String type) {

        if (cardNumber != 0) {
            Member member = MemberManager.retrieveByCardNumber(cardNumber);
            double balance = member.getBalance();
            if (balance >= amount) {
                double newBalance = balance - amount;
                MemberDAO.updateBalance(cardNumber, newBalance);
                OrderDAO.add(staffId, staffId2, cardNumber, serviceId, amount, type);
                return "success";
            } else {
                return "failed";
            }
        } else {
            OrderDAO.add(staffId, staffId2, cardNumber, serviceId, amount, type);
            return "success";
        }

    }

    public static ArrayList<Order> getOrderByTimeAndStaffId(int id, String startDate, String endDate) {
        return OrderDAO.getOrderByTimeAndStaffId(id, startDate, endDate);
    }

    public static ArrayList<Order> getOrderByTimeAndStaffId2(int id, String startDate, String endDate) {
        return OrderDAO.getOrderByTimeAndStaffId2(id, startDate, endDate);
    }
}
