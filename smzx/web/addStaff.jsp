<%-- 
    Document   : addStaff
    Created on : Dec 7, 2015, 9:27:15 PM
    Author     : lvbowen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新增员工</title>
    </head>
    <body>
        <div class="page-content">
            <div class="span12">
                <h3 class="page-title">
                    新增员工
                </h3>

                <ul class="breadcrumb">

                    <li>

                        <i class="icon-sitemap"></i>
                        员工管理
                        <i class="icon-angle-right"></i>

                    </li>

                    <li>

                        新增员工


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
                            <input type="hidden" value="staff" name="method">
                            <table class="table table-hover table-bordered">
                                <tbody>
                                    <tr><td>姓名</td><td><input type="text" name="name" required></td></tr>
                                    <tr><td>性别</td><td><label><input type="radio" name="gender" value="F" required>女</label>
                                            <label><input type="radio" name="gender" value="M" required>男</label></td></tr>
                                    <tr><td>电话</td><td><input type="text" name="phone" minlength="11" maxlength="11" required=""></td></tr>
                                    <tr><td>基本工资</td><td><input type="text" name="salary" required=""></td></tr>
                                    <tr><td>状态</td><td><select name="status">
                                                <option value ="发型师">发型师</option>
                                                <option value ="助理">助理</option>
                                                <option value ="学徒">学徒</option>
                                                <option value ="离职">离职</option>
                                            </select></td></tr>
                                    <tr><td></td><td colspan="2" align="center"><input type="submit" value="提交"><input type="reset" value="重填"/></td></tr>

                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>
