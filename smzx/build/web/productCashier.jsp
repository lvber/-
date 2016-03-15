<%-- 
    Document   : cashier
    Created on : Dec 5, 2015, 2:12:45 PM
    Author     : lvbowen
--%>

<%@page import="com.app.model.Product"%>
<%@page import="com.app.controller.ProductManager"%>
<%@page import="com.app.model.CardLevelDAO"%>
<%@page import="com.app.model.ServiceDAO"%>
<%@page import="com.app.controller.CardManager"%>
<%@page import="com.app.controller.ServiceManager"%>
<%@page import="com.app.model.Service"%>
<%@page import="com.app.controller.StaffManager"%>
<%@page import="com.app.model.Staff"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.Member"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>收银台</title>
    </head>
    <body>
        <div class="page-content">
            <script>
                function getAmount() {
                    var chkObjs = null;
                    var amount = 0;
                    var obj = document.getElementsByName("productId")
                    for (var i = 0; i < obj.length; i++) { //遍历Radio 
                        if (obj[i].checked) {
                            chkObjs = obj[i].value;
                            amount = document.getElementsByName(chkObjs)[0].value;
                            document.c.realAmount.value = amount;
                        }
                    }
                }
                function getMemberPrice() {
                    var chkObjs = null;
                    var amount = 0;
                    var obj = document.getElementsByName("productId")
                    for (var i = 0; i < obj.length; i++) { //遍历Radio 
                        if (obj[i].checked) {
                            chkObjs = obj[i].value;
                            amount = document.getElementsByName(chkObjs)[0].value;
                            document.c.realAmount.value = amount * document.c.discount.value / 10;
                            ;

                        }
                    }
                }
                function getCardNumber() {
                    var chkObjs = null;
                    var discount = 0;
                    var obj = document.getElementsByName("card")

                    for (var i = 0; i < obj.length; i++) { //遍历Radio 
                        if (obj[i].checked) {
                            chkObjs = obj[i].value;
                            discount = document.getElementsByName(chkObjs)[0].value;
                            document.c.cardNumber.value = chkObjs;
                            document.c.discount.value = discount;
                            getRealAmountWithoutDiscount();
                            getRealAmountWithDiscount();
                        }
                    }
                }
            </script>

            <div class="span12">
                <h3 class="page-title">
                    产品收银台
                </h3>

                <ul class="breadcrumb">

                    <li>

                        <i class="icon-home"></i>
                        产品收银台

                    </li>



                </ul>
            </div>
            <div class="container" id="cashier" align="center">
                <div class="span16">
                    <div class="portlet box blue">
                        <div class="portlet-title">

                            <div class="caption">查找会员</div>

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
                                <input type="hidden" name="method" value="productCashier">
                            </form>
                        </div>
                    </div>
                </div>


                <%

                    Member member = (Member) request.getAttribute("member");
                    ArrayList<Member> members = (ArrayList<Member>) request.getAttribute("members");
                    if ((request.getAttribute("search") != null && member == null && members == null) || (request.getAttribute("search") != null && members != null && members.size() == 0)) {
                %>
                <script>alert("没有该会员信息")</script>
                <%
                    }
                    if ((member == null && members != null && members.size() == 0) || (member == null && members == null)) {
                %>


                <div class="span8">
                    <div class="portlet box white">
                        <div class="portlet-title">

                            <div class="caption"></div>

                        </div>

                        <div class="portlet-body">
                            <form action="add" method="post" name = "c">
                                <table class="table table-hover table-bordered">
                                    <tbody>
                                        <tr><td>*操作员</td>
                                            <td><%ArrayList<Staff> staffs = StaffManager.getAll();
                                                for (Staff s : staffs) {
                                                    if (!s.getStatus().equals("离职")) {
                                                %>
                                                <label><input type="radio" name="staffId" value="<%=s.getStaffId()%>" required ><%=s.getName()%></label>
                                                <%}
                                                        }%></td></tr>
                                        
                                        <tr><td>*会员卡卡号</td><td>散客</td></tr>
                                        <tr><td>*消费内容</td>
                                            <td><%ArrayList<Product> products = ProductManager.retrieveAll();
                                                for (int i = 0; i < products.size(); i++) {
                                                    Product p = products.get(i);
                                                %>
                                                <label><input type="radio" name="productId" value="<%=p.getId()%>" onclick="getAmount();" required ><%=p.getName()%><%=p.getCost()%></label>
                                                <input type="hidden" name="<%=p.getId()%>" value="<%=p.getCost()%>" >
                                                <%if ((i + 1) % 3 == 0) {
                                                            out.println("<br />");
                                                        }
                                                    }
                                                %>
                                            </td></tr>
                                        <!--<tr><td>消费金额</td><td><input type="hidden" name="amount" onkeypress="getRealAmountWithoutDiscount();
                                                this.value.change" onchange="getRealAmountWithoutDiscount();
                                                        this.value.change"></td></tr>-->
                                        <tr><td>折扣</td><td>无折扣</td></tr>
                                        <tr><td>*金额</td><td><input type="text" name="realAmount" required  ></td></tr>
                                        <tr><td>*支付方式</td><td><label><input type="radio" name="type" value="现金" required checked>现金</label>
                                                <label><input type="radio" name="type" value="会员卡" required>会员卡</label>
                                                <label><input type="radio" name="type" value="微信" required>微信</label>
                                                <label><input type="radio" name="type" value="POS" required>POS机刷卡</label></td></tr>
                                        <tr><td></td><td colspan="2" align="center"><input type="submit" value="提交"><input type="reset" value="重填" /></td></tr>

                                    </tbody>
                                </table>
                                <input type="hidden" name="cardNumber" value="0" >
                                <input type="hidden" name="discount" value="10.0" >
                                <input type="hidden" name="method" value="productCashier"/>
                            </form>
                        </div>
                    </div>
                </div>


            </div>
            <%} else if (member
                    != null) {%>


            <div class="span8">
                <div class="portlet box white">
                    <div class="portlet-title">

                        <div class="caption"></div>

                    </div>

                    <div class="portlet-body">
                        <form action="add" method="post" name="c">
                            <table class="table table-hover table-bordered">
                                <tbody>
                                    <tr><td>*操作员</td>
                                        <td><%ArrayList<Staff> staffs = StaffManager.getAll();
                                            for (Staff s : staffs) {
                                                if (!s.getStatus().equals("离职")) {
                                            %>
                                            <label><input type="radio" name="staffId" value="<%=s.getStaffId()%>" required><%=s.getName()%></label>
                                                <%}
                                                }%></td></tr>
                                    
                                    <tr><td>*会员卡卡号</td><td><input type="text" name="cardNumber" value="<%=member.getCardNumber()%>" required></td>
                                        <td><div>姓名:<%=member.getName()%></div><div>电话:<%=member.getPhoneNumber()%></div><div>余额:<%=member.getBalance()%></div></td></tr>
                                    <tr><td>*消费内容</td>
                                        <td><%ArrayList<Product> products = ProductManager.retrieveAll();
                                                for (int i = 0; i < products.size(); i++) {
                                                    Product p = products.get(i);
                                                %>
                                                <label><input type="radio" name="productId" value="<%=p.getId()%>" onclick="getAmount();" required ><%=p.getName()%><%=p.getCost()%></label>
                                                <input type="hidden" name="<%=p.getId()%>" value="<%=p.getCost()%>" >
                                                <%if ((i + 1) % 3 == 0) {
                                                            out.println("<br />");
                                                        }
                                                    }
                                                %>
                                            </td></tr>
                                    <!--<tr><td>消费金额</td><td><input id="1" type="text" name="amount" onkeypress="getRealAmountWithDiscount();
                                                this.value.change" onchange="getRealAmountWithDiscount();
                                                        this.value.change" ></td></tr>-->
                                    <tr><td>*实际金额</td><td><input id="3" type="text" name="realAmount" required></td></tr>
                                    <tr><td>*支付方式</td><td><label><input type="radio" name="type" value="现金" required >现金</label>
                                            <label><input type="radio" name="type" value="会员卡" required checked>会员卡</label>
                                            <label><input type="radio" name="type" value="微信" required>微信</label>
                                            <label><input type="radio" name="type" value="POS" required>POS机刷卡</label></td></tr>
                                    <tr><td></td><td colspan="2" align="center"><input type="submit" value="提交"><input type="reset" value="重填" /></td></tr>

                                </tbody>
                            </table>
                            <input type="hidden" name="method" value="productCashier"/>
                        </form>
                    </div>
                </div>
            </div>


        </div>
        <%} else if (members
                != null) {%>


        <div class="container" id="cashier" align="center">

            <div class="span8">
                <div class="portlet box white">
                    <div class="portlet-title">

                        <div class="caption"></div>

                    </div>

                    <div class="portlet-body">
                        <form action="add" method="post" name="c">
                            <table class="table table-hover table-bordered">
                                <tbody>
                                    <tr><td>*操作员</td>
                                        <td><%ArrayList<Staff> staffs = StaffManager.getAll();
                                            for (Staff s : staffs) {
                                                if (!s.getStatus().equals("离职")) {
                                            %>
                                            <label><input type="radio" name="staffId" value="<%=s.getStaffId()%>" required><%=s.getName()%></label>
                                                <%}
                                                    }%></td></tr>
                                    

                                    <%if (members.size() > 1) {%>
                                    <tr><td>*会员卡卡号</td><td><input type="text" name="cardNumber" value="" required></td>

                                        <%for (Member m : members) {
                                                String memberType = m.getType();
                                                double discount = CardLevelDAO.retrieveByType(memberType).getDiscount();
                                        %> <td> 
                                            <label>
                                                <input type="radio" name="card" value="<%=m.getCardNumber()%>" onclick="getCardNumber();">
                                                <input type="hidden" name="<%=m.getCardNumber()%>" value="<%=discount%>">
                                                <span>卡号:<%=m.getCardNumber()%> 姓名:<%=m.getName()%> </span><br />
                                                <span>电话:<%=m.getPhoneNumber()%></span><br /><span>余额:<%=m.getBalance()%></span>
                                            </label>
                                        </td> 
                                        <%}%>
                                    </tr>
                                    
                                            <%} else if (members.size() == 1) {
                                                Member m = members.get(0);
                                                String memberType = m.getType();
                                                double discount = CardLevelDAO.retrieveByType(memberType).getDiscount();
                                            %>
                                    <tr><td>*会员卡卡号</td><td><input type="text" name="cardNumber" value="<%=m.getCardNumber()%>" required></td>
                                        <td> 
                                            <label>
                                                <input type="radio" name="card" value="<%=m.getCardNumber()%>" onclick="getCardNumber();" checked>
                                                <input type="hidden" name="<%=m.getCardNumber()%>" value="<%=discount%>">
                                                <span>卡号:<%=m.getCardNumber()%> 姓名:<%=m.getName()%> </span><br />
                                                <span>电话:<%=m.getPhoneNumber()%></span><br /><span>余额:<%=m.getBalance()%></span>
                                            </label>
                                        </td> 
                                    </tr>
                                   
                                            <%}%>

                                    <tr><td>*消费内容</td>
                                        <td><%ArrayList<Product> products = ProductManager.retrieveAll();
                                                for (int i = 0; i < products.size(); i++) {
                                                    Product p = products.get(i);
                                                %>
                                                <label><input type="radio" name="productId" value="<%=p.getId()%>" onclick="getAmount();" required ><%=p.getName()%><%=p.getCost()%></label>
                                                <input type="hidden" name="<%=p.getId()%>" value="<%=p.getCost()%>" >
                                                <%if ((i + 1) % 3 == 0) {
                                                            out.println("<br />");
                                                        }
                                                    }
                                                %>
                                            </td></tr>
                                    <!-- <tr><td>消费金额</td><td><input id="1" type="text" name="amount" onkeypress="getRealAmountWithDiscount();
                                                 this.value.change" onchange="getRealAmountWithDiscount();
                                                         this.value.change" ></td></tr>-->

                                    <tr><td>*实际金额</td><td><input id="3" type="text" name="realAmount" required></td></tr>
                                    <tr><td>*支付方式</td><td><label><input type="radio" name="type" value="现金" required >现金</label>
                                            <label><input type="radio" name="type" value="会员卡" required checked>会员卡</label>
                                            <label><input type="radio" name="type" value="微信" required>微信</label>
                                            <label> <input type="radio" name="type" value="POS" required>POS机刷卡</label></td></tr>
                                    <tr><td></td><td colspan="2" align="center"><input type="submit" value="提交"><input type="reset" value="重填" /></td></tr>

                                </tbody>
                            </table>
                            <input type="hidden" name="method" value="productCashier"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <%}%>

        <%  String msg = request.getParameter("msg");
            if (null != msg
                    && msg.equals(
                            "success")) {
        %>
        <script>alert("操作成功！")</script>
        <%
        } else if (null != msg
                && msg.equals(
                        "failed")) {
        %>
        <script>alert("余额不足！")</script>
        <%}%>

    </body>
</html>
