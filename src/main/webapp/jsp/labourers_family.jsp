<%@page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>民工之家</title>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<link href="<%=path%>/css/bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="<%=path%>/css/bootstrap-theme.css" rel="stylesheet"
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
			<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"></div>
			<div
				class="col-lg-10 col-md-10 col-sm-10 col-xs-10 text-center">
				<div id="white" class="row">民工之家</div>
				<div class="jumbotron row">工友们，欢迎来到xx公司民工之家！</div>
				<div id="login" class="row">
					<a href="#">xxx</a>工友，您好！ &nbsp&nbsp&nbsp&nbsp
					<button href="#" class="btn btn-default btn-info">重新登录</button>
					<!--链接登录窗口-->
					&nbsp&nbsp&nbsp&nbsp
					<button class="btn btn-default btn-info">修改信息</button>
					&nbsp&nbsp&nbsp&nbsp
					<button class="btn btn-default btn-info">我要发帖</button>
				</div>
				<div class="row">
					<div class="col-xs-2" id="menu">
						<ul class="nav nav-pills nav-stacked" data-spy="affix"
							data-offset-top="280">
							<li><a href="#1"><i class="icon-chevron-right"></i> 本地新闻</a></li>
							<li><a href="#2"><i class="icon-chevron-right"></i> 工作记实</a></li>
							<li><a href="#3"><i class="icon-chevron-right"></i> 娱乐天地</a></li>
							<li><a href="#4"><i class="icon-chevron-right"></i> 民工之星</a></li>
							<li><a href="#5"><i class="icon-chevron-right"></i> 工友问答</a></li>
							<li><a href="#6"><i class="icon-chevron-right"></i> 联系老板</a></li>
						</ul>
					</div>
					<div class="col-xs-10">
						<fieldset id="1">
							<legend>本地新闻</legend>

							<div class="fieldset-content">
								<ul class="nav nav-pills nav-stacked">
									<li><a href="#">《上海堡垒》导演直言用错鹿晗引争议，向佐发文怒斥滕华涛</a></li>
									<li><a href="#">陈晓前发文直指苹果日报：这就是你们嘴里的新闻自由吗？</a></li>
									<li><a href="#">传阿里推迟150亿美元香港上市计划 或于10月份重启</a></li>
									<li><a href="https://www.baidu.com">意大利总理孔特宣布将辞职</a></li>
								</ul>
							</div>
							<br>
						</fieldset>
						<fieldset id="2">
							<legend>工作纪实</legend>
							<div class="fieldset-content">
								<div class="container-fluid">
									一、倡树“学校是我家，荣辱靠大家”思想，用思想引领大家用心办教育；“河文化”办学理念不断完善，并已经深入师生心中。

									二、落实领导干部一线任课制度。副校级周课时数9节，中层正职任语数学科教学，中层副职任语数学科教学，担任班主任。

									三、文明行路、文明如厕成为校内外的一道风景，养成教育扎实推进。在学生行为习惯养成方面推行、落实“早叮咛，晚嘱咐”制度。 四
									、录制《好习惯，好人生》教育视频；《清婉林晓》学校特色办学宣传片。出版《我的交心故事—来自1+1的交心日志》宣传册。 五
									、成立教师读书会，引导老师们记写教学反思，依托1+1教育网，让读写引领教师专业成长。本人自XX年9月至今累计记写教学日志171篇。

									六
									、交心教育全面丰收，《教子故事》交心本，在多家媒体报道。我校教师的七篇交心文章入选《水寨交心教育研究》。四名教师日志入选《1+1旅途周刊》，并获好评。

									七、“232高效思维课堂模式”初现，五名教师代表全镇参加市级优质课评选。XX年12月19日，全镇小学常规材料展示观摩在我校举行。

									八、校本课程开发落地，有20个科目正在进行。“爱、责任、创新”主题实践活动有序开展。

									九、抓常规材料检查工作，在作业批改和单元过关.
									<ul class="pagination">
										<li><a href="#">上一页</a></li>
										<li class="active"><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li><a href="#">下一页</a></li>
									</ul>
								</div>
								<br>
							</div>
						</fieldset>
						<fieldset id="3">
							<legend>娱乐天地</legend>
							<div class="fieldset-content">
								<div class="container-fluid">
									<div class="media">
										<a href="#" class="pull-left"> <img title="有关链接"
											src="1.jpg" class="media-object">
										</a>
										<div class="media-body">
											<h2 class="media-heading">世界之巅，针锋相对，尽在2018世界杯！</h2>
											<div class="media">
												<p>2018年俄罗斯世界杯（2018 FIFA World
													Cup）是国际足联世界杯足球赛举办的第21届赛事。比赛于2018年6月14日至7月15日在俄罗斯举行，这是世界杯首次在俄罗斯境内举行，亦是世界杯首次在东欧国家举行。本届赛事共有来自5大洲足联的32支球队参赛，除东道主俄罗斯队自动获得参赛资格以外，其余31支球队通过各大洲足联举办的预选赛事获得参赛资格。
												</p>
											</div>
										</div>
									</div>
									<div class="me media pull-right">
										<a href="#" class="pull-left"> <img title="有关链接"
											src="2.jpg" class="media-object">
										</a>
										<div class="media-body">
											<h2 class="media-heading">日本重启销售华为是怎么回事</h2>
											<div class="media">
												<p>据外媒消息，日本三大运营商之一的NTT
													Docomo近日表示，将重启接受华为高端P30Pro智能手机的订单。此前，在美国单方面禁止华为后，NTT
													Docomo也在5月底暂停接受订单。 日本最大的运营商NTT
													Docomo表示，它将于周三重启华为高端智能手机的订单，这款P30Pro手机定于9月在日本发售。</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</fieldset>
						<br>

						<fieldset id="5">
							<legend>
								工友问答 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								<button class="btn btn-warning ">我要提问</button>
							</legend>
							<div class="fieldset-content">
								<font class="qs">工地的生活快乐吗？</font> &nbsp&nbsp&nbsp&nbsp
								<button class="btn btn-info">我要回答</button>
								<br> <br> <font class="qs">今年的生猪价格为什么这么贵？</font>
								&nbsp&nbsp&nbsp&nbsp
								<button class="btn btn-info">我要回答</button>
								<br> <br>
							</div>
						</fieldset>
						<fieldset id="6">
							<legend>联系老板</legend>
							<div class="email fieldset-content">
								公司法人：王根生 <br> <br> 老板信箱:547894345@qq.com <br> <br>
								老板手机：18723454956 <br> <br>
							</div>
						</fieldset>
					</div>
				</div>
				<div class="row">
					<article id="a4" class="text-center">网易公司版权所有©1997-2019
						ICP证粤B2-20090191 粤公网安备 44010602000311 （数据来源：艾媒邮箱报告）</article>
				</div>
			</div>
		</div>
	</div>

	<script src="<%=path %>/js/jquery-1.12.js"></script>
	<script src="<%=path %>/js/bootstrap.js"></script>
	<script src="<%=path %>/js/labourers_family.js"></script>
</body>
</html>
