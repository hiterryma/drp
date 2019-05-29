$(function() {
	$("button[id*=addCar-]").each(function(){
		var gid = $(this).attr("id").split("-")[1] ;
		$(this).on("click",function(){
			operateAlert(true,"购物车添加成功！","购物车添加失败！") ;
		}) ;
	}) ;

	//获取地址栏的信息
	(function ($) {
		$.getUrlParam = function (name) {
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
			var r = window.location.search.substr(1).match(reg);
			if (r != null) return unescape(r[2]); return null;
		}
	})(jQuery);
	var stid = $.getUrlParam('stid');
	/*$.getJSON("pages/front/goods/goods_subaru.action",{"stid" : stid},function (data) {
		for (x = 0;x<data.length;x++){
			$('#goodsList_img').attr('src','images/'+data[x].photo);
			$('#goodsList_span').text(data[x].price);
			$("#goodsList_a").text(data[x].name)
		}
	});*/
}) ;