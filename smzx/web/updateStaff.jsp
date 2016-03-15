<%-- 
    Document   : updateStaff
    Created on : Dec 7, 2015, 9:29:38 PM
    Author     : lvbowen
--%>

<%@page import="com.app.model.StaffDAO"%>
<%@page import="com.app.model.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>员工资料修改</title>
    </head>
    <body>
        <div class="page-content">
            <div class="span12">
                <h3 class="page-title">
                    员工资料修改
                </h3>

                <ul class="breadcrumb">

                    <li>

                        <i class="icon-sitemap"></i>
                        员工管理
                        <i class="icon-angle-right"></i>

                    </li>

                    <li>

                        员工资料修改

                    </li>
                </ul>
            </div>


            <%
                if (request.getParameter("id") == null) {
                    response.sendRedirect("staff.jsp");
                }
                String id = request.getParameter("id");
                Staff staff = StaffDAO.retrieveById(Integer.parseInt(id));
                String name = staff.getName();
                String gender = staff.getGender();
                String phone = staff.getPhoneNumber();
                double salary = staff.getSalary();
                String status = staff.getStatus();
            %>
            <div class="span6">
                <div class="portlet box blue">
                    <div class="portlet-title">

                        <div class="caption">请输入</div>

                    </div>

                    <div class="portlet-body">
                        <form action="update" method="post">
                            <input type="hidden" name="method" value="staff">
                            <input type="hidden" name="id" value=<%=id%>>
                            <table border="1">
                                <tr><td>姓名</td><td><input type="text" name="name" value="<%=name%>" required></td></tr>
                                        <%
                                            if (gender.equals("M")) {
                                        %>
                                <tr><td>性别</td><td><label><input type="radio" name="gender" value="F">女</label><label><input type="radio" name="gender" value="M" checked>男</label></td></tr>
                                            <%
                                            } else if (gender.equals("F")) {
                                            %>
                                <tr><td>性别</td><td><label><input type="radio" name="gender" value="F" checked>女</label><label><input type="radio" name="gender" value="M">男</label></td></tr>

                                <%
                                    }
                                %>
                                <tr><td>电话</td><td><input type="text" name="phone" value="<%=phone%>" minlength="11" maxlength="11" required=""></td></tr>
                                <tr><td>电话</td><td><input type="text" name="salary" value="<%=salary%>"  required=""></td></tr>
                                <tr><td>状态</td><td><select name="status">
                                            <%
                                                if (status.equals("发型师")) {
                                            %>
                                            <option value ="发型师" selected>发型师</option>
                                            <option value ="助理">助理</option>
                                            <option value ="学徒">学徒</option>
                                            <option value ="离职">离职</option>
                                            <%
                                            } else if (status.equals("助理")) {
                                            %>
                                            <option value ="发型师">发型师</option>
                                            <option value ="助理" selected>助理</option>
                                            <option value ="学徒">学徒</option>
                                            <option value ="离职">离职</option>
                                            <%
                                            } else if (status.equals("学徒")) {
                                            %>
                                            <option value ="发型师">发型师</option>
                                            <option value ="助理">助理</option>
                                            <option value ="学徒" selected>学徒</option>
                                            <option value ="离职">离职</option>
                                            <%
                                            } else {
                                            %>
                                            <option value ="发型师">发型师</option>
                                            <option value ="助理">助理</option>
                                            <option value ="学徒">学徒</option>
                                            <option value ="离职">离职</option>
                                            <%
                                                }
                                            %>
                                        </select></td></tr>
                                <tr><td colspan="2" align="center"><input type="submit" value="提交"><input type="reset" value="重填" ></td></tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
