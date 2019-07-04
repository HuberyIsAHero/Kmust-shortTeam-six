/*
@功能：购物车页面js
@作者：diamondwang
@时间：2013年11月14日
*/
$(function () {
    getReceiver();
    getOrderList();
    var sum = 0;
    var count = 0;
    //获取收货地址
    function getReceiver() {
        $.ajax({
            type: "get",    //请求类型
            data: {
                opType: "Receiver"
            },
            url: "receiver",//请求的 URL地址
            dataType: "json",//返回的数据类型
            success: function (data) {
                //将收获地址传过来
                var html = "<p>" + data[0].getReceiverName + "  " + data[0].phone + "</p><p>" + data[0].sheng
                    + "  " + data[0].shi + "  " + data[0].qu + "  " + data[0].xiangXiDiZhi + "</p>";
                var htmls = "";
                for (var i = 0; i < data.length; i++) {
                    if (i == 0) {
                        htmls += "<ul><li class=\"cur\"><input type=\"radio\" name=\"address\" checked=\"checked\" />" + data[i].getReceiverName +
                            " " + data[i].sheng + " " + data[i].shi + " " + data[i].qu +
                            " " + data[i].xiangXiDiZhi + " " + data[i].phone + "<a href=\"\">  删除</a></li>";
                    } else {
                        htmls += "<li><input type=\"radio\" name=\"address\" />" + data[i].getReceiverName +
                            " " + data[i].sheng + " " + data[i].shi + " " + data[i].qu +
                            " " + data[i].xiangXiDiZhi + " " + data[i].phone + "<a href=\"\">  删除</a></li>";
                    }
                }
                htmls += "<li><input type=\"radio\" name=\"address\" class='new_address' />使用新地址</li></ul>";
                $(".address_select").html(htmls);
                $(".address_info").html(html);
            },
            error: function (data) {
                alert("getReceiver-error");
            }
        });
    }

    //获取商品清单
    function getOrderList() {
        count=0;
        sum = 0;
        $.ajax({
            async: false,
            type: "get",    //请求类型
            data: {
                opType: "getOrder"
            },
            url: "receiver",//请求的 URL地址
            dataType: "json",//返回的数据类型 json

            success: function (data) {
                // alert(data.length);
                for (var i = 0; i < data.length; i++) {
                    // alert("1次");
                    getGood(data[i]);    //传取一组记录填充网页内
                }
            },
            error: function (data) {
                alert("getGoodList-error！");
            }
        });
    }

    //获取商品名字
    function getGood(order) {
        // alert("getGood函数"+order.goodId);
        $.ajax({
            async: false,
            type: "get",    //请求类型
            data: {
                opType: "getGoods",
                goodId: order.goodId
            },
            url: "receiver",//请求的 URL地址
            dataType: "json",//返回的数据类型 json
            success: function (data) {
                    // alert("getGood获得商品信息:"+data[0].shangPinMingCheng);
                    getPicture(data,order);    //传取一组记录填充网页内容
            },
            error: function (data) {
                alert("getGood-error！");
            }
        });
    }

    //获取图片
    function getPicture(good,order) {
        // alert("获取图片"+good[0].shangPinMingCheng+" "+order.goodId);
        var html = "";
        var html2 = "";
        var html3 = "";

        $.ajax({
            async: false,
            type: "get",    //请求类型
            data: {
                goodId: good[0].goodId
            },
            url: "getSinglePicServlet",//请求的 URL地址
            dataType: "text",//返回的数据类型
            success: function (data) {
                // alert("获取图片函数来拼接html");
                html = "<tr><td class=\"col1\"><a href=\"\"><img src=\"images/"+data+"\" alt=\"\" /></a>  " +
                    "<strong><a href=\"\">"+good[0].shangPinMingCheng+"</a></strong></td>" +
                    "<td class=\"col2\"> <p>颜色："+order.yanSe+"</p> <p>版本："+order.banBeng+"</p> </td>" +
                    "<td class=\"col3\">￥"+good[0].benDianJia+"</td>" +
                    "<td class=\"col4\">"+order.shuLiang+" </td>" +
                    "<td class=\"col5\"><span>￥"+good[0].benDianJia*order.shuLiang+"</span></td>" +
                    "</tr>";
                sum = sum + good[0].benDianJia*order.shuLiang;
                var temp = sum-230;
                count++;
                // html2 = "<li><span>" +count+" 件商品，总商品金额：</span>" +
                //     "<em>"+sum+"</em></li><li><span>返现：</span><em>240.00</em>"+
                //     "</li><li><span>运费：</span><em> 10.00</em></li>";
                html2 = "<li><span>"+count+"件商品，总商品金额：</span><em>￥"+sum+"</em></li><li><span>返现：</span><em>￥240.00</em></li>" +
                    "<li><span>运费：</span><em>￥10.00</em></li><li><span>应付总额：</span><em>￥"+temp+"</em></li>";
                html3 = "<a href=\"flow3.html\"><span>提交订单</span></a>" +
                "<p>应付总额：<strong>"+temp+"元</strong></p>";
                $(".setGoods").append(html);
                $(".setSums").html(html2);
                $(".fillin_ft").html(html3);

            },
            error: function (data) {
                alert("getPicture-error");
            }
        });
    }

    //收货人修改
    $("#address_modify").click(function () {
        $(this).hide();
        $(".address_info").hide();
        $(".address_select").show();
    });

    $(".new_address").click(function () {
        $("form[name=address_form]").show();
        $(this).parent().addClass("cur").siblings().removeClass("cur");

    }).parent().siblings().find("input").click(function () {
        $("form[name=address_form]").hide();
        $(this).parent().addClass("cur").siblings().removeClass("cur");
    });

    //送货方式修改
    $("#delivery_modify").click(function () {
        $(this).hide();
        $(".delivery_info").hide();
        $(".delivery_select").show();
    })

    $("input[name=delivery]").click(function () {
        $(this).parent().parent().addClass("cur").siblings().removeClass("cur");
    });

    //支付方式修改
    $("#pay_modify").click(function () {
        $(this).hide();
        $(".pay_info").hide();
        $(".pay_select").show();
    })

    $("input[name=pay]").click(function () {
        $(this).parent().parent().addClass("cur").siblings().removeClass("cur");
    });

    //发票信息修改
    $("#receipt_modify").click(function () {
        $(this).hide();
        $(".receipt_info").hide();
        $(".receipt_select").show();
    })

    $(".company").click(function () {
        $(".company_input").removeAttr("disabled");
    });

    $(".personal").click(function () {
        $(".company_input").attr("disabled", "disabled");
    });

});