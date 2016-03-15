

<%@page import="java.sql.SQLException"%>
<%@page import="com.app.controller.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.Member"%>
<%@page import="com.app.controller.MemberManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>会员中心</title>
    </head>
    <body>
        <%!
            public static final int PAGESIZE = 10;
            int pageCount;
            int curPage = 1;
        %>
        <div class="page-content">
            <div class="span12">
                <h3 class="page-title">
                    会员管理
                </h3>

                <ul class="breadcrumb">

                    <li>

                        <i class="icon-user"></i>
                        会员管理
                        <i class="icon-angle-right"></i>

                    </li>

                    <li>

                        会员管理

                    </li>
                </ul>
            </div>
            <br/>

            <div class="container">
                <div class="span6">
                    <div class="portlet box blue">
                        <div class="portlet-title">

                            <div class="caption">请输入会员姓名或手机号</div>

                        </div>

                        <div class="portlet-body">
                            <form action="search" method="post">
                                <table class="table table-hover table-bordered">
                                    <tbody>
                                        <tr><td>会员姓名/电话</td><td><input type="text" name="input"></td>
                                            <td><input type="submit" value="搜索" class="btn blue"></td></tr>
                                    </tbody>
                                </table>
                                <input type="hidden" name="method" value="member">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <%
                Member member2 = (Member) request.getAttribute("member");
                ArrayList<Member> members2 = (ArrayList<Member>) request.getAttribute("members");
                if ((request.getAttribute("search") != null && member2 == null && members2 == null) || (request.getAttribute("search") != null && members2 != null && members2.size() == 0)) {
            %>
            <script>alert("没有该会员信息")</script>
            <%
            } else if (member2 != null && members2 == null) {
                response.sendRedirect("memberRecord.jsp?id=" + member2.getCardNumber());
            } else if (member2 == null && members2 != null) {
                if (members2.size() == 1) {
                    response.sendRedirect("memberRecord.jsp?id=" + members2.get(0).getCardNumber());
                } else {
            %>


            <div class="container">
                <div class="span6">
                    <div class="portlet box blue">
                        <div class="portlet-title">

                            <div class="caption">重复姓名会员选择</div>

                        </div>

                        <div class="portlet-body">

                            <table class="table table-hover table-bordered">
                                <thead>
                                    <tr><th>操作</th><th>会员卡号</th><th>姓名</th><th>手机号</th><th>性别</th><th>会员等级</th>
                                </thead>
                                <tbody>
                                    <%
                                        for (Member m : members2) {
                                    %>
                                    <tr>
                                        <td><i class="m-icon-swapright"></i><a href="memberRecord.jsp?id=<%= m.getCardNumber()%>"> 详细资料</a></td>
                                        <td><%= m.getCardNumber()%></td>
                                        <td><%= m.getName()%></td>
                                        <td><%= m.getPhoneNumber()%></td>
                                        <%if (m.getGender().equals("M")) {%>
                                        <td>男</td>
                                        <%} else {%>
                                        <td>女</td>
                                        <%}%>
                                        <td><%= m.getType()%></td>
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
            <%
                    }
                }
            %>


            <br/>

            <div class="container">
                <div class="span8">
                    <div class="portlet box white">
                        <div class="portlet-title">

                            <div class="caption"><i class="m-icon-swapright"></i><a href="addMember.jsp">新增会员</a></div>

                        </div>

                        <div class="portlet-body">
                            <table class="table table-hover table-bordered">
                                <thead>
                                    <tr><th>操作</th><th>会员卡号</th><th>姓名</th><th>手机号</th><th>性别</th><th>会员等级</th><th>储值余额</th></tr>
                                </thead>
                                <tbody>
                                    <%ArrayList<Member> members = new ArrayList<Member>();

                                        Connection conn = null;
                                        ResultSet rs = null;
                                        PreparedStatement preStmt = null;
                                        String sql = "select * from member";
                                        try {
                                            conn = ConnectionManager.getConnection();
                                            preStmt = conn.prepareStatement(sql);
                                            rs = preStmt.executeQuery();
                                            rs.last();
                                            int size = rs.getRow();
                                            pageCount = (size % PAGESIZE == 0) ? (size / PAGESIZE) : (size / PAGESIZE + 1);
                                            String tmp = request.getParameter("curPage");
                                            if (tmp == null) {
                                                tmp = "1";
                                            }
                                            curPage = Integer.parseInt(tmp);
                                            if (curPage >= pageCount) {
                                                curPage = pageCount;
                                            }
                                            boolean flag = rs.absolute((curPage - 1) * PAGESIZE + 1);

                                            int count = 0;

                                            do {
                                                if (count >= PAGESIZE) {
                                                    break;
                                                }

                                                int cardNumber = rs.getInt(1);
                                                String name = rs.getString(2);
                                                String gender = rs.getString(3);
                                                String phoneNumber = rs.getString(4);
                                                String type = rs.getString(5);
                                                double balance = rs.getDouble(6);
                                                count++;
                                                Member member = new Member(cardNumber, name, gender, phoneNumber, type, balance);
                                    %>
                                    <tr><td><a href="topup.jsp?id=<%= member.getCardNumber()%>">充值</a>
                                            <a href="updateMember.jsp?id=<%= member.getCardNumber()%>"> 修改</a>
                                            <a href="memberRecord.jsp?id=<%= member.getCardNumber()%>"> 详细资料</a></td>
                                        <td><%= member.getCardNumber()%></td><td><%= member.getName()%></td><td><%= member.getPhoneNumber()%></td>
                                        <%if (gender.equals("M")) {%>
                                        <td>男</td>
                                        <%} else {%>
                                        <td>女</td>
                                        <%}%>
                                        <td><%= member.getType()%></td><td><%= member.getBalance()%></td></tr>


                                    <%    } while (rs.next());
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        } finally {
                                            ConnectionManager.close(conn, preStmt, rs);

                                        }%>
                                </tbody>
                            </table>
                            <a href = "member.jsp?curPage=1" >首页</a>  
                            <a href = "member.jsp?curPage=<%=curPage - 1%>" >上一页</a>  
                            <a href = "member.jsp?curPage=<%=curPage + 1%>" >下一页</a>  
                            <a href = "member.jsp?curPage=<%=pageCount%>" >尾页</a>  
                            <form>
                                <input type="text" name="curPage" placeholder="跳转" class="m-wrap small" >
                                <input type="submit" value="跳转">
                            </form>
                            第<%=curPage%>页/共<%=pageCount%>页  
                        </div>
                    </div>
                </div>

            </div>

            <%  String msg = request.getParameter("msg");
                if (null != msg) {
            %>
            <script>alert("<%=msg%>")</script>
            <%
                }
            %>
        </div>
    </body>
</html>
