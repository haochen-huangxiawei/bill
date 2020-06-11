function checkpassword() {
	var $pwd = $("#password").val();
	var $pwdId = $("#errpassword");
	$pwdId.html("");
	
	if ($pwd == "") {
		$pwdId.html("旧密码不允许为空！");
		return false;
	}
	return true;
}

function checkpwd() {
	var $pwd = $("#pwd").val();
	var $pwdId = $("#errpwd");
	$pwdId.html("");

	if ($pwd == "") {
		$pwdId.html("新密码不允许为空！");
		return false;
	}

	var $repwd = $("#repwd").val();
	var $repwdId = $("#errrepwd");
	$repwdId.html("");

	if ($repwd == "") {
		$repwdId.html("请输入确认密码！");
		return false;
	}
	if ($pwd != $repwd) {
		$pwdId.html("两次输入密码不一致！");
		$repwdId.html("两次输入密码不一致！");
		return false;
	}
	return true;
}

$(function() {
	//绑定失去焦点事件
	$("#password").blur(checkpassword);
	$("#pwd").blur(checkpwd);
	$("#repwd").blur(checkpwd);

	//提交表单，调用验证函数
	$("#myform").submit(function() {
		var flag = true;
		if (!checkpassword()) flag = false;
		if (!checkpwd()) flag = false;

		return flag;
	});
});