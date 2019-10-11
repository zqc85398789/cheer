$(function() {
	$("#regist").click(function() {
		var path = $(this).attr("data-path");
		window.location.href= path + "/registPage.do";
	});
})
