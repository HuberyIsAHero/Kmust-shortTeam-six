$(document).ready(function () {
    f();   //执行函数





});
var html ="";

var picutre = [];

function f1() {
    $.ajax({
        type : "get",    //请求类型
        data: {
        },
        url : "GainPicutreServlet",//请求的 URL地址
        dataType : "json",//返回的数据类型
        success: function (data) {
            for (var i = 0;i<data.length;i++){
                picutre[i] = data[i].picId;
            }
        },
        error: function (data) {
            alert("获取图片出错！");
        }
    });
};

function f() {
//    alert("进入f（）！");
    alert("进入函数");
    $.ajax({
        type : "get",    //请求类型
        data : {

        },
        url : "GainCartServlet",//请求的 URL地址
        dataType : "json",//返回的数据类型
        success: function (data) {
            //           alert("进入成功！");

            for (var i = 0;i<data.length;i++){
                getPicture(data[i]);    //传取一组记录填充网页内容
            }


        },

        error: function (data) {
            alert("出错啦！");
        }

    });

}

function getPicture(good){
    $.ajax({
        type : "get",    //请求类型
        data : {
            goodId:good.goodId
        },
        url : "getSinglePicServlet",//请求的 URL地址
        dataType :"text",//返回的数据类型 json
        success: function (data) {
            var   value = good.danJia;

            html+="<tr>";
            html+="<td class=\"col1\"><a href=\"\">" +"<img src=\"images/"+ data +'"'+" alt=\"\" /></a>  <strong>" + "<a href=\"\">"+good.mingCheng + "</a></strong></td>";
            html+="<td class=\"col2\"> <p>颜色：" + good.yanSe + "</p> <p>版本：" + good.banBen +"</p> </td>";
            html+="<td class=\"col3\">￥<span>" + good.danJia +"</span></td>";
            html+="<td class=\"col4\">";
            html+="<a href=\"javascript:;\" class=\"reduce_num\" id='reduce_num' onclick='reduce(this)'></a>";
            html+="<input type=\"text\" name=\"amount\" value=\""+good.shuLiang+"\" class=\"amount\"/>";
            html+="<a href=\"javascript:;\" class=\"add_num\" id='add_num' onclick='add(this)'></a>";
            html+="</td>";
            html+="<td class=\"col5\">￥<span>" + value + "</span></td>";
            html+="<td class=\"col6\"><a href=\"\">删除</a></td>"
            html+="</tr>";
//            alert(html);

            // alert("4544");
            $("#datalist").html(html);
            //alert(html);
           // window.location.href = "flow2.html?orderId";
        },
        error:function (data) {
            alert("发生错误！");
        }
    });
    //alert(html);
    //$(".goodslist").html(html);
}
//减少
function reduce(reduce){
    var amount = $(reduce).parent().find(".amount");
    if (parseInt($(amount).val()) <= 1){
        alert("商品数量最少为1");
    } else{
        $(amount).val(parseInt($(amount).val()) - 1);
    }
    //小计
    var subtotal = parseFloat($(reduce).parent().parent().find(".col3 span").text()) * parseInt($(amount).val());
    $(reduce).parent().parent().find(".col5 span").text(subtotal.toFixed(2));
    //总计金额
    total += $(".amount").val();
    $("#total").html(total);
}
//增加
function add(add){
    var amount = $(add).parent().find(".amount");
    $(amount).val(parseInt($(amount).val()) + 1);
    //小计
    var subtotal = parseFloat($(add).parent().parent().find(".col3 span").text()) * parseInt($(amount).val());
    $(add).parent().parent().find(".col5 span").text(subtotal.toFixed(2));
    //总计金额
    var total = 0;
    $(".col5 span").each(function(){
        total += parseFloat($(add).text());
    });

    $("#total").text(total.toFixed(2));
}
//直接输入
function input(){
    if (parseInt($(".amount").val()) < 1){
        alert("商品数量最少为1");
        $(".amount").val(1);
    }
    //小计
    var subtotal = parseFloat($(".amount").parent().parent().find(".col3 span").text()) * parseInt($(".amount").val());
    $(".amount").parent().parent().find(".col5 span").text(subtotal.toFixed(2));
    //总计金额
    var total = 0;
    $(".col5 span").each(function(){
        total += parseFloat($(".amount").text());
    });

    $("#total").text(total.toFixed(2));

}