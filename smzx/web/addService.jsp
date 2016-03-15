<%-- 
    Document   : addService
    Created on : Dec 9, 2015, 11:01:02 PM
    Author     : lvbowen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新增服务项目</title>
    </head>
    <body>
        <div class="page-content">
            <div class="span12">
                <h3 class="page-title">
                    新增服务项目
                </h3>

                <ul class="breadcrumb">

                    <li>

                        <i class="icon-bookmark-empty"></i>
                        服务项目管理
                        <i class="icon-angle-right"></i>

                    </li>

                    <li>

                        新增服务项目


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
                                    <tr><td>项目名称</td><td><input type="text" name="name" required=""/></td></tr>
                                    <tr><td>默认价格</td><td><input type="text" name="price" required=""></td></tr>
                                    <tr><td>种类</td><td><label><input type="radio" name="type" value="小活">小活</label>
                                            <label><input type="radio" name="type" value="大活">大活</label></td></tr>
                                    <tr><td></td><td colspan="2" align="center"><input type="submit" value="提交"><input type="reset" value="重填" /></td></tr>

                                </tbody>
                            </table>
                            <input type="hidden" name="method" value="service">
                        </form>
                    </div>
                </div>
            </div>


        </div>
    </body>
</html>
