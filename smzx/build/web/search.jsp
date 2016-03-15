<%-- 
    Document   : search
    Created on : Dec 4, 2015, 5:44:07 PM
    Author     : lvbowen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>查找会员</title>
    </head>
    <body>
        <div class="page-content">
            <h1>会员搜索</h1>
            <form action="search" method="post">
                <table border="1">
                    <tr><td>姓名/电话</td><td><input type="text" name="input"></td></tr>
                    <tr><td colspan="2" align="center"><input type="submit" value="搜索"><input type="reset" value="重填" /></td></tr>
                </table>
                <input type="hidden" name="method" value="member">
            </form>
        </div>
    </body>
</html>
