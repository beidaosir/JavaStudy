<%@ page import="com.hnu.po.Admin" %>
<%@ page import="com.hnu.po.Business" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
	<head>
    	<title>elm系统欢迎你</title>
    	<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
    	<!-- Main CSS-->
    	<link rel="stylesheet" type="text/css" href="static/system/css/main.css">
    	<!-- Font-icon css-->
    	<link rel="stylesheet" type="text/css" href="static/system/css/font-awesome.min.css">
  	</head>
  	<body class="app sidebar-mini">

		<%
			//验证登录状态 查看session中是否存在loginUser
			Object loginUser = session.getAttribute("loginUser");
//			if (loginUser==null){
//				response.sendRedirect("/login.jsp");
//			}

			String username = "";
			String role = "";
			//转型需要判断角色
			if (loginUser instanceof Admin){
				Admin admin = (Admin)loginUser;
				username = admin.getAdminName();
				role=admin.getRole();
			}else if (loginUser instanceof Business){
				Business business = (Business)loginUser;
				username = business.getBusinessAccount();
				role = business.getRole();
			}
		%>

    	<!-- 导航条-->
		<header class="app-header">
    		<a class="app-header__logo" href="index.html">饿了么后台</a>
			<a class="app-sidebar__toggle" href="#" data-toggle="sidebar" aria-label="Hide Sidebar"></a>
			<!-- 导航条右边菜单 -->
      		<ul class="app-nav">
        		<!-- 用户菜单 -->
       	 		<li class="dropdown">
        			<a class="app-nav__item" href="#" data-toggle="dropdown" aria-label="Open Profile Menu">
        			<i class="fa fa-user fa-lg"></i></a>
          			<ul class="dropdown-menu settings-menu dropdown-menu-right">
            			<li>
            				<a class="dropdown-item" href="/log/out">
            				<i class="fa fa-sign-out fa-lg"></i> 退出 </a>
            			</li>
          			</ul>
        		</li>
      		</ul>
		</header>
    	<!-- 侧边菜单 -->
    	<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
    	<aside class="app-sidebar">
      		<div class="app-sidebar__user">	
      			<img class="app-sidebar__user-avatar" width="48px" height="48px" src="static/system/images/m1.jpg" alt="User Image">
        		<div>
          			<p class="app-sidebar__user-name"><%=username%>[<%=role%>]</p>
        		</div>
      		</div>

			<%
				if ("manager".equals(role)){
			%>
      		<ul class="app-menu">
	        	<li>
	        		<a class="app-menu__item active" href="/business/list" target="mainFrame">
	        			<i class="app-menu__icon fa fa-dashboard"></i>
	        			<span class="app-menu__label">商家管理</span>
	        		</a>
	        	</li>
				<li>
	        		<a class="app-menu__item active" href="/food/list" target="mainFrame">
	        			<i class="app-menu__icon fa fa-dashboard"></i>
	        			<span class="app-menu__label">餐品管理</span>
	        		</a>
	        	</li>
      		</ul>

			<% }else if("business".equals(role)) {%>
			<ul class="app-menu">
				<li>
					<a class="app-menu__item active" href="/food/list" target="mainFrame">
						<i class="app-menu__icon fa fa-dashboard"></i>
						<span class="app-menu__label">餐品管理</span>
					</a>
					<a class="app-menu__item active" href="/business/list" target="mainFrame">
						<i class="app-menu__icon fa fa-dashboard"></i>
						<span class="app-menu__label">顾客管理</span>
					</a>
					<a class="app-menu__item active" href="/business/list" target="mainFrame">
						<i class="app-menu__icon fa fa-dashboard"></i>
						<span class="app-menu__label">订单管理</span>
					</a>
					<a class="app-menu__item active" href="/business/list" target="mainFrame">
						<i class="app-menu__icon fa fa-dashboard"></i>
						<span class="app-menu__label">个人信息</span>
					</a>
				</li>

			</ul>

			<%}%>
		</aside>
    	<!-- 中间内容区域 -->
    	<main class="app-content" style="padding: 0">
			<iframe src="welcome.jsp" name="mainFrame" style="width: 100%;height:1000px;border: none"></iframe>
    	</main>
    	<!-- Essential javascripts for application to work-->
    	<script src="static/system/js/jquery-3.3.1.min.js"></script>
    	<script src="static/system/js/popper.min.js"></script>
    	<script src="static/system/js/bootstrap.min.js"></script>
    	<script src="static/system/js/main.js"></script>
    	<!-- The javascript plugin to display page loading on top-->
    	<script src="static/system/js/plugins/pace.min.js"></script>

	</body>
</html>