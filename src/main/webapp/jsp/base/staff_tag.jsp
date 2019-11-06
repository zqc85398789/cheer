<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="nav nav-tabs staff-tabs">
	<li class="now-active" id="query_tag"><a href="<%=request.getContextPath()%>/staff/staffList.do">员工查询</a></li>
	<li id="create_tag"><a href="<%=request.getContextPath()%>/staff/createStaffPage.do">新增员工</a></li>
</ul>
<script src="<%=request.getContextPath()%>/js/bootstrap/jquery-1.12.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/js/staff_tag.js"></script>
