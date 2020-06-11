function checkid() {
	var $mail = $("#id");
	var $divId = $("#errid");
	$divId.html("");

	if ($mail.val() == "") {
		$divId.html("用户编号不允许为空！");
		return false;
	}
	return true;
}

function checkname() {
	var $mail = $("#name");
	var $divId = $("#errname");
	$divId.html("");

	if ($mail.val() == "") {
		$divId.html("用户名称不允许为空！");
		return false;
	}
	return true;
}

function checkpwd() {
	var $pwd = $("#pwd").val();
	var $pwdId = $("#errpwd");
	$pwdId.html("");

	if ($pwd == "") {
		$pwdId.html("用户密码不允许为空！");
		return false;
	}
	return true;
}

function checkage() {
	var $mail = $("#age");
	var $divId = $("#errage");
	$divId.html("");

	if ($mail.val() == "") {
		$divId.html("用户年龄为空则不能提交！！！！");
		return false;
	}
	return true;
}

function checkphone() {
	var $mail = $("#phone");
	var $divId = $("#errphone");
	$divId.html("");

	if ($mail.val() == "") {
		$divId.html("用户电话不允许为空！");
		return false;
	}
	return true;
}

$(function() {
	// 绑定失去焦点事件
	$("#id").blur(checkid);
	$("#name").blur(checkname);
	$("#pwd").blur(checkpwd);
	$("#repwd").blur(checkpwd);
	$("#age").blur(checkage);
	$("#phone").blur(checkphone);

	// 提交表单，调用验证函数
	$("#myform").submit(function() {
		var flag = true;
		if (!checkid()) flag = false;
		if (!checkname()) flag = false;
		if (!checkpwd()) flag = false;
		if (!checkage()) flag = false;
		if (!checkphone()) flag = false;

		return flag;
	});
});