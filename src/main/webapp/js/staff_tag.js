$(function() {
	$(".staff").addClass("now-active");
	$(".staff-tabs").find("li").each(function() {
		var a = $(this).find("a:first");
		var href = location.pathname;
		if(href.indexOf("query")!=-1 || href.indexOf("List")!=-1){
			$("#query_tag").addClass("now-active");
		}else{
			$("#query_tag").removeClass("now-active");
		}
	});
});
