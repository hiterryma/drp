function bftask(objInfo){
    var stid= $(objInfo).attr("foole");
    $.session.remove('stid');
    $.session.set('stid', stid);
}

