<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/> 

        <link href="media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>

        <link href="media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

        <link href="media/css/style-metro.css" rel="stylesheet" type="text/css"/>

        <link href="media/css/style.css" rel="stylesheet" type="text/css"/>

        <link href="media/css/style-responsive.css" rel="stylesheet" type="text/css"/>

        <link href="media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>

        <link href="media/css/uniform.default.css" rel="stylesheet" type="text/css"/>

        <!-- END GLOBAL MANDATORY STYLES -->

        <!-- BEGIN PAGE LEVEL STYLES --> 

        <link href="media/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>

        <link href="media/css/daterangepicker.css" rel="stylesheet" type="text/css" />

        <link href="media/css/fullcalendar.css" rel="stylesheet" type="text/css"/>

        <link href="media/css/jqvmap.css" rel="stylesheet" type="text/css" media="screen"/>

        <link href="media/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>

        <!-- END PAGE LEVEL STYLES -->

        <link rel="shortcut icon" href="media/image/favicon.ico" />

    </head>

    <body class="page-header-fixed">

        <!-- BEGIN HEADER -->

        <div class="header navbar navbar-inverse navbar-fixed-top">

            <!-- BEGIN TOP NAVIGATION BAR -->

            <div class="navbar-inner">

                <div class="container-fluid">

                    <!-- BEGIN LOGO -->

                    <a class="brand" >
                        <font face="黑体">尚美造型</font>
                    </a>

                    <!-- END LOGO -->



                </div>

            </div>

            <!-- END TOP NAVIGATION BAR -->

        </div>

        <!-- END HEADER -->

        <!-- BEGIN CONTAINER -->

        <div class="page-container">

            <!-- BEGIN SIDEBAR -->

            <div class="page-sidebar nav-collapse collapse">

                <!-- BEGIN SIDEBAR MENU -->        
                <br/>
                <ul class="page-sidebar-menu">

                    <li class="">

                        <a href="cashier.jsp">

                            <i class="icon-home"></i> 

                            <span class="title">收银台</span>

                            <span class="selected"></span>

                        </a>

                    </li>
                    
                     <li class="">

                        <a href="productCashier.jsp">

                            <i class="icon-home"></i> 

                            <span class="title">产品收银台</span>

                            <span class="selected"></span>

                        </a>

                    </li>

                    <li class="">

                        <a href="javascript:;">

                            <i class="icon-user"></i> 

                            <span class="title">会员管理</span>

                            <span class="arrow "></span>

                        </a>

                        <ul class="sub-menu">

                            <li >

                                <a href="addMember.jsp">

                                    新增会员</a>

                            </li>

                            <li >

                                <a href="member.jsp">

                                    会员管理</a>

                            </li>

                            <li >

                                <a href="cardLevel.jsp">

                                    会员级别管理</a>

                            </li>



                        </ul>

                    </li>

                    <li class="">

                        <a href="javascript:;">

                            <i class="icon-sitemap"></i> 

                            <span class="title">员工管理</span>

                            <span class="arrow "></span>

                        </a>

                        <ul class="sub-menu">

                            <li >

                                <a href="addStaff.jsp">

                                    新增员工</a>

                            </li>
                            <li >

                                <a href="staff.jsp">

                                    员工管理</a>

                            </li>


                        </ul>

                    </li>

                    <li class="">

                        <a href="javascript:;">

                            <i class="icon-bookmark-empty"></i> 

                            <span class="title">服务项目管理</span>

                            <span class="arrow "></span>

                        </a>

                        <ul class="sub-menu">

                            <li >

                                <a href="addService.jsp">

                                    新增服务项目</a>

                            </li>

                            <li >

                                <a href="service.jsp">

                                    服务项目管理</a>

                            </li>
                            <li >

                                <a href="product.jsp">

                                    产品管理</a>

                            </li>

                        </ul>

                    </li>

                    <li class="">

                        <a href="recordAnalysis.jsp">

                            <i class="icon-bar-chart"></i> 

                            <span class="title">数据统计</span>

                            <span class="selected"></span>

                        </a>

                    </li>

                    <li class="last ">

                        <a href="topup.jsp">

                            <i class="icon-briefcase"></i> 

                            <span class="title">快速充值</span>

                        </a>

                    </li>

                </ul>

                <!-- END SIDEBAR MENU -->

            </div>
        </div>
        <!-- END FOOTER -->

        <!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->

        <!-- BEGIN CORE PLUGINS -->

        <script src="media/js/jquery-1.10.1.min.js" type="text/javascript"></script>

        <script src="media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>

        <!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->

        <script src="media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      

        <script src="media/js/bootstrap.min.js" type="text/javascript"></script>

        <!--[if lt IE 9]>

        <script src="media/js/excanvas.min.js"></script>

        <script src="media/js/respond.min.js"></script>  

        <![endif]-->   

        <script src="media/js/jquery.slimscroll.min.js" type="text/javascript"></script>

        <script src="media/js/jquery.blockui.min.js" type="text/javascript"></script>  

        <script src="media/js/jquery.cookie.min.js" type="text/javascript"></script>

        <script src="media/js/jquery.uniform.min.js" type="text/javascript" ></script>

        <!-- END CORE PLUGINS -->

        <!-- BEGIN PAGE LEVEL PLUGINS -->

        <script src="media/js/jquery.vmap.js" type="text/javascript"></script>   

        <script src="media/js/jquery.vmap.russia.js" type="text/javascript"></script>

        <script src="media/js/jquery.vmap.world.js" type="text/javascript"></script>

        <script src="media/js/jquery.vmap.europe.js" type="text/javascript"></script>

        <script src="media/js/jquery.vmap.germany.js" type="text/javascript"></script>

        <script src="media/js/jquery.vmap.usa.js" type="text/javascript"></script>

        <script src="media/js/jquery.vmap.sampledata.js" type="text/javascript"></script>  

        <script src="media/js/jquery.flot.js" type="text/javascript"></script>

        <script src="media/js/jquery.flot.resize.js" type="text/javascript"></script>

        <script src="media/js/jquery.pulsate.min.js" type="text/javascript"></script>

        <script src="media/js/date.js" type="text/javascript"></script>

        <script src="media/js/daterangepicker.js" type="text/javascript"></script>     

        <script src="media/js/jquery.gritter.js" type="text/javascript"></script>

        <script src="media/js/fullcalendar.min.js" type="text/javascript"></script>

        <script src="media/js/jquery.easy-pie-chart.js" type="text/javascript"></script>

        <script src="media/js/jquery.sparkline.min.js" type="text/javascript"></script>  

        <!-- END PAGE LEVEL PLUGINS -->

        <!-- BEGIN PAGE LEVEL SCRIPTS -->

        <script src="media/js/app.js" type="text/javascript"></script>

        <script src="media/js/index.js" type="text/javascript"></script>        

        <!-- END PAGE LEVEL SCRIPTS -->  
        <script>

            jQuery(document).ready(function () {

                App.init(); // initlayout and core plugins

                Index.init();

                Index.initJQVMAP(); // init index page's custom scripts

                Index.initCalendar(); // init index page's custom scripts

                Index.initCharts(); // init index page's custom scripts

                Index.initChat();

                Index.initMiniCharts();

                Index.initDashboardDaterange();

                Index.initIntro();

            });

        </script>

        <!-- END JAVASCRIPTS -->


    </body>
</html>