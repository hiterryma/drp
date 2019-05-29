<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>

<%!
    public static final String LOGOUT_URL = "member_logout.action";
    public static final String INDEX_URL = "/pages/back/member_action.action";
%>
<header class="main-header">

    <!-- Logo -->
    <a href="<%=INDEX_URL%>" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>D</b>RP</span> <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>Distribution</b>Resource</span>
    </a>

    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas"
           role="button"> <span class="sr-only">Toggle navigation</span>
        </a>
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <li class="dropdown user user-menu"><a href="#"
                                                       class="dropdown-toggle" data-toggle="dropdown"> <img
                        src="images/user.png" class="user-image" alt="User Image">
                    <span class="hidden-xs">小李老师</span>
                </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header"><img src="images/user.png"
                                                     class="img-circle" alt="User Image"></li>
                        <!-- Menu Body -->
                        <li>
                            <div class="text-center">
                                上次登录日期：${lastdate}
                            </div>
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="text-center">
                                <a href="<%=LOGOUT_URL%>" class="btn btn-default btn-flat">系统注销</a>
                            </div>
                        </li>
                    </ul>
                </li>
                <!-- Control Sidebar Toggle Button -->
                <li><a href="#" data-toggle="control-sidebar"><i
                        class="fa fa-gears"></i></a></li>
            </ul>
        </div>

    </nav>
</header>
