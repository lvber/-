<%-- 
    Document   : record
    Created on : Dec 7, 2015, 8:47:32 PM
    Author     : lvbowen
--%>

<%@page import="com.app.model.ProductDAO"%>
<%@page import="com.app.model.ProductOrder"%>
<%@page import="com.app.controller.ConnectionManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.app.model.StaffDAO"%>
<%@page import="com.app.model.ServiceDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.app.model.OrderDAO"%>
<%@page import="com.app.model.Order"%>
<%@page import="com.app.model.Topup"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.TopupDAO"%>
<%@page import="com.app.model.Member"%>
<%@page import="com.app.controller.MemberManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会员详情</title>
    </head>
    <body>
        <%!
            public static final int PAGESIZE = 10;
            int pageCount;
            int curPage = 1;
        %>
        <div class="page-content">
            <% int cardNumber = Integer.parseInt(request.getParameter("id"));
                Member member = MemberManager.retrieveByCardNumber(cardNumber);
                String gender = member.getGender();
                ArrayList<Topup> topupList = TopupDAO.retrieveByCardNumber(cardNumber);
                ArrayList<Order> orderList = OrderDAO.retreveByCardNumber(cardNumber);
                ArrayList<ProductOrder> productOrderList = OrderDAO.getAllProductOrderByCardNumber(cardNumber);
            %>

            <div class="span12">
                <h3 class="page-title">
                    会员详情
                </h3>

                <ul class="breadcrumb">

                    <li>

                        <i class="icon-user"></i>
                        会员管理
                        <i class="icon-angle-right"></i>

                    </li>

                    <li>

                        <a href="member.jsp">会员管理</a>

                        <i class="icon-angle-right"></i>

                    </li>

                    <li>会员详情</li>

                </ul>
            </div>

            <div class="span6">
                <div class="portlet box white">
                    <div class="portlet-title">

                        <div class="caption"></div>

                    </div>

                    <div class="portlet-body">
                        <form>
                            <table class="table table-hover table-bordered">
                                <thead>
                                    <tr><th>操作</th><th>会员卡号</th><th>姓名</th><th>手机号</th><th>性别</th><th>会员等级</th><th>储值余额</th></tr>
                                </thead>
                                <tbody>

                                    <tr><td><a href="topup.jsp?id=<%= member.getCardNumber()%>">充值</a>
                                            <a href="updateMember.jsp?id=<%= member.getCardNumber()%>"> 修改</a>
                                        <td><%= member.getCardNumber()%></td><td><%= member.getName()%></td><td><%= member.getPhoneNumber()%></td>
                                        <%if (gender.equals("M")) {%>
                                        <td>男</td>
                                        <%} else {%>
                                        <td>女</td>
                                        <%}%>
                                        <td><%= member.getType()%></td><td><%= member.getBalance()%></td></tr>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>


            <div class="span6">
                <div class="portlet box blue">
                    <div class="portlet-title">

                        <div class="caption">充值记录</div>

                    </div>

                    <div class="portlet-body">
                        <form>
                            <table class="table table-hover table-bordered">
                                <thead>
                                    <tr><th>创建时间</th><th>充值金额</th><th>付款方式</th><th>操作员</th></tr>
                                </thead>
                                <tbody>
                                    <%for (int i = 0; i < topupList.size(); i++) {
                                            Topup topup = topupList.get(i);
                                            int staffId = topup.getStaffId();
                                            String staffName = StaffDAO.retrieveById(staffId).getName();
                                    %>
                                    <tr><td><%=topup.getTimestamp()%></td><td><%=topup.getAmount()%></td><td><%= topup.getType()%></td><td><%= staffName%></td></tr>
                                    <%}%>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>                    

            <div class="span6">
                <div class="portlet box blue">
                    <div class="portlet-title">

                        <div class="caption">产品购买记录</div>

                    </div>

                    <div class="portlet-body">
                        <form>
                            <table class="table table-hover table-bordered">
                                <thead>
                                    <tr><th>消费编号</th><th>日期</th><th>产品名称</th><th>支付方式</th><th>支付金额</th><th>操作员</th></tr>
                                </thead>
                                <tbody>
                                    <%for (int i = 0; i < productOrderList.size(); i++) {
                                            ProductOrder pOrder = productOrderList.get(i);
                                            int staffId = pOrder.getStaffId();
                                            String staffName = StaffDAO.retrieveById(staffId).getName();
                                            int productId = pOrder.getProductId();
                                            String productName = ProductDAO.retrieveById(productId).getName();
                                    %>
                                    <tr><td><%=i+1%></td><td><%=pOrder.getTimestamp()%></td><td><%=productName%></td><td><%= pOrder.getType()%></td><td><%= pOrder.getAmount()%></td><td><%= staffName%></td></tr>
                                    <%}%>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>    
                                
            <div class="container">
                <div class="span6">
                    <div class="portlet box blue">
                        <div class="portlet-title">

                            <div class="caption">消费记录</div>

                        </div>

                        <div class="portlet-body">

                            <table class="table table-hover table-bordered">
                                <thead>
                                    <tr><th>消费编号</th><th>日期</th><th>消费项目</th><th>支付方式</th><th>支付金额</th><th>操作员</th><th>助理操作员</th></tr>
                                </thead>
                                <tbody>
                                    <%
                                        ArrayList<Order> orders = new ArrayList<Order>();
                                        Connection conn = null;
                                        ResultSet rs = null;
                                        PreparedStatement preStmt = null;
                                        String sql = "select * from `order` where cardNumber =\"" + cardNumber + "\" order by dateTime";

                                        try {
                                            conn = ConnectionManager.getConnection();
                                            preStmt = conn.prepareStatement(sql);
                                            rs = preStmt.executeQuery();
                                            rs.last();
                                            int size = rs.getRow();
                                            pageCount = (size % PAGESIZE == 0) ? (size / PAGESIZE) : (size / PAGESIZE + 1);
                                            String tmp = request.getParameter("curPage");
                                            if (tmp == null) {
                                                tmp = "1";
                                            }
                                            curPage = Integer.parseInt(tmp);
                                            if (curPage >= pageCount) {
                                                curPage = pageCount;
                                            }
                                            boolean flag = rs.absolute((curPage - 1) * PAGESIZE + 1);

                                            int count = 0;

                                            do {
                                                if (count >= PAGESIZE) {
                                                    break;
                                                }
                                                int orderId = rs.getInt(1);
                                                Timestamp timestamp = rs.getTimestamp(2);
                                                int staffId = rs.getInt(3);
                                                int staffId2 = rs.getInt(4);
                                                cardNumber = rs.getInt(5);
                                                int serviceId = rs.getInt(6);
                                                double amount = rs.getDouble(7);
                                                String type = rs.getString(8);
                                                String details = ServiceDAO.retrieveById(serviceId).getDetail();

                                                String name = StaffDAO.retrieveById(staffId).getName();
                                                String name2 = "无";
                                                if (staffId2 != 0) {
                                                    name2 = StaffDAO.retrieveById(staffId2).getName();
                                                }

                                                count++;

                                    %>
                                    <tr><td><%=orderId%></td><td><%=timestamp%></td><td><%=details%></td><td><%=type%></td><td><%=amount%></td><td><%=name%></td><td><%=name2%></td></tr>

                                    <%  } while (rs.next());
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        } finally {
                                            ConnectionManager.close(conn, preStmt, rs);

                                        }
                                    %>


                                </tbody>
                            </table>
                            <a href = "memberRecord.jsp?curPage=1&id=<%=cardNumber%>" >首页</a>  
                            <a href = "memberRecord.jsp?curPage=<%=curPage - 1%>&id=<%=cardNumber%>" >上一页</a>  
                            <a href = "memberRecord.jsp?curPage=<%=curPage + 1%>&id=<%=cardNumber%>" >下一页</a>  
                            <a href = "memberRecord.jsp?curPage=<%=pageCount%>&id=<%=cardNumber%>" >尾页</a>  
                            <form>
                                <input type="hidden" name="id" value="<%=cardNumber%>">
                                <input type="text" name="curPage" placeholder="跳转" class="m-wrap small" >
                                <input type="submit" value="跳转">
                            </form>
                            第<%=curPage%>页/共<%=pageCount%>页  

                        </div>
                    </div>
                </div>
            </div>
            <%  String msg = request.getParameter("msg");
                if (null != msg && msg.equals("success")) {
            %>
            <script>alert("操作成功！")</script>
            <%
                }%>
        </div>
    </body>
</html>
