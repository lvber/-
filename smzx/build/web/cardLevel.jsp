<%-- 
    Document   : cardlevel
    Created on : Dec 5, 2015, 2:45:04 PM
    Author     : lvbowen
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.CardLevelDAO"%>
<%@page import="com.app.model.CardLevel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会员级别管理</title>
    </head>
    <body>
        <div class="page-content">
            <%
                ArrayList<CardLevel> cardLevels = CardLevelDAO.getAll();
            %>

            <div class="span12">
                <h3 class="page-title">
                    会员级别管理
                </h3>

                <ul class="breadcrumb">

                    <li>

                        <i class="icon-user"></i>
                        会员管理
                        <i class="icon-angle-right"></i>

                    </li>

                    <li>

                        会员级别管理



                    </li>



                </ul>
            </div>






            <div class="span6">
                <div class="portlet box white">
                    <div class="portlet-title">

                        <div class="caption"><i class="m-icon-swapright"></i><a href="addCardLevel.jsp">新增会员级别</a></div>

                    </div>

                    <div class="portlet-body">

                        <table class="table table-hover table-bordered">
                            <thead>
                                <tr><th>操作</th><th>序号</th><th>级别名称</th><th>折扣</th><th>最低充值金额</th></tr>
                            </thead>
                            <tbody>
                                <%
                                    int num = 1;
                                    for (CardLevel cardLevel : cardLevels) {
                                        String type = cardLevel.getType();
                                        double discount = cardLevel.getDiscount();
                                        int minCharge = cardLevel.getMinCharge();
                                %>        
                                <tr><td><a href="updateCardLevel.jsp?type=<%=type%>&discount=<%=discount%>&minCharge=<%=minCharge%>">修改</a></td>
                                    <td><%=num++%></td><td><%=type%></td><td><%=discount%>折</td><td><%=minCharge%></td></tr>
                                    <%
                                        }
                                    %>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>

        </div>
    </body>
</html>
