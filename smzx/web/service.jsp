<%-- 
    Document   : service
    Created on : Dec 9, 2015, 10:59:43 PM
    Author     : lvbowen
--%>

<%@page import="com.app.controller.ServiceManager"%>
<%@page import="com.app.model.Service"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>服务项目</title>
    </head>
    <body>
        <div class="page-content">
            <div class="span12">
                <h3 class="page-title">
                    服务项目管理
                </h3>
                <ul class="breadcrumb">

                    <li>

                        <i class="icon-user"></i>
                        服务项目管理
                        <i class="icon-angle-right"></i>

                    </li>

                    <li>

                        服务项目管理

                    </li>
                </ul>
            </div>
            <br/>
            <div class="container">
                <div class="span8">
                    <div class="portlet box white">
                        <div class="portlet-title">

                            <div class="caption"><i class="m-icon-swapright"></i><a href="addService.jsp">新增服务项目</a></div>

                        </div>
                        <div class="portlet-body">

                            <table class="table table-hover table-bordered">

                                <thead> <tr><th>操作</th><th>序号</th><th>项目名称</th><th>默认价格</th><th>种类</th></tr></thead>
                                <tbody>
                                    <%ArrayList<Service> services = ServiceManager.retrieveAll();
                                        for (int i = 0; i < services.size(); i++) {
                                            Service service = services.get(i);
                                    %>
                                    <tr><td><a href="updateService.jsp?id=<%= service.getId()%>"> 修改</a></td>
                                        <td><%= service.getId()%></td><td><%= service.getDetail()%></td><td><%= service.getPrice()%></td><td><%= service.getType()%></td></tr>
                                        <%}%>
                                </tbody>
                            </table>

                            <%String msg = request.getParameter("msg");
                                if (msg != null) {
                                    out.println(msg);
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
