$(function(){
	$("#imageCode").on("click",function() {
		$("#imageCode").attr("src","ImageCode?p="+Math.random()) ;
	}) ;
	$("#myform").validate({
		debug : true, // 取消表单的提交操作
		submitHandler : function(form) {
			form.submit(); // 提交表单
		},
		errorPlacement : function(error, element) {
			var id = $(element).attr("id") ;
			if (id.indexOf(".") != -1) {
				id = id.replace(".","\\.") ;
			}
			id = id + "Msg" ;
			$("#" + id).empty() ;	// 先清除之前的所有内容
			$("#" + id).append(error) ;
		},
		highlight : function(element, errorClass) {
			$(element).fadeOut(1,function() {
				$(element).fadeIn(1, function() {
					$("#" + $(element).attr("id").replace(".","\\.") + "Div").attr("class","form-group has-error");
				});

			})
		},
		success : function(error,element) {
			var id = $(element).attr("id") ;
			id = id + "Msg" ;
			$("#" + id).empty() ;	// 先清除之前的所有内容
			$("#" + id).append("<span class='text-success glyphicon glyphicon-ok'></span>") ;
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
			"mid" : {
				required : true
			},
			"password" : {
				required : true
			} ,
			"code" : {
				required : true ,
				remote : {
					url : "code_check.action", // 后台处理程序
					type : "post", // 数据发送方式
					dataType : "html", // 接收数据格式
					data : { // 要传递的数据
						code : function() {
							return $("#code").val();
						}
					},
					dataFilter : function(data, type) {
						if (data.trim() == "true") {
							return true;
						} else {
							if ($("#code").val().length == 4) {
								$("#imageCode").attr("src","ImageCode?p="+Math.random()) ;
							}
							return false;
						}
					}
				}
			}
		}
	});
})