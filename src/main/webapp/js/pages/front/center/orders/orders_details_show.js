$(function(){
	sumAmount();
	$("a[id*=showBtn-]").each(function(){
		// 拆分id数据
		var gid = this.id.split("-")[1] ;
		$(this).on("click",function(){
			window.location = "pages/front/goods/goods_show.jsp?gid=" + gid ;
		})
	}) ;
}) ;
function sumAmount(){
	sum = 0 ; // 保存总数量
	$("td[id^='amount-']").each(function() {
		amount = parseInt($(this).text()) ;
		sum += amount ;
	}) ;
	$("#allAmount").text(sum) ;
}