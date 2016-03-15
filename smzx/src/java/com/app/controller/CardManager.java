/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.CardLevel;
import com.app.model.CardLevelDAO;
import java.util.ArrayList;

/**
 *
 * @author lvbowen
 */
public class CardManager {

    public static ArrayList<CardLevel> retrieveAll() {
        return CardLevelDAO.getAll();
    }

    public static void delete(String cardType) {
        CardLevelDAO.deleteByType(cardType);
    }

    public static void add(String cardType, double discount, int minCharge) {
        CardLevelDAO.add(cardType, discount, minCharge);
    }

    public static void update(String cardType, double discount, int minCharge) {
        CardLevelDAO.update(cardType, discount, minCharge);
    }
    
    public static CardLevel retrieveByType(String type){
        return CardLevelDAO.retrieveByType(type);
    }
}
