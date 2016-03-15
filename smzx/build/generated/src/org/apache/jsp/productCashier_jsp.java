package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.app.model.Product;
import com.app.controller.ProductManager;
import com.app.model.CardLevelDAO;
import com.app.model.ServiceDAO;
import com.app.controller.CardManager;
import com.app.controller.ServiceManager;
import com.app.model.Service;
import com.app.controller.StaffManager;
import com.app.model.Staff;
import java.util.ArrayList;
import com.app.model.Member;

public final class productCashier_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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
      out.write("                            <li >\r\n");
      out.write("\r\n");
      out.write("                                <a href=\"product.jsp\">\r\n");
      out.write("\r\n");
      out.write("                                    产品管理</a>\r\n");
      out.write("\r\n");
      out.write("                            </li>\r\n");
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
      out.write("        <title>收银台</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"page-content\">\n");
      out.write("            <script>\n");
      out.write("                function getAmount() {\n");
      out.write("                    var chkObjs = null;\n");
      out.write("                    var amount = 0;\n");
      out.write("                    var obj = document.getElementsByName(\"serviceId\")\n");
      out.write("                    for (var i = 0; i < obj.length; i++) { //遍历Radio \n");
      out.write("                        if (obj[i].checked) {\n");
      out.write("                            chkObjs = obj[i].value;\n");
      out.write("                            amount = document.getElementsByName(chkObjs)[0].value;\n");
      out.write("                            document.c.realAmount.value = amount;\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                function getMemberPrice() {\n");
      out.write("                    var chkObjs = null;\n");
      out.write("                    var amount = 0;\n");
      out.write("                    var obj = document.getElementsByName(\"serviceId\")\n");
      out.write("                    for (var i = 0; i < obj.length; i++) { //遍历Radio \n");
      out.write("                        if (obj[i].checked) {\n");
      out.write("                            chkObjs = obj[i].value;\n");
      out.write("                            amount = document.getElementsByName(chkObjs)[0].value;\n");
      out.write("                            document.c.realAmount.value = amount * document.c.discount.value / 10;\n");
      out.write("                            ;\n");
      out.write("\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                function getCardNumber() {\n");
      out.write("                    var chkObjs = null;\n");
      out.write("                    var discount = 0;\n");
      out.write("                    var obj = document.getElementsByName(\"card\")\n");
      out.write("\n");
      out.write("                    for (var i = 0; i < obj.length; i++) { //遍历Radio \n");
      out.write("                        if (obj[i].checked) {\n");
      out.write("                            chkObjs = obj[i].value;\n");
      out.write("                            discount = document.getElementsByName(chkObjs)[0].value;\n");
      out.write("                            document.c.cardNumber.value = chkObjs;\n");
      out.write("                            document.c.discount.value = discount;\n");
      out.write("                            getRealAmountWithoutDiscount();\n");
      out.write("                            getRealAmountWithDiscount();\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("            <div class=\"span12\">\n");
      out.write("                <h3 class=\"page-title\">\n");
      out.write("                    收银台\n");
      out.write("                </h3>\n");
      out.write("\n");
      out.write("                <ul class=\"breadcrumb\">\n");
      out.write("\n");
      out.write("                    <li>\n");
      out.write("\n");
      out.write("                        <i class=\"icon-home\"></i>\n");
      out.write("                        收银台\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"container\" id=\"cashier\" align=\"center\">\n");
      out.write("                <div class=\"span16\">\n");
      out.write("                    <div class=\"portlet box blue\">\n");
      out.write("                        <div class=\"portlet-title\">\n");
      out.write("\n");
      out.write("                            <div class=\"caption\">查找会员</div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"portlet-body\">\n");
      out.write("                            <form action=\"search\" method=\"post\">\n");
      out.write("                                <table class=\"table table-hover table-bordered\">\n");
      out.write("                                    <thead>\n");
      out.write("\n");
      out.write("                                    </thead>\n");
      out.write("                                    <tbody>\n");
      out.write("                                        <tr><td>会员姓名/电话</td><td><input type=\"text\" name=\"input\"></td><td><input type=\"submit\" value=\"搜索\"></td></tr>\n");
      out.write("\n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("                                <input type=\"hidden\" name=\"method\" value=\"cashier\">\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                ");


                    Member member = (Member) request.getAttribute("member");
                    ArrayList<Member> members = (ArrayList<Member>) request.getAttribute("members");
                    if ((request.getAttribute("search") != null && member == null && members == null) || (request.getAttribute("search") != null && members != null && members.size() == 0)) {
                
      out.write("\n");
      out.write("                <script>alert(\"没有该会员信息\")</script>\n");
      out.write("                ");

                    }
                    if ((member == null && members != null && members.size() == 0) || (member == null && members == null)) {
                
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"span8\">\n");
      out.write("                    <div class=\"portlet box white\">\n");
      out.write("                        <div class=\"portlet-title\">\n");
      out.write("\n");
      out.write("                            <div class=\"caption\"></div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"portlet-body\">\n");
      out.write("                            <form action=\"add\" method=\"post\" name = \"c\">\n");
      out.write("                                <table class=\"table table-hover table-bordered\">\n");
      out.write("                                    <tbody>\n");
      out.write("                                        <tr><td>*操作员</td>\n");
      out.write("                                            <td>");
