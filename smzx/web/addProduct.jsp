<%-- 
    Document   : updateProduct
    Created on : Dec 26, 2015, 5:31:22 PM
    Author     : Wang Ziteng
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.ServiceDAO"%>
<%@page import="com.app.model.ProductDAO"%>
<%@page import="com.app.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新增产品</title>
    </head>
    <body>
        <div class="span15">
            <div class="page-content">
                <div class="span12">
                    <h3 class="page-title">
                        新增产品
                    </h3>

                    <ul class="breadcrumb">

                        <li>

                            <i class="icon-bookmark-empty"></i>
                            服务项目管理
                            <i class="icon-angle-right"></i>

                        </li>

                        <li>

                            产品管理
                            <i class="icon-angle-right"></i>
                        </li>
                        <li>

                            新增产品
                        </li>

                    </ul>
                </div>
                <br/>
                
                <%
                    ArrayList<String> details = ServiceDAO.retrieveAllDetails();
                %>


                <div class="container">
                    <div class="span6">
                        <div class="portlet box blue">
                            <div class="portlet-title">
                                <div class="caption">请输入</div>
                            </div>
                        </div>

                        <div class="portlet-body">
                            <form action="add" method="post">
                                <input type="hidden" name="method" value="product"/>
                            <table class="table table-hover table-bordered">
                                <thead>
                                </thead>
                                <tbody>
                                     <tr><td>产品名称</td><td><input type="text" name="productName" required=""></td></tr>
                                     <tr><td>价格</td><td><input type="text" name="cost" required=""></td></tr>
                                     <tr><td>提成</td><td><input type="text" name="moneyTaken" required=""></td></tr>
                                     
                                     
                                     <tr><td></td><td><input type="submit" value="提交"><input type="reset" value="重填" /></td></tr>
                                </tbody>
                            </table>
                                
                                
                            </form>
                        </div>

                    </div>



                </div>
            </div>
        </div>

    </body>
</html>
