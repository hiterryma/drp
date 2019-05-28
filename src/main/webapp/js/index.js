window.onload = function () {
    ajax_login();
}
$(function () {
    $("img[id*='but']").each(function () {
        $(this).on("mouseover", function () {
            $(this).fadeOut(50, function () {
                $(this).fadeIn(500);
            });
        })
    });
});

function ajax_login() {
    $.post("member_role.action", function (data) {
        if (data == 1) {
            $("#manage").append("<a href=\"pages/back/index.jsp\"><i class=\"glyphicon glyphicon-home\"></i>&nbsp;管理中心</a>");
        }
    },"text");
}
