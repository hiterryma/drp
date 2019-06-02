//定义一个全局变量，表示表的行数，行数从一开始
temp_did = 1 ;
$(function(){
	$("tr[id^=dettr-]").each(function () {
		temp_did ++ ;
	})
	//给“追加商品”按钮绑定“单击”事件
	$("#addbut").on("click",function(){
		// 通过ajax保存一行新的数据，而后把详情id取得，替换掉如下的id设置
		addDetails("temp" + temp_did ++) ; // 设置一个临时 id信息
	}) ;

	//给表中每行的“保存”按钮绑定“单击”事件
	$("button[id^=save-]").each(function(){
		$(this).on("click",function(){
			did = this.id.split("-") [1] ;
			saveDetails(did) ;
		}) ;
	}) ;

	//给表中每行的“移除”按钮绑定“单击”事件
	$("button[id^=remove-]").each(function(){
		$(this).on("click",function(){
			did = this.id.split("-") [1] ;
			deleteDetails(did) ;
		}) ;
	}) ;

	// //给每行商品编号输入框绑定事件
	// $("input[id^=gid-]").each(function () {
	// 	$(this).on("blur",function () {
	// 		//获取当前行的行数标号，每行的组件id都带行数
	// 		tid = $(this).attr("id").split("-")[1] ;
    //
	// 		//获取当前输入的商品编号
	// 		val = $(this).val() ;
	// 		//判断商品编号是否为空，不为空的话执行Ajax调用
	// 		console.log(val) ;
	// 		if (val != "") {
	// 			$.get("/pages/back/admin/goods/goods_list_gid.action", {"gid":val},function (data) {
	// 				console.log(data) ;
	// 				//设置本行商品名称
	// 				$("#name-" + tid).val(data.name) ;
	// 				//设置本行商品价格
	// 				$("#price-" + tid).val(data.price) ;
	// 				//设置本行商品重量
	// 				$("#weight-" + tid).val(data.weight) ;
    //
	// 			}, "json");
	// 		}
    //
	// 	})
	// })

	$("input[id^=gid-]").each(function () {
		trnum = $(this).attr("id").split("-")[1];
		console.log(trnum);
		$(this).on("blur", function () {
			gid = this.value;
			console.log(gid);
			$.get("/pages/back/admin/goods/goods_get_ajax.action", {"gid": gid}, function (data) {
				if (data == null) {
					$("#name-" + trnum).attr("value", "商品编号输入有误");
				} else {
					$("#name-" + trnum).val(data.name);

					$("#price-" + trnum).val(data.price);
					$("#weight-" + trnum).val(data.weight);
				}
			}, "json");
		});


		//给“保存”按钮绑定单击事件
		$("#save-" + trnum).on("click",function(){
			saveDetails(trnum) ;
		}) ;
		//给“移除”按钮绑定单击事件
		$("#remove-" + trnum).on("click",function(){
			deleteDetails(trnum) ;
		}) ;
		//进行商品数量的修改
		$("#amount-" + trnum).on("blur", function () {

			gid = $("#gid-" + trnum).val();
			//总价的计算
			calcSumPrice(trid, gid);
			//总重量的计算
			calcSumWeight(trid, gid);
		});
	});





})