ArrayList<Staff> staffs = StaffManager.getAll();
                                                for (Staff s : staffs) {
                                                    if (!s.getStatus().equals("离职")) {
                                                
      out.write("\n");
      out.write("                                                <label><input type=\"radio\" name=\"staffId\" value=\"");
      out.print(s.getStaffId());
      out.write("\" required >");
      out.print(s.getName());
      out.write("</label>\n");
      out.write("                                                ");
}
                                                        }
      out.write("</td></tr>\n");
      out.write("                                        <tr><td>助理操作员</td>\n");
      out.write("                                            <td>");

                                                for (Staff s : staffs) {
                                                    if (s.getStatus().equals("助理")) {
                                                
      out.write("\n");
      out.write("                                                <label><input type=\"radio\" name=\"staffId2\" value=\"");
      out.print(s.getStaffId());
      out.write("\" >");
      out.print(s.getName());
      out.write("</label>\n");
      out.write("                                                ");
}
                                                        }
      out.write("</td></tr>\n");
      out.write("                                        <tr><td>*会员卡卡号</td><td>散客</td></tr>\n");
      out.write("                                        <tr><td>*消费内容</td>\n");
      out.write("                                            <td>");
ArrayList<Product> products = ProductManager.retrieveAll();
                                                for (int i = 0; i < products.size(); i++) {
                                                    Product p = products.get(i);
                                                
      out.write("\n");
      out.write("                                                <label><input type=\"radio\" name=\"serviceId\" value=\"");
      out.print(p.getId());
      out.write("\" onclick=\"getAmount();\" required >");
      out.print(p.getName());
      out.print(p.getCost());
      out.write("</label>\n");
      out.write("                                                <input type=\"hidden\" name=\"");
      out.print(p.getId());
      out.write("\" value=\"");
      out.print(p.getCost());
      out.write("\" >\n");
      out.write("                                                ");
if ((i + 1) % 3 == 0) {
                                                            out.println("<br />");
                                                        }
                                                    }
                                                
      out.write("\n");
      out.write("                                            </td></tr>\n");
      out.write("                                        <!--<tr><td>消费金额</td><td><input type=\"hidden\" name=\"amount\" onkeypress=\"getRealAmountWithoutDiscount();\n");
      out.write("                                                this.value.change\" onchange=\"getRealAmountWithoutDiscount();\n");
      out.write("                                                        this.value.change\"></td></tr>-->\n");
      out.write("                                        <tr><td>折扣</td><td>无折扣</td></tr>\n");
      out.write("                                        <tr><td>*金额</td><td><input type=\"text\" name=\"realAmount\" required  ></td></tr>\n");
      out.write("                                        <tr><td>*支付方式</td><td><label><input type=\"radio\" name=\"type\" value=\"现金\" required checked>现金</label>\n");
      out.write("                                                <label><input type=\"radio\" name=\"type\" value=\"会员卡\" required>会员卡</label>\n");
      out.write("                                                <label><input type=\"radio\" name=\"type\" value=\"微信\" required>微信</label>\n");
      out.write("                                                <label><input type=\"radio\" name=\"type\" value=\"POS\" required>POS机刷卡</label></td></tr>\n");
      out.write("                                        <tr><td></td><td colspan=\"2\" align=\"center\"><input type=\"submit\" value=\"提交\"><input type=\"reset\" value=\"重填\" /></td></tr>\n");
      out.write("\n");
      out.write("                                    </tbody>\n");
      out.write("                                </table>\n");
      out.write("                                <input type=\"hidden\" name=\"cardNumber\" value=\"0\" >\n");
      out.write("                                <input type=\"hidden\" name=\"discount\" value=\"10.0\" >\n");
      out.write("                                <input type=\"hidden\" name=\"method\" value=\"cashier\"/>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            ");
} else if (member
                    != null) {
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"span8\">\n");
      out.write("                <div class=\"portlet box white\">\n");
      out.write("                    <div class=\"portlet-title\">\n");
      out.write("\n");
      out.write("                        <div class=\"caption\"></div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"portlet-body\">\n");
      out.write("                        <form action=\"add\" method=\"post\" name=\"c\">\n");
      out.write("                            <table class=\"table table-hover table-bordered\">\n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr><td>*操作员</td>\n");
      out.write("                                        <td>");
