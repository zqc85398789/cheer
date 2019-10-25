<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>月度最佳</title>
<%
		String path = request.getScheme()+"://"+
		request.getServerName()+":"+request.getServerPort()+request.getContextPath(); 
		%>
		<link href="<%=path %>/css/bootstrap.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/bootstrap-theme.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/styles.css" rel="stylesheet" type="text/css">
		<link href="<%=path%>/css/labourers_family.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container-fluid">
		<%@include file="base/header.jsp"%>
		<div class="content-div row">
			<%@include file="base/left.jsp"%>
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
			<div
				class="col-lg-10 col-md-10 col-sm-10 col-xs-10 text-center">
				<div class="row">
					<h3>
						民工之星<font class="small">&emsp;(每人限投一票)</font>
					</h3>
				</div>
				<hr>
				<div class="row">
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
						<img class="candidate" data-src="holder.js/300x200" /> <br> <br>
						<button id="io1" class="btn btn-info">投他一票</button>
						<div id="po1"></div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
						<img class="candidate" data-src="holder.js/300x200" /> <br> <br>
						<button id="io2" class="btn btn-info">投他一票</button>
						<div id="po2"></div>
					</div>
					<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
						<img class="candidate"  data-src="holder.js/300x200" /> <br> <br>
						<button id="io3" class="btn btn-info">投他一票</button>
						<div id="po3"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="<%=path %>/js/bootstrap/jquery-1.12.js"></script>
	<script src="<%=path %>/js/bootstrap/bootstrap.js"></script>
	<script src="https://cdn.bootcss.com/holder/2.9.4/holder.js"></script>
	<script src="<%=path %>/js/labourers_family.js"></script>
</body>
</html>
