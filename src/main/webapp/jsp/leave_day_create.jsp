<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>新增请假记录</title>
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
			<%@include file="base/left.jsp"%><br>
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
			<div
				class="col-lg-8 col-md-8 col-lg-8 col-xs-8 text-center form-back">
				<ul class="nav nav-tabs">
					<li><a href="<%=path%>/leaveDayList.do">记录查询</a></li>
					<li class="now-active"><a
						href="<%=path%>/createLeaveDayPage.do">创建记录</a></li>
				</ul>
				<div class="h2 text-primary">创建记录</div>
				<div class="row">
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 text-center">
						<form:form action="/cheer/createLeaveDay.do" method="post"
							modelAttribute="iLeaveDay">
							<div class="form-group row">
								<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
								<label
									class="article col-lg-3 col-md-3 col-sm-3 col-xs-3 text-primary"
									for="empno">员工号</label>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									<form:input id="empno" cssClass="form-control"  path="empno" value="${iLeaveDay.empno}" />
								</div>
								<div
									class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left">
									<form:errors path="empno" cssClass="text-danger"></form:errors>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
								<label
									class="article col-lg-3 col-md-3 col-sm-3 col-xs-3 text-primary" 
									for="leaveDate">请假日期</label>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 text-left">
									<form:input type="date" pattern="yyyy-MM-dd" id="leaveDate"
										cssClass="form-control" path="leaveDate" value="${iLeaveDay.leaveDateAsStr}" />
								</div>
								<div
									class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left">
									<form:errors path="leaveDate" cssClass="text-danger"></form:errors>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
								<label
									class="article col-lg-3 col-md-3 col-sm-3 col-xs-3 text-primary"
									for="days">请假天数</label>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
									<form:input type="number" id="days" min="1" name="duration"
										cssClass="form-control" path="days" value="${iLeaveDay.days}" />
								</div>
								<div
									class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left">
									<form:errors path="days" cssClass="text-danger"></form:errors>
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
								<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
									<button type="submit" id="regist_submit"
										class="btn btn-primary">提交</button>
								</div>
								<label class="col-lg-4 col-md-4 col-sm-4 col-xs-4 text-danger">
									${leave_day_create_msg} </label>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="<%=path%>/js/bootstrap/jquery-1.12.js"></script>
	<script src="<%=path%>/js/bootstrap/bootstrap.js"></script>
	<script src="<%=path%>/js/workingHour.js"></script>
</body>
</html>
