function getRootPath() {
	// 获取当前网址
	var curWwwPath = window.document.location.href;
	// 获取主机地址之后的目录
	var pathName = window.document.location.pathname;
	// 获取主机地址
	var pos = curWwwPath.indexOf(pathName);
	var localhostPaht = curWwwPath.substring(0, pos);
	// 获取带"/"的项目名
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	return (localhostPaht + projectName);
}

var path = getRootPath();

$(function() {
	$(".update-button").each(function() {
		$(this).click(function() {
			var accountId = $(this).attr("data-accountId");
			window.location.href = path
				+ "/account/updateAccountPage.do/"
				+ accountId + ".do";
		});
	});
});

$(function() {
	$(".delete-button").each(function() {
		$(this).click(function() {
			var accountId = $(this).attr("data-accountId");
			if(confirm("确认要删除吗？")){
				window.location.href= path + "/account/deleteAccountPage.do/" + accountId + ".do";
			}
		});
	});
});

$(function() {
	$(".page_tag").each(function() {
		// 分页查询
		$(this).click(function() {
			var queryPage = $(this).attr("data-current");
			var maxPage = $("#max_page").val();
			// 判断是否已在首页尾页
			if (queryPage < 1) {
				queryPage = 1;
			}
			if (queryPage > maxPage) {
				queryPage = maxPage;
			}
			$("#query_page").val(queryPage);
			document.getElementById('query_param').submit();
		});
	});
});

$(function() {
	$(".num_tag").each(function() {
		// 为当前页设置选中样式
		var currentPage = $("#current_page").val();
		var thisPage = $(this).attr("data-current");
		if (currentPage == thisPage) {
			$(this).addClass("now-active");
		}else{
			$(this).removeClass("now-active");
		}
	});
});