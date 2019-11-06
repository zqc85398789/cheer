<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>创建账号</title>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<link href="<%=path%>/css/bootstrap/bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/css/bootstrap/bootstrap-theme.css"
	rel="stylesheet" type="text/css">
<link href="<%=path%>/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container-fluid">
		<%@include file="base/header.jsp"%>
		<div class="content-div row">
			<%@include file="base/left.jsp"%>
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
			<div
				class="col-lg-8 col-md-8 col-lg-8 col-xs-8 text-center content-div form-back">
				<%@include file="base/account_tag.jsp" %>
				<br>
				<div class="h2 text-primary">创建账号</div>
				<div class="row">
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
						<form:form action="createAccount.do" method="post"
							modelAttribute="account">
							<div class="form-group row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
								<label
									class="article col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary"
									for="username">用户名：</label>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									<form:input path="accountName" cssClass="form-control"
										id="username" value="${account.accountName}" placeholder="由5-16位字母或数字组成,只能以字母开头" />
								</div>
								<div
									class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left">
									<form:errors path="accountName" cssClass="text-danger"></form:errors>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
								<label
									class="article col-lg-2 col-md-2 col-sm-2 col-xs-2 text-primary"
									for="password">密&emsp;码：</label>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									<form:password path="accountPassword" id="password"
										cssClass="form-control"
										placeholder="由8-16位字母、数字或&quot;_&quot;组成" />
								</div>
								<div
									class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left">
									<form:errors path="accountPassword" cssClass="text-danger"></form:errors>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									<form:password path="passwordCheck" id="password_check"
										cssClass="form-control" placeholder="请再次输入密码" />
								</div>
								<div
									class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left">
									<label class="text-danger">${account_password_error}</label>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
									<label for="boss" class="text-primary">老板</label>
									<input type="radio" name="privilegeId" id="boss" value="2" />
								</div>
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
									<label for="foreman" class="text-primary">组长</label>
									<input type="radio" name="privilegeId" id="foreman" value="3" checked="checked"/>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<button type="submit" id="regist_submit"
										class="btn btn-primary">创建账号</button>
								</div>
								<label class="col-lg-4 col-md-4 col-sm-4 col-xs-4 text-danger">
									${account_create_msg}
								</label>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="<%=path%>/js/bootstrap/jquery-1.12.js"></script>
	<script src="<%=path%>/js/bootstrap/bootstrap.js"></script>
	<script src="<%=path%>/js/account.js"></script>
</body>
</html>
