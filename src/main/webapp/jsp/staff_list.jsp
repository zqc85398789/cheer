<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>员工列表</title>
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
				<%@include file="base/staff_tag.jsp"%>
				<br>
				<div class="row text-primary">
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
						<!-- 查询条件表单 -->
						<form action="/cheer/staff/queryStaff.do" method="post" id="query_param">
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
						<!-- 显示账号 -->
						<table class="table table-striped table-bordered table-reponsive">
							<tr>
								<th class="text-center">姓名</th>
								<th class="text-center">生日</th>
								<th class="text-center">电话</th>
								<th class="text-center">员工号</th>
								<th class="text-center">身份证号</th>
								<th class="text-center">性别</th>
								<th class="text-center">紧急联系人/电话</th>
								<th class="text-center">操作</th>
							</tr>
							<c:choose>
								<c:when test="${not empty iStaffList}">
									<c:forEach items="${iStaffList}" var="iStaff">
										<tr>
											<td class="text-center">${iStaff.staffName}</td>
											<td class="text-center">${iStaff.birthDateAsStr}</td>
											<td class="text-center">${iStaff.telephoneNo}</td>
											<td class="text-center">${iStaff.empno}</td>
											<td class="text-center">${iStaff.idCard}</td>
											<td class="text-center">${iStaff.gender}</td>
											<td class="text-center">${iStaff.emergencyContact}/${iStaff.emergencyTel}</td>
											<td class="text-center">
												<button class="update-button btn btn-primary btn-sm"
													data-path="<%=request.getContextPath() %>"
													data-staffId="${iStaff.id}">修改</button>
												<c:choose>
													<c:when test="${iStaff.isActive == 'Y'}">
														<button class="delete-button btn btn-warning btn-sm"
															data-path="<%=request.getContextPath() %>"
															data-staffId="${iStaff.id}">删除</button>
													</c:when>
													<c:otherwise>
														<button class="active-button btn btn-success btn-sm"
															data-path="<%=request.getContextPath() %>"
															data-staffId="${iStaff.id}">激活</button>
													</c:otherwise>
												</c:choose>
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
					<div><label class="text-danger h3">${staff_list_msg}</label></div>
				</div>
			</div>
		</div>
	</div>

	<script src="<%=path%>/js/bootstrap/jquery-1.12.js"></script>
	<script src="<%=path%>/js/bootstrap/bootstrap.js"></script>
	<script src="<%=path%>/js/staff.js"></script>
</body>
</html>
