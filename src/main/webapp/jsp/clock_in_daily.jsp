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
<link href="<%=path%>/css/bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/css/bootstrap-theme.css" rel="stylesheet"
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
					<div class="col-lg-2">
						<h3 class="text-primary">签到情况</h3>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="card-block text-left">
							<h4 class="card-title text-info">签到</h4>
							<input type="date" value="2019-08-24" readonly> <input
								type="text" value="07:32已签到" readonly>
							<button class="btn">签到</button>
							<button class="btn">签退</button>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-2">
						<h3 class="text-primary">今日任务</h3>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="card-block text-left">
							<h4 class="card-title text-success">工程任务一</h4>
							<div class="text-primary">
								<h3 class="text-success">二期北地库地坪浇筑</h3>
								<span class="text-muted"> ........................ </span>
							</div>
						</div>
						<br>
						<div class="card-block text-left">
							<h4 class="card-title text-success">工程任务二</h4>
							<div class="text-primary">
								<h3 class="text-success">二期活动场地坪浇筑</h3>
								<span class="text-muted"> ........................ </span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="<%=path%>/js/jquery-1.12.js"></script>
	<script src="<%=path%>/js/bootstrap.js"></script>
</body>
</html>
