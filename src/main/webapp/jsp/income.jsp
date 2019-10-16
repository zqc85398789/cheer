<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>收支记录</title>
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
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
			<div class="col-lg-8 col-md-8 col-lg-8 col-xs-8 text-center content-background content-div">
				<%@include file="base/tally.jsp" %>
				<div class="col col-lg-6 col-md-6 col-lg-6 col-xs-6">
					<div class="h3">收入记录</div>
					<form method="post" action="income.do" class="form-horizontal">
						<div class="form-group">
							<label for="item" class="col-lg-4 text-right">款项：</label>
							<div class="col-lg-8">
								<input type="text" id="item" name="item" class="form-control col-lg-8"
								 value="${income.item}" />
							</div>
						</div>
						<div class="form-group">
							<label for="income_source" class="col-lg-4 text-right">付款方：</label>
							<div class="col-lg-8">
								<input type="text" id="income_source" name="income_source" class="form-control"
									value="${income.income_source}" />
							</div>
						</div>
						<div class="form-group">
							<label for="received_by" class="col-lg-4 text-right">经收人：</label>
							<div class="col-lg-8">
								<input type="text" id="received_by" name="received_by" class="form-control col-lg-8"
									value="${income.received_by}" />
							</div>
						</div>
						<div class="form-group">
							<label for="received_time" class="col-lg-4 text-right">收款时间：</label>
							<div class="col-lg-8">
								<input type="datetime-local" id="received_time" name="received_time"
									class="form-control col-lg-8" value="${income.dateTimeLocal}"/>
							</div>
						</div>
						<div class="form-group">
							<label for="amount" class="col-lg-4 text-right">金额：</label>
							<div class="col-lg-8">
								<input type="text" id="amount" name="amount" class="form-control col-lg-8"
									value="${income.amount}" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-4 col-md-4 col-lg-4 col-xs-4"></div>
							<div class="col-lg-2 col-md-2 col-lg-2 col-xs-2">
								<button type="submit" class="btn btn-info btn_login">
									 <i class="glyphicon glyphicon-user"></i>添加记录
								</button>
							</div>
							<div class="col-lg-6 col-md-6 col-lg-6 col-xs-6">
								<label class="text-danger">${income_msg}</label>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script src="<%=path%>/js/jquery-1.12.js"></script>
	<script src="<%=path%>/js/bootstrap.js"></script>
	<script src="<%=path%>/js/tally.js"></script>
</body>
</html>
