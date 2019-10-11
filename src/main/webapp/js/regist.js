var verify_username = false;
var verify_password = false;
var verify_password_check = false;
var verify_legal_name = false;

/*校验用户名*/
$(function() {
	$("#username").blur(function() {
		var username = this.value;
		if (username == "") {
			verify_username = false;
			$("#verify_username").html("用户名不能为空");
			return;
		}
		var pattern = /^[a-zA-z][a-zA-z0-9]{4,15}$/;
		console.log(pattern.test(username));
		if (!pattern.exec(username)) {
			verify_username = false;
			$("#verify_username").html("格式不正确");
			return;
		} else {
			verify_username = true;
			$("#verify_username").html("*");
		}
	});
})

/*校验密码*/
$(function() {
	$("#password").blur(function() {
		var password = this.value;
		if (password == "") {
			verify_password = false;
			$("#verify_password").html("密码不能为空");
			return;
		}
		var pattern = /^[a-zA-z0-9_]{8,16}$/;
		console.log(pattern.test(password));
		if (!pattern.exec(password)) {
			verify_password = false;
			$("#verify_password").html("格式不正确");
			return;
		} else {
			verify_password = true;
			$("#verify_password").html("*");
			check_consistency();
		}
	});
})

$(function() {
	$("#password_check").blur(function(){
		check_consistency();
	});
})

/*校验两次密码一致性*/
var check_consistency = function() {
	var password_check = $("#password_check").val();
	var password = $("#password").val();
	if (!(password_check == password)) {
		verify_password_check = false;
		$("#verify_password_check").html("两次输入的密码不一致");
		return;
	} else {
		verify_password_check = true;
		$("#verify_password_check").html("*");
	}
};

$(function() {
	$("#legal_name").blur(function() {
		var legal_name = this.value;
		if (legal_name == "") {
			verify_legal_name = false;
			$("#verify_legal_name").html("姓名不能为空");
		}else{
			verify_legal_name = true;
			$("#verify_legal_name").html("*");
		}
	});
})

/*提交控制*/
$(function() {
	$("#regist_submit").click(function() {
		var allow_submit = verify_username && verify_password && verify_password_check && verify_legal_name;
		if (!allow_submit) {
			alert("请修改错误项后再提交。");
			return false;
		} else {
			return true;
		}
	});
})
