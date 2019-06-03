$(function () {
   $.getJSON("/pages/back/member_message.action",function (date) {
       $("#imgae1").empty();
       $("#name1").empty();
       $("#imgae2").empty();
       $("#image3").empty();

       $("#imgae1").append("<img src=\"http://upload-server/upload/"+date.photo+"\" class=\"img-circle\" alt=\"User Image\">");
       $("#name1").append("<p>"+date.name+"</p>");
       $("#imgae2").append("<img src=\"http://upload-server/upload/"+date.photo+"\" class=\"user-image\" alt=\"User Image\">");
       $("#name2").html(date.name);
       $("#image3").append("<img src=\"http://upload-server/upload/"+date.photo+"\" class=\"img-circle\" alt=\"User Image\">")
       $("#lasttime").html("上次登录日期："+date.lasttime)
   }) ;
});