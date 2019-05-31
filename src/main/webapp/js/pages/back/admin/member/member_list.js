$(function(){
	$(selall).on("click",function(){
		checkboxSelectAll("mid",this.checked) ;
	}) ;
	// $(selall).on("click",function(){
	// 	$("input[id^=eid-]").each(function(){
	// 		$(this).prop("checked",true) ;
	// 	}) ;
	// }) ;
	$(removeBtn).on("click",function(){
		data = "" ; // 保存要删除的商品编号
		gidArray = new Array() ; // 保存要删除 gid编号
		foot = 0 ;
		$(":checkbox[id='mid']").each(function(){
			if ($(this).prop("checked")) {
				data += $(this).val() + ";";
				gidArray[foot ++] = $(this).val() ;
			}
		}) ;
		if (data == "") {   // 此时没有选中任何的内容
			operateAlert(false,"","请先选择要删除的雇员！") ;
		} else {
			$.get("pages/back/admin/member/member_delete.action",{"data":data},function(data){
				//operateAlert(data.trim() == "true","公告删除成功！","公告删除失败！") ;
				if(data.trim() == "true"){
					alert("雇员删除成功！") ;
					window.location = "/pages/back/admin/news/news_list.action" ;
				}else{
					alert("雇员删除失败！") ;
				}

			},"text") ;
		}
		//operateChecked("nid","/pages/back/emp") ;
	}) ;
})