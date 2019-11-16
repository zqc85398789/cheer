$(function() {
	$(".nav-stacked").find("li").each(function() {
		var a = $(this).find("a:first");
		if ($(a).attr("href") == location.pathname) {
			$(this).addClass("now-active");
		} else {
			$(this).removeClass("now-active");
		}
	});
});

$(function(){
	$("#logout").click(function(){
		var path = $(this).attr("data-path");
		window.location.href= path + "/logout.do";
	});
});