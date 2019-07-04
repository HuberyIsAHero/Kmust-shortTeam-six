/*
@功能：列表页js
@作者：diamondwang
@时间：2013年11月13日
*/
$(document).ready(function(){
    getGoodList();
});

/**
 * 获取商品列表
 */
	function getGoodList(){
		 $.ajax({
            type : "get",    //请求类型
            data : {

            },
            url : "getGoodServlet",//请求的 URL地址
            dataType :"json",//返回的数据类型 json
            success: function (data) {
                for(var i=0; i<data.length-1; i++){
                    getPicture(data[i]);    //传取一组记录填充网页内容
                }
            },
            error:function (data) {
                alert("发生错误!!!！");
            }
        });
	}

/**
 * 获取图片名称
 * @param goodId
 */
function getPicture(good){
    var html ="";
        $.ajax({
            type : "get",    //请求类型
            data : {
                goodId:good.goodId
            },
            url : "getSinglePicServlet",//请求的 URL地址
            dataType :"text",//返回的数据类型 json
            success: function (data) {
                html = '<li><dl><dt><a href=\"goods.html?goodId='+good.goodId+'\"><img src='+ '\"images/'+data+'\" alt=\"\"/></a></dt>' +'<dd><a href='+
                    '\"goods.html\">'+good.shangPinMingCheng+'</a></dd><dd><strong>¥'+good.benDianJia+'</strong></dd><dd><a href=\"goods.html\">'+
                    '<em>评分：'+good.shangPinPingFen+'</em></a></dd></dl></li>';
                //alert(html);
               $(".goodslist").append(html);
            },
            error:function (data) {
                alert("发生错误！");
            }
        });
        //alert(html);
    //$(".goodslist").html(html);
}
	//下面是原版本的
	$(".child h3").click(function(){
		$(this).toggleClass("on").parent().find("ul").toggle();
	});
