function checkusername() {
	var $mail = $("#billnamebillname");
	var $divId = $("#errbill");
	$divId.html("");

	if ($mail.val() == "") {
			$divId.html("�������ݲ�����Ϊ�գ�").css("font-size", "14px");
		//$divId.innerHTML("�������ݲ�����Ϊ�գ�").css("font-size", "14px");
		return false;
	}
	return true;
}

$(function() {
	//��ʧȥ�����¼�
	$("#billnamebillname").blur(checkusername);

	//�ύ����������֤����
	$("#myform").submit(function() {
		var flag = true;
		if (!checkusername()) flag = false;
		return flag;
	});
});