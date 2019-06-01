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
		messages:{
 			 mid:{
				 remote:"用户ID已经被注册"
 			 }
		},
		rules : {
			// "mid" : {
			// 	required : true
				//remote : {
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
// 			} ,
			"mid" : {
				required : true ,
				remote : {
					url : "checkMid.action", // 后台处理程序
					type : "post", // 数据发送方式
					dataType : "html", // 接收数据格式
					data : { // 要传递的数据
						id : function() {
							mid=$("#mid").val();
							return mid;
						}
					},
					dataFilter : function(data, type) {
						console.log(data.trim());
						if (data.trim() == "true") {
							return false;
						} else {
							return true;
						}
					}
				}
			},
			"password" : {
				required : true
			},
			"name" : {
				required : true
			} ,
			"phone" : {
				required : true 
			},
			"lid" : {
				required : true 
			},
			"did" : {
				required : true 
			},
			"pic" : {
				required : true ,
				accept : ["jpg","png","gif","bmp"]
			},
			"note" : {
				required : true
			}
		}
	});
})