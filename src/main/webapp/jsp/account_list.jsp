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
			<br>
			<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
			<div
				class="col-lg-8 col-md-8 col-lg-8 col-xs-8 text-center form-back">
				<br>
				<div class="row text-primary">
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
						<form action="queryAccount.do" method="post">
							<div class="form-group row">
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
									<!-- 账户名 -->
									<input type="text" name="accountName" class="form-control"
										placeholder="输入用户名查询">
								</div>
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
									<!-- 员工号 -->
									<input type="text" name="empno" class="form-control"
										placeholder="输入员工号查询">
								</div>
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
									<!-- 姓名 -->
									<input type="text" name="staffName" class="form-control"
										placeholder="输入姓名查询">
								</div>
								<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
									<button class="btn btn-success" type="submit">查询</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="row">
					<div>
						<!-- 显示账号 -->
						<table class="table table-striped table-bordered table-reponsive">
							<tr>
								<th class="text-center">账户名</th>
								<th class="text-center">姓名</th>
								<th class="text-center">员工号</th>
								<th class="text-center">创建者</th>
								<th class="text-center">创建时间</th>
								<th class="text-center">修改者</th>
								<th class="text-center">修改时间</th>
								<th class="text-center">操作</th>
							</tr>
							<c:choose>
								<c:when test="${not empty accountList}">
									<c:forEach items="${accountList}" var="account">
										<tr>
											<td class="text-center">${account.accountName}</td>
											<td class="text-center">${account.staff.staffName}</td>
											<td class="text-center">${account.staff.empno}</td>
											<td class="text-center">${account.createdBy}</td>
											<td class="text-center">${account.createdTimeAsStr}</td>
											<td class="text-center">${account.updateBy}</td>
											<td class="text-center">${account.updateTimeAsStr}</td>
											<td class="text-center">
												<button class="update-button btn btn-primary btn-sm"
													data-path="<%=request.getContextPath() %>"
													data-accountId="${account.id}">修改</button>
												<button class="delete-button btn btn-sm"
													data-path="<%=request.getContextPath() %>"
													data-accountId="${account.id}">删除</button>
											</td>
										</tr>
									</c:forEach>
								</c:when>
							</c:choose>
						</table>
					</div>
					<div class="row text-primary">
						<div>
							<ul class="pagination">
								<li><a href="#"><i
										class="glyphicon glyphicon-fast-backward"></i></a></li>
								<li><a href="#"><i class="glyphicon glyphicon-backward"></i></a></li>
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#"><i
										class="glyphicon glyphicon-fast-forward"></i></a></li>
								<li><a href="#"><i class="glyphicon glyphicon-forward"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="<%=path%>/js/bootstrap/jquery-1.12.js"></script>
	<script src="<%=path%>/js/bootstrap/bootstrap.js"></script>
	<script src="<%=path%>/js/regist.js"></script>
	<script src="<%=path%>/js/account.js"></script>
</body>
</html>
