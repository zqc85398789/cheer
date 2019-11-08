<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>员工信息修改</title>
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
				<div class="h2 text-primary">今日打卡</div>
				<div class="row">
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 text-center">
						<c:choose>
							<c:when test="${not empty workingHour}">
								<div>
									<label class="h3 text-info">员工：${workingHour.staff.staffName}&emsp;
										工号：${workingHour.staff.empno}</label>
								</div>
								<form action="/cheer/updateWorkingHour.do" method="post">
									<div class="form-group row">
										<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
										<label
											class="article col-lg-3 col-md-3 col-sm-3 col-xs-3 text-primary"
											for="duration">请输入工作时长</label>
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
											<input type="hidden" name="staff.staffName" value="${workingHour.staff.staffName}"/>
											<input type="hidden" name="staff.empno" value="${workingHour.staff.empno}"/>
											<input type="number" max="24" min="0" name="duration" class="form-control"
												id="duration" value="${workingHour.duration}" />
										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
										<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
											<button type="submit" id="regist_submit"
												class="btn btn-primary">提交</button>
										</div>
										<label class="col-lg-4 col-md-4 col-sm-4 col-xs-4 text-danger">
											${workingHour_update_msg} </label>
									</div>
								</form>
							</c:when>
							<c:otherwise>
								<h2 class="text-danger">员工信息不存在</h2>
							</c:otherwise>
						</c:choose>
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
