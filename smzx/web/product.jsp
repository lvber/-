<%-- 
    Document   : product
    Created on : Dec 26, 2015, 4:50:06 PM
    Author     : Wang Ziteng
--%>

<%@page import="com.app.model.ProductDAO"%>
<%@page import="com.app.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>产品管理</title>
    </head>
    <%
        ArrayList<Product> products = ProductDAO.getAllProducts();

    %>
    <body>
        <div class="span15">
            <div class="page-content">
                <div class="span12">
                    <h3 class="page-title">
                        产品管理
                    </h3>

                    <ul class="breadcrumb">

                        <li>

                            <i class="icon-bookmark-empty"></i>
                            服务项目管理
                            <i class="icon-angle-right"></i>

                        </li>

                        <li>

                            产品管理

                        </li>
                    </ul>
                </div>
                <br/>




                <div class="container">
                    <div class="span6">
                        <div class="portlet box white">
                            <div class="portlet-title">
                            <div class="caption"><i class="m-icon-swapright"></i><a href="addProduct.jsp">新增产品</a></div>
                            </div>
                            <div class="portlet-body">
                            <table class="table table-hover table-bordered">
                                <thead>
                                    <tr><th>操作</th><th>产品编号</th><th>产品名称</th><th>价格</th><th>提成</th></tr>
                                </thead>
                                <tbody>
                                    <%                                for (Product product : products) {
                                            int id = product.getId();
                                            String name = product.getName();
                                            double cost = product.getCost();
                                            double moneyTaken = product.getMoneyTaken();
                                    %>
                                    <tr>
                                        <td><a href="updateProduct.jsp?productId=<%= id%>">修改</a>
                                            <!--<a href="delete?id=<%= id%>&method=product"> 删除</a>-->
                                        </td>
                                        <td>
                                            <%=id%>
                                        </td>
                                        <td>
                                            <%=name%>
                                        </td>
                                        <td>
                                            <%=cost%>
                                        </td>
                                        <td>
                                            <%=moneyTaken%>
                                        </td>

                                    </tr>
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
        </div>
</div>
    </body>
</html>
