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
function getPicture(goodId){
	    alert("进来啦！！");
        $.ajax({
            type : "get",    //请求类型
            data : {
                goodId:goodId
            },
            url : "getSinglePicServlet",//请求的 URL地址
            dataType :"text",//返回的数据类型 json
            success: function (data) {
                alert(data);
            },
            error:function (data) {
                alert("发生错误！");
            }
        });
    }
	//下面是原版本的
	$(".child h3").click(function(){
		$(this).toggleClass("on").parent().find("ul").toggle();
	});
