$(function() {
	$("#io1").click(function() {
		$("#po1").html("<center><b>投票成功</b></center>");
		$("#io1").hide();
		$("#io2").hide();
		$("#io3").hide();
	});
});
$(function() {
	$("#io2").click(function() {
		$("#po2").html("<center><b>投票成功</b></center>");
		$("#io1").hide();
		$("#io2").hide();
		$("#io3").hide();
	});
});
$(function() {
	$("#io3").click(function() {
		$("#po3").html("<center><b>投票成功</b></center>");
		$("#io1").hide();
		$("#io2").hide();
		$("#io3").hide();
	});
});