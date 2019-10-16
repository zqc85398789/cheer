<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="nav nav-tabs tally-tabs">
	<li class="now-active"><a href="<%=request.getContextPath()%>/incomePage.do">收入记录</a></li>
	<li><a href="<%=request.getContextPath()%>/expensePage.do">支出记录</a></li>
</ul>
<script src="<%=request.getContextPath()%>/js/jquery-1.12.js"></script>
<script src="<%=request.getContextPath()%>/js/bootstrap.js"></script>
