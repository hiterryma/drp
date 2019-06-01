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
<<<<<<< HEAD
    }) ;
    $("button[id^='addCar-']").each(function(){
        var gid = $(this).attr("id").split("-")[1] ;
        $(this).on("click",function(){
            console.log("*** gid = " + gid) ;
            $.get("pages/front/center/shopcar/shopcar_add.action",{"gid":gid},function (data) {
                operateAlert(data.trim()=="true","购物车添加成功！","购物车添加失败！") ;
            })
        }) ;
    }) ;
})
=======
    });
});
$(function () {
    $.post("/pages/front/news/news_index.action", function (data) {
        $(".panel-body>ul").empty();
        for (x = 0; x < data.length; x++) {
            urlText = "<li><a href=\"pages/back/admin/news/news_show.action?nid=" + data[x].nid + "\"  target=\"_blank\" >" ;
            urlText += "<span class=\"glyphicon glyphicon-exclamation-sign text-danger\"></span>&nbsp;" + data[x].title + "</a></li>" ;
            $(".panel-body>ul").append(urlText);
        }
    },"json");
});
function ajax_login() {
    $.post("member_role.action", function (data) {
        if (data == 1) {
            $("#manage").append("<a href=\"/pages/back/member_action.action\"><i class=\"glyphicon glyphicon-home\"></i>&nbsp;管理中心</a>");
        }
    },"text");
}
>>>>>>> c9daa61ab914d6f8827919a80ce10ebbd7262e31
