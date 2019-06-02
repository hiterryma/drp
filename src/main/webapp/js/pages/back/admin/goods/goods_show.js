loadFlag = false ;
$(function() {
	$("button[id^=storage-]").each(function(){
		$(this).on("click",function(){
			mid = this.id.split("-")[1] ;
			$("#goodsRecordInfo").modal("toggle") ; 
		}) ;
	}) ;
	$('#storageDetails').on('show.bs.collapse', function () {
		if (loadFlag == false) {
			// ajax异步加载库存信息
			operateAlert(true,"商品库存信息加载成功！","商品库存信息加载失败！") ;
			loadFlag = true ; // 数据已经加载完成
			$("span[id^=mid_]").each(function(){
				$(this).on("click",function(){
					$("#photo").append("")
					$("#mid").html("");
					$("#level").html("");
					$("#dept").html("");
					$("#phone").html("");
					$("#note").html("");

					mid = this.id.split("_")[1] ;
                    $("#memberInfo").modal("toggle") ;
					$.getJSON("/pages/back/admin/goods/goods_member.action",{"mid":mid},function (data) {
                        $("#photo").empty();
                        $("#photo").append("<img src=\"http://upload-server/upload/"+data.voMember.photo+"\" style=\"width:200px;\">")
                       $("#mid").html(data.voMember.name);
                       $("#level").html(data.level.title);
                       $("#dept").html(data.dept.dname);
                       $("#phone").html(data.voMember.phone);
                       $("#note").html(data.voMember.note);
                    });

				}) ;
			}) ;
		}
	}) ;
})