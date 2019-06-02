$(function(){
	$("button[id^=out-]").each(function(){
		$(this).on("click",function(){
			gid = this.id.split("-")[1] ;
			$.getJSON("/pages/back/admin/goods/goods_out.action", {"gid":gid}, function (data) {

				operateAlert(data,"待出库商品添加成功！","待出库商品添加失败！") ;
			})
		}) ;
	}) ;
	$("span[id^=storage-]").each(function(){
		$(this).on("click",function(){
			mid = this.id.split("-")[1] ;
			$("#goodsRecordInfo").modal("toggle") ; 
		}) ;
	}) ;
	$("span[id^=mid_]").each(function(){
		$(this).on("click",function(){
			mid = this.id.split("_")[1] ;
			$("#memberInfo").modal("toggle") ;
			$.getJSON("/pages/back/admin/goods/goods_member.action",{"mid":mid},function (data) {
				$("#photo").empty();
				$("#photo").append("<img src=\"http://43.226.146.219/upload/"+data.voMember.photo+"\" style=\"width:200px;\">")
				$("#mid").html(data.voMember.name);
				$("#level").html(data.level.title);
				$("#dept").html(data.dept.dname);
				$("#phone").html(data.voMember.phone);
				$("#note").html(data.voMember.note);
			});

		}) ;
	}) ;
})