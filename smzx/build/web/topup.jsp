<%-- 
    Document   : recharge
    Created on : Dec 4, 2015, 5:43:49 PM
    Author     : lvbowen
--%>

<%@page import="com.app.model.Staff"%>
<%@page import="com.app.controller.StaffManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.controller.MemberManager"%>
<%@page import="com.app.model.Member"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会员卡充值</title>
    </head>
    <body>
        <script>
            function getCardNumber() {
                var chkObjs = null;
                var discount = 0;
                var obj = document.getElementsByName("card")

                for (var i = 0; i < obj.length; i++) { //遍历Radio 
                    if (obj[i].checked) {
                        chkObjs = obj[i].value;
                        document.c.cardNumber.value = obj[i].value;
                    }
                }
            }
        </script>


        <div class="page-content">
            <div class="span12">
                <h3 class="page-title">会员卡充值</h3>
                <ul class="breadcrumb">

                    <li>

                        <i class="icon-home"></i>
                        会员卡充值

                    </li>



                </ul>
                <div class="span6">
                    <div class="portlet box blue">
                        <div class="portlet-title">

                            <div class="caption">请输入会员姓名或手机号</div>

                        </div>

                        <div class="portlet-body">
                            <form action="search" method="post">
                                <table class="table table-hover table-bordered">
                                    <thead>

                                    </thead>
                                    <tbody>
                                        <tr><td>会员姓名/电话</td><td><input type="text" name="input"></td><td><input type="submit" value="搜索"></td></tr>

                                    </tbody>
                                </table>
                                <input type="hidden" name="method" value="topup">
                            </form>
                        </div>
                    </div>
                </div>

                <div class="span7">
                    <div class="portlet box white">
                        <div class="portlet-title">

                            <div class="caption"></div>

                        </div>

                        <div class="portlet-body">
                            <form action="add" method="post" name="c">

                                <%   Member member = (Member) request.getAttribute("member");
                                    ArrayList<Member> members = (ArrayList<Member>) request.getAttribute("members");
                                    String cardNumber = request.getParameter("id");
                                    if ((request.getAttribute("search") != null && cardNumber == null && member == null && members == null)
                                            || (request.getAttribute("search") != null && members != null && members.size() == 0)) {
                                %>
                                <script>alert("没有该会员信息")</script>
                                <%
                                    }
                                    if (members == null) {
                                        if (cardNumber == null && member != null) {
                                            cardNumber = String.valueOf(member.getCardNumber());
                                        } else if (cardNumber != null && member == null) {
                                            member = MemberManager.retrieveByCardNumber(Integer.parseInt(cardNumber));
                                        }
                                %>

                                <table class="table table-hover table-bordered">
                                    <tbody>
                                        <%if (null != cardNumber) {%>
                                        <tr><td>会员卡卡号</td><td><input type="text" name="cardNumber" value="<%=cardNumber%>" required></td>
                                            <td><div>姓名:<%=member.getName()%></div><div>电话:<%=member.getPhoneNumber()%></div><div>余额:<%=member.getBalance()%></div></td></tr>
                                            <%} else {%>
                                        <tr><td>会员卡卡号</td><td><input type="text" name="cardNumber" required></td></tr>
                                                <%}%>

                                        <tr><td>充值金额</td><td><input type="text" name="amount" required/></td></tr>
                                        <tr><td>支付方式</td><td><label><input type="radio" name="type" value="现金" required checked>现金</label>
                                                <label><input type="radio" name="type" value="微信" required>微信</label>
                                                <label> <input type="radio" name="type" value="POS" required>POS机刷卡</label></td></tr>
                                        <tr><td>操作员</td>
                                            <td><%ArrayList<Staff> staffs = StaffManager.getAll();
                                                for (Staff s : staffs) {
                                                    if (!s.getStatus().equals("离职")) {
                                                    %>
                                                <label><input type="radio" name="staffId" value="<%=s.getStaffId()%>" required ><%=s.getName()%></label>
                                                <%}
                                                    }%></td></tr>
                                        <tr><td colspan="2" align="center"><input type="submit" value="充值"><input type="reset" value="重填" /></td></tr>
                                    </tbody>
                                </table>
                                <input type="hidden" name="method" value="topup">
                            </form>


                            <%} else if (members != null) {%>


                            <form action="add" method="post" name="c">
                                <table class="table table-hover table-bordered">
                                    <tbody>
                                        <tr><td>*会员卡卡号</td><td><input type="text" name="cardNumber" value="" required></td>
                                                <%for (Member m : members) {%> 
                                            <td> 
                                                <label>
                                                    <input type="radio" name="card" value="<%=m.getCardNumber()%>" onclick="getCardNumber();">
                                                    <span>卡号:<%=m.getCardNumber()%> 姓名:<%=m.getName()%> </span><br />
                                                    <span>电话:<%=m.getPhoneNumber()%></span><br /><span>余额:<%=m.getBalance()%></span>
                                                </label>
                                            </td> 
                                            <%}%>
                                        </tr>
                                        <tr><td>充值金额</td><td><input type="text" name="amount" required/></td></tr>
                                        <tr><td>支付方式</td><td><label><input type="radio" name="type" value="现金" required checked>现金</label>
                                                <label><input type="radio" name="type" value="微信" required>微信</label>
                                                <label> <input type="radio" name="type" value="POS" required>POS机刷卡</label></td></tr>
                                        <tr><td>操作员</td>
                                            <td><%ArrayList<Staff> staffs = StaffManager.getAll();
                                                for (Staff s : staffs) {
                                                    if (!s.getStatus().equals("离职")) {
                                                %>
                                                <label><input type="radio" name="staffId" value="<%=s.getStaffId()%>" required ><%=s.getName()%></label>
                                                    <%}
                                                    }%></td></tr>
                                        <tr><td colspan="2" align="center"><input type="submit" value="充值"><input type="reset" value="重填" /></td></tr>
                                    </tbody>
                                </table>
                                <input type="hidden" name="method" value="topup">
                                <%}%>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
