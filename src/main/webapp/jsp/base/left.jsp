<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="left-aside text-center col col-lg-2 col-md-2 col-sm-2 col-xs-2">
	<div class="h4 text-info">页面导航</div>
	<ul class="nav nav-tabs nav-stacked">
		<li><a href="<%=request.getContextPath()%>/jsp/index.jsp">首页</a></li>
		<li><a href="<%=request.getContextPath()%>/jsp/user_info.jsp">个人信息</a></li>
		<li><a href="<%=request.getContextPath()%>/jsp/clock_in_daily.jsp">每日打卡</a></li>
		<li><a href="<%=request.getContextPath()%>/jsp/data_statement.jsp">数据查询</a></li>
		<li><a href="<%=request.getContextPath()%>/jsp/labourers_family.jsp">民工之家</a></li>
		<li><a href="<%=request.getContextPath()%>/jsp/month_best.jsp">月度最佳</a></li>
		<li class="tally"><a href="<%=request.getContextPath()%>/incomePage.do">收支记录</a></li>
	</ul>
	<div class="container-fluid">
		&nbsp;
		<div class="h4 text-info">联系方式</div>
		<address class="text-info text-left">
			邮箱：xxxxxx@163.com<br>
			电话：159xxxxxxxx
		</address>
	</div>
	<div class="container-fluid text-center">
		<button class="btn btn-primary" id="logout"  data-path="<%=request.getContextPath()%>">注销登陆</button>
	</div>
	<div class="container-fluid text-center">
		<label class="text-danger h3">${message }</label>
	</div>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap/jquery-1.12.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/left.js"></script>