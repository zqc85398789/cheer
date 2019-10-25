<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户注册</title>
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
			<div class="text-center">
				<br>
				<div class="h2 text-primary">用户注册</div>
				<label class="text-primary">（带*为必填项）</label>
				<div class="row regist-form">
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
					<div class="form-back col-lg-8 col-md-8 col-sm-8 col-xs-8">
						<form:form action="regist.do" method="post" modelAttribute="user">
							<div class="form-group row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
								<label
									class="article col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary"
									for="username">用户名：</label>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
 									<form:input path="username" cssClass="form-control" id="username" placeholder="由5-16位字母或数字组成,只能以字母开头"/>
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left">
									<form:errors path="username" cssClass="text-danger"></form:errors>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
								<label
									class="article col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary"
									for="password">密&emsp;码：</label>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									<form:password path="password" id="password" cssClass="form-control" placeholder="由8-16位字母、数字或&quot;_&quot;组成"/>
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left">
									<form:errors path="password" cssClass="text-danger"></form:errors>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									<form:password path="password_check" id="password_check" cssClass="form-control" placeholder="请再次输入密码"/>
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left">
									<form:errors path="*" cssClass="text-danger"></form:errors>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
								<label
									class="article col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary"
									for="legal_name">姓&emsp;名：</label>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									<form:input path="legal_name" id="legal_name" cssClass="form-control" placeholder="请输入姓名"/>
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left">
									<form:errors path="legal_name" cssClass="text-danger"></form:errors>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
								<label
									class="article col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary"
									for="birth_date">生&emsp;日：</label>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									<input type="date" pattern="yyyy-MM-dd" min="1900-01-01" class="form-control"
										id="birth_date" name="birth_date" />
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left">
									<form:errors path="birth_date" cssClass="text-danger"></form:errors>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
								<label
									class="article col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary"
									for="birth_date">性&emsp;别：</label>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary">
									<form:radiobutton  id="gender" path="gender" value="M" label="男"/>
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary">
									<form:radiobutton  id="gender" path="gender" value="F" label="女"/>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<button type="submit" id="regist_submit"
										class="btn btn-primary">完成注册</button>
								</div>
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<form:errors path="*" cssClass="text-danger"></form:errors>
									<label id="error_msg" class="text-danger">${msg }</label>
								</div>
							</div>
						</form:form>
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=path%>/js/bootstrap/jquery-1.12.js"></script>
	<script src="<%=path%>/js/bootstrap/bootstrap.js"></script>
	<script src="<%=path%>/js/regist.js"></script>
</body>
</html>
