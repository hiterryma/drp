$(function () {
    $("img[id*='but']").each(function () {
        $(this).on("mouseover", function () {
            $(this).fadeOut(50, function () {
                $(this).fadeIn(500);
            });
        })
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
