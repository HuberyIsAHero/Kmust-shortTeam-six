var good;
$(document).ready(function(){
    var loc = location.href;
    var n1 = loc.length;//地址的总长度
    var n2 = loc.indexOf("=");//取得=号的位置
    var goodId = loc.substr(n2+1, n1-n2);//获取商品id
    getGoodInfo(goodId);    //获取商品信息
    testData(good);
});
function getGoodInfo(goodId) {
    $.ajax({
        type : "get",    //请求类型
        data : {
            goodId:goodId
        },
        url : "getGoodServlet",//请求的 URL地址
        dataType :"json",//返回的数据类型 json
        success: function (data) {
            good = data;
        },
        error:function (data) {
            alert("发生错误!!!！");
        }
    });
}
//1.类breadcrumb下的h2值进行更改电脑名称



//2.类summary下的h3值电脑名称



//3.类preview 设置商品具体图片


//4.类goodsinfo 设置商品的具体数据



//5.类attr设置下面的文字内容


//6.类desc设置下面的图片你内容