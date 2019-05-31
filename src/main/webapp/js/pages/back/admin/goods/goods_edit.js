$(function(){
	tinymce.init({ selector:'#note' });
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
			} ,
			"tid" : {
				required : true 
			},
			"stid" : {
				required : true 
			},
			"price" : {
				required : true ,
				number : true 
			},
			"weight" : {
				required : true ,
				digits : true 
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
	$("#wiid").on("change",function () {
		$("#stid option:gt(0)").remove(); // 清除已有的内容
		$("#stid option:eq(0)").prop("selected") ;
		if (this.value != "") {	// 有内容，需要进行ajax异步加载
			$.getJSON("/pages/back/admin/subtype/list_subtype.action", {"wiid": $(this).val()}, function (data) {
				for (x = 0; x < data.length; x++) {
					$("#stid").append("<option value='" + data[x].stid + "'>" + data[x].title + "</option>");
				}
			});
		}
	});
})