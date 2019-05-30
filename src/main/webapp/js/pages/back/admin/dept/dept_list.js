$(function(){
	$("button[id^=edit-]").each(function(){
		$(this).on("click",function(){
			did = this.id.split("-")[1] ;
			console.log("部门编号：" +  did) ;
			dname = $("#dname-" + did).val() ;
			if (dname == "") { 
				operateAlert(false,"","部门名称不允许为空，请确认后再提交更新！") ;
			} else {
				$.get("/pages/back/admin/dept/dept_edit.action?did="+did+"&dname="+dname, function(data){
					if(data == "true"){
						operateAlert(true,"部门名称更新成功！","") ;
					}else{
						operateAlert(false,"部门名称更新失败！","") ;
					}
				});

			}
		}) ;
	}) ;
	$("span[id^=eid-]").each(function(){
		$(this).on("click",function(){
			eid = this.id.split("-")[1] ;
			console.log("雇员编号：" + eid) ;
			$("#memberInfo").modal("toggle") ;

			$.getJSON("/pages/back/admin/member/dept_edit.action?did="+did+"&dname="+dname, function(data){
				if(data == "true"){
					operateAlert(true,"部门名称更新成功！","") ;
				}else{
					operateAlert(false,"部门名称更新失败！","") ;
				}
			});
		}) ;
	}) ;
}) ;