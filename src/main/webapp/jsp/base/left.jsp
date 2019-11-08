<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="left-aside text-center col col-lg-2 col-md-2 col-sm-2 col-xs-2">
	<div class="h4 text-info">页面导航</div>
	<ul class="nav nav-tabs nav-stacked">
		<li><a href="<%=request.getContextPath()%>/homePage.do">首页</a></li>
		<li class="staff"><a href="<%=request.getContextPath()%>/staff/staffList.do">员工管理</a></li>
		<li class="workingHour"><a href="<%=request.getContextPath()%>/workingHourList.do">工时管理</a></li>
		<li><a href="<%=request.getContextPath()%>/vacateList.do">请假记录</a></li>
		<li><a href="<%=request.getContextPath()%>/codeList.do">code管理</a></li>
		<li class="account"><a href="<%=request.getContextPath()%>/account/accountList.do">账号管理</a></li>
		<li class="tally"><a href="<%=request.getContextPath()%>/financePage.do">营收管理</a></li>
		<li><a href="<%=request.getContextPath()%>/salaryPage.do">工资管理</a></li>
	</ul>
	<div class="container-fluid">
		&nbsp;
		<div class="h4 text-info">联系方式</div>
		<address class="text-info text-left">
			联系人：xxx<br>
			邮&nbsp;箱：xxxxxx@163.com<br>
			电&nbsp;话：136xxxxxxx
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