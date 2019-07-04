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
//         alert(data);
            html+="<tr>";
            html+="<td class=\"col1\"><a href=\"\">" +"<img src=\"images/"+ data +'"'+" alt=\"\" /></a>  <strong>" + "<a href=\"\">"+good.mingCheng + "</a></strong></td>";
            html+="<td class=\"col2\"> <p>颜色：" + good.yanSe + "</p> <p>版本：" + good.banBen +"</p> </td>";
            html+="<td class=\"col3\">￥<span>" + good.danJia +"</span></td>";
            html+="<td class=\"col4\">";
            html+="<a href=\"javascript:;\" class=\"reduce_num\" id='reduce_num'></a>";
            html+="<input type=\"text\" name=\"amount\" value=\"1\" class=\"amount\"/>";
            html+="<a href=\"javascript:;\" class=\"add_num\" id='add_num'></a>";
            html+="</td>";
            html+="<td class=\"col5\">￥<span>" + value + "</span></td>";
            html+="<td class=\"col6\"><a href=\"\">删除</a></td>"
            html+="</tr>";
//            alert(html);


            $("#datalist").html(html);
            //alert(html);

        },
        error:function (data) {
            alert("发生错误！");
        }
    });
    //alert(html);
    //$(".goodslist").html(html);
}
