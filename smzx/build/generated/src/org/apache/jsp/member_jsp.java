package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.SQLException;
import com.app.controller.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import com.app.model.Member;
import com.app.controller.MemberManager;

public final class member_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


            public static final int PAGESIZE = 10;
            int pageCount;
            int curPage = 1;
        
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
      out.write("        <title>会员中心</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("        <div class=\"page-content\">\n");
      out.write("            <div class=\"span12\">\n");
      out.write("                <h3 class=\"page-title\">\n");
      out.write("                    会员管理\n");
      out.write("                </h3>\n");
      out.write("\n");
      out.write("                <ul class=\"breadcrumb\">\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("\n");
      out.write("                        <i class=\"icon-user\"></i>\n");
      out.write("                        会员管理\n");
      out.write("                        <i class=\"icon-angle-right\"></i>\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("\n");
      out.write("                        会员管理\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <br/>\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"span6\">\n");
      out.write("                    <div class=\"portlet box blue\">\n");
      out.write("                        <div class=\"portlet-title\">\n");
      out.write("\n");
      out.write("                            <div class=\"caption\">请输入会员姓名或手机号</div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"portlet-body\">\n");
      out.write("                            <form action=\"search\" method=\"post\">\n");
      out.write("                                <table class=\"table table-hover table-bordered\">\n");
      out.write("                                    <tbody>\n");
      out.write("                                        <tr><td>会员姓名/电话</td><td><input type=\"text\" name=\"input\"></td>\n");
      out.write("                                            <td><input type=\"submit\" value=\"搜索\" class=\"btn blue\"></td></tr>\n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("                                <input type=\"hidden\" name=\"method\" value=\"member\">\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");

                Member member2 = (Member) request.getAttribute("member");
                ArrayList<Member> members2 = (ArrayList<Member>) request.getAttribute("members");
                if ((request.getAttribute("search") != null && member2 == null && members2 == null) || (request.getAttribute("search") != null && members2 != null && members2.size() == 0)) {
            
      out.write("\n");
      out.write("            <script>alert(\"没有该会员信息\")</script>\n");
      out.write("            ");

            } else if (member2 != null && members2 == null) {
                response.sendRedirect("memberRecord.jsp?id=" + member2.getCardNumber());
            } else if (member2 == null && members2 != null) {
                if (members2.size() == 1) {
                    response.sendRedirect("memberRecord.jsp?id=" + members2.get(0).getCardNumber());
                } else {
            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"span6\">\n");
      out.write("                    <div class=\"portlet box blue\">\n");
      out.write("                        <div class=\"portlet-title\">\n");
      out.write("\n");
      out.write("                            <div class=\"caption\">重复姓名会员选择</div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"portlet-body\">\n");
      out.write("\n");
      out.write("                            <table class=\"table table-hover table-bordered\">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr><th>操作</th><th>会员卡号</th><th>姓名</th><th>手机号</th><th>性别</th><th>会员等级</th>\n");
      out.write("                                </thead>\n");
      out.write("                                <tbody>\n");
      out.write("                                    ");

                                        for (Member m : members2) {
                                    
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td><i class=\"m-icon-swapright\"></i><a href=\"memberRecord.jsp?id=");
      out.print( m.getCardNumber());
      out.write("\"> 详细资料</a></td>\n");
      out.write("                                        <td>");
      out.print( m.getCardNumber());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print( m.getName());
      out.write("</td>\n");
      out.write("                                        <td>");
      out.print( m.getPhoneNumber());
      out.write("</td>\n");
      out.write("                                        ");
if (m.getGender().equals("M")) {
      out.write("\n");
      out.write("                                        <td>男</td>\n");
      out.write("                                        ");
} else {
      out.write("\n");
      out.write("                                        <td>女</td>\n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                        <td>");
      out.print( m.getType());
      out.write("</td>\n");
      out.write("                                    </tr> \n");
      out.write("\n");
      out.write("                                    ");

                                        }
                                    
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");

                    }
                }
            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <br/>\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"span8\">\n");
      out.write("                    <div class=\"portlet box white\">\n");
      out.write("                        <div class=\"portlet-title\">\n");
      out.write("\n");
      out.write("                            <div class=\"caption\"><i class=\"m-icon-swapright\"></i><a href=\"addMember.jsp\">新增会员</a></div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"portlet-body\">\n");
      out.write("                            <table class=\"table table-hover table-bordered\">\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr><th>操作</th><th>会员卡号</th><th>姓名</th><th>手机号</th><th>性别</th><th>会员等级</th><th>储值余额</th></tr>\n");
      out.write("                                </thead>\n");
      out.write("                                <tbody>\n");
      out.write("                                    ");
ArrayList<Member> members = new ArrayList<Member>();

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
                                    
      out.write("\n");
      out.write("                                    <tr><td><a href=\"topup.jsp?id=");
      out.print( member.getCardNumber());
      out.write("\">充值</a>\n");
      out.write("                                            <a href=\"updateMember.jsp?id=");
      out.print( member.getCardNumber());
      out.write("\"> 修改</a>\n");
      out.write("                                            <a href=\"memberRecord.jsp?id=");
      out.print( member.getCardNumber());
      out.write("\"> 详细资料</a></td>\n");
      out.write("                                        <td>");
      out.print( member.getCardNumber());
      out.write("</td><td>");
      out.print( member.getName());
      out.write("</td><td>");
      out.print( member.getPhoneNumber());
      out.write("</td>\n");
      out.write("                                        ");
if (gender.equals("M")) {
      out.write("\n");
      out.write("                                        <td>男</td>\n");
      out.write("                                        ");
} else {
      out.write("\n");
      out.write("                                        <td>女</td>\n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                        <td>");
      out.print( member.getType());
      out.write("</td><td>");
      out.print( member.getBalance());
      out.write("</td></tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    ");
    } while (rs.next());
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        } finally {
                                            ConnectionManager.close(conn, preStmt, rs);

                                        }
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                            <a href = \"member.jsp?curPage=1\" >首页</a>  \n");
      out.write("                            <a href = \"member.jsp?curPage=");
      out.print(curPage - 1);
      out.write("\" >上一页</a>  \n");
      out.write("                            <a href = \"member.jsp?curPage=");
      out.print(curPage + 1);
      out.write("\" >下一页</a>  \n");
      out.write("                            <a href = \"member.jsp?curPage=");
      out.print(pageCount);
      out.write("\" >尾页</a>  \n");
      out.write("                            <form>\n");
      out.write("                                <input type=\"text\" name=\"curPage\" placeholder=\"跳转\" class=\"m-wrap small\" >\n");
      out.write("                                <input type=\"submit\" value=\"跳转\">\n");
      out.write("                            </form>\n");
      out.write("                            第");
      out.print(curPage);
      out.write("页/共");
      out.print(pageCount);
      out.write("页  \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
  String msg = request.getParameter("msg");
                if (null != msg) {
            
      out.write("\n");
      out.write("            <script>alert(\"");
      out.print(msg);
      out.write("\")</script>\n");
      out.write("            ");

                }
            
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
