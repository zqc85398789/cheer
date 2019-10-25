<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>工程管理系统-首页</title>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<link href="<%=path%>/css/bootstrap/bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/css/bootstrap/bootstrap-theme.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container-fluid">
		<%@include file="base/header.jsp"%>
		<div class="content-div row">
			<%@include file="base/left.jsp"%>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
			<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 text-center">
				<div class="row">
					<div class="col-lg-6">
						<h3 class="text-primary">用户<b>${loginUser.username}</b>您好！欢迎使用工程管理系统</h3>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="card-block">
							<h4 class="text-left text-success">工程项目</h4>
							<div class="text-right">
								<h3 class="text-success">XX小区三期</h3>
								<span class="text-muted">进度</span>
							</div>
							<span class="text-success">80%</span>
							<div class="progress progress-striped active">
								<div
									class="progress-bar progress-bar-success project-progress card-progress"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="<%=path%>/js/bootstrap/jquery-1.12.js"></script>
	<script src="<%=path%>/js/bootstrap/bootstrap.js"></script>
</body>
</html>
