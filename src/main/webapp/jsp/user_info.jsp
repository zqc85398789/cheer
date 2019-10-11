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
			<div class="col-lg-10 col-md-10 col-lg-10 col-xs-10 text-center">
				<div class="col col-lg-4">
					<div class="h3">个人信息</div>
					<form method="post" action="" class="form-horizontal">
						<div class="form-group">
							<label for="userName" class="col-lg-4 text-right">用户名：</label>
							<div class="col-lg-8">
								<input type="text" id="userName" class="form-control col-lg-8"
									readonly value="MichaelJack" />
							</div>
						</div>
						<div class="form-group">
							<label for="leaglName" class="col-lg-4 text-right">姓名：</label>
							<div class="col-lg-8">
								<input type="text" id="leaglName" class="form-control" readonly
									value="张全蛋" />
							</div>
						</div>
						<div class="form-group">
							<label for="job" class="col-lg-4 text-right">职务：</label>
							<div class="col-lg-8">
								<input type="text" id="job" class="form-control col-lg-8"
									readonly value="质检员" />
							</div>
						</div>
						<div class="form-group">
							<label for="phoneNumber" class="col-lg-4 text-right">电话：</label>
							<div class="col-lg-8">
								<input type="text" id="phoneNumber"
									class="form-control col-lg-8" readonly value="138********" />
							</div>
						</div>
						<div class="form-group">
							<label for="emergency" class="col-lg-4 text-right">紧急联系人：</label>
							<div class="col-lg-8">
								<input type="text" id="emergency" class="form-control col-lg-8"
									readonly value="赵铁柱" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-11 col-lg-offset-1">
								<button type="button" class="btn btn-info btn_login">
									<a
										href="<%=request.getContextPath()%>/jsp/info_modification.jsp"
										class="text-muted"> <i class="glyphicon glyphicon-user"></i>修改信息
									</a>
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script src="<%=path%>/js/jquery-1.12.js"></script>
	<script src="<%=path%>/js/bootstrap.js"></script>
</body>
</html>
