<%-- 
    Document   : staff
    Created on : Dec 5, 2015, 2:10:23 PM
    Author     : lvbowen
--%>

<%@page import="com.app.model.Staff"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.StaffDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>员工中心</title>
    </head>
    <body>  
        <div class="page-content">
            <div class="span12">
                <h3 class="page-title">
                    员工管理
                </h3>
                <%
                    StaffDAO staffDAO = new StaffDAO();
                    ArrayList<Staff> staffList = staffDAO.getAll();
                %>
                <ul class="breadcrumb">

                    <li>

                        <i class="icon-user"></i>
                        员工管理
                        <i class="icon-angle-right"></i>

                    </li>

                    <li>

                        员工管理

                    </li>
                </ul>
            </div>
            <br/>

            <div class="container">
                <div class="span8">
                    <div class="portlet box white">
                        <div class="portlet-title">

                            <div class="caption"><i class="m-icon-swapright"></i><a href="addStaff.jsp">新增员工</a></div>

                        </div>

                        <div class="portlet-body">

                            <table class="table table-hover table-bordered">

                                <thead><tr><th>操作</th><th>ID</th><th>姓名</th><th>手机号</th><th>性别</th><th>基本工资</th><th>状态</th></tr></thead>
                                <tbody>
                                    <%
                                        for (Staff staff : staffList) {
                                            int id = staff.getStaffId();
                                            String name = staff.getName();
                                            String gender = staff.getGender();
                                            String phone = staff.getPhoneNumber();
                                            double salary = staff.getSalary();
                                            String status = staff.getStatus();
                                    %>
                                    <tr><td><a href="updateStaff.jsp?id=<%=id%>"> 修改</a>
                                            <a href="staffRecord.jsp?id=<%=id%>"> 工作记录</a></td>
                                        <td><%=id%></td><td><%=name%></td><td><%=phone%></td>
                                        <%if (gender.equals("M")) {%>
                                        <td>男</td>
                                        <%} else {%>
                                        <td>女</td>
                                        <%}%>
                                        <td><%=salary%></td>
                                        <td><%=status%></td></tr>
                                        <%
                                            }
                                        %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
