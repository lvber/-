<%-- 
    Document   : add
    Created on : Dec 4, 2015, 5:43:26 PM
    Author     : lvbowen
--%>
<%@page import="com.app.model.Staff"%>
<%@page import="com.app.controller.StaffManager"%>
<%@page import="com.app.model.CardLevelDAO"%>
<%@page import="com.app.model.CardLevel"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新增会员</title>
    </head>
    <body>
        <div class="page-content">
            <div class="span12">
                <h3 class="page-title">
                    新增会员
                </h3>

                <ul class="breadcrumb">

                    <li>

                        <i class="icon-user"></i>
                        会员管理
                        <i class="icon-angle-right"></i>

                    </li>

                    <li>

                        新增会员

                    </li>

                </ul>
            </div>



            <div class="span6">
                <div class="portlet box blue">
                    <div class="portlet-title">

                        <div class="caption">请输入</div>

                    </div>

                    <div class="portlet-body">
                        <form action="add" method="post">
                            <table class="table table-hover table-bordered">
                                <tbody>
                                    <tr><td>姓名</td><td><input type="text" name="name" required=""/></td></tr>
                                    <tr><td>性别</td><td><label><input type="radio" name="gender" value="F">女</label><label><input type="radio" name="gender" value="M">男</label></td></tr>
                                    <tr><td>电话</td><td><input type="text" name="phone" minlength="11" maxlength="11" required=""/></td></tr>
                                    <tr><td>充值金额</td><td><input type="text" name="balance" required=""/></td></tr>
                                    <tr><td>会员等级</td><td><select name="cardLevel" >
                                                <%ArrayList<CardLevel> cardLevels = CardLevelDAO.getAll();
                                                    for (CardLevel c : cardLevels) {
                                                %>
                                                <option value ="<%=c.getType()%>"><%=c.getType()%><%=c.getDiscount()%>折</option>
                                                <%}%>
                                            </select>

                                        </td></tr>
                                    <tr><td>支付方式</td><td><label><input type="radio" name="type" value="现金" required checked>现金</label>
                                            <label><input type="radio" name="type" value="微信" required>微信</label>
                                            <label> <input type="radio" name="type" value="POS" required>POS机刷卡</label></td></tr>
                                    <tr><td>操作员</td>
                                        <td><%ArrayList<Staff> staffs = StaffManager.getAll();
                                            for (Staff s : staffs) {
                                                if (!s.getStatus().equals("离职")) {
                                            %>
                                            <label><input type="radio" name="staffId" value="<%=s.getStaffId()%>" required ><%=s.getName()%></label>
                                            <%}
                                                    }%></td></tr>
                                    <tr><td></td><td colspan="2" align="center"><input type="submit" value="提交"><input type="reset" value="重填" /></td></tr>

                                </tbody>
                            </table>
                            <input type="hidden" name="method" value="member">
                        </form>
                    </div>
                </div>
            </div>


            <%  String msg = request.getParameter("msg");
                if (null != msg) {
            %>
            <script>alert("添加失败，手机号重复！")</script>
            <%
                }
            %>
        </div>

    </body>
</html>
