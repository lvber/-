/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.servlet;

import com.app.controller.CardManager;
import com.app.controller.MemberManager;
import com.app.controller.OrderManager;
import com.app.controller.PrinterAction;
import com.app.controller.ServiceManager;
import com.app.controller.StaffManager;
import com.app.model.MemberDAO;
import com.app.model.Order;
import com.app.model.OrderDAO;
import com.app.model.PrinterMessage;
import com.app.model.ProductDAO;
import com.app.model.ServiceDAO;
import com.app.model.StaffDAO;
import com.app.model.Topup;
import com.app.model.TopupDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
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
@WebServlet(name = "add", urlPatterns = {"/add"})
public class add extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String method = request.getParameter("method");
        if ("member".equals(method)) {
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String balanceStr = request.getParameter("balance");
            String cardLevel = request.getParameter("cardLevel");
            String type = request.getParameter("type");
            String staffIdStr = request.getParameter("staffId");

            double balance = Double.parseDouble(balanceStr);
            int staffId = Integer.parseInt(staffIdStr);
            boolean isAddMemberSuccess = true;

            if (null != MemberDAO.retrieveByPhone(phone)) {
                isAddMemberSuccess = false;
            }

            if (isAddMemberSuccess) {
                MemberManager.add(name, gender, phone, balance, cardLevel, type, staffId);

                int cardNumber = MemberDAO.retrieveByPhone(phone).getCardNumber();
                Topup topup = TopupDAO.retrieveByCardNumber(cardNumber).get(0);
                Timestamp ts = topup.getTimestamp();
                String staffName = StaffDAO.retrieveById(staffId).getName();
                PrinterMessage printerMsg = new PrinterMessage(0, ts, "会员开卡", balance, type, staffName, cardNumber, balance);
                PrinterAction.print(printerMsg);
                PrinterAction.print(printerMsg);

                response.sendRedirect("member.jsp?msg=success");
                return;
            } else {
                request.getRequestDispatcher("addMember.jsp?msg=failed").forward(request, response);
            }
        } else if ("topup".equals(method)) {
            String cardNumberStr = request.getParameter("cardNumber");
            String amountStr = request.getParameter("amount");
            String type = request.getParameter("type");
            String staffIdStr = request.getParameter("staffId");
            int cardNumber = Integer.parseInt(cardNumberStr);
            double amount = Double.parseDouble(amountStr);
            int staffId = Integer.parseInt(staffIdStr);
            boolean isTopupSuccess = true;
            if (isTopupSuccess) {
                MemberManager.topup(cardNumber, amount, type, staffId);
                ArrayList<Topup> topupList = TopupDAO.retrieveByCardNumber(cardNumber);
                Topup topup = topupList.get(topupList.size() - 1);
                Timestamp ts = topup.getTimestamp();
                String staffName = StaffDAO.retrieveById(staffId).getName();
                double balance = MemberDAO.retrieveByCardNumber(cardNumber).getBalance();
                PrinterMessage printerMsg = new PrinterMessage(0, ts, "会员卡充值", amount, type, staffName, cardNumber, balance);
                PrinterAction.print(printerMsg);
                PrinterAction.print(printerMsg);

                response.sendRedirect("memberRecord.jsp?msg=success&id=" + cardNumberStr);
                return;
            } else {
                request.getRequestDispatcher("topup.jsp").forward(request, response);
            }
        } else if ("cardLevel".equals(method)) {
            String cardType = request.getParameter("name");
            String discount = request.getParameter("discount");
            String minCharge = request.getParameter("minCharge");

            double discount2 = Double.parseDouble(discount);
            int minCharge2 = Integer.parseInt(minCharge);
            CardManager.add(cardType, discount2, minCharge2);

            response.sendRedirect("cardLevel.jsp?msg=success");
        } else if ("cashier".equals(method)) {
            int staffId = Integer.parseInt(request.getParameter("staffId"));
            String staffId2Str = request.getParameter("staffId2");
            int staffId2 = 0;
            if (null != staffId2Str) {
                staffId2 = Integer.parseInt(request.getParameter("staffId2"));
            }
            int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
            int serviceId = Integer.parseInt(request.getParameter("serviceId"));
            double amount = Double.parseDouble(request.getParameter("realAmount"));
            String type = request.getParameter("type");
            String msg = OrderManager.add(staffId, staffId2, cardNumber, serviceId, amount, type);

            if (cardNumber != 0 && msg.equals("success")) {
                Order order = OrderDAO.retrieveLastOrder();
                int id = order.getId();
                Timestamp ts = order.getTimestamp();
                String detail = ServiceDAO.retrieveById(serviceId).getDetail();
                String staffName = StaffDAO.retrieveById(staffId).getName();
                double balance = 0;
                balance = MemberDAO.retrieveByCardNumber(cardNumber).getBalance();
                PrinterMessage printerMsg = new PrinterMessage(id, ts, detail, amount, type, staffName, cardNumber, balance);
                PrinterAction.print(printerMsg);
                PrinterAction.print(printerMsg);
                response.sendRedirect("memberRecord.jsp?id=" + cardNumber);
                return;
            }

            response.sendRedirect("cashier.jsp?msg=" + msg);
        } else if ("service".equals(method)) {
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String type = request.getParameter("type");
            ServiceManager.add(name, price, type);

            response.sendRedirect("service.jsp?msg=success");
        } else if ("staff".equals(method)) {
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            double salary = Double.parseDouble(request.getParameter("salary"));
            String status = request.getParameter("status");

            StaffManager.add(name, gender, phone, salary, status);
            response.sendRedirect("staff.jsp?msg=success");
        } else if ("product".equals(method)) {
            String name = request.getParameter("productName");
            String cost = request.getParameter("cost");
            String moneyTaken = request.getParameter("moneyTaken");
            ProductDAO.add(name, Double.parseDouble(cost), Double.parseDouble(moneyTaken));
            /*int proId = ProductDAO.getProductId(name);
            
            String[] details = request.getParameterValues("details");
            for(String detail: details) {
                ProductAndServiceDAO.add(proId, detail);
            }*/

            response.sendRedirect("product.jsp");

        } else if ("productCashier".equals(method)) {
            int staffId = Integer.parseInt(request.getParameter("staffId"));

            int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
            int productId = Integer.parseInt(request.getParameter("productId"));
            double amount = Double.parseDouble(request.getParameter("realAmount"));
            String type = request.getParameter("type");

            String msg = OrderManager.addProductOrder(staffId, cardNumber, productId, amount, type);

            // print information
            /*if (cardNumber != 0 && msg.equals("success")) {
                Order order = OrderDAO.retrieveLastOrder();
                int id = order.getId();
                Timestamp ts = order.getTimestamp();
                String detail = ServiceDAO.retrieveById(serviceId).getDetail();
                String staffName = StaffDAO.retrieveById(staffId).getName();
                double balance = 0;
                balance = MemberDAO.retrieveByCardNumber(cardNumber).getBalance();
                PrinterMessage printerMsg = new PrinterMessage(id, ts, detail, amount, type, staffName, cardNumber, balance);
                PrinterAction.print(printerMsg);
                PrinterAction.print(printerMsg);
                response.sendRedirect("memberRecord.jsp?id=" + cardNumber);
                return;
            }*/
            response.sendRedirect("productCashier.jsp?msg=" + msg);
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
