$(function(){
	$("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			form.submit(); // 提交表单
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
			"name" : {
				required : true
				//remote : {	// 确保仓库名称不重复
//				url : "check.jsp", // 后台处理程序
//				type : "post", // 数据发送方式
//				dataType : "html", // 接受数据格式
//				data : { // 要传递的数据
//					code : function() {
//						return $("#code").val();
//					}
//				},
//				dataFilter : function(data, type) {
//					if (data.trim() == "true")
//						return true;
//					else
//						return false;
//				}
//}
			} ,
			"ename" : {
				required : true
			} ,
			"csid" : {
				required : true 
			},
			"pid" : {
				required : true 
			},
			"cid" : {
				required : true 
			},
			"phone" : {
				required : true 
			},
			"address" : {
				required : true 
			},
			"ciid" : {
				required : true 
			},
			"note" : {
				required : true
			}
		}
	});
	$("#cid").on("change",function() {
		handleAddress() ;	// 处理地址
	}) ;
	$("#pid").on("change",function(){
		$("#cid option:gt(0)").remove(); // 清除已有的内容
		$("#cid option:eq(0)").prop("selected") ;
		if (this.value != "") {	// 有内容，需要进行ajax异步加载
			$.getJSON("pages/pub/city/list_city.action", {"pid": $(this).val()}, function (data) {
				for (x = 0; x < data.length; x++) {
					$("#cid").append("<option value='" + data[x].cid + "'>" + data[x].title + "</option>");
				}
			});
		} else {
			//$("#cid option:gt(0)").remove() ;
		}
		handleAddress() ;	// 处理地址
	}) ;
})

function handleAddress() {	// 实现地址处理过程
	address = $("#address").val() ;	// 获得address原始内容
	ptitle = "";
	if ($("#pid option:selected").val() != "") {
		ptitle = $("#pid option:selected").text() + " " ;
	}
	ctitle = "" ;
	if ($("#cid option:selected").val() != "") {
		ctitle = $("#cid option:selected").text() + " " ;
	}
	adr = address.split(" ") ;
	str = ptitle + ctitle;
	if (adr.length >= 3) {	// 都填写完了，现在要修改了
		for (x = 2 ; x < adr.length ; x ++) {
			str += " " + adr[x];
		}
		$("#address").val(str) ;
	} else {
		$("#address").val(str) ;
	}
}