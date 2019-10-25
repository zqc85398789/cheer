<%@page language="java" pageEncoding="utf-8"%>
<%
	String img_path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<div class="row head navbar navbar-default navbar-fixed-top">
	<div class="col col-lg-2 col-md-2 col-sm-2 col-xs-2 logo-div">
		<img class="logo" src="<%=img_path %>/images/logo.jpg">
	</div>
	<div class="col col-lg-9 col-md-9 col-sm-9 col-xs-9"></div>
	<div class="col col-lg-1 col-md-1 col-sm-1 col-xs-1">
		<img class="img-circle userphoto" src="<%=img_path %>/images/portrait.jpg">
	</div>
</div>