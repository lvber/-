/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.servlet;

import com.app.controller.CardManager;
import com.app.controller.MemberManager;
import com.app.controller.ServiceManager;
import com.app.controller.StaffManager;
import com.app.model.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lvbowen
 */
@WebServlet(name = "update", urlPatterns = {"/update"})
public class update extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String method = request.getParameter("method");

        if ("cardLevel".equals(method)) {
            String cardType = request.getParameter("name");
            String discount = request.getParameter("discount");
            String minCharge = request.getParameter("minCharge");

            double discount2 = Double.parseDouble(discount);
            int minCharge2 = Integer.parseInt(minCharge);
            CardManager.update(cardType, discount2, minCharge2);
            response.sendRedirect("cardLevel.jsp");
        } else if ("member".equals(method)) {
            int cardNumber = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            double balance = Double.parseDouble(request.getParameter("balance"));
            String cardlevel = request.getParameter("cardlevel");
            MemberManager.update(cardNumber, name, gender, phone, balance, cardlevel);

            response.sendRedirect("member.jsp");
        } else if ("staff".equals(method)) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            double salary = Double.parseDouble(request.getParameter("salary"));
            String status = request.getParameter("status");
            int id2 = Integer.parseInt(id);

            StaffManager.update(id2, name, gender, phone, salary, status);
            response.sendRedirect("staff.jsp?msg=success");
        } else if ("service".equals(method)) {
            String idStr = request.getParameter("id");
            String detail = request.getParameter("detail");
            String priceStr = request.getParameter("price");
            String type = request.getParameter("type");
            int id = Integer.parseInt(idStr);
            double price = Double.parseDouble(priceStr);

            ServiceManager.update(id, detail, price, type);
            response.sendRedirect("service.jsp?msg=success");
        } else if("product".equals(method)) {
            String proId = request.getParameter("productId");
            String name = request.getParameter("productName");
            String cost = request.getParameter("cost");
            String moneyTaken = request.getParameter("moneyTaken");
            ProductDAO.update(Integer.parseInt(proId), name, Double.parseDouble(cost), Double.parseDouble(moneyTaken));
            
            response.sendRedirect("product.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
