<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>请登录</title>
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
			<div class="text-center">
				<br>
				<div class="h2 text-primary">请登录</div>
				<div class="row login-form">
					<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
					<div class="form-back col-lg-6 col-md-6 col-sm-6 col-xs-6">
						<form action="login.do" method="post">
							<div class="form-group row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
								<label
									class="article col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary"
									for="username">用户名：</label>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									<input type="text" class="form-control" id="username" name="username"
										value="${username}" placeholder="请输入用户名">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
								<label
									class="article col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary"
									for="password">密&emsp;码：</label>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									<input type="password" class="form-control" id="password" name="password"
										placeholder="请输入密码">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
								<label
									class="article col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary"
									for="isAdmin">账号类别：</label>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary">
									管理员：<input type="radio" id="isAdmin" name="isAdmin" value="Y" />
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary">
									普通账户：<input type="radio" id="isAdmin" name="isAdmin" value="N" />
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
									<button type="submit" class="btn btn-primary">登录</button>
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
									<button type="button" id="regist"
										data-path="<%=request.getContextPath() %>" class="btn">注册</button>
								</div>
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label class="text-danger">${msg }</label>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=path%>/js/jquery-1.12.js"></script>
	<script src="<%=path%>/js/bootstrap.js"></script>
	<script src="<%=path%>/js/login.js"></script>
</body>
</html>
