$(function() {
	$("#selectAll").on("click",function(){
		checkboxSelectAll('gid',this.checked) ;
	});
	calcSumPrice() ;
	$("button[id^='add-']").each(function(){
		$(this).on("click",function(){
			gid = $(this).attr("id").split("-")[1] ; // 获取id的属性内容
			amount = parseInt($("#amount-" + gid).val()); // 获取数量
			if (amount < 0 ) {
				amount = 0 ;
			}
			$("#amount-" + gid).val(amount + 1) ;
			calcSumPrice(); // 重新进行总价的计算
		}) ;
	}) ;
	$("button[id^='updateBtn-']").each(function(){
		$(this).on("click",function() { // 绑定单击事件
			gid = $(this).attr("id").split("-")[1] ; // 获取id的属性内容
			amount = $("#amount-" + gid).val() ;
			data = gid + ":" + amount ;
			$.get("pages/front/center/shopcar/shopcar_edit.action",{"data":data},function(data){
				operateAlert(data.trim() == "true","购物车信息修改成功！","购物车信息修改失败！") ;
			},"text") ;
		}) ;
	}) ;
	$(editBtn).on("click",function(){
		data = "" ; // 发送的修改数据
		$("input[id^='amount-']").each(function(){
			gid = $(this).attr("id").split("-")[1] ; // 获取id的属性内容
			amount = $(this).val() ; // 获取数量
			data += gid + ":" + amount + ";" ;
		}) ;
		$.get("pages/front/center/shopcar/shopcar_edit.action",{"data":data},function(data){
			operateAlert(data.trim() == "true","购物车信息修改成功！","购物车信息修改失败！") ;
		},"text") ;
	}) ;
	$("button[id^='sub-']").each(function(){
		$(this).on("click",function(){
			gid = $(this).attr("id").split("-")[1] ; // 获取id的属性内容
			amount = parseInt($("#amount-" + gid).val()); // 获取数量
			if (amount < 0 ) {
				amount = 0 ;
			}
			if (amount - 1 != 0) {
				$("#amount-" + gid).val(amount - 1);
				calcSumPrice(); // 重新进行总价的计算
			}
		}) ;
	}) ;
	$(rmBtn).on("click",function(){
		data = "" ; // 保存要删除的商品编号
		gidArray = new Array() ; // 保存要删除 gid编号
		foot = 0 ;
		$(":checkbox[id='gid']").each(function(){
			if ($(this).prop("checked")) {
				data += $(this).val() + ";";
				gidArray[foot ++] = $(this).val() ;
			}
		}) ;
		console.log(data);
		if (data == "") {   // 此时没有选中任何的内容
			operateAlert(false,"","请先选择要删除的购物项！") ;
		} else {
			$.get("pages/front/center/shopcar/shopcar_delete.action",{"data":data},function(data){
				operateAlert(data.trim() == "true","购物车信息删除成功！","购物车信息删除失败！") ;
				if (data.trim() == "true") {    // 删除对应的表格行的信息
					for (x = 0 ; x < gidArray.length ; x ++) {
						$("#shopcar-" + gidArray).fadeOut(1000,function() {
							$("#shopcar-" + gidArray).remove() ;
						}) ;
					}
				}
			},"text") ;
		}
	}) ;
});
function calcSumPrice() {	// 进行购买总价的计算
	sum = 0.0 ; // 保存商品的计算总价
	$("span[id^='price-']").each(function() {	// 获取全部的商品价格元素的内容
		gid = $(this).attr("id").split("-")[1] ; // 获取id的属性内容
		price = parseFloat($(this).text()) ; // 将字符串的内容变为小数
		amount = parseInt($("#amount-" + gid).val()); // 获取数量
		sum += price * amount ; // 商品总价计算
	}) ;
	$(allPrice).text(round(sum,2)) ;
}
