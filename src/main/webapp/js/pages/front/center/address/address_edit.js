$(function() {
	$(cid).on("change",function(){
		val = $(this).val() ;
		if (val != "") {
			setAddressValue() ;
		}
		$.get("/pages/front/center/address/province_list.action", {"pid": val}, function (data) {
			for (x = 0; x < data.length; x++) {
				$(pid).append("<option value='" + data[x].pid + "'>" + data[x].title + "</option>");
			}
		}, "json");
	}) ;
	$(pid).on("change",function(){
		val = $(this).val() ;
		if (val != "") {
			$("#cid option:gt(0)").remove(); // 清除已有的内容
			$("#cid option:eq(0)").prop("selected") ;
			setAddressValue() ;
			$.get("/pages/front/center/address/city_list.action", {"pid": val}, function (data) {
				for (x = 0; x < data.length; x++) {
					$(cid).append("<option value='" + data[x].cid + "'>" + data[x].title + "</option>");
				}
			}, "json");
		}
	}) ;
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
				required : true,
			},
			"phone" : {
				required : true ,
				digits : true
			} ,
			"pid" : {
				required : true 
			},
			"cid" : {
				required : true 
			},
			"addr" : {
				required: true
			  }
			}
		});
	})
	function setAddressValue() {	// 设置省份和城市的内容
		myaddress = "" ; // 用户自己输入的地址
		if ($(addr).val() != null) {	// 现在已经有了输入地址了
			results = $(addr).val().split(" ") ; // 根据空格拆分
			if (results.length == 3) {	// 输入过地址
				myaddress = results[2] ; // 获取输入的地址内容
			}
		}
		province = "" ;
		city = "" ;
		if ($("#pid").val() != "") {
			province = $("#pid>option:selected").text(); // 获得选定元素的文本内容
		}
		if ($("#cid").val() != "") {
			city = $("#cid>option:selected").text(); // 获得选定元素的文本内容
		}
		$("#addr").val(province + " " + city + " " + myaddress) ;
}