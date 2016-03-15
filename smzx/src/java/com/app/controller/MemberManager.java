/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.CardLevel;
import com.app.model.Member;
import com.app.model.MemberDAO;
import com.app.model.OrderDAO;
import com.app.model.TopupDAO;
import java.util.ArrayList;

/**
 *
 * @author lvbowen
 */
public class MemberManager {

    public static void add(String name, String gender, String phone, double balance, String cardLevel, String type, int staffId) {

        MemberDAO.add(name, gender, phone, balance, cardLevel);
        int cardNumber = MemberDAO.retrieveByPhone(phone).getCardNumber();
        TopupDAO.add(cardNumber, balance, type, staffId);

    }

    public static void topup(int cardNumber, double amount, String type, int staffId) {
        double balance = MemberDAO.retrieveByCardNumber(cardNumber).getBalance();
        MemberDAO.topup(cardNumber, amount, balance);
        TopupDAO.add(cardNumber, amount, type, staffId);

    }

    public static void update(int cardNumber, String name, String gender, String phone, double balance, String type) {
        MemberDAO.update(cardNumber, name, gender, phone, balance, type);
    }

    public static ArrayList<Member> retrieveAll() {
        return MemberDAO.retrieveAll();
    }

    public static Member retrieveByCardNumber(int cardNumber) {
        return MemberDAO.retrieveByCardNumber(cardNumber);
    }

    public static Member retrieveByPhone(String phone) {
        return MemberDAO.retrieveByPhone(phone);
    }

    public static ArrayList<Member> retrieveByName(String name) {
        return MemberDAO.retrieveByName(name);
    }
}
