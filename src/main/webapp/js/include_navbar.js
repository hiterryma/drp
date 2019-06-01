$(function () {
	$.post("member_role.action", function (data) {
		if (data == 1) {
			$("#manage").append("<a href=\"/pages/back/member_action.action\"><i class=\"glyphicon glyphicon-home\"></i>&nbsp;管理中心</a>");
		}
	},"text");
});