ArrayList<Staff> staffs = StaffManager.getAll();
                                            for (Staff s : staffs) {
                                                if (!s.getStatus().equals("离职")) {
                                            
      out.write("\n");
      out.write("                                            <label><input type=\"radio\" name=\"staffId\" value=\"");
      out.print(s.getStaffId());
      out.write("\" required>");
      out.print(s.getName());
      out.write("</label>\n");
      out.write("                                                ");
}
                                                }
      out.write("</td></tr>\n");
      out.write("                                    <tr><td>助理操作员</td>\n");
      out.write("                                        <td>");

                                            for (Staff s : staffs) {
                                                if (s.getStatus().equals("助理")) {
                                            
      out.write("\n");
      out.write("                                            <label><input type=\"radio\" name=\"staffId2\" value=\"");
      out.print(s.getStaffId());
      out.write("\"  >");
      out.print(s.getName());
      out.write("</label>\n");
      out.write("                                                ");
}
                                                }
      out.write("</td></tr>\n");
      out.write("                                    <tr><td>*会员卡卡号</td><td><input type=\"text\" name=\"cardNumber\" value=\"");
      out.print(member.getCardNumber());
      out.write("\" required></td>\n");
      out.write("                                        <td><div>姓名:");
      out.print(member.getName());
      out.write("</div><div>电话:");
      out.print(member.getPhoneNumber());
      out.write("</div><div>余额:");
      out.print(member.getBalance());
      out.write("</div></td></tr>\n");
      out.write("                                    <tr><td>折扣</td><td><input id=\"2\" type=\"text\" name=\"discount\" value=\"");
      out.print(CardManager.retrieveByType(member.getType()).getDiscount());
      out.write("\" ></td></tr>\n");
      out.write("                                    <tr><td>*消费内容</td>\n");
      out.write("                                        <td>");
