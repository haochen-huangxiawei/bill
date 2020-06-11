
function billmone() {
	var $mail = $("#billmone");
	var $divId = $("#errmone");
	$divId.html("");

	if ($mail.val() == "") {
		$divId.html("交易金额不允许为空！");
		return false;
	}
	return true;
}

function billunit() {
	var $mail = $("#billunit");
	var $divId = $("#errunit");
	$divId.html("");

	if ($mail.val() == "") {
		$divId.html("交易单位不允许为空！");
		return false;
	}
	return true;
}

function billcount() {
	var $mail = $("#billcount");
	var $divId = $("#errcount");
	$divId.html("");

	if ($mail.val() == "") {
		$divId.html("交易数量不允许为空！");
		return false;
	}
	return true;
}

$(function() {
	//绑定失去焦点事件
	$("#billmone").blur(billmone);
	$("#billunit").blur(billunit);
	$("#billcount").blur(billcount);

	//提交表单，调用验证函数
	$("#myform").submit(function() {
		var flag = true;
		if (!billmone()) flag = false;
		if (!billunit()) flag = false;
		if (!billcount()) flag = false;

		return flag;
	});
});