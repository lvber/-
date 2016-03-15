<%-- 
    Document   : updateCardLevel
    Created on : Dec 7, 2015, 9:15:43 PM
    Author     : lvbowen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会员卡等级修改</title>
    </head>
    <%
        /*if(request.getParameter("type") == null) {
            response.sendRedirect("cardLevel.jsp");
        }*/
        String type = request.getParameter("type");
        String discount = request.getParameter("discount");
        String minCharge = request.getParameter("minCharge");
    %>
    <body>
        <div class="page-content">

            <div class="span12">
                <h3 class="page-title">
                    会员卡等级修改
                </h3>

                <ul class="breadcrumb">

                    <li>

                        <i class="icon-user"></i>
                        会员管理
                        <i class="icon-angle-right"></i>

                    </li>

                    <li>

                        <a href="cardLevel.jsp">会员级别管理</a>

                        <i class="icon-angle-right"></i>

                    </li>

                    <li>会员卡等级修改</li>

                </ul>
            </div>
            <div class="span6">
                <div class="portlet box blue">
                    <div class="portlet-title">

                        <div class="caption">请输入</div>

                        <div class="tools">
                        </div>

                    </div>

                    <div class="portlet-body">
                        <form action="update" method="post">
                            <input type="hidden" value="cardLevel" name="method">
                            <table border="1">
                                <tr><td>级别名称</td><td><input type="text" name="name" value=<%=type%> readonly/></td></tr>
                                <tr><td>折扣</td><td><input type="text" name="discount" value=<%=discount%> /></td></tr>
                                <tr><td>最低充值金额</td><td><input type="text" name="minCharge" value=<%=minCharge%> /></td></tr>
                                <tr><td colspan="2" align="center"><input type="submit" value="提交"><input type="reset" value="重填" /></td></tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