ArrayList<Service> services = ServiceManager.retrieveAll();
                                            for (int i = 0; i < services.size(); i++) {
                                                Service s = services.get(i);
                                            
      out.write("\n");
      out.write("                                            <label><input type=\"radio\" name=\"serviceId\" value=\"");
      out.print(s.getId());
      out.write("\" onclick=\"getMemberPrice();\" required >");
      out.print(s.getDetail());
      out.print(s.getPrice());
      out.write("</label>\n");
      out.write("                                            <input type=\"hidden\" name=\"");
      out.print(s.getId());
      out.write("\" value=\"");
      out.print(s.getPrice());
      out.write("\" >\n");
      out.write("                                            ");
if ((i + 1) % 3 == 0) {
                                                        out.println("<br />");
                                                    }
                                                }
                                            
      out.write("</td></tr>\n");
      out.write("                                    <!--<tr><td>消费金额</td><td><input id=\"1\" type=\"text\" name=\"amount\" onkeypress=\"getRealAmountWithDiscount();\n");
      out.write("                                                this.value.change\" onchange=\"getRealAmountWithDiscount();\n");
      out.write("                                                        this.value.change\" ></td></tr>-->\n");
      out.write("                                    <tr><td>*实际金额</td><td><input id=\"3\" type=\"text\" name=\"realAmount\" required></td></tr>\n");
      out.write("                                    <tr><td>*支付方式</td><td><label><input type=\"radio\" name=\"type\" value=\"现金\" required >现金</label>\n");
      out.write("                                            <label><input type=\"radio\" name=\"type\" value=\"会员卡\" required checked>会员卡</label>\n");
      out.write("                                            <label><input type=\"radio\" name=\"type\" value=\"微信\" required>微信</label>\n");
      out.write("                                            <label><input type=\"radio\" name=\"type\" value=\"POS\" required>POS机刷卡</label></td></tr>\n");
      out.write("                                    <tr><td></td><td colspan=\"2\" align=\"center\"><input type=\"submit\" value=\"提交\"><input type=\"reset\" value=\"重填\" /></td></tr>\n");
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                            <input type=\"hidden\" name=\"method\" value=\"cashier\"/>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");
} else if (members
                != null) {
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\" id=\"cashier\" align=\"center\">\n");
      out.write("\n");
      out.write("            <div class=\"span8\">\n");
      out.write("                <div class=\"portlet box white\">\n");
      out.write("                    <div class=\"portlet-title\">\n");
      out.write("\n");
      out.write("                        <div class=\"caption\"></div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"portlet-body\">\n");
      out.write("                        <form action=\"add\" method=\"post\" name=\"c\">\n");
      out.write("                            <table class=\"table table-hover table-bordered\">\n");
      out.write("                                <tbody>\n");
      out.write("                                    <tr><td>*操作员</td>\n");
      out.write("                                        <td>");
ArrayList<Staff> staffs = StaffManager.getAll();
                                            for (Staff s : staffs) {
                                                if (!s.getStatus().equals("离职")) {
                                            
      out.write("\n");
      out.write("                                            <label><input type=\"radio\" name=\"staffId\" value=\"");
      out.print(s.getStaffId());
      out.write("\" required>");
      out.print(s.getName());
      out.write("</label>\n");
      out.write("                                                ");
}
                                                    }
      out.write("</td></tr>\n");
      out.write("                                    <tr><td>助理操作员</td>\n");
      out.write("                                        <td>");

                                            for (Staff s : staffs) {
                                                if (s.getStatus().equals("助理")) {
                                            
      out.write("\n");
      out.write("                                            <label><input type=\"radio\" name=\"staffId2\" value=\"");
      out.print(s.getStaffId());
      out.write("\"  >");
      out.print(s.getName());
      out.write("</label>\n");
      out.write("                                                ");
}
                                                    }
      out.write("</td></tr>\n");
      out.write("\n");
      out.write("                                    ");
