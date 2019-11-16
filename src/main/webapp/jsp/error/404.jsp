<%@page language="java" pageEncoding="utf-8" isErrorPage="true"%>
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
<link href="<%=path%>/css/bootstrap/bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/css/bootstrap/bootstrap-theme.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container-fluid">
		<div class="row head"></div>
		<div class="error_info row text-center">
			<img src="<%=path %>/images/apologize.png"><br>
			<br> <label>您访问的页面失踪了……</label><br>
			<a class="btn btn-success" href="<%=path%>/homePage.do">回首页</a>
		</div>
	</div>
	<script src="<%=path %>/js/bootstrap/jquery-1.12.js"></script>
	<script src="<%=path %>/js/bootstrap/bootstrap.js"></script>
</body>
</html>
