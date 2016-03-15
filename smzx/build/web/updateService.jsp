<%-- 
    Document   : updateService
    Created on : Dec 9, 2015, 11:01:11 PM
    Author     : lvbowen
--%>

<%@page import="com.app.model.Service"%>
<%@page import="com.app.model.ServiceDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>服务项目修改</title>
    </head>
    <body>
        <div class="page-content">
            <div class="span12">
                <h3 class="page-title">
                    服务项目修改
                </h3>
                <ul class="breadcrumb">

                    <li>

                        <i class="icon-user"></i>
                        服务项目管理
                        <i class="icon-angle-right"></i>

                    </li>

                    <li>

                        服务项目修改

                    </li>
                </ul>
            </div>
            <br/>
            <%
                if (request.getParameter("id") == null) {
                    response.sendRedirect("service.jsp");
                }
                int id = Integer.parseInt(request.getParameter("id"));
                Service service = ServiceDAO.retrieveById(id);
                String detail = service.getDetail();
                double price = service.getPrice();
                String type = service.getType();
            %>
            <div class="span6">
                <div class="portlet box blue">
                    <div class="portlet-title">

                        <div class="caption">请输入</div>

                    </div>

                    <div class="portlet-body">
                        <form action="update" method="post">
                            <input type="hidden" name="method" value="service">
                            <input type="hidden" name="id" value="<%=id%>">
                            <table border="1">
                                <tr><td>项目名称</td><td><input type="text" name="detail" value="<%=detail%>"></td></tr>
                                <tr><td>默认价格</td><td><input type="text" name="price" value="<%=price%>"></td></tr>
                                        <%if ("小活".equals(type)) {%>
                                <tr><td>种类</td><td><label><input type="radio" name="type" value="小活" checked>小活</label><label><input type="radio" name="type" value="大活">大活</label></td></tr>
                                            <%} else {%>
                                <tr><td>种类</td><td><label><input type="radio" name="type" value="小活">小活</label><label><input type="radio" name="type" value="大活" checked>大活</label></td></tr>
                                            <%}%>
                                <tr><td colspan="2" align="center"><input type="submit" value="提交"><input type="reset" value="重填" /></td></tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
