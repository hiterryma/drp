$(function() {
    $("#cid").on("change",function () {
        cid = $(this).val();
        if (cid != null){
            setAddressValue();
        }
    });
    $("#pid").on("change",function () {
        pid = $(this).val();
        if (pid != null) {
            $("#cid option:gt(0)").remove();
            $("#cid option:eq(0)").prop("selectde");
            setAddressValue();
            $.getJSON("/pages/front/center/purchase/city_list.action",{"pid" : pid},function (data) {
                for (x = 0 ; x<data.length ; x++){
                    $("#cid").append("<option value='"+data[x].cid+"'>"+data[x].title+"</option>")
                }
            });
        }
    });
    setAddressValue();
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
            "type" : {
                required : true,
            },
            "pid" : {
                required : true,
            },
            "cid" : {
                required : true,
            },
            "address" : {
                required : true,
            },
            "phone" : {
                required : true,
            },
            "note" : {
                required : true ,
                digits : true
            }
        }
    });
});
function setAddressValue() {
    myaddress = "";
    data = $("#address").val();
    if (data != null){
        results = data.split(" ");
        if (results.length == 3){
            myaddress = results[2];
        }
    }
    province = "";
    city = "";
    if ($("#pid").val() != ""){
        province = $("#pid>option:selected").text();
    }
    if ($("#cid").val() != ""){
        city = $("#cid>option:selected").text();
    }
    $("#address").val(province+" "+city+" "+myaddress);
}