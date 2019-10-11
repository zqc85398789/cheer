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
				<div class="h2 text-primary">用户注册</div>
				<label class="text-primary">（带*为必填项）</label>
				<div class="row regist-form">
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
					<div class="form-back col-lg-8 col-md-8 col-sm-8 col-xs-8">
						<form action="regist.do"
							method="post">
							<div class="form-group row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
								<label
									class="article col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary"
									for="username">用户名：</label>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									<input type="text" class="form-control" id="username" name="username"
										value="${user.username}" placeholder="由5-16位字母或数字组成,只能以字母开头" />
								</div>
								<label
									class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left"
									id="verify_username">*</label>
							</div>
							<div class="form-group row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
								<label
									class="article col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary"
									for="password">密&emsp;码：</label>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									<input type="text" class="form-control" id="password" name="password"
										placeholder="由8-16位字母、数字或&quot;_&quot;组成">
								</div>
								<label
									class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left"
									id="verify_password">*</label>
							</div>
							<div class="form-group row">
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									<input type="text" class="form-control" id="password_check"
										name="password_check" placeholder="请再次输入密码" />
								</div>
								<label
									class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left"
									id="verify_password_check">*</label>
							</div>
							<div class="form-group row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
								<label
									class="article col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary"
									for="legal_name">姓&emsp;名：</label>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									<input type="text" class="form-control" id="legal_name"
										value="${user.legal_name}" name="legal_name" placeholder="请输入姓名" />
								</div>
								<label
									class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left"
									id="verify_legal_name">*</label>
							</div>
							<div class="form-group row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
								<label
									class="article col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary"
									for="birth_date">生&emsp;日：</label>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									<input type="date" min="1900-01-01" class="form-control"
										id="birth_date" name="birth_date" />
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
								<label
									class="article col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary"
									for="birth_date">性&emsp;别：</label>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary">
									男：<input type="radio" id="gender" name="gender" value="M" />
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary">
									女：<input type="radio" id="gender" name="gender" value="F" />
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<button type="submit" id="regist_submit"
										class="btn btn-primary">完成注册</button>
								</div>
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<label id="error_msg" class="text-danger">${msg }</label>
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
	<script src="<%=path%>/js/regist.js"></script>
</body>
</html>
