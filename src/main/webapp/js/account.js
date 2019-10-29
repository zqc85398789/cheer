$(function() {
	$(".update-button").each(function() {
		$(this).click(function(){
			var accountId = $(this).attr("data-accountId");
			var path = $(this).attr("data-path");
			alert(path + "/updateAccountPage.do/"+accountId);
			//window.location.href= path + "/updateAccountPage.do/"+accountId;
		});
	});
});

$(function() {
	$(".delete-button").each(function() {
		$(this).click(function(){
			var accountId = $(this).attr("data-accountId");
			var path = $(this).attr("data-path");
			alert(path + "/deleteAccount.do/"+accountId);
			//window.location.href= path + "/deleteAccount.do/"+accountId;
		});
	});
});