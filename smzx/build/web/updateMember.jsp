<%-- 
    Document   : update
    Created on : Dec 7, 2015, 8:47:26 PM
    Author     : lvbowen
--%>

<%@page import="com.app.model.Member"%>
<%@page import="com.app.model.MemberDAO"%>
<%@page import="com.app.model.CardLevelDAO"%>
<%@page import="com.app.model.CardLevel"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会员资料修改</title>
    </head>
    <body>
        <div class="page-content">
            <div class="span12">
                <h3 class="page-title">
                    会员资料修改
                </h3>

                <ul class="breadcrumb">

                    <li>

                        <i class="icon-user"></i>
                        会员管理
                        <i class="icon-angle-right"></i>

                    </li>

                    <li>

                        会员资料修改

                    </li>

                </ul>
            </div>


            <%ArrayList<CardLevel> cardLevels = CardLevelDAO.getAll();
                int id = Integer.parseInt(request.getParameter("id"));
                Member member = MemberDAO.retrieveByCardNumber(id);
            %>
            <div class="span6">
                <div class="portlet box blue">
                    <div class="portlet-title">

                        <div class="caption">请输入</div>

                    </div>

                    <div class="portlet-body">
                        <form action="update" method="post">
                            <table border="1">
                                <tr><td>会员卡卡号</td><td><input type="text" name="id" value="<%= id%>" readonly></td></tr>
                                <tr><td>姓名</td><td><input type="text" name="name" value="<%= member.getName()%>" ></td></tr>
                                        <%
                                            if (member.getGender().equals("M")) {
                                        %>
                                <tr><td>性别</td><td><label><input type="radio" name="gender" value="F">女</label><label><input type="radio" name="gender" value="M" checked>男</label></td></tr>
                                            <%
                                            } else if (member.getGender().equals("F")) {
                                            %>
                                <tr><td>性别</td><td><label><input type="radio" name="gender" value="F" checked>女</label><label><input type="radio" name="gender" value="M">男</label></td></tr>

                                <%
                                    }
                                %>
                                <tr><td>电话</td><td><input type="text" name="phone" value="<%= member.getPhoneNumber()%>" minlength="11" maxlength="11" required></td></tr>
                                <tr><td>会员等级</td><td><select name="cardlevel">
                                            <%for (CardLevel c : cardLevels) {%>
                                            <option value ="<%=c.getType()%>"><%=c.getType()%><%=c.getDiscount()%>折</option>
                                            <%}%>
                                        </select></td></tr>
                                <tr><td>余额</td><td><input type="text" name="balance" value="<%=member.getBalance()%>" readonly></td></tr>
                                <tr><td colspan="2" align="center"><input type="submit" value="提交"><input type="reset" value="重填" /></td></tr>
                            </table>
                            <input type="hidden" name="method" value="member"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
