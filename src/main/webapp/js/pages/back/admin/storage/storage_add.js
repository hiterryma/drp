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
			"title" : {
				required : true
			} ,
			"pid" : {
				required : true 
			},
			"cid" : {
				required : true 
			},
			"wid" : {
				required : true 
			},
			"iid" : {
				required : true 
			},
			"note" : {
				required : true
			}
		}
	});




	/**
	 * 给省份绑定“change”事件
	 */
	$("#pid").on("change",function(){
		//1、获得本省份组件的内容
		val = $(this).val() ;
		//2、判断省份内容是否为空
		if (val != "") {
			//3、 清除已有的城市内容
			$("#cid option:gt(0)").remove();
			//4、将下拉列表的第一个城市默认选中
			$("#cid option:eq(0)").prop("selected") ;


			/**
			 * Ajax使用标准
			 * 1、get请求路径
			 * 2、传入的参数
			 * 3、回调函数
			 * 4、action返回的数据类型
			 */
			$.get("pages/pub/city/list_city.action", {"pid": val},function (data) {

				for (x = 0; x < data.length; x++) {
					$("#cid").append("<option value='" + data[x].cid + "'>" + data[x].title + "</option>");
				}
			}, "json");
		}
	}) ;


	$("#iid").on("change",function(){
		//获取省份id
		val1 = $("#pid").val() ;
		//获取城市id
		val2 = $("#cid").val() ;
		//获取仓库类型id
		val3 = $(this).val() ;


		//2、判断省份内容是否为空
		if (val1 !="" && val2!="" && val3!="") {
			//3、 清除仓库已有的仓库内容
			$("#wid option:gt(0)").remove();
			//4、将下拉列表的第一个仓库默认选中
			$("#wid option:eq(0)").prop("selected") ;


			/**
			 * Ajax使用标准
			 * 1、get请求路径
			 * 2、传入的参数
			 * 3、回调函数
			 * 4、action返回的数据类型
			 */
			$.get("pages/back/admin/warehouse/warehouse_list_pcw.action", {"pid": val1,"cid":val2,"wiid":val3},function (data) {
				console.log(data) ;
				for (x = 0; x < data.length; x++) {
					$("#wid").append("<option value='" + data[x].wid + "'>" + data[x].name + "</option>");
				}
			}, "json");
		}
	}) ;
})

