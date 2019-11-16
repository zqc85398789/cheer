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
				<div class="h2 text-primary">员工信息修改</div>
				<div class="row">
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
						<c:choose>
							<c:when test="${not empty iStaff}">
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 text-right">
								<form:form action="/cheer/staff/updateStaff.do" method="post"
									modelAttribute="iStaff">
									<div class="form-group row">
										<!-- id -->
										<form:hidden path="id" value="${iStaff.id}"/>
										<!-- 姓名 -->
										<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
										<label
											class="article col-lg-3 col-md-3 col-sm-3 col-xs-3 text-primary"
											for="staffName">姓名：</label>
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
											<form:input path="staffName" cssClass="form-control"
												id="staffName" value="${iStaff.staffName}" />
										</div>
										<div
											class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left">
											<form:errors path="staffName" cssClass="text-danger"></form:errors>
										</div>
									</div>

									<div class="form-group row">
										<!-- 电话 -->
										<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
										<label
											class="article col-lg-3 col-md-3 col-sm-3 col-xs-3 text-primary"
											for="telephoneNo">电话：</label>
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
											<form:input path="telephoneNo" cssClass="form-control"
												id="telephoneNo" value="${iStaff.telephoneNo}" />
										</div>
										<div
											class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left">
											<form:errors path="telephoneNo" cssClass="text-danger"></form:errors>
										</div>
									</div>
									<div class="form-group row">
										<!-- 身份证号 -->
										<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
										<label
											class="article col-lg-3 col-md-3 col-sm-3 col-xs-3 text-primary"
											for="idCard">身份证：</label>
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
											<form:input path="idCard" cssClass="form-control" id="idCard"
												value="${iStaff.idCard}" />
										</div>
										<div
											class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left">
											<form:errors path="idCard" cssClass="text-danger"></form:errors>
										</div>
									</div>
									<div class="form-group row">
										<!-- 紧急联系人 -->
										<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
										<label
											class="article col-lg-3 col-md-3 col-sm-3 col-xs-3 text-primary"
											for="emergencyContact">联系人：</label>
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
											<form:input path="emergencyContact" cssClass="form-control"
												id="emergencyContact" value="${iStaff.emergencyContact}" />
										</div>
										<div
											class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left">
											<form:errors path="emergencyContact" cssClass="text-danger"></form:errors>
										</div>
									</div>
									<div class="form-group row">
										<!-- 紧急联系电话 -->
										<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
										<label
											class="article col-lg-3 col-md-3 col-sm-3 col-xs-3 text-primary"
											for="emergencyTel">紧急联系电话：</label>
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
											<form:input path="emergencyTel" cssClass="form-control"
												id="emergencyTel" value="${iStaff.emergencyTel}" />
										</div>
										<div
											class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left">
											<form:errors path="emergencyTel" cssClass="text-danger"></form:errors>
										</div>
									</div>
									<div class="form-group row">
										<!-- 员工号 -->
										<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
										<label
											class="article col-lg-3 col-md-3 col-sm-3 col-xs-3 text-primary"
											for="empno">员工号：</label>
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
											<form:input path="empno" cssClass="form-control" id="empno"
												value="${iStaff.empno}" />
										</div>
										<div
											class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left">
											<form:errors path="empno" cssClass="text-danger"></form:errors>
										</div>
									</div>
									<div class="form-group row">
										<!-- 生日 -->
										<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
										<label
											class="article col-lg-3 col-md-3 col-sm-3 col-xs-3 text-primary"
											for="birthDate">生日：</label>
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6 text-left">
											<input type="date" id="birthDate" name="birthDate" class="form-control" 
												pattern="yyyy-MM-dd" value="${iStaff.birthDateAsStr}">
										</div>
										<div
											class="col-lg-2 col-md-2 col-sm-2 col-xs-2 text-danger text-left">
											<form:errors path="birthDate" cssClass="text-danger"></form:errors>
										</div>
									</div>
									<div class="form-group row">
										<!-- 性别 -->
										<div class="col-lg-1 col-md-1 col-sm-1 col-xs-1"></div>
										<label
											class="article col-lg-3 col-md-3 col-sm-3 col-xs-3 text-primary"
											for="gender">性别：</label>
										<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
											<label for="male" class="text-primary">男</label> <input
												type="radio" name="gender" id="male" value="M"
												checked="checked" />
										</div>
										<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
											<label for="female" class="text-primary">女</label> <input
												type="radio" name="gender" id="female" value="F" />
										</div>
									</div>
									<div class="form-group row">
										<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4"></div>
										<div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
											<button type="submit" id="regist_submit"
												class="btn btn-primary">提交</button>
										</div>
										<label class="col-lg-4 col-md-4 col-sm-4 col-xs-4 text-danger">
											${staff_update_msg} </label>
									</div>
								</form:form>
							</c:when>
							<c:otherwise>
								<div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 text-center">
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
	<script src="<%=path%>/js/staff.js"></script>
</body>
</html>
