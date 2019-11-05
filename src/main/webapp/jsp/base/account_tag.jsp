<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="nav nav-tabs account-tabs">
	<li class="now-active" id="query_tag"><a href="<%=request.getContextPath()%>/account/accountList.do">账户查询</a></li>
	<li id="create_tag"><a href="<%=request.getContextPath()%>/account/createAccountPage.do">创建账户</a></li>
</ul>
<script src="<%=request.getContextPath()%>/js/bootstrap/jquery-1.12.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/js/account_tag.js"></script>
