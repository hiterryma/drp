$(function(){
	$("button[id^=access-]").each(function(){

		$(this).on("click",function(){
			trid = this.id.split("-")[1] ;
			said = $("#said").text() ;
			gid = $("#gid-" + trid).text() ;
			gname = $("#name-" + trid).text() ;
			amount = $("#amount-" + trid).text() ;
			price = $("#price-" + trid).text() ;
			weight = $("#weight-" + trid).text() ;
			inorno = 1 ;
			$.get("/pages/back/admin/manage/manage_storage/storage_record_add.action",{"said":said,"gid":gid,"name":gname,"num":amount,"price":price,"weight":weight,"status":inorno},function(data){
				operateAlert(data.trim() == "true","商品成功入库存储！","商品入库失败！") ;
			},"text") ;

		}) ;
	}) ;
	$("button[id^=denied-]").each(function(){ 
		$(this).on("click",function(){
			sdid = this.id.split("-")[1] ;
			operateAlert(false,"商品成功入库存储！","商品入库失败！") ;
		}) ;
	}) ;
})