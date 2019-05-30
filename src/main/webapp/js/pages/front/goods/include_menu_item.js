function bftask(objInfo){
    var stid= $(objInfo).attr("foole");
    $.getJSON("/pages/back/admin/goods/goods_subaru.action",{"stid" : stid});
}