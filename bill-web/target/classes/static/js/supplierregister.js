
function checkname() {
	var $mail = $("#name");
	var $divId = $("#errname");
	$divId.html("");

	if ($mail.val() == "") {
		$divId.html("供应商名称不允许为空！").css("font-size","14px");
		return false;
	}
	return true;
}

function checkcontact() {
	var $mail = $("#contact");
	var $divId = $("#errcontact");
	$divId.html("");

	if ($mail.val() == "") {
		$divId.html("供应商联系不允许为空！").css("font-size","14px");
		return false;
	}
	return true;
}

function checkphone() {
	var $mail = $("#phone");
	var $divId = $("#errphone");
	$divId.html("");

	if ($mail.val() == "") {
		$divId.html("供应商电话不允许为空！").css("font-size","14px");
		return false;
	}
	return true;
}

function checkfax() {
	var $mail = $("#fax");
	var $divId = $("#errfax");
	$divId.html("");

	if ($mail.val() == "") {
		$divId.html("供应商传真不允许为空！").css("font-size","14px");
		return false;
	}
	return true;
}

function checksite() {
	var $mail = $("#site");
	var $divId = $("#errsite");
	$divId.html("");

	if ($mail.val() == "") {
		$divId.html("供应商地址不允许为空！").css("font-size","14px");
		return false;
	}
	return true;
}

$(function() {
	//绑定失去焦点事件
	$("#name").blur(checkname);
	$("#contact").blur(checkcontact);
	$("#phone").blur(checkphone);
	$("#fax").blur(checkfax);
	$("#site").blur(checksite);

	//提交表单，调用验证函数
	$("#myform").submit(function() {
		var flag = true;
		if (!checkname()) flag = false;
		if (!checkcontact()) flag = false;
		if (!checkphone()) flag = false;
		if (!checkfax()) flag = false;
		if (!checksite()) flag = false;

		return flag;
	});
});