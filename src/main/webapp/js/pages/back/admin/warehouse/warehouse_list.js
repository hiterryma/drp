wid = 0 ;
$(function(){
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			// mid = this.id.split("-")[1] ;
			mid = this.id.substring(this.id.indexOf("-") + 1);
			console.log("仓库管理员编号：" + mid) ;

			showMemberInfo(mid);

		}) ;
	}) ;
	$("button[id^=editadmin-]").each(function(){
		$(this).on("click",function(){
			wid = this.id.split("-")[1] ;
			console.log("修改仓库管理员，仓库编号：" + wid) ;
			// loadData() ; // 异步数据加载与分页控制
			$("#did option:gt(0)").remove(); // 清除已有的内容
			$("#did option:eq(0)").prop("selected") ;
			$.getJSON("/pages/back/admin/dept/dept_list_all.action", {}, function (data) {
				for (x = 0; x < data.length; x++) {
					$("#did").append("<option value='" + data[x].did + "'>" + data[x].dname + "</option>");
				}
			});

			$("#memberBasicInfo tr:gt(0)").remove() ; // 加载之前要进行原有数据删除
			clearBar();
			$("#memberDeptInfo").modal("toggle") ;
		}) ;
	}) ;
	// $("button[id^=addadmin-]").each(function(){
	// 	$(this).on("click",function(){
	// 		mid = this.id.split("-")[1] ;
	// 		// mid = this.id.substring(this.id.indexOf("-") + 1);
	// 		console.log(mid);
	// 		console.log("新的仓库管理员编号：" + mid) ;
	// 		memberName = $("#memberName").text() ;
	// 		ele = $("<span id='mid-" + mid + "' style='cursor:pointer;'>"+memberName+"</span>") ;
	// 		ele.on("click",function(){
	// 			console.log("仓库管理员ID：" + mid) ;
	// 			// $("#memberInfo").modal("toggle") ;
	// 			showMemberInfo(mid);
	// 		}) ;
	// 		$("#admin-" + wid).html(ele) ;
	// 		$.getJSON("/pages/back/admin/warehouse/warehouse_edit_admin.action", {"wid":wid, "mid":mid}, function (data) {
	//
	// 			$("#memberDeptInfo").modal("toggle") ;
	// 			operateAlert(data,"仓库管理员修改成功！","仓库管理员修改失败！") ;
	// 		});
	//
	// 	}) ;
	// })
	$("#did").on("change",function(){
		// did = $(this).val();
		jsCommonCp = 1;
		// console.log("部门编号：" + did) ;
		// $("#memberBasicInfo tr:gt(0)").remove() ; // 加载之前要进行原有数据删除
		// createSplitBar(10) ;	// 创建分页控制项

		// console.log(jsCommonCp);
		// console.log(jsCommonLs);
		// console.log(jsCommonPageSize);
		loadData();

	}) ;
}) ;
function loadData() {	// 该函数名称一定要固定，不许修改

	// alert(jsCommonCp);
	// alert(jsCommonLs);
	// alert(jsCommonPageSize);
	// 如果要想进行分页的处理列表前首先查询出部门编号
	did = $("#did").val() ;	// 取得指定组件的value
	tid = $("#tid").val() ;
	console.log(did);
	// console.log(tid);

	//console.log("部门编号：" + did) ;
	$("#memberBasicInfo tr:gt(0)").remove() ; // 加载之前要进行原有数据删除
	//createSplitBar(10) ;	// 创建分页控制项

	if (did.value != "") {	// 有内容，需要进行ajax异步加载
		$.getJSON("/pages/back/admin/dept/dept_member_list.action", {"did": did,"currentPage":jsCommonCp,"lineSize":jsCommonLs}, function (data) {
			console.log(data);
			createSplitBar(data.allRecorders) ;
			allMembers = data.allMembers;
			allLevelMap = data.allLevelMap;
			for (x = 0; x < allMembers.length; x++) {
				// $("#cid").append("<option value='" + data[x].cid + "'>" + data[x].title + "</option>");
				member = allMembers[x];
				// lid = member.lid;
				// levelName = allLevelMap.lid;
				photo = member.photo;
				if (photo==null || photo=="") {
					photo = "nophoto.jpg"
				}
				src = "http://upload-server/upload/" + photo;
				str = "<tr id=\"travel-1\">" +
					"<td class=\"text-center\"><img src=" + src + " style=\"width:20px;\"/></td>" +
					"<td class=\"text-center\" id=\"memberName\">" + member.name + "</td>" +
					"<td class=\"text-center\">" + member.lid + "</td>" +
					"<td class=\"text-center\">" + member.phone + "</td>" +
					"<td class=\"text-center\">" +
					"<button class=\"btn btn-danger btn-xs\" id=\"addadmin-" + member.mid + "\">" +
					"<span class=\"glyphicon glyphicon-plus-sign\"></span>&nbsp;设置为库管</button>" +
					"</td>" +
					"</tr> "
				tbody = $("#memberDeptInfo tbody:eq(0)")
				tbody.append(str);
				$("button[id^=addadmin-]").each(function(){
					$(this).on("click",function(){
						// mid = this.id.split("-")[1] ;
						mid = this.id.substring(this.id.indexOf("-") + 1);
						console.log(mid);
						console.log("新的仓库管理员编号：" + mid) ;
						memberName = $("#memberName").text() ;
						ele = $("<span id='mid-" + mid + "' style='cursor:pointer;'>"+memberName+"</span>") ;
						ele.on("click",function(){
							console.log("仓库管理员ID：" + mid) ;
							// $("#memberInfo").modal("toggle") ;
							showMemberInfo(mid);
						}) ;
						$("#admin-" + wid).html(ele) ;
						$.getJSON("/pages/back/admin/warehouse/warehouse_edit_admin.action", {"wid":wid, "mid":mid}, function (data) {

							$("#memberDeptInfo").modal("toggle") ;
							operateAlert(data,"仓库管理员修改成功！","仓库管理员修改失败！") ;
						});

					}) ;
				})
			}
		});
	}
}
function showMemberInfo(mid) {
	$.getJSON("/pages/back/admin/member/member_info.action?mid="+mid, function(data){
		// console.log(data);
		levelMap = data.allLevels ;
		// console.log(levelMap);
		deptMap = data.allDepts ;
		// console.log(deptMap);
		$("#mid").text(data.member.name);
		$("#level").text(levelMap[data.member.lid]);
		$("#dept").text(deptMap[data.member.did]);
		$("#phone").text(data.member.phone);
		$("pre").text(data.member.note);
		photo = data.member.photo
		if (photo == null || "" == photo){
			photo = "nophoto.jpg"
		}
		// $(".row img").attr("src","admin"+photo) ;
		// console.log("http://upload-server/upload/"+data.member.photo);
		$("#photo").empty();
		// $("#photo").append("<img src=\"http://43.226.146.219/upload/"+data.voMember.photo+"\" style=\"width:200px;\">")
		$("#photo").append("<img src='http://upload-server/upload/" + photo + "' style=\"width:200px;\">");
		$("#memberInfo").modal("toggle") ;
	});
}