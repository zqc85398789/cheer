$(function() {
	$("#login").click(function() {
		var path = $(this).attr("data-path");
		window.location.href= path + "/loginPage.do";
	});
})