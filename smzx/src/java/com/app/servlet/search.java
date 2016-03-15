/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.servlet;

import com.app.controller.MemberManager;
import com.app.controller.OrderManager;
import com.app.model.Member;
import com.app.model.Order;
import com.app.model.Topup;
import com.app.model.TopupDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lvbowen
 */
@WebServlet(name = "search", urlPatterns = {"/search"})
public class search extends HttpServlet {

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

        if ("cashier".equals(method)) {
            Member member = null;
            ArrayList<Member> members = null;
            String input = request.getParameter("input");
            if (input.matches("^[0-9]*$")) {
                member = MemberManager.retrieveByPhone(input);
            } else {
                members = MemberManager.retrieveByName(input);
            }
            request.setAttribute("member", member);
            request.setAttribute("members", members);
            request.setAttribute("search", true);
            request.getRequestDispatcher("cashier.jsp").forward(request, response);
        } else if ("recordAnalysis".equals(method)) {
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            int staffId = Integer.parseInt(request.getParameter("staffId"));

            ArrayList<Order> orders = OrderManager.getOrderByTimeAndStaffId(staffId, startDate, endDate);
            ArrayList<Order> orders2 = OrderManager.getOrderByTimeAndStaffId2(staffId, startDate, endDate);
            ArrayList<Topup> topups = TopupDAO.retrieveByTimeAndStaffId(staffId, startDate, endDate);

            request.setAttribute("orders", orders);
            request.setAttribute("orders2", orders2);
            request.setAttribute("topup", topups);
            request.getRequestDispatcher("recordAnalysis.jsp").forward(request, response);
        } else if ("topup".equals(method)) {
            Member member = null;
            ArrayList<Member> members = null;
            String input = request.getParameter("input");
            if (input.matches("^[0-9]*$")) {
                member = MemberManager.retrieveByPhone(input);
            } else {
                members = MemberManager.retrieveByName(input);
            }
            request.setAttribute("member", member);
            request.setAttribute("members", members);
            request.setAttribute("search", true);
            request.getRequestDispatcher("topup.jsp").forward(request, response);
        } else if ("member".equals(method)) {
            Member member = null;
            ArrayList<Member> members = null;
            String input = request.getParameter("input");
            if (input.matches("^[0-9]*$")) {
                member = MemberManager.retrieveByPhone(input);
            } else {
                members = MemberManager.retrieveByName(input);
            }
            request.setAttribute("member", member);
            request.setAttribute("members", members);
            request.setAttribute("search", true);
            request.getRequestDispatcher("member.jsp").forward(request, response);
        } else if ("productCashier".equals(method)) {
            Member member = null;
            ArrayList<Member> members = null;
            String input = request.getParameter("input");
            if (input.matches("^[0-9]*$")) {
                member = MemberManager.retrieveByPhone(input);
            } else {
                members = MemberManager.retrieveByName(input);
            }
            request.setAttribute("member", member);
            request.setAttribute("members", members);
            request.setAttribute("search", true);
            request.getRequestDispatcher("productCashier.jsp").forward(request, response);
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
