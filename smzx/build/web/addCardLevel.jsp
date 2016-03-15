<%-- 
    Document   : addCardLevel
    Created on : Dec 7, 2015, 8:52:41 PM
    Author     : lvbowen
--%>
<%-- 
    Document   : navigationBar2
    Created on : Dec 19, 2015, 6:24:59 PM
    Author     : Wang Ziteng
--%>
<%@include file="include/navigationBar.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<!-- BEGIN PAGE -->



<div class="page-content">
    <div class="span12">
        <h3 class="page-title">
            新增会员卡等级
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

            <li>新增会员卡等级</li>

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
                <form action="add" method="post">
                    <input type="hidden" value="cardLevel" name="method">
                    <table class="table table-hover table-bordered">
                        <tbody>
                            <tr><td>级别名称</td><td><input type="text" name="name"/></td></tr>
                            <tr><td>折扣</td><td><input type="text" name="discount"></td></tr>
                            <tr><td>最低充值金额</td><td><input type="text" name="minCharge"/></td></tr>
                            <tr><td></td><td colspan="2" align="center"><input type="submit" value="提交"><input type="reset" value="重填" /></td></tr> 
                        </tbody>
                    </table>
                </form>
            </div>
        </div>

    </div>

</div>

<!-- END PAGE -->



</html>
