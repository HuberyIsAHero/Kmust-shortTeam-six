$(document).ready(function () {
    getAddress();
});

function addAddress(address) {

    var receiverName = $("#receiverName").val(); //收货人姓名
    var Sheng = $("#Sheng").val();   //收货人省份
    var Shi = $("#Shi").val(); //收货人市
    var Qu = $("#Qu").val();  //收货人区县
    var xiangXiDiZhi = $("#xiangXiDiZhi").val();   //详细地址
    var phone = $("#phone").val();   //收货人电话号
    // alert(receiverName+Sheng+Shi+Qu+xiangXiDiZhi+phone);
    $.ajax({
        type: "get",    //请求类型
        data: {
            opType: "addAddress",
            receiverName: receiverName,
            Sheng: Sheng,
            Shi: Shi,
            Qu: Qu,
            xiangXiDiZhi: xiangXiDiZhi,
            phone: phone
        },
        url: "receiver",//请求的 URL地址
        dataType: "json",//返回的数据类型
        success: function (data) {
            getAddress();
            alert(添加成功);
        },
        error: function (data) {
            alert("addAddress-error");
        }
    });
}

function getAddress() {
    $.ajax({
        type: "get",    //请求类型
        data: {
            opType: "Receiver"
        },
        url: "receiver",//请求的 URL地址
        dataType: "json",//返回的数据类型
        success: function (data) {
            //将收获地址传过来
            var html = "<h3>收货地址薄</h3>";
            for (var i = 0; i < data.length; i++) {
                html += "<dl><dt>" + data[i].getReceiverName + " " + data[i].sheng + " " + data[i].shi + " " + data[i].qu + " " + data[i].xiangXiDiZhi
                    + " " + data[i].phone + " </dt><dd><a href=\"\">删除</a></dd></dl>"
            }
            $(".address_hd").html(html);
        },
        error: function (data) {
            alert("getAddress-error");
        }
    });
}