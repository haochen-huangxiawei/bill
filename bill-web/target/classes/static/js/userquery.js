function checkusername() {
	var $mail = $("#username");
	var $divId = $("#userspan");
	$divId.html("");

	if ($mail.val() == "") {
		$divId.html("查找内容不允许为空！").css("font-size", "14px");
		return false;
	}
	return true;
}

$(function() {
	// 绑定失去焦点事件
	$("#username").blur(checkusername);

	// 提交表单，调用验证函数
	$("#userform").submit(function() {
		var flag = true;
		if (!checkusername())
			flag = false;
		return flag;
	});
});

/*$(function() {
 $.ajax({
 url : "show.do",
 type : "post",
 success : function(data) {
 alert(data)
 }
 });
 });*/
