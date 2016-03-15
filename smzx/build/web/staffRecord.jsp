<%-- 
    Document   : staffRecord
    Created on : Dec 7, 2015, 9:32:50 PM
    Author     : lvbowen
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="com.app.controller.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.app.model.Staff"%>
<%@page import="com.app.model.StaffDAO"%>
<%@page import="com.app.model.TopupDAO"%>
<%@page import="com.app.model.Topup"%>
<%@page import="com.app.model.ServiceDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.app.model.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.OrderDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>工单记录</title>
    </head>
    <body>
        <%!
            public static final int PAGESIZE1 = 10;
            int pageCount1;
            int curPage1 = 1;

            public static final int PAGESIZE2 = 10;
            int pageCount2;
            int curPage2 = 1;
            
            public static final int PAGESIZE3 = 10;
            int pageCount3;
            int curPage3 = 1;
        %>
        <div class="page-content">
            <div class="span12">
                <h3 class="page-title">
                    员工详情
                </h3>

                <ul class="breadcrumb">

                    <li>

                        <i class="icon-user"></i>
                        员工管理
                        <i class="icon-angle-right"></i>

                    </li>

                    <li>

                        <a href="staff.jsp">员工管理</a>

                        <i class="icon-angle-right"></i>

                    </li>

                    <li>员工详情</li>

                </ul>
            </div>
            <%

                String id = request.getParameter("id");
                Staff staff = StaffDAO.retrieveById(Integer.parseInt(id));
                String name = staff.getName();
                String gender = staff.getGender();
                String phone = staff.getPhoneNumber();
                double salary = staff.getSalary();
                String status = staff.getStatus();
            %>
            <div class="container">
                <div class="row-fluid">
                    <div class="span4">
                        <div class="portlet-body">
                            <div class="portlet box blue">
                                <div class="portlet-title">

                                    <div class="caption">工单记录查询</div>

                                </div>
                            </div>

                            <form action="staffRecord.jsp" method="get">
                                <table class="table table-hover table-bordered">
                                    <tr>
                                        <td>开始日期</td> <td><input type="date" name="startDate"/></td>
                                    </tr>
                                    <tr>
                                        <td>结束日期</td> <td><input type="date" name="endDate"/></td>
                                    </tr>

                                </table>
                                <input type="hidden" name="id" value="<%=id%>">
                                <input type="hidden" name="name" value="<%=name%>">
                                <input type="hidden" name="gender" value="<%=gender%>">
                                <input type="hidden" name="phone" value="<%=phone%>">
                                <input type="hidden" name="salary" value="<%=salary%>">
                                <input type="hidden" name="status" value="<%=status%>">
                                <input type="submit" value="提交"/>
                            </form>
                        </div>
                    </div>

                    <div class="span6">
                        <div class="portlet box white">
                            <div class="portlet-title">

                                <div class="caption"></div>

                            </div>

                            <div class="portlet-body">
                                <table class="table table-hover table-bordered">
                                    <thead><tr><th>操作</th><th>ID</th><th>姓名</th><th>手机号</th><th>性别</th><th>基本工资</th><th>状态</th></tr></thead>
                                    <tbody>
                                        <tr><td><a href="updateStaff.jsp?id=<%=id%>"> 修改</a></td>
                                            <td><%=id%></td><td><%=name%></td><td><%=phone%></td>
                                            <%if (gender.equals("M")) {%>
                                            <td>男</td>
                                            <%} else {%>
                                            <td>女</td>
                                            <%}%>
                                            <td><%=salary%></td><td><%=status%></td></tr>
                                    </tbody>
                                </table>
                                <br/>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%

                ArrayList<Order> orderList = null;
                ArrayList<Topup> topupList = null;
                if (request.getParameter("startDate") == null) {
                    orderList = OrderDAO.getAllByStaffId(Integer.parseInt(id));
                    topupList = TopupDAO.retrieveByStaffId(Integer.parseInt(id));
                } else {
                    String startTime = request.getParameter("startDate");
                    String endTime = request.getParameter("endDate");
                    orderList = OrderDAO.getOrderByTimeAndStaffId(Integer.parseInt(id), startTime, endTime);
                    topupList = TopupDAO.retrieveByTimeAndStaffId(Integer.parseInt(id), startTime, endTime);
                }

            %>


            <div class="container">
                <div class="row-fluid">
                    <div class="span6">
                        <div class="portlet box blue">
                            <div class="portlet-title">

                                <div class="caption">工单记录1：大活小活</div>

                            </div>

                            <div class="portlet-body">
                                <table class="table table-hover table-bordered">
                                    <thead><tr><th>日期</th><th>会员卡号</th><th>消费项目</th><th>支付方式</th><th>支付金额</th><th>操作员</th><th>种类</th></tr></thead>
                                                <%                                                
                                                    ArrayList<Order> orders = new ArrayList<>();
                                                    Connection conn = null;
                                                    ResultSet rs = null;
                                                    PreparedStatement preStmt = null;
                                                    String sql = "";
                                                    if (request.getParameter("startDate") == null) {
                                                        sql = "select * from `order` where staffId = " + Integer.parseInt(id) + " order by dateTime";
                                                    } else {
                                                        String startTime = request.getParameter("startDate");
                                                        String endTime = request.getParameter("endDate");
                                                        sql = "select * from `order` where staffId =" + Integer.parseInt(id) + " and dateTime >=\"" + startTime + "\" and dateTime <=\"" + endTime + " 23:59:59\" order by dateTime";
                                                    }

                                                    try {
                                                        conn = ConnectionManager.getConnection();
                                                        preStmt = conn.prepareStatement(sql);
                                                        rs = preStmt.executeQuery();
                                                        rs.last();
                                                        int size = rs.getRow();
                                                        pageCount1 = (size % PAGESIZE1 == 0) ? (size / PAGESIZE1) : (size / PAGESIZE1 + 1);
                                                        String tmp = request.getParameter("curPage1");
                                                        if (tmp == null) {
                                                            tmp = "1";
                                                        }
                                                        curPage1 = Integer.parseInt(tmp);
                                                        if (curPage1 >= pageCount1) {
                                                            curPage1 = pageCount1;
                                                        }
                                                        boolean flag = rs.absolute((curPage1 - 1) * PAGESIZE1 + 1);

                                                        int count = 0;

                                                        do {
                                                            if (count >= PAGESIZE1) {
                                                                break;
                                                            }

                                                            int orderId = rs.getInt(1);
                                                            Timestamp timestamp = rs.getTimestamp(2);
                                                            int staffId = rs.getInt(3);
                                                            int staffId2 = rs.getInt(4);
                                                            int cardNumber = rs.getInt(5);
                                                            int serviceId = rs.getInt(6);
                                                            double amount = rs.getDouble(7);
                                                            String paymentType = rs.getString(8);
                                                            String details = ServiceDAO.retrieveById(serviceId).getDetail();
                                                            String workType = ServiceDAO.retrieveById(serviceId).getType();
                                                            count++;

                                                %>
                                    <tr><td><%=timestamp%></td><td><%=cardNumber%></td><td><%=details%></td><td><%=paymentType%></td><td><%=amount%></td><td><%=name%></td><td><%=workType%></td></tr>

                                    <%
                                            } while (rs.next());
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        } finally {
                                            ConnectionManager.close(conn, preStmt, rs);

                                        }
                                    %>

                                </table>
                                <a href = "staffRecord.jsp?curPage=1&id=<%=id%>" >首页</a>  
                                <a href = "staffRecord.jsp?curPage1=<%=curPage1 - 1%>&id=<%=id%>" >上一页</a>  
                                <a href = "staffRecord.jsp?curPage1=<%=curPage1 + 1%>&id=<%=id%>" >下一页</a>  
                                <a href = "staffRecord.jsp?curPage1=<%=pageCount1%>&id=<%=id%>" >尾页</a>  

                                <form>
                                    <input type="text" name="curPage1" placeholder="跳转" class="m-wrap small" >
                                    <input type="submit" value="跳转">
                                </form>
                                第<%=curPage1%>页/共<%=pageCount1%>页  
                            </div>
                        </div>

                        <div class="span12">
                            <div class="portlet box blue">
                                <div class="portlet-title">
                                    <div class="caption">工单记录2:充值</div>
                                </div>

                                <div class="portlet-body">
                                    <table class="table table-hover table-bordered">
                                        <thead><tr><th>日期</th><th>会员卡号</th><th>消费项目</th><th>支付方式</th><th>支付金额</th><th>操作员</th><th>种类</th></tr></thead>

                                        <%
                                            ArrayList<Topup> topups = new ArrayList<>();
                                            String sql2 = "";
                                            if (request.getParameter("startDate") == null) {
                                                sql2 = "select * from `topup` where staffId = " + Integer.parseInt(id) + " order by dateTime";
                                            } else {
                                                String startTime = request.getParameter("startDate");
                                                String endTime = request.getParameter("endDate");
                                                sql2 = "select * from `topup` where staffId =" + Integer.parseInt(id) + " and dateTime >=\"" + startTime + "\" and dateTime <=\"" + endTime + " 23:59:59\" order by dateTime";
                                            }

                                            try {
                                                conn = ConnectionManager.getConnection();
                                                preStmt = conn.prepareStatement(sql2);
                                                rs = preStmt.executeQuery();
                                                rs.last();
                                                int size = rs.getRow();
                                                pageCount2 = (size % PAGESIZE2 == 0) ? (size / PAGESIZE2) : (size / PAGESIZE2 + 1);
                                                String tmp = request.getParameter("curPage2");
                                                if (tmp == null) {
                                                    tmp = "1";
                                                }
                                                curPage2 = Integer.parseInt(tmp);
                                                if (curPage2 >= pageCount2) {
                                                    curPage2 = pageCount2;
                                                }
                                                boolean flag = rs.absolute((curPage2 - 1) * PAGESIZE2 + 1);

                                                int count = 0;
                                                do {
                                                    if (count >= PAGESIZE2) {
                                                        break;
                                                    }

                                                    Timestamp timestamp = rs.getTimestamp(1);
                                                    int cardNumber = rs.getInt(2);
                                                    double amount = rs.getDouble(3);
                                                    String paymentType = rs.getString(4);
                                                    int staffId = rs.getInt(5);
                                                    name = StaffDAO.retrieveById(staffId).getName();
                                                    count++;
                                        %>
                                        <tr><td><%=timestamp%></td><td><%=cardNumber%></td><td>充值</td><td><%=paymentType%></td><td><%=amount%></td><td><%=name%></td><td>充值</td></tr>
                                        <%

                                                } while (rs.next());
                                            } catch (SQLException e) {
                                                e.printStackTrace();
                                            } finally {
                                                ConnectionManager.close(conn, preStmt, rs);

                                            }%>
                                    </table>
                                    <a href = "staffRecord.jsp?curPage2=1&id=<%=id%>" >首页</a>  
                                    <a href = "staffRecord.jsp?curPage2=<%=curPage2 - 1%>&id=<%=id%>" >上一页</a>  
                                    <a href = "staffRecord.jsp?curPage2=<%=curPage2 + 1%>&id=<%=id%>" >下一页</a>  
                                    <a href = "staffRecord.jsp?curPage2=<%=pageCount2%>&id=<%=id%>" >尾页</a>  
                                    <form>
                                        <input type="text" name="curPage2" placeholder="跳转" class="m-wrap small" >
                                        <input type="submit" value="跳转">
                                    </form>
                                    第<%=curPage2%>页/共<%=pageCount2%>页 
                                </div>
                            </div>
                        </div>
                                
                        <div class="span12">
                            <div class="portlet box blue">
                                <div class="portlet-title">
                                    <div class="caption">工单记录3:产品类</div>
                                </div>

                                <div class="portlet-body">
                                    <table class="table table-hover table-bordered">
                                        <thead><tr><th>日期</th><th>会员卡号</th><th>消费产品</th><th>支付方式</th><th>支付金额</th><th>操作员</th></tr></thead>

                                        <%
                                            String sql3 = "";
                                            if (request.getParameter("startDate") == null) {
                                                sql3 = "SELECT dateTime, cardNumber,p2.name,p1.type,p1.cost, s.name  FROM `productorder` p1, `product` p2, `staff` s WHERE p1.productId = p2.id and p1.staffId = s.id and staffId = " + Integer.parseInt(id);
                                            } else {
                                                String startTime = request.getParameter("startDate");
                                                String endTime = request.getParameter("endDate");
                                                sql3 = "SELECT dateTime, cardNumber,p2.name,p1.type,p1.cost, s.name  FROM `productorder` p1, `product` p2, `staff` s WHERE p1.productId = p2.id and p1.staffId = s.id and staffId = " + Integer.parseInt(id) + " and dateTime >=\"" + startTime + "\" and dateTime <=\"" + endTime + " 23:59:59\" order by dateTime";
                                            }

                                            try {
                                                conn = ConnectionManager.getConnection();
                                                preStmt = conn.prepareStatement(sql3);
                                                rs = preStmt.executeQuery();
                                                rs.last();
                                                int size = rs.getRow();
                                                pageCount3 = (size % PAGESIZE3 == 0) ? (size / PAGESIZE3) : (size / PAGESIZE3 + 1);
                                                String tmp = request.getParameter("curPage3");
                                                if (tmp == null) {
                                                    tmp = "1";
                                                }
                                                curPage3 = Integer.parseInt(tmp);
                                                if (curPage3 >= pageCount3) {
                                                    curPage3 = pageCount3;
                                                }
                                                boolean flag = rs.absolute((curPage3 - 1) * PAGESIZE3 + 1);

                                                int count = 0;
                                                do {
                                                    if (count >= PAGESIZE3) {
                                                        break;
                                                    }

                                                    Timestamp timestamp = rs.getTimestamp(1);
                                                    int cardNumber = rs.getInt(2);
                                                    String productName = rs.getString(3);
                                                    String paymentType = rs.getString(4);
                                                    double cost = rs.getDouble(5);
                                                    String staffName = rs.getString(6);
                                                    count++;
                                        %>
                                        <tr><td><%=timestamp%></td><td><%=cardNumber%></td><td><%=productName%></td><td><%=paymentType%></td><td><%=cost%></td><td><%=staffName%></td></tr>
                                        <%

                                                } while (rs.next());
                                            } catch (SQLException e) {
                                                e.printStackTrace();
                                            } finally {
                                                ConnectionManager.close(conn, preStmt, rs);

                                            }%>
                                    </table>
                                    <a href = "staffRecord.jsp?curPage3=1&id=<%=id%>" >首页</a>  
                                    <a href = "staffRecord.jsp?curPage3=<%=curPage3 - 1%>&id=<%=id%>" >上一页</a>  
                                    <a href = "staffRecord.jsp?curPage3=<%=curPage3 + 1%>&id=<%=id%>" >下一页</a>  
                                    <a href = "staffRecord.jsp?curPage3=<%=pageCount3%>&id=<%=id%>" >尾页</a>  
                                    <form>
                                        <input type="text" name="curPage3" placeholder="跳转" class="m-wrap small" >
                                        <input type="submit" value="跳转">
                                    </form>
                                    第<%=curPage3%>页/共<%=pageCount3%>页 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
