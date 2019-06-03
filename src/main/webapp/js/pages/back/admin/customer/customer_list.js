cuid = 0 ;
$(function(){
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			mid = this.id.substr(4);
			$.getJSON("/pages/back/admin/member/memberJson.action?mid="+mid, function(data){
				console.log(data)
				$("#memberInfo").modal("toggle") ;
				levelMap = data.allLevelMap ;
				deptMap = data.allDeptMap ;
				$("#mid").text(data.member.name);
				$(level).text(levelMap[data.member.lid]);
				$(dept).text(deptMap[data.member.did]);
				$(phone).text(data.member.phone);
				$("pre").text(data.member.note);
				// $(".row img").attr("src","http://upload-server/upload/"+data.member.photo) ;
				photo = data.member.photo
				if (photo == null || "" == photo){
					photo = "nophoto.jpg"
				}
				$("#photo").empty();
				$("#photo").append("<img src='http://upload-server/upload/" + photo + "' style=\"width:200px;\">");
			});
		}) ;
	}) ;
	$("span[id^=cuid-]").each(function(){
		$(this).on("click",function(){
			cuid = this.id.split("-")[1] ;
			loadData() ;
			$("#customerRecordInfo").modal("toggle") ;
		}) ;
	}) ;
	$("button[id^=out-]").each(function(){
		$(this).on("click",function(){
			cuid = this.id.split("-")[1] ;
			operateAlert(true,"出库客户追加成功！","出库客户追加失败！") ;
		}) ;
	}) ;
	$("button[id^=input-]").each(function(){
		$(this).on("click",function(){
			//cuid = this.id.split("-")[1] ;
			 cuid = this.id.substr(6);
			$("#customerRecordInputInfo").modal("toggle") ;
			$.get("pages/back/admin/customer/customerRecordInputInfo.action", function (data) {
				operateAlert(data,"客户联系记录追加成功！","客户联系记录追加失败！") ;
			}, "json");

			$.getJSON("pages/back/admin/customer/customerrecord_pre_add.action", function (data) {
				data = data.allCritemMap ;
				for (x = 0; x < data.length; x++) {
					$("#criid").append("<option value='" + data[x].criid + "'>" + data[x].title + "</option>");
				}
			});
			$("#cuid").val(cuid) ;
		}) ;
	}) ;
	$("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			// 发送ajax请求进行异步数据处理操作
			$("#customerRecordInputInfo").modal("toggle") ;
			$.get("pages/back/admin/customer/customer_record_add.action", {
				title: $("#title").val(),
				criid: $("#criid").val(),
				note: $("#note").val(),

				cuid: $("#cuid").val()
			}, function (data) {
				operateAlert(data,"客户联系记录追加成功！","客户联系记录追加失败！") ;
			}, "json");
		},
		errorPlacement : function(error, element) {
			$("#" + $(element).attr("id").replace(".", "\\.") + "Msg").append(error);
		},
		highlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1, function() {
					$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
				});

			})
		},
		unhighlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1,function() {
						$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-success");
				});
			})
		},
		errorClass : "text-danger",
		rules : {
			"title" : {
				required : true
			} ,
			"criid" : {
				required : true
			} ,
			"note" : { 
				required : true 
			}
		}
	});
}) ;
function loadData() {	// 该函数名称一定要固定，不许修改
	// 如果要想进行分页的处理列表前首先查询出部门编号
	// console.log("客户编号：" + cuid);
	dataLength  =0 ;
	$.getJSON("/pages/back/admin/customer/customer_record_list.action?currentPage=" + jsCommonCp + "&lineSize=" + jsCommonLs + "&cuid=" + cuid, function (data) {
		$("#recordTable tr:gt(0)").remove() ; // 加载之前要进行原有数据删除
		dataLength = data.allRecorders ;
		createSplitBar(dataLength) ;	// 创建分页控制项
		for(item  in data.allCustomerRecord){   //variable 为属性名
			dealRecorderRow(data.allCustomerRecord[item]);
		}
	});

}

function dealRecorderRow(data) {
	textHtml = "\n" +
		"\t\t\t\t\t\t\t<tr id=\"record-1\">\n" +
		"\t\t\t\t\t\t\t\t<td class=\"text-center\">cdate</td>\n" +
		"\t\t\t\t\t\t\t\t<td class=\"text-left\">title</td>\n" +
		"\t\t\t\t\t\t\t\t<td class=\"text-left\">1101010202929</td>\n" +
		"\t\t\t\t\t\t\t\t<td class=\"text-left\">\n" +
		"\t\t\t\t\t\t\t\t\t<pre class=\"pre-scrollable\" style=\"width:600px;height:60px;\">note</pre>\n" +
		"\t\t\t\t\t\t\t\t</td>\n" +
		"\t\t\t\t\t\t\t</tr> " ;
	textHtml = textHtml.replace("title",data.title).replace("cdate",data.cdate).replace("note",data.note).replace("title",data.title);
	$("#recordTable").append(textHtml);
}