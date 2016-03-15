<%@page import="com.app.model.ProductOrderDAO"%>
<%@page import="com.app.model.ProductDAO"%>
<%@page import="com.app.model.ProductOrder"%>
<%@page import="com.app.controller.ConnectionManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.app.model.OrderDAO"%>
<%@page import="com.app.model.Topup"%>
<%@page import="com.app.model.TopupDAO"%>
<%@page import="com.app.model.Service"%>
<%@page import="com.app.model.StaffDAO"%>
<%@page import="com.app.model.ServiceDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.app.model.Order"%>
<%@page import="com.app.controller.StaffManager"%>
<%@page import="com.app.model.Staff"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.controller.OrderManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="include/navigationBar.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script language="javascript">
            function getDate() {
                var now = new Date();
                document.write("今天是" + now.year() + "年" + now.month() + "月" + now.day() + "日");
            }
        </script>
        <title>数据统计报表</title>
    </head>
    <%!
        public static final int PAGESIZE1 = 10;
        int pageCount1;
        int curPage1 = 1;

        public static final int PAGESIZE2 = 10;
        int pageCount2;
        int curPage2 = 1;

        public static final int PAGESIZE3 = 10;
        int pageCount3;
        int curPage3 = 1;
        
        public static final int PAGESIZE4 = 10;
        int pageCount4;
        int curPage4 = 1;
    %>
    <body>
        <div class="page-content">
            <div class="span12">
                <h3 class="page-title">
                    数据统计报表
                </h3>

                <ul class="breadcrumb">
                    <li>

                        <i class="icon-home"></i>
                        数据统计报表

                    </li>
                </ul>
            </div>

            <div class="row-fluid">
                <div class="span6">
                    <div class="portlet-body">
                        <div class="portlet box blue">
                            <div class="portlet-title">

                                <div class="caption">员工工单记录查询</div>

                            </div>
                        </div>
                        <form action="recordAnalysis.jsp" method="post">
                            <table class="table table-hover table-bordered">
                                <tr>
                                    <td>开始日期</td> <td><input type="date" name="startDate"/></td>
                                </tr>
                                <tr>
                                    <td>结束日期</td> <td><input type="date" name="endDate"/></td>
                                </tr>
                                <tr><td>员工姓名</td>  <td><select name="staffId">
                                            <%ArrayList<Staff> staffs = StaffManager.getAll();
                                                for (Staff s : staffs) {
                                                    if (!s.getStatus().equals("离职")) {
                                            %>
                                            <option value="<%=s.getStaffId()%>"><%=s.getName()%></option>
                                            <%}
                                                }%>
                                        </select>
                                    </td></tr>
                                <tr><td colspan="2" align="center"><input type="submit" value="提交"><input type="reset" value="重填" /></td></tr>
                            </table>
                            <input type="hidden" name="method" value="recordAnalysis">
                        </form>
                        <div>
                        </div>
                    </div>
                </div>
                <div class="span6">
                    <div class="portlet-body">
                        <div class="portlet box blue">
                            <div class="portlet-title">

                                <div class="caption">今日数据分析:
                                    <script type="text/javascript">
                                        var today = new Date(); //新建一个Date对象
                                        var date = today.getDate();//查询当月日期
                                        var day = today.getDay();//查询当前星期几  
                                        var month = today.getMonth();//查询月份  从0开始
                                        var year = today.getFullYear();//查询年份
                                        document.write(year + "年" + (month + 1) + "月" + date + "日<br />");
                                    </script></div>
                            </div>
                        </div>

                        <table class="table table-hover table-bordered">
                            <theah><tr><th>姓名</th><th>工单数量</th><th>总业绩</th><th>现金业绩</th><th>会员卡业绩</th><th>微信业绩</th><th>POS业绩</th><th>提成</th></tr></theah>
                            <tbody>
                                <%
                                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                                    String start = df.format(new Date()); //get current time
                                    double totalSumOfMoney = 0.0;
                                    double totalSalary = 0.0;
                                    double totalCashFlow = 0.0;
                                    double totalWechat = 0.0;
                                    double totalPos = 0.0;
                                    int totalNumber = 0;
                                    for (Staff s : staffs) {

                                        ArrayList<Order> orders = OrderManager.getOrderByTimeAndStaffId(s.getStaffId(), start, start);
                                        String status2 = s.getStatus();

                                        String name2 = s.getName();
                                        int numbers = orders.size();
                                        double sumOfMoney = 0.0;
                                        double salary = 0.0;
                                        double cashFlow = 0.0;
                                        double wechat = 0.0;
                                        double pos = 0.0;
                                        
                                        for (Order order : orders) {
                                            int serviceId = order.getServiceId();
                                            Service service = ServiceDAO.retrieveById(serviceId);
                                            String type2 = service.getType();
                                            double amount2 = order.getAmount();
                                            if (order.getType().equals("现金")) {
                                                cashFlow += amount2;
                                            } else if (order.getType().equals("微信")) {
                                                wechat += amount2;
                                            } else if (order.getType().equals("POS")) {
                                                pos += amount2;
                                            }
                                            sumOfMoney += amount2;
                                            if (status2.equals("发型师")) {
                                                if (type2.equals("大活")) {
                                                    salary += 0.27 * amount2;
                                                } else if (type2.equals("小活")) {
                                                    salary += 0.3 * amount2;
                                                }
                                            } else if (status2.equals("助理")) {
                                                if (type2.equals("大活")) {
                                                    salary += 0.09 * amount2;
                                                } else if (type2.equals("小活")) {
                                                    salary += 0.3 * amount2;
                                                }
                                            }
                                        }
                                        
                                        ArrayList<ProductOrder> productOrders = ProductOrderDAO.getProductOrderByTimeAndStaffId(s.getStaffId(),start,start);
                                        for(ProductOrder proOrder: productOrders) {
                                            String type = proOrder.getType();
                                            double cost = proOrder.getAmount();
                                            double moneyTaken = ProductDAO.retrieveMoneyTakenByProductId(proOrder.getProductId());
                                            if (type.equals("现金")) {
                                                cashFlow += cost;
                                            } else if (type.equals("微信")) {
                                                wechat += cost;
                                            } else if (type.equals("POS")) {
                                                pos += cost;
                                            }
                                            salary += moneyTaken;
                                            sumOfMoney += cost;
                                        }

                                        ArrayList<Order> orders2 = OrderDAO.getOrderByTimeAndStaffId2(s.getStaffId(), start, start);
                                        //numbers = numbers + orders2.size();
                                        for (Order order : orders2) {
                                            int serviceId = order.getServiceId();
                                            Service service = ServiceDAO.retrieveById(serviceId);
                                            String type2 = service.getType();
                                            double amount2 = order.getAmount();
                                            //sumOfMoney += amount2;
                                            if (status2.equals("助理")) {
                                                if (type2.equals("大活")) {
                                                    salary += 0.045 * amount2;
                                                }
                                            }
                                        }

                                        ArrayList<Topup> topups = TopupDAO.retrieveByTimeAndStaffId(s.getStaffId(), start, start);
                                        numbers = numbers + topups.size();
                                        for (Topup topup : topups) {
                                            sumOfMoney += topup.getAmount();
                                            cashFlow += topup.getAmount();
                                            salary += 0.05 * topup.getAmount();
                                        }
                                        DecimalFormat decimalFormat = new DecimalFormat("0.00");
                                %>
                                <tr><td><%=name2%></td><td><%=numbers%></td><td><%=sumOfMoney%></td><td><%=cashFlow%></td><td><%= sumOfMoney - cashFlow - wechat - pos%></td>
                                    <td><%=wechat%></td><td><%=pos%></td><td><%=decimalFormat.format(salary)%></td></tr>
                                    <%
                                            totalNumber += numbers;
                                            totalSumOfMoney += sumOfMoney;
                                            totalSalary += salary;
                                            totalCashFlow += cashFlow;
                                            totalWechat += wechat;
                                            totalPos += pos;
                                        }
                                        DecimalFormat decimalFormat = new DecimalFormat("0.00");
                                    %>
                            </tbody>
                        </table>
                        <table class="table table-hover table-bordered">
                            <tr><th>合计</th><th>工单数量</th><th>业绩</th><th>现金业绩</th><th>会员卡业绩</th><th>微信业绩</th><th>POS业绩</th><th>提成</th></tr>   
                            <tr><td>合计</td><td><%=totalNumber%></td><td><%=totalSumOfMoney%></td><td><%=totalCashFlow%></td><td><%= totalSumOfMoney - totalCashFlow - totalWechat - totalPos%></td>
                                <td><%=totalWechat%></td><td><%=totalPos%></td><td><%= decimalFormat.format(totalSalary)%></td></tr>   
                        </table>
                    </div>
                </div>
            </div>
            <% String startDate = request.getParameter("startDate");
                String endDate = request.getParameter("endDate");
                int staffId9 = -1;
                if (request.getParameter("staffId") != null) {
                    staffId9 = Integer.parseInt(request.getParameter("staffId"));
                }
                if (startDate != null) {
            %>   
            <div class="container">
                <div class="span6">
                    <div class="portlet-body">
                        <div class="portlet box white">
                            <h3 class="page-title">
                                工单记录1:大活小活
                            </h3>
                            <%
                                double sumOfMoney2 = 0.0;
                                double salary2 = 0.0;
                                double cashFlow = 0.0;
                                double cardFlow = 0.0;
                                double wechat = 0.0;
                                double pos = 0.0;
                            %>
                            <table class="table table-hover table-bordered">
                                <tr><th>日期</th><th>会员卡号</th><th>消费项目</th><th>支付方式</th><th>支付金额</th><th>操作员</th></tr>
                                        <%
                                            ArrayList<Order> orders = new ArrayList<>();
                                            Connection conn = null;
                                            ResultSet rs = null;
                                            PreparedStatement preStmt = null;

                                            String sql = "select * from `order` where staffId =" + staffId9 + " and dateTime >= \"" + startDate + "\" and dateTime <= \"" + endDate + " 23:59:59\" order by dateTime";
                                            try {
                                                conn = ConnectionManager.getConnection();
                                                preStmt = conn.prepareStatement(sql);
                                                rs = preStmt.executeQuery();
                                                rs.last();
                                                int size = rs.getRow();
                                                pageCount1 = (size % PAGESIZE1 == 0) ? (size / PAGESIZE1) : (size / PAGESIZE1 + 1);
                                                String tmp = request.getParameter("curPage1");
                                                if (tmp == null) {
                                                    tmp = "1";
                                                }
                                                curPage1 = Integer.parseInt(tmp);
                                                if (curPage1 >= pageCount1) {
                                                    curPage1 = pageCount1;
                                                }
                                                boolean flag = rs.absolute((curPage1 - 1) * PAGESIZE1 + 1);

                                                int count = 0;

                                                do {
                                                    if (count >= PAGESIZE1) {
                                                        break;
                                                    }

                                                    int orderId = rs.getInt(1);
                                                    Timestamp timestamp = rs.getTimestamp(2);
                                                    int staffId = rs.getInt(3);
                                                    int staffId2 = rs.getInt(4);
                                                    int cardNumber = rs.getInt(5);
                                                    int serviceId = rs.getInt(6);
                                                    double amount = rs.getDouble(7);
                                                    String paymentType = rs.getString(8);
                                                    String details = ServiceDAO.retrieveById(serviceId).getDetail();
                                                    String workType = ServiceDAO.retrieveById(serviceId).getType();
                                                    if (paymentType.equals("现金")) {
                                                        cashFlow += amount;
                                                    } else if (paymentType.equals("微信")) {
                                                        wechat += amount;
                                                    } else if (paymentType.equals("POS")) {
                                                        pos += amount;
                                                    } else {
                                                        cardFlow += amount;
                                                    }
                                                    String serviceType = ServiceDAO.retrieveById(serviceId).getType();
                                                    String name = StaffDAO.retrieveById(staffId).getName();
                                                    String status = StaffDAO.retrieveById(staffId).getStatus();
                                                    sumOfMoney2 += amount;
                                                    if (status.equals("发型师")) {
                                                        if (serviceType.equals("大活")) {
                                                            salary2 += 0.27 * amount;
                                                        } else if (serviceType.equals("小活")) {
                                                            salary2 += 0.3 * amount;
                                                        }
                                                    } else if (status.equals("助理")) {
                                                        if (serviceType.equals("大活")) {
                                                            salary2 += 0.09 * amount;
                                                        } else if (serviceType.equals("小活")) {
                                                            salary2 += 0.3 * amount;
                                                        }
                                                    }
                                                    count++;
                                        %>
                                <tr><td><%=timestamp%></td>
                                    <td><%if (0 == cardNumber) {
                                            out.println("散客");
                                        } else {
                                            out.println(cardNumber);
                                        }%></td>
                                    <td><%=details%></td><td><%=paymentType%></td><td><%=amount%></td><td><%=name%></td></tr>
                                    <%
                                            } while (rs.next());
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        } finally {
                                            ConnectionManager.close(conn, preStmt, rs);

                                        }

                                        DecimalFormat decimalFormat2 = new DecimalFormat("0.00");

                                    %>
                            </table>
                            <a href = "recordAnalysis.jsp?curPage1=1&staffId=<%=staffId9%>&startDate=<%=startDate%>&endDate=<%=endDate%>" >首页</a>  
                            <a href = "recordAnalysis.jsp?curPage1=<%=curPage1 - 1%>&staffId=<%=staffId9%>&startDate=<%=startDate%>&endDate=<%=endDate%>" >上一页</a>  
                            <a href = "recordAnalysis.jsp?curPage1=<%=curPage1 + 1%>&staffId=<%=staffId9%>&startDate=<%=startDate%>&endDate=<%=endDate%>" >下一页</a>  
                            <a href = "recordAnalysis.jsp?curPage1=<%=pageCount1%>&staffId=<%=staffId9%>&startDate=<%=startDate%>&endDate=<%=endDate%>" >尾页</a>  
                            <form>
                                <input type="hidden" name="staffId" value="<%=staffId9%>">
                                <input type="hidden" name="startDate" value="<%=startDate%>">
                                <input type="hidden" name="endDate" value="<%=endDate%>">
                                <input type="text" name="curPage1" placeholder="跳转" class="m-wrap small" >
                                <input type="submit" value="跳转">
                            </form>
                            第<%=curPage1%>页/共<%=pageCount1%>页 
                            <br/>



                        </div>
                    </div>
                </div>

                <div class="span6">
                    <div class="portlet-body">
                        <div class="portlet box white">
                            <h3 class="page-title">
                                工单记录2:辅助类
                            </h3>
                            <table class="table table-hover table-bordered">
                                <tr><th>日期</th><th>会员卡号</th><th>消费项目</th><th>支付方式</th><th>支付金额</th><th>操作员</th></tr>

                                <%
                                    ArrayList<Order> orders2 = new ArrayList<>();
                                    String sql2 = "select * from `order` where staffId2 =" + staffId9 + " and dateTime >= \"" + startDate + "\" and dateTime <= \"" + endDate + " 23:59:59\" order by dateTime";

                                    try {
                                        conn = ConnectionManager.getConnection();
                                        preStmt = conn.prepareStatement(sql2);
                                        rs = preStmt.executeQuery();
                                        rs.last();
                                        int size = rs.getRow();
                                        pageCount2 = (size % PAGESIZE2 == 0) ? (size / PAGESIZE2) : (size / PAGESIZE2 + 1);
                                        String tmp = request.getParameter("curPage2");
                                        if (tmp == null) {
                                            tmp = "1";
                                        }
                                        curPage2 = Integer.parseInt(tmp);
                                        if (curPage2 >= pageCount2) {
                                            curPage2 = pageCount2;
                                        }
                                        boolean flag = rs.absolute((curPage2 - 1) * PAGESIZE2 + 1);

                                        int count = 0;

                                        do {
                                            if (count >= PAGESIZE2) {
                                                break;
                                            }

                                            int orderId = rs.getInt(1);
                                            Timestamp timestamp = rs.getTimestamp(2);
                                            int staffId = rs.getInt(3);
                                            int staffId2 = rs.getInt(4);
                                            int cardNumber = rs.getInt(5);
                                            int serviceId = rs.getInt(6);
                                            double amount = rs.getDouble(7);
                                            salary2 += amount * 0.045;
                                            String paymentType = rs.getString(8);
                                            String details = ServiceDAO.retrieveById(serviceId).getDetail();
                                            String workType = ServiceDAO.retrieveById(serviceId).getType();
                                            String name = StaffDAO.retrieveById(staffId).getName();
                                            String name2 = StaffDAO.retrieveById(staffId2).getName();
                   
                                            count++;

                                %>
                                <tr><td><%=timestamp%></td>
                                    <td><%if (0 == cardNumber) {
                                            out.println("散客");
                                        } else {
                                            out.println(cardNumber);
                                        }%></td>
                                    <td><%=details%></td><td><%=paymentType%></td><td><%=amount%></td><td><%=name%>(<%=name2%> 辅助)</td></tr>
                                    <%
                                            } while (rs.next());
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        } finally {
                                            ConnectionManager.close(conn, preStmt, rs);

                                        }
                                    %>
                            </table>
                            <a href = "recordAnalysis.jsp?curPage2=1&staffId=<%=staffId9%>&startDate=<%=startDate%>&endDate=<%=endDate%>" >首页</a>  
                            <a href = "recordAnalysis.jsp?curPage2=<%=curPage3 - 1%>&staffId=<%=staffId9%>&startDate=<%=startDate%>&endDate=<%=endDate%>" >上一页</a>  
                            <a href = "recordAnalysis.jsp?curPage2=<%=curPage3 + 1%>&staffId=<%=staffId9%>&startDate=<%=startDate%>&endDate=<%=endDate%>" >下一页</a>  
                            <a href = "recordAnalysis.jsp?curPage2=<%=pageCount3%>&staffId=<%=staffId9%>&startDate=<%=startDate%>&endDate=<%=endDate%>" >尾页</a>  
                            <form>
                                <input type="hidden" name="staffId" value="<%=staffId9%>">
                                <input type="hidden" name="startDate" value="<%=startDate%>">
                                <input type="hidden" name="endDate" value="<%=endDate%>">
                                <input type="text" name="curPage2" placeholder="跳转" class="m-wrap small" >
                                <input type="submit" value="跳转">
                            </form>
                            第<%=curPage2%>页/共<%=pageCount2%>页 
                        </div>
                    </div>
                </div>


                <div class="span6">
                    <div class="portlet-body">
                        <div class="portlet box white">
                            <h3 class="page-title">
                                工单记录3：充值类
                            </h3>
                            <table class="table table-hover table-bordered">
                                <tr><th>日期</th><th>会员卡号</th><th>消费项目</th><th>支付方式</th><th>支付金额</th><th>操作员</th></tr>

                                <%
                                    ArrayList<Topup> topups = new ArrayList<>();
                                    String sql3 = "select * from topup where staffId = " + staffId9 + " and dateTime >= \"" + startDate + "\" and dateTime <= \"" + endDate + "23:59:59\" order by dateTime";

                                    try {
                                        conn = ConnectionManager.getConnection();
                                        preStmt = conn.prepareStatement(sql3);
                                        rs = preStmt.executeQuery();
                                        rs.last();
                                        int size = rs.getRow();
                                        pageCount3 = (size % PAGESIZE3 == 0) ? (size / PAGESIZE3) : (size / PAGESIZE3 + 1);
                                        String tmp = request.getParameter("curPage3");
                                        if (tmp == null) {
                                            tmp = "1";
                                        }
                                        curPage3 = Integer.parseInt(tmp);
                                        if (curPage3 >= pageCount3) {
                                            curPage3 = pageCount3;
                                        }
                                        boolean flag = rs.absolute((curPage3 - 1) * PAGESIZE3 + 1);

                                        int count = 0;
                                        do {
                                            if (count >= PAGESIZE3) {
                                                break;
                                            }

                                            Timestamp timestamp = rs.getTimestamp(1);
                                            int cardNumber = rs.getInt(2);
                                            double amount = rs.getDouble(3);
                                            String paymentType = rs.getString(4);
                                            int staffId = rs.getInt(5);
                                            String name = StaffDAO.retrieveById(staffId).getName();
                                            cashFlow += amount;
                                            sumOfMoney2 += amount;
                                            salary2 += amount * 0.05;
                                            
                                %>
                                <tr><td><%=timestamp%></td><td><%=cardNumber%></td><td>充值</td><td><%=paymentType%></td><td><%=amount%></td><td><%=name%></td></tr>
                                <%
                                            count++;
                                        } while (rs.next());
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    } finally {
                                        ConnectionManager.close(conn, preStmt, rs);

                                    }%>
                            </table>
                            <a href = "member.jsp?curPage3=1&staffId=<%=staffId9%>&startDate=<%=startDate%>&endDate=<%=endDate%>" >首页</a>  
                            <a href = "recordAnalysis.jsp?curPage3=<%=curPage3 - 1%>&staffId=<%=staffId9%>&startDate=<%=startDate%>&endDate=<%=endDate%>" >上一页</a>  
                            <a href = "recordAnalysis.jsp?curPage3=<%=curPage3 + 1%>&staffId=<%=staffId9%>&startDate=<%=startDate%>&endDate=<%=endDate%>" >下一页</a>  
                            <a href = "recordAnalysis.jsp?curPage3=<%=pageCount3%>&staffId=<%=staffId9%>&startDate=<%=startDate%>&endDate=<%=endDate%>" >尾页</a>  
                            <form>
                                <input type="hidden" name="staffId" value="<%=staffId9%>">
                                <input type="hidden" name="startDate" value="<%=startDate%>">
                                <input type="hidden" name="endDate" value="<%=endDate%>">
                                <input type="text" name="curPage3" placeholder="跳转" class="m-wrap small" >
                                <input type="submit" value="跳转">
                            </form>
                            第<%=curPage3%>页/共<%=pageCount3%>页 
                        </div>
                    </div>
                </div>
                        
                <div class="span6">
                    <div class="portlet-body">
                        <div class="portlet box white">
                            <h3 class="page-title">
                                工单记录4:产品类
                            </h3>
                            <table class="table table-hover table-bordered">
                                <tr><th>日期</th><th>会员卡号</th><th>消费产品</th><th>支付方式</th><th>支付金额</th><th>操作员</th></tr>
                                        <%
                                            String sql4 = "SELECT dateTime, cardNumber,p2.name,p1.type,p1.cost, s.name, p1.productId  FROM `productorder` p1, `product` p2, `staff` s WHERE p1.productId = p2.id and p1.staffId = s.id and staffId = " + staffId9 + " and dateTime >=\"" + startDate + "\" and dateTime <=\"" + endDate + " 23:59:59\" order by dateTime";
                                            try {
                                                conn = ConnectionManager.getConnection();
                                                preStmt = conn.prepareStatement(sql4);
                                                rs = preStmt.executeQuery();
                                                rs.last();
                                                int size = rs.getRow();
                                                pageCount4 = (size % PAGESIZE4 == 0) ? (size / PAGESIZE4) : (size / PAGESIZE4 + 1);
                                                String tmp = request.getParameter("curPage4");
                                                if (tmp == null) {
                                                    tmp = "1";
                                                }
                                                curPage4 = Integer.parseInt(tmp);
                                                if (curPage4 >= pageCount4) {
                                                    curPage4 = pageCount4;
                                                }
                                                boolean flag = rs.absolute((curPage4 - 1) * PAGESIZE4 + 1);

                                                int count = 0;

                                                do {
                                                    if (count >= PAGESIZE4) {
                                                        break;
                                                    }

                                                    Timestamp timestamp = rs.getTimestamp(1);
                                                    int cardNumber = rs.getInt(2);
                                                    String productName = rs.getString(3);
                                                    String paymentType = rs.getString(4);
                                                    double cost = rs.getDouble(5);
                                                    String staffName = rs.getString(6);
                                                    int productId = rs.getInt(7);
                                                    if (paymentType.equals("现金")) {
                                                        cashFlow += cost;
                                                    } else if (paymentType.equals("微信")) {
                                                        wechat += cost;
                                                    } else if (paymentType.equals("POS")) {
                                                        pos += cost;
                                                    } else {
                                                        cardFlow += cost;
                                                    }
                                                    salary2+= ProductDAO.retrieveMoneyTakenByProductId(productId);
                                                    sumOfMoney2 += cost;
                                                    count++;
                                        %>
                                <tr><td><%=timestamp%></td>
                                    <td><%if (0 == cardNumber) {
                                            out.println("散客");
                                        } else {
                                            out.println(cardNumber);
                                        }%></td>
                                    <td><%=productName%></td><td><%=paymentType%></td><td><%=cost%></td><td><%=staffName%></td></tr>
                                    <%
                                            } while (rs.next());
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        } finally {
                                            ConnectionManager.close(conn, preStmt, rs);

                                        }

                                        DecimalFormat decimalFormat3 = new DecimalFormat("0.00");

                                    %>
                            </table>
                            <a href = "recordAnalysis.jsp?curPage4=1&staffId=<%=staffId9%>&startDate=<%=startDate%>&endDate=<%=endDate%>" >首页</a>  
                            <a href = "recordAnalysis.jsp?curPage4=<%=curPage4 - 1%>&staffId=<%=staffId9%>&startDate=<%=startDate%>&endDate=<%=endDate%>" >上一页</a>  
                            <a href = "recordAnalysis.jsp?curPage4=<%=curPage4 + 1%>&staffId=<%=staffId9%>&startDate=<%=startDate%>&endDate=<%=endDate%>" >下一页</a>  
                            <a href = "recordAnalysis.jsp?curPage4=<%=pageCount4%>&staffId=<%=staffId9%>&startDate=<%=startDate%>&endDate=<%=endDate%>" >尾页</a>  
                            <form>
                                <input type="hidden" name="staffId" value="<%=staffId9%>">
                                <input type="hidden" name="startDate" value="<%=startDate%>">
                                <input type="hidden" name="endDate" value="<%=endDate%>">
                                <input type="text" name="curPage4" placeholder="跳转" class="m-wrap small" >
                                <input type="submit" value="跳转">
                            </form>
                            第<%=curPage4%>页/共<%=pageCount4%>页 
                            <br/>



                        </div>
                    </div>
                </div>


                <div class="span6">
                    <div class="portlet-body">
                        <div class="portlet box white">
                            <h3 class="page-title">
                                总计
                            </h3>
                            <table class="table table-hover table-bordered">
                                <tr><th>总业绩</th><th>现金业绩</th><th>会员卡业绩</th><th>微信业绩</th><th>POS业绩</th><th>提成</th></tr>   
                                <tr><td><%=sumOfMoney2%></td><td><%=cashFlow%></td><td><%=cardFlow%></td><td><%=wechat%></td><td><%=pos%></td><td><%=decimalFormat2.format(salary2)%></td></tr>   
                            </table>
                        </div>
                    </div>
                </div>      
            </div>


            <%}%>


        </div>
    </body>
</html>
