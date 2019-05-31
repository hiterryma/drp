

$(function () {
    stid = $.session.get('stid');
    var newurl = updateQueryStringParameter(window.location.href, 'stid', stid);
    //向当前url添加参数，没有历史记录
    window.history.replaceState({
        path: newurl
    }, '', newurl);
    console.log(newurl);



    $("button[id*=addCar-]").each(function () {
        var gid = $(this).attr("id").split("-")[1];
        $(this).on("click", function () {
            operateAlert(true, "购物车添加成功！", "购物车添加失败！");
        });
    });

    if($.cookie("refresh")!="no"){
        setTimeout(function(){
            window.location.reload();
            $.cookie("refresh","yes");
        },10);
    }
});

//url地址拼凑
function updateQueryStringParameter(uri, key, value) {
    if(!value) {
        return uri;
    }
    var re = new RegExp("([?&])" + key + "=.*?(&|$)", "i");
    var separator = uri.indexOf('?') !== -1 ? "&" : "?";
    if (uri.match(re)) {
        return uri.replace(re, '$1' + key + "=" + value + '$2');
    }
    else {
        return uri + separator + key + "=" + value;
    }
}