function addDetails(tdid) {
	//定义一行表组件
	trInfo = $("<tr id='dettr-"+tdid+"' class='text-danger'>" +
		"	<td><input type='text' id='gid-"+tdid+"' value='0'/></td>" +
		"	<td><input type='text' id='name-"+tdid+"' value='等待查询...' size='50'/></td>" +
		"	<td><input type='text' id='amount-"+tdid+"' value='0' maxlength='8' size='8'/></td>" +
		"	<td><input type='text' id='price-"+tdid+"' value='0.0' maxlength='8' size='8'/></td>" +
		"	<td><input type='text' id='weight-"+tdid+"' value='0' maxlength='8' size='8'/></td>" +
		"	<td>" +
		"		<button id='save-"+tdid+"' class='btn btn-primary btn-xs'>" +
		"			<span class='glyphicon glyphicon-edit'></span>&nbsp;保存</button>" +
		"		<button id='remove-"+tdid+"' class='btn btn-danger btn-xs'>" +
		"			<span class='glyphicon glyphicon-edit'></span>&nbsp;移除</button>" +
		"	</td>" +
		"</tr>");
	//给详情表追加一行记录
    $(detailsTab).append(trInfo);

    $("#gid-" + tdid).on("blur", function () {
            sadid = this.id.split("-") [1];
            gid = this.value;
            console.log(sadid);
            console.log(gid);
            $.get("/pages/back/admin/goods/goods_get_ajax.action", {"gid": gid}, function (data) {
                if (data == null) {
                    $("#name-" + tdid).attr("value", "商品编号输入有误");
                } else {
                    $("#name-" + tdid).attr("value", data.name);
                    $("#amount-" + tdid).attr("value", "1");
                    $("#price-" + tdid).attr("value", data.price);
                    $("#weight-" + tdid).attr("value", data.weight);
                }
            }, "json");
        }
    );



	//给“保存”按钮绑定单击事件
	$("#save-" + tdid).on("click",function(){
		saveDetails(tdid) ;
	}) ;
	//给“移除”按钮绑定单击事件
	$("#remove-" + tdid).on("click",function(){
		deleteDetails(tdid) ;
	}) ;
	//进行商品数量的修改
    $("#amount-" + tdid).on("blur", function () {
        sadid = this.id.split("-") [1];
        gid = $("#gid-" + sadid).val();
        //总价的计算
        calcSumPrice(sadid, gid);
        //总重量的计算
        calcSumWeight(sadid, gid);
    })
}

//执行入库商品添加
function saveDetails(did) {
	said = $("#saidid").val() ;
	sadid = $("dettr-" + did).val() ;
	gid = $("#gid-" + did).val() ;
	gname = $("#name-" + did).val() ;
	amount = $("#amount-" + did).val() ;
	price = $("#price-" + did).val() ;
	weight = $("#weight-" + did).val() ;
	totalprice = price * amount ;
	totalweight = weight * amount ;
	console.log(said);
	console.log(sadid);
	console.log(gid);
	console.log(gname) ;
	console.log(amount) ;
	console.log(totalprice) ;
	console.log(totalweight) ;

	/**
	 * 执行Ajax异步增加清单详情
	 */
	$.get("/pages/back/admin/storage_details/storage_details_addoredit.action",{"sadid":sadid,"said":said,"gid":gid,"name":gname,"num":amount,"price":totalprice,"weight":totalweight},function(data){
		operateAlert(data.trim() == "true","清单详情保存成功！","清单详情保存失败！") ;
	},"text") ;

	// console.log("【增加】详情编号：" + did) ;
	// // 需要进行数据验证，而后再进行ajax提交处理，当提交成功后应该获取最后一次增长ID信息，替换掉原始的临时id
	// operateAlert(true,"入库商品信息添加成功！","入库商品信息添加失败！") ;
	// $("#dettr-" + did).attr("class","text-success") ;
}

//删除一行表格
function deleteDetails(did) {
	console.log("【删除】详情编号：" + did) ;
	// ajax移除信息，而后删除表格；
	$("#dettr-" + did).remove() ;
	operateAlert(true,"入库商品信息删除成功！","入库商品信息删除失败！") ;
}

function calcSumPrice(sadid, gid) {	// 进行购买总价的计算
	sum = 0.0; // 保存商品的计算总价
	price = parseFloat(getPrice(gid)); // 将字符串的内容变为小数
	amount = parseInt($("#amount-" + sadid).val()); // 获取数量
	sum = (price * amount).toFixed(2); // 商品总价计算
	$("#price-" + sadid).attr("value", sum);
}

// 进行购买总重的计算
function calcSumWeight(sadid, gid) {
	sum = 0.0; // 保存商品的计算总价
	weight = parseFloat(getWeight(gid)); // 将字符串的内容变为小数
	amount = parseInt($("#amount-" + sadid).val()); // 获取数量
	sum = (weight * amount).toFixed(2); // 商品总价计算
	$("#weight-" + sadid).attr("value", sum);
}

function getPrice(gid) {
	$.ajaxSettings.async = false;
	price = "";
	$.get("/pages/back/admin/goods/goods_get_ajax.action", {"gid": gid}, function (data) {
		price = data.price;
	}, "json");
	$.ajaxSettings.async = true;
	return price;
}

function getWeight(gid) {
	$.ajaxSettings.async = false;
	weight = "";
	$.get("/pages/back/admin/goods/goods_get_ajax.action", {"gid": gid}, function (data) {
		weight = data.weight;
	}, "json");
	$.ajaxSettings.async = true;
	return weight;
}