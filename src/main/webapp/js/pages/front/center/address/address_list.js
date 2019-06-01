$(function() {
	$("#selectAll").on("click",function(){
		checkboxSelectAll('mid',this.checked) ;
	}) ;
	$("#delBtn").on("click",function(){
		data = "" ; // 保存要删除的商品编号
		adidArray = new Array() ; // 保存要删除 adid编号
		foot = 0 ;
		$(":checkbox[id ='mid']").each(function(){
			if ($(this).prop("checked")) {
				data += $(this).val() + ";";
				adidArray[foot ++] = $(this).val() ;
			}
		}) ;
		$("#delBtn").on("click",function(){	// 绑定用户锁定操作
			operateChecked("确定要删除这些地址吗？","address.mid",'pages/jsp/admin/UserActionBack!lock.action?p=p') ;
		}) ;
		console.log(data);
		if (data == "") {   // 此时没有选中任何的内容
			operateAlert(false,"","请先选择要删除的购物项！") ;
		} else {
			$.get("/pages/front/center/address/address_delete.action",{"data":data},function(data){
				operateAlert(data.trim() == "true","购物车信息删除成功！","购物车信息删除失败！") ;
				if (data.trim() == "true") {    // 删除对应的表格行的信息
					for (x = 0 ; x < adidArray.length ; x ++) {
						$("#address-" + adidArray[x]).fadeOut(1000,function() {
							$("#address-" + adidArray[x]).remove() ;
						}) ;
					}
				}
			},"text") ;
		}
	}) ;
})
