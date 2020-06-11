function checkusername() {
	var $mail = $("#billnamebillname");
	var $divId = $("#errbill");
	$divId.html("");

	if ($mail.val() == "") {
			$divId.html("查找内容不允许为空！").css("font-size", "14px");
		//$divId.innerHTML("查找内容不允许为空！").css("font-size", "14px");
		return false;
	}
	return true;
}

$(function() {
	//绑定失去焦点事件
	$("#billnamebillname").blur(checkusername);

	//提交表单，调用验证函数
	$("#myform").submit(function() {
		var flag = true;
		if (!checkusername()) flag = false;
		return flag;
	});
});