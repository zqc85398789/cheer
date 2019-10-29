$(function() {
	$("#loginUser").click(function(){
		var path = $(this).attr("data-path");
		window.location.href= path + "/accountUpdatePage.do";
	});
})