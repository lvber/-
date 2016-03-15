package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.app.controller.ConnectionManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.app.model.OrderDAO;
import com.app.model.Topup;
import com.app.model.TopupDAO;
import com.app.model.Service;
import com.app.model.StaffDAO;
import com.app.model.ServiceDAO;
import java.sql.Timestamp;
import com.app.model.Order;
import com.app.controller.StaffManager;
import com.app.model.Staff;
import java.util.ArrayList;
import com.app.controller.OrderManager;

public final class recordAnalysis_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


        public static final int PAGESIZE1 = 10;
        int pageCount1;
        int curPage1 = 1;

        public static final int PAGESIZE2 = 10;
        int pageCount2;
        int curPage2 = 1;

        public static final int PAGESIZE3 = 10;
        int pageCount3;
        int curPage3 = 1;
    
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/include/navigationBar.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <link href=\"media/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/> \r\n");
      out.write("\r\n");
      out.write("        <link href=\"media/css/bootstrap-responsive.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"media/css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"media/css/style-metro.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"media/css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"media/css/style-responsive.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"media/css/default.css\" rel=\"stylesheet\" type=\"text/css\" id=\"style_color\"/>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"media/css/uniform.default.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("        <!-- END GLOBAL MANDATORY STYLES -->\r\n");
      out.write("\r\n");
      out.write("        <!-- BEGIN PAGE LEVEL STYLES --> \r\n");
      out.write("\r\n");
      out.write("        <link href=\"media/css/jquery.gritter.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"media/css/daterangepicker.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("        <link href=\"media/css/fullcalendar.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"media/css/jqvmap.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\"/>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"media/css/jquery.easy-pie-chart.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\"/>\r\n");
      out.write("\r\n");
      out.write("        <!-- END PAGE LEVEL STYLES -->\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"media/image/favicon.ico\" />\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body class=\"page-header-fixed\">\r\n");
      out.write("\r\n");
      out.write("        <!-- BEGIN HEADER -->\r\n");
      out.write("\r\n");
      out.write("        <div class=\"header navbar navbar-inverse navbar-fixed-top\">\r\n");
      out.write("\r\n");
      out.write("            <!-- BEGIN TOP NAVIGATION BAR -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"navbar-inner\">\r\n");
      out.write("\r\n");
      out.write("                <div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- BEGIN LOGO -->\r\n");
      out.write("\r\n");
      out.write("                    <a class=\"brand\" >\r\n");
      out.write("                        <font face=\"黑体\">尚美造型</font>\r\n");
      out.write("                    </a>\r\n");
      out.write("\r\n");
      out.write("                    <!-- END LOGO -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <!-- END TOP NAVIGATION BAR -->\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- END HEADER -->\r\n");
      out.write("\r\n");
      out.write("        <!-- BEGIN CONTAINER -->\r\n");
      out.write("\r\n");
      out.write("        <div class=\"page-container\">\r\n");
      out.write("\r\n");
      out.write("            <!-- BEGIN SIDEBAR -->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"page-sidebar nav-collapse collapse\">\r\n");
      out.write("\r\n");
      out.write("                <!-- BEGIN SIDEBAR MENU -->        \r\n");
      out.write("                <br/>\r\n");
      out.write("                <ul class=\"page-sidebar-menu\">\r\n");
      out.write("\r\n");
      out.write("                    <li class=\"\">\r\n");
      out.write("\r\n");
      out.write("                        <a href=\"cashier.jsp\">\r\n");
      out.write("\r\n");
      out.write("                            <i class=\"icon-home\"></i> \r\n");
      out.write("\r\n");
      out.write("                            <span class=\"title\">收银台</span>\r\n");
      out.write("\r\n");
      out.write("                            <span class=\"selected\"></span>\r\n");
      out.write("\r\n");
      out.write("                        </a>\r\n");
      out.write("\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                    <li class=\"\">\r\n");
      out.write("\r\n");
      out.write("                        <a href=\"javascript:;\">\r\n");
      out.write("\r\n");
      out.write("                            <i class=\"icon-user\"></i> \r\n");
      out.write("\r\n");
      out.write("                            <span class=\"title\">会员管理</span>\r\n");
      out.write("\r\n");
      out.write("                            <span class=\"arrow \"></span>\r\n");
      out.write("\r\n");
      out.write("                        </a>\r\n");
      out.write("\r\n");
      out.write("                        <ul class=\"sub-menu\">\r\n");
      out.write("\r\n");
      out.write("                            <li >\r\n");
      out.write("\r\n");
      out.write("                                <a href=\"addMember.jsp\">\r\n");
      out.write("\r\n");
      out.write("                                    新增会员</a>\r\n");
      out.write("\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li >\r\n");
      out.write("\r\n");
      out.write("                                <a href=\"member.jsp\">\r\n");
      out.write("\r\n");
      out.write("                                    会员管理</a>\r\n");
      out.write("\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li >\r\n");
      out.write("\r\n");
      out.write("                                <a href=\"cardLevel.jsp\">\r\n");
      out.write("\r\n");
      out.write("                                    会员级别管理</a>\r\n");
      out.write("\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </ul>\r\n");
      out.write("\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                    <li class=\"\">\r\n");
      out.write("\r\n");
      out.write("                        <a href=\"javascript:;\">\r\n");
      out.write("\r\n");
      out.write("                            <i class=\"icon-sitemap\"></i> \r\n");
      out.write("\r\n");
      out.write("                            <span class=\"title\">员工管理</span>\r\n");
      out.write("\r\n");
      out.write("                            <span class=\"arrow \"></span>\r\n");
      out.write("\r\n");
      out.write("                        </a>\r\n");
      out.write("\r\n");
      out.write("                        <ul class=\"sub-menu\">\r\n");
      out.write("\r\n");
      out.write("                            <li >\r\n");
      out.write("\r\n");
      out.write("                                <a href=\"addStaff.jsp\">\r\n");
      out.write("\r\n");
      out.write("                                    新增员工</a>\r\n");
      out.write("\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li >\r\n");
      out.write("\r\n");
      out.write("                                <a href=\"staff.jsp\">\r\n");
      out.write("\r\n");
      out.write("                                    员工管理</a>\r\n");
      out.write("\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </ul>\r\n");
      out.write("\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                    <li class=\"\">\r\n");
      out.write("\r\n");
      out.write("                        <a href=\"javascript:;\">\r\n");
      out.write("\r\n");
      out.write("                            <i class=\"icon-bookmark-empty\"></i> \r\n");
      out.write("\r\n");
      out.write("                            <span class=\"title\">服务项目管理</span>\r\n");
      out.write("\r\n");
      out.write("                            <span class=\"arrow \"></span>\r\n");
      out.write("\r\n");
      out.write("                        </a>\r\n");
      out.write("\r\n");
      out.write("                        <ul class=\"sub-menu\">\r\n");
      out.write("\r\n");
      out.write("                            <li >\r\n");
      out.write("\r\n");
      out.write("                                <a href=\"addService.jsp\">\r\n");
      out.write("\r\n");
      out.write("                                    新增服务项目</a>\r\n");
      out.write("\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("                            <li >\r\n");
      out.write("\r\n");
      out.write("                                <a href=\"service.jsp\">\r\n");
      out.write("\r\n");
      out.write("                                    服务项目管理</a>\r\n");
      out.write("\r\n");
      out.write("                            </li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </ul>\r\n");
      out.write("\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                    <li class=\"\">\r\n");
      out.write("\r\n");
      out.write("                        <a href=\"recordAnalysis.jsp\">\r\n");
      out.write("\r\n");
      out.write("                            <i class=\"icon-bar-chart\"></i> \r\n");
      out.write("\r\n");
      out.write("                            <span class=\"title\">数据统计</span>\r\n");
      out.write("\r\n");
      out.write("                            <span class=\"selected\"></span>\r\n");
      out.write("\r\n");
      out.write("                        </a>\r\n");
      out.write("\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                    <li class=\"last \">\r\n");
      out.write("\r\n");
      out.write("                        <a href=\"topup.jsp\">\r\n");
      out.write("\r\n");
      out.write("                            <i class=\"icon-briefcase\"></i> \r\n");
      out.write("\r\n");
      out.write("                            <span class=\"title\">快速充值</span>\r\n");
      out.write("\r\n");
      out.write("                        </a>\r\n");
      out.write("\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                </ul>\r\n");
      out.write("\r\n");
      out.write("                <!-- END SIDEBAR MENU -->\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- END FOOTER -->\r\n");
      out.write("\r\n");
      out.write("        <!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->\r\n");
      out.write("\r\n");
      out.write("        <!-- BEGIN CORE PLUGINS -->\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery-1.10.1.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery-migrate-1.2.1.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery-ui-1.10.1.custom.min.js\" type=\"text/javascript\"></script>      \r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/bootstrap.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!--[if lt IE 9]>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/excanvas.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/respond.min.js\"></script>  \r\n");
      out.write("\r\n");
      out.write("        <![endif]-->   \r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery.slimscroll.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery.blockui.min.js\" type=\"text/javascript\"></script>  \r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery.cookie.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery.uniform.min.js\" type=\"text/javascript\" ></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- END CORE PLUGINS -->\r\n");
      out.write("\r\n");
      out.write("        <!-- BEGIN PAGE LEVEL PLUGINS -->\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery.vmap.js\" type=\"text/javascript\"></script>   \r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery.vmap.russia.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery.vmap.world.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery.vmap.europe.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery.vmap.germany.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery.vmap.usa.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery.vmap.sampledata.js\" type=\"text/javascript\"></script>  \r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery.flot.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery.flot.resize.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery.pulsate.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/date.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/daterangepicker.js\" type=\"text/javascript\"></script>     \r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery.gritter.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/fullcalendar.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery.easy-pie-chart.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/jquery.sparkline.min.js\" type=\"text/javascript\"></script>  \r\n");
      out.write("\r\n");
      out.write("        <!-- END PAGE LEVEL PLUGINS -->\r\n");
      out.write("\r\n");
      out.write("        <!-- BEGIN PAGE LEVEL SCRIPTS -->\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/app.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"media/js/index.js\" type=\"text/javascript\"></script>        \r\n");
      out.write("\r\n");
      out.write("        <!-- END PAGE LEVEL SCRIPTS -->  \r\n");
      out.write("        <script>\r\n");
      out.write("\r\n");
      out.write("            jQuery(document).ready(function () {\r\n");
      out.write("\r\n");
      out.write("                App.init(); // initlayout and core plugins\r\n");
      out.write("\r\n");
      out.write("                Index.init();\r\n");
      out.write("\r\n");
      out.write("                Index.initJQVMAP(); // init index page's custom scripts\r\n");
      out.write("\r\n");
      out.write("                Index.initCalendar(); // init index page's custom scripts\r\n");
      out.write("\r\n");
      out.write("                Index.initCharts(); // init index page's custom scripts\r\n");
      out.write("\r\n");
      out.write("                Index.initChat();\r\n");
      out.write("\r\n");
      out.write("                Index.initMiniCharts();\r\n");
      out.write("\r\n");
      out.write("                Index.initDashboardDaterange();\r\n");
      out.write("\r\n");
      out.write("                Index.initIntro();\r\n");
      out.write("\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <!-- END JAVASCRIPTS -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script language=\"javascript\">\n");
      out.write("            function getDate() {\n");
      out.write("                var now = new Date();\n");
      out.write("                document.write(\"今天是\" + now.year() + \"年\" + now.month() + \"月\" + now.day() + \"日\");\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <title>数据统计报表</title>\n");
      out.write("    </head>\n");
      out.write("    ");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"page-content\">\n");
      out.write("            <div class=\"span12\">\n");
      out.write("                <h3 class=\"page-title\">\n");
      out.write("                    数据统计报表\n");
      out.write("                </h3>\n");
      out.write("\n");
      out.write("                <ul class=\"breadcrumb\">\n");
      out.write("                    <li>\n");
      out.write("\n");
      out.write("                        <i class=\"icon-home\"></i>\n");
      out.write("                        数据统计报表\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"row-fluid\">\n");
      out.write("                <div class=\"span6\">\n");
      out.write("                    <div class=\"portlet-body\">\n");
      out.write("                        <div class=\"portlet box blue\">\n");
      out.write("                            <div class=\"portlet-title\">\n");
      out.write("\n");
      out.write("                                <div class=\"caption\">员工工单记录查询</div>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <form action=\"recordAnalysis.jsp\">\n");
      out.write("                            <table class=\"table table-hover table-bordered\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>开始日期</td> <td><input type=\"date\" name=\"startDate\"/></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>结束日期</td> <td><input type=\"date\" name=\"endDate\"/></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr><td>员工姓名</td>  <td><select name=\"staffId\">\n");
      out.write("                                            ");
ArrayList<Staff> staffs = StaffManager.getAll();
                                                for (Staff s : staffs) {
                                                    if (!s.getStatus().equals("离职")) {
                                            
      out.write("\n");
      out.write("                                            <option value=\"");
      out.print(s.getStaffId());
      out.write('"');
      out.write('>');
      out.print(s.getName());
      out.write("</option>\n");
      out.write("                                            ");
}
                                                }
      out.write("\n");
      out.write("                                        </select>\n");
      out.write("                                    </td></tr>\n");
      out.write("                                <tr><td colspan=\"2\" align=\"center\"><input type=\"submit\" value=\"提交\"><input type=\"reset\" value=\"重填\" /></td></tr>\n");
      out.write("                            </table>\n");
      out.write("                            <input type=\"hidden\" name=\"method\" value=\"recordAnalysis\">\n");
      out.write("                        </form>\n");
      out.write("                        <div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"span6\">\n");
      out.write("                    <div class=\"portlet-body\">\n");
      out.write("                        <div class=\"portlet box blue\">\n");
      out.write("                            <div class=\"portlet-title\">\n");
      out.write("\n");
      out.write("                                <div class=\"caption\">今日数据分析:\n");
      out.write("                                    <script type=\"text/javascript\">\n");
      out.write("                                        var today = new Date(); //新建一个Date对象\n");
      out.write("                                        var date = today.getDate();//查询当月日期\n");
      out.write("                                        var day = today.getDay();//查询当前星期几  \n");
      out.write("                                        var month = today.getMonth();//查询月份  从0开始\n");
      out.write("                                        var year = today.getFullYear();//查询年份\n");
      out.write("                                        document.write(year + \"年\" + (month + 1) + \"月\" + date + \"日<br />\");\n");
      out.write("                                    </script></div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <table class=\"table table-hover table-bordered\">\n");
      out.write("                            <theah><tr><th>姓名</th><th>工单数量</th><th>总业绩</th><th>现金业绩</th><th>会员卡业绩</th><th>微信业绩</th><th>POS业绩</th><th>提成</th></tr></theah>\n");
      out.write("                            <tbody>\n");
      out.write("                                ");

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
                                
      out.write("\n");
      out.write("                                <tr><td>");
      out.print(name2);
      out.write("</td><td>");
      out.print(numbers);
      out.write("</td><td>");
      out.print(sumOfMoney);
      out.write("</td><td>");
      out.print(cashFlow);
      out.write("</td><td>");
      out.print( sumOfMoney - cashFlow - wechat - pos);
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(wechat);
      out.write("</td><td>");
      out.print(pos);
      out.write("</td><td>");
      out.print(decimalFormat.format(salary));
      out.write("</td></tr>\n");
      out.write("                                    ");

                                            totalNumber += numbers;
                                            totalSumOfMoney += sumOfMoney;
                                            totalSalary += salary;
                                            totalCashFlow += cashFlow;
                                            totalWechat += wechat;
                                            totalPos += pos;
                                        }
                                        DecimalFormat decimalFormat = new DecimalFormat("0.00");
                                    
      out.write("\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                        <table class=\"table table-hover table-bordered\">\n");
      out.write("                            <tr><th>合计</th><th>工单数量</th><th>业绩</th><th>现金业绩</th><th>会员卡业绩</th><th>微信业绩</th><th>POS业绩</th><th>提成</th></tr>   \n");
      out.write("                            <tr><td>合计</td><td>");
      out.print(totalNumber);
      out.write("</td><td>");
      out.print(totalSumOfMoney);
      out.write("</td><td>");
      out.print(totalCashFlow);
      out.write("</td><td>");
      out.print( totalSumOfMoney - totalCashFlow - totalWechat - totalPos);
      out.write("</td>\n");
      out.write("                                <td>");
      out.print(totalWechat);
      out.write("</td><td>");
      out.print(totalPos);
      out.write("</td><td>");
      out.print( decimalFormat.format(totalSalary));
      out.write("</td></tr>   \n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
 String startDate = request.getParameter("startDate");
                String endDate = request.getParameter("endDate");
                int staffId9 = -1;
                if(request.getParameter("staffId")!= null) {
                    staffId9 = Integer.parseInt(request.getParameter("staffId"));
                }
                if (startDate != null) {
            
      out.write("   \n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"span6\">\n");
      out.write("                    <div class=\"portlet-body\">\n");
      out.write("                        <div class=\"portlet box white\">\n");
      out.write("                            <h3 class=\"page-title\">\n");
      out.write("                                工单记录1\n");
      out.write("                            </h3>\n");
      out.write("                            ");

                                double sumOfMoney2 = 0.0;
                                double salary2 = 0.0;
                                double cashFlow = 0.0;
                                double cardFlow = 0.0;
                                double wechat = 0.0;
                                double pos = 0.0;
                            
      out.write("\n");
      out.write("                            <table class=\"table table-hover table-bordered\">\n");
      out.write("                                <tr><th>日期</th><th>会员卡号</th><th>消费项目</th><th>支付方式</th><th>支付金额</th><th>操作员</th></tr>\n");
      out.write("                                        ");

                                            ArrayList<Order> orders = new ArrayList<>();
                                            Connection conn = null;
                                            ResultSet rs = null;
                                            PreparedStatement preStmt = null;
                                            String sql = "select * from `order` where staffId =" + staffId9 + " and dateTime >= " + startDate + " and dateTime <= " + endDate + " order by dateTime";
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

                                        
      out.write("\n");
      out.write("                                <tr><td>");
      out.print(timestamp);
      out.write("</td>\n");
      out.write("                                    <td>");
if (0 == cardNumber) {
                                            out.println("散客");
                                        } else {
                                            out.println(cardNumber);
                                        }
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(details);
      out.write("</td><td>");
      out.print(paymentType);
      out.write("</td><td>");
      out.print(amount);
      out.write("</td><td>");
      out.print(name);
      out.write("</td></tr>\n");
      out.write("                                    ");

                                            } while (rs.next());
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        } finally {
                                            ConnectionManager.close(conn, preStmt, rs);

                                        }

                                        DecimalFormat decimalFormat2 = new DecimalFormat("0.00");

                                    
      out.write("\n");
      out.write("                            </table>\n");
      out.write("                            <a href = \"recordAnalysis.jsp?curPage1=1\" >首页</a>  \n");
      out.write("                            <a href = \"recordAnalysis.jsp?curPage1=");
      out.print(curPage1 - 1);
      out.write("\" >上一页</a>  \n");
      out.write("                            <a href = \"recordAnalysis.jsp?curPage1=");
      out.print(curPage1 + 1);
      out.write("\" >下一页</a>  \n");
      out.write("                            <a href = \"recordAnalysis.jsp?curPage1=");
      out.print(pageCount1);
      out.write("\" >尾页</a>  \n");
      out.write("                            <form>\n");
      out.write("                                <input type=\"text\" name=\"curPage1\" placeholder=\"跳转\" class=\"m-wrap small\" >\n");
      out.write("                                <input type=\"submit\" value=\"跳转\">\n");
      out.write("                            </form>\n");
      out.write("                            第");
      out.print(curPage1);
      out.write("页/共");
      out.print(pageCount1);
      out.write("页 \n");
      out.write("                            <br/>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"span6\">\n");
      out.write("                    <div class=\"portlet-body\">\n");
      out.write("                        <div class=\"portlet box white\">\n");
      out.write("                            <h3 class=\"page-title\">\n");
      out.write("                                工单记录2:辅助类\n");
      out.write("                            </h3>\n");
      out.write("                            <table class=\"table table-hover table-bordered\">\n");
      out.write("                                <tr><th>日期</th><th>会员卡号</th><th>消费项目</th><th>支付方式</th><th>支付金额</th><th>操作员</th></tr>\n");
      out.write("\n");
      out.write("                                ");

                                    ArrayList<Order> orders2 = new ArrayList<>();
                                    String sql2 = "select * from `order` where staffId =" + staffId9 + " and dateTime >= " + startDate + " and dateTime <= " + endDate + " order by dateTime";

                                    try {
                                        conn = ConnectionManager.getConnection();
                                        preStmt = conn.prepareStatement(sql);
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


                                
      out.write("\n");
      out.write("                                <tr><td>");
      out.print(timestamp);
      out.write("</td>\n");
      out.write("                                    <td>");
if (0 == cardNumber) {
                                            out.println("散客");
                                        } else {
                                            out.println(cardNumber);
                                        }
      out.write("</td>\n");
      out.write("                                    <td>");
      out.print(details);
      out.write("</td><td>");
      out.print(paymentType);
      out.write("</td><td>");
      out.print(amount);
      out.write("</td><td>");
      out.print(name);
      out.write('(');
      out.print(name2);
      out.write(" 辅助)</td></tr>\n");
      out.write("                                    ");

                                            } while (rs.next());
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        } finally {
                                            ConnectionManager.close(conn, preStmt, rs);

                                        }
                                    
      out.write("\n");
      out.write("                            </table>\n");
      out.write("                            <a href = \"recordAnalysis.jsp?curPage3=1\" >首页</a>  \n");
      out.write("                            <a href = \"recordAnalysis.jsp?curPage3=");
      out.print(curPage3 - 1);
      out.write("\" >上一页</a>  \n");
      out.write("                            <a href = \"recordAnalysis.jsp?curPage3=");
      out.print(curPage3 + 1);
      out.write("\" >下一页</a>  \n");
      out.write("                            <a href = \"recordAnalysis.jsp?curPage3=");
      out.print(pageCount3);
      out.write("\" >尾页</a>  \n");
      out.write("                            <form>\n");
      out.write("                                <input type=\"text\" name=\"curPage3\" placeholder=\"跳转\" class=\"m-wrap small\" >\n");
      out.write("                                <input type=\"submit\" value=\"跳转\">\n");
      out.write("                            </form>\n");
      out.write("                            第");
      out.print(curPage3);
      out.write("页/共");
      out.print(pageCount3);
      out.write("页 \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"span6\">\n");
      out.write("                    <div class=\"portlet-body\">\n");
      out.write("                        <div class=\"portlet box white\">\n");
      out.write("                            <h3 class=\"page-title\">\n");
      out.write("                                工单记录3：充值类\n");
      out.write("                            </h3>\n");
      out.write("                            <table class=\"table table-hover table-bordered\">\n");
      out.write("                                <tr><th>日期</th><th>会员卡号</th><th>消费项目</th><th>支付方式</th><th>支付金额</th><th>操作员</th></tr>\n");
      out.write("\n");
      out.write("                                ");

                                    ArrayList<Topup> topups = new ArrayList<>();
                                    String sql3 = "select * from topup where staffId = " + staffId9 + " and dateTime >= " + startDate + " and dateTime <= " + endDate + " order by dateTime";

                                    try {
                                        conn = ConnectionManager.getConnection();
                                        preStmt = conn.prepareStatement(sql);
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
                                
      out.write("\n");
      out.write("                                <tr><td>");
      out.print(timestamp);
      out.write("</td><td>");
      out.print(cardNumber);
      out.write("</td><td>充值</td><td>");
      out.print(paymentType);
      out.write("</td><td>");
      out.print(amount);
      out.write("</td><td>");
      out.print(name);
      out.write("</td><td>充值</td></tr>\n");
      out.write("                                ");


                                        } while (rs.next());
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    } finally {
                                        ConnectionManager.close(conn, preStmt, rs);

                                    }
      out.write("\n");
      out.write("                            </table>\n");
      out.write("                            <a href = \"member.jsp?curPage3=1\" >首页</a>  \n");
      out.write("                            <a href = \"recordAnalysis.jsp?curPage2=");
      out.print(curPage3 - 1);
      out.write("\" >上一页</a>  \n");
      out.write("                            <a href = \"recordAnalysis.jsp?curPage2=");
      out.print(curPage3 + 1);
      out.write("\" >下一页</a>  \n");
      out.write("                            <a href = \"recordAnalysis.jsp?curPage2=");
      out.print(pageCount3);
      out.write("\" >尾页</a>  \n");
      out.write("                            <form>\n");
      out.write("                                <input type=\"text\" name=\"curPage3\" placeholder=\"跳转\" class=\"m-wrap small\" >\n");
      out.write("                                <input type=\"submit\" value=\"跳转\">\n");
      out.write("                            </form>\n");
      out.write("                            第");
      out.print(curPage3);
      out.write("页/共");
      out.print(pageCount3);
      out.write("页 \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"span6\">\n");
      out.write("                    <div class=\"portlet-body\">\n");
      out.write("                        <div class=\"portlet box white\">\n");
      out.write("                            <h3 class=\"page-title\">\n");
      out.write("                                总计\n");
      out.write("                            </h3>\n");
      out.write("                            <table class=\"table table-hover table-bordered\">\n");
      out.write("                                <tr><th>总业绩</th><th>现金业绩</th><th>会员卡业绩</th><th>微信业绩</th><th>POS业绩</th><th>提成</th></tr>   \n");
      out.write("                                <tr><td>");
      out.print(sumOfMoney2);
      out.write("</td><td>");
      out.print(cashFlow);
      out.write("</td><td>");
      out.print(cardFlow);
      out.write("</td><td>");
      out.print(wechat);
      out.write("</td><td>");
      out.print(pos);
      out.write("</td><td>");
      out.print(decimalFormat2.format(salary2));
      out.write("</td></tr>   \n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>      \n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
