$(function(){
	$("button[id^=edit-]").each(function(){
		$(this).on("click",function(){
			did = this.id.split("-")[1] ;
			dname = $("#dname-" + did).val() ;
			if (dname == "") {
				operateAlert(false,"","部门名称不允许为空，请确认后再提交更新！") ;
			} else {
				$.get("/pages/back/admin/dept/dept_edit.action?did="+did+"&dname="+dname, function(data){
					if(data.trim() == "true"){
						operateAlert(true,"部门名称更新成功！","") ;
					}else{
						operateAlert(false,"部门名称更新失败！","") ;
					}
				});

			}
		}) ;
	}) ;
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			mid = this.id.substr(4);
			$.getJSON("/pages/back/admin/member/memberJson.action?mid="+mid, function(data){
				$("#memberInfo").modal("toggle") ;
				levelMap = data.allLevelMap ;
				deptMap = data.allDeptMap ;
				$(mid).text(data.member.mid);
				$(level).text(levelMap[data.member.lid]);
				$(dept).text(deptMap[data.member.did]);
				$(phone).text(data.member.phone);
				$("pre").text(data.member.note);
				$(".row img").attr("src","http://upload-server/upload/"+data.member.photo) ;
			});
		}) ;
	}) ;



	function  _objToStrMap(obj){
		let strMap = new Map();
		for (let k of Object.keys(obj)) {
			strMap.set(k,obj[k]);
		}
		return strMap;
	}

}) ;