if (members.size() > 1) {
      out.write("\n");
      out.write("                                    <tr><td>*会员卡卡号</td><td><input type=\"text\" name=\"cardNumber\" value=\"\" required></td>\n");
      out.write("\n");
      out.write("                                        ");
for (Member m : members) {
                                                String memberType = m.getType();
                                                double discount = CardLevelDAO.retrieveByType(memberType).getDiscount();
                                        
      out.write(" <td> \n");
      out.write("                                            <label>\n");
      out.write("                                                <input type=\"radio\" name=\"card\" value=\"");
      out.print(m.getCardNumber());
      out.write("\" onclick=\"getCardNumber();\">\n");
      out.write("                                                <input type=\"hidden\" name=\"");
      out.print(m.getCardNumber());
      out.write("\" value=\"");
      out.print(discount);
      out.write("\">\n");
      out.write("                                                <span>卡号:");
      out.print(m.getCardNumber());
      out.write(" 姓名:");
      out.print(m.getName());
      out.write(" </span><br />\n");
      out.write("                                                <span>电话:");
      out.print(m.getPhoneNumber());
      out.write("</span><br /><span>余额:");
      out.print(m.getBalance());
      out.write("</span>\n");
      out.write("                                            </label>\n");
      out.write("                                        </td> \n");
      out.write("                                        ");
}
      out.write("\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr><td>折扣</td><td><input id=\"2\" type=\"text\" name=\"discount\" value=\"\" ></td></tr>\n");
      out.write("                                            ");
} else if (members.size() == 1) {
                                                Member m = members.get(0);
                                                String memberType = m.getType();
                                                double discount = CardLevelDAO.retrieveByType(memberType).getDiscount();
                                            
      out.write("\n");
      out.write("                                    <tr><td>*会员卡卡号</td><td><input type=\"text\" name=\"cardNumber\" value=\"");
      out.print(m.getCardNumber());
      out.write("\" required></td>\n");
      out.write("                                        <td> \n");
      out.write("                                            <label>\n");
      out.write("                                                <input type=\"radio\" name=\"card\" value=\"");
      out.print(m.getCardNumber());
      out.write("\" onclick=\"getCardNumber();\" checked>\n");
      out.write("                                                <input type=\"hidden\" name=\"");
      out.print(m.getCardNumber());
      out.write("\" value=\"");
      out.print(discount);
      out.write("\">\n");
      out.write("                                                <span>卡号:");
      out.print(m.getCardNumber());
      out.write(" 姓名:");
      out.print(m.getName());
      out.write(" </span><br />\n");
      out.write("                                                <span>电话:");
      out.print(m.getPhoneNumber());
      out.write("</span><br /><span>余额:");
      out.print(m.getBalance());
      out.write("</span>\n");
      out.write("                                            </label>\n");
      out.write("                                        </td> \n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr><td>折扣</td><td><input id=\"2\" type=\"text\" name=\"discount\" value=\"");
      out.print(discount);
      out.write("\" ></td></tr>\n");
      out.write("                                            ");
}
      out.write("\n");
      out.write("\n");
      out.write("                                    <tr><td>*消费内容</td>\n");
      out.write("                                        <td>");
ArrayList<Service> services = ServiceManager.retrieveAll();
                                            for (int i = 0; i < services.size(); i++) {
                                                Service s = services.get(i);
                                            
      out.write("\n");
      out.write("                                            <label><input type=\"radio\" name=\"serviceId\" value=\"");
      out.print(s.getId());
      out.write("\" onclick=\"getMemberPrice();\" required >");
      out.print(s.getDetail());
      out.print(s.getPrice());
      out.write("</label>\n");
      out.write("                                            <input type=\"hidden\" name=\"");
      out.print(s.getId());
      out.write("\" value=\"");
      out.print(s.getPrice());
      out.write("\" >\n");
      out.write("                                            ");
if ((i + 1) % 3 == 0) {
                                                        out.println("<br />");
                                                    }
                                                }
                                            
      out.write("</td></tr>\n");
      out.write("                                    <!-- <tr><td>消费金额</td><td><input id=\"1\" type=\"text\" name=\"amount\" onkeypress=\"getRealAmountWithDiscount();\n");
      out.write("                                                 this.value.change\" onchange=\"getRealAmountWithDiscount();\n");
      out.write("                                                         this.value.change\" ></td></tr>-->\n");
      out.write("\n");
      out.write("                                    <tr><td>*实际金额</td><td><input id=\"3\" type=\"text\" name=\"realAmount\" required></td></tr>\n");
      out.write("                                    <tr><td>*支付方式</td><td><label><input type=\"radio\" name=\"type\" value=\"现金\" required >现金</label>\n");
      out.write("                                            <label><input type=\"radio\" name=\"type\" value=\"会员卡\" required checked>会员卡</label>\n");
      out.write("                                            <label><input type=\"radio\" name=\"type\" value=\"微信\" required>微信</label>\n");
      out.write("                                            <label> <input type=\"radio\" name=\"type\" value=\"POS\" required>POS机刷卡</label></td></tr>\n");
      out.write("                                    <tr><td></td><td colspan=\"2\" align=\"center\"><input type=\"submit\" value=\"提交\"><input type=\"reset\" value=\"重填\" /></td></tr>\n");
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                            <input type=\"hidden\" name=\"method\" value=\"cashier\"/>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("\n");
      out.write("        ");
  String msg = request.getParameter("msg");
            if (null != msg
                    && msg.equals(
                            "success")) {
        
      out.write("\n");
      out.write("        <script>alert(\"操作成功！\")</script>\n");
      out.write("        ");

        } else if (null != msg
                && msg.equals(
                        "failed")) {
        
      out.write("\n");
      out.write("        <script>alert(\"余额不足！\")</script>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("\n");
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
