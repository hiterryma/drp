$(function() {
    $.getJSON("pages/front/center/purchase/get_purchase.action",function (data) {
        if (data == 1){
            $("#authentication>a").on('click', function(event) {
                event.preventDefault();
                alert("您已通过客户认证！");
            });
        }
        if (data == 0){
            $("#purchaseRequest>a").on('click', function(event) {
                event.preventDefault();
                alert("您还未进行客户认证申请或您的客户认证还在审核中，请耐心等待");

            });
        }
        if (data == 3){
            $("#purchaseRequest>a").on('click', function(event) {
                event.preventDefault();
                alert("您的客户认证审核未通过，请重新提交");

            });
        }
    });
});