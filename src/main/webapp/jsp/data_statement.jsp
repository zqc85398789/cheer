<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>数据汇总</title>
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
			<div class="col-lg-10 col-md-10 col-sm-10 col-xs-10 text-center">
				<br>
				<div class="row">
					<div class="col-lg-2"></div>
					<div class='col-lg-3'>
						<div class="form-group">
							<div class='input-group date' id='datetimepicker1'>
								<input type='date' class="form-control" /> <span
									class="input-group-addon"> <span>起始时间</span>
								</span>
							</div>
						</div>
					</div>
					<div class='col-lg-3'>
						<div class="form-group">
							<div class='input-group date' id='datetimepicker1'>
								<input type='date' class="form-control" /> <span
									class="input-group-addon"> <span>结束时间</span>
								</span>
							</div>
						</div>
					</div>
					<div class='col-lg-1'>
						<button class="btn">查询</button>
					</div>
				</div>
				<div class="row">
					<div class="col col-lg-1"></div>
					<div class="col col-lg-10 table-responsive">
						<table class="table table-bordered table-hover table-striped">
							<thead>
								<tr>
									<th>条目1</th>
									<th>条目2</th>
									<th>条目3</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>null</td>
									<td>null</td>
									<td>null</td>
								</tr>
								<tr>
									<td>null</td>
									<td>null</td>
									<td>null</td>
								</tr>
								<tr>
									<td>null</td>
									<td>null</td>
									<td>null</td>
								</tr>
								<tr>
									<td>null</td>
									<td>null</td>
									<td>null</td>
								</tr>
								<tr>
									<td>null</td>
									<td>null</td>
									<td>null</td>
								</tr>
								<tr>
									<td>null</td>
									<td>null</td>
									<td>null</td>
								</tr>
								<tr>
									<td>null</td>
									<td>null</td>
									<td>null</td>
								</tr>
								<tr>
									<td>null</td>
									<td>null</td>
									<td>null</td>
								</tr>
								<tr>
									<td>null</td>
									<td>null</td>
									<td>null</td>
								</tr>
								<tr>
									<td>null</td>
									<td>null</td>
									<td>null</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row">
					<ul class="pagination">
						<li><a href="#" class="glyphicon glyphicon-fast-backward"></a></li>
						<li><a href="#">上一页</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">下一页</a></li>
						<li><a href="#" class="glyphicon glyphicon-fast-forward"></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>

	<script src="<%=path%>/js/jquery-1.12.js"></script>
	<script src="<%=path%>/js/bootstrap.js"></script>
</body>
</html>
