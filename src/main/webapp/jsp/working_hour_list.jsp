<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>工时管理</title>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<link href="<%=path%>/css/bootstrap/bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/css/bootstrap/bootstrap-theme.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/css/styles.css" rel="stylesheet" type="text/css">
<link href="<%=path%>/css/labourers_family.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div class="container-fluid">
		<%@include file="base/header.jsp"%>
		<div class="content-div row">
			<%@include file="base/left.jsp"%>
			<br>
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
			<div
				class="col-lg-8 col-md-8 col-lg-8 col-xs-8 text-center form-back">
				<br>
				<div class="row text-primary">
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
						<!-- 查询条件表单 -->
						<form action="/cheer/queryWorkingHour.do" method="post" id="query_param">
							<div class="form-group row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
									<!-- 查询页号 -->
									<input type="hidden" name="queryPage" id="query_page" value="1">
									<!-- 账户名 -->
									<input type="text" name="staffName" value="${iStaff.staffName}" class="form-control"
										placeholder="输入姓名查询">
								</div>
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
									<!-- 员工号 -->
									<input type="text" name="empno" value="${iStaff.empno }" class="form-control"
										placeholder="输入员工号查询">
								</div>
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
									<button class="btn btn-success" type="submit">查询</button>
								</div>
							</div>
						</form>
					</div>

				</div>
				<!-- 显示部分 -->
				<div class="row">
					<div>
						<!-- 显示工时信息 -->
						<table class="table table-striped table-bordered table-reponsive">
							<tr>
								<th class="text-center">姓名</th>
								<th class="text-center">工号</th>
								<th class="text-center">年度工时</th>
								<th class="text-center">本月工时</th>
								<th class="text-center">今日工时</th>
								<th class="text-center">操作</th>
							</tr>
							<c:choose>
								<c:when test="${not empty iWorkingHourList}">
									<c:forEach items="${iWorkingHourList}" var="iWorkingHour">
										<tr>
											<td class="text-center">${iWorkingHour.iStaff.staffName}</td>
											<td class="text-center">${iWorkingHour.empno}</td>
											<td class="text-center">${iWorkingHour.yearDuration}</td>
											<td class="text-center">${iWorkingHour.monthDuration}</td>
											<td class="text-center">${iWorkingHour.duration}</td>
											<td class="text-center">
												<button class="update-button btn btn-primary btn-sm"
													data-path="<%=request.getContextPath() %>"
													data-staff-empno="${iWorkingHour.empno}">今日打卡</button>
											</td>
										</tr>
									</c:forEach>
								</c:when>
							</c:choose>
						</table>
					</div>
				</div>
				<!-- 分页标签 -->
				<div class="row text-primary">
					<div>
						<input type="hidden" id="current_page" value="${current_page }" />
						<input type="hidden" id="max_page" value="${max_page }" />
						<c:if test="${not empty current_page }">
							<ul class="pagination">
								<li><a href="#" class="page_tag" data-current="1"><i
										class="glyphicon glyphicon-fast-backward"></i></a></li>
								<li><a href="#" class="page_tag"
									data-current="${current_page-1}" ><i
										class="glyphicon glyphicon-backward"></i></a></li>
								<c:forEach begin="1" end="${max_page}" varStatus="status">
									<li class=""><a href="#" class="page_tag num_tag"
										data-current="${status.count}">${status.count}</a></li>
								</c:forEach>
								<li><a href="#" class="page_tag"
									data-current="${current_page+1}"><i
										class="glyphicon glyphicon-forward"></i></a></li>
								<li><a href="#" class="page_tag" data-current="${max_page}">
										<i class="glyphicon glyphicon-fast-forward"></i>
								</a></li>
							</ul>
						</c:if>
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
