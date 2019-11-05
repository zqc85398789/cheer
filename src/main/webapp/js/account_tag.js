$(function() {
	$(".account").addClass("now-active");
	$(".account-tabs").find("li").each(function() {
		var a = $(this).find("a:first");
		var href = location.pathname;
		if(href.indexOf("queryAccount")!=-1 || href.indexOf("accountList")!=-1){
			$("#query_tag").addClass("now-active");
		}else{
			$("#query_tag").removeClass("now-active");
		}
	});
});
