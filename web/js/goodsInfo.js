
$(document).ready(function(){
    var loc = location.href;
    var n1 = loc.length;//地址的总长度
    var n2 = loc.indexOf("=");//取得=号的位置
    var goodId = loc.substr(n2+1, n1-n2);//获取商品id
    getGoodInfo(goodId);    //获取商品信息
});
function getGoodInfo(goodId) {
    //alert("进来执行ajax啦..");
    $.ajax({
        type : "get",    //请求类型
        data : {
            goodId:goodId
        },
        url : "getSingleGoodServlet",//请求的 URL地址
        dataType :"json",//返回的数据类型 json
        success: function (data) {
            setBreadCrumb(data.shangPinMingCheng);  //设置面包屑名称
            setSummaryName(data.shangPinMingCheng); //设置Summary的名称
            setMidPic(data.goodId); //设置图片
            getSmallPic(data.goodId);   //设置预浏图
            setGoodsInfo(data); //设置商品详情
            setGoodsInfo2(data);
            setAttrWords(data);
            setAttrPic(data.goodId);
        },
        error:function (data) {
            alert("发生错误!!!！");
        }
    });
}
//1.类breadcrumb下的h2值进行更改电脑名称
function setBreadCrumb(name) {
    //alert(name);
    html = '<h2>当前位置：<a href=\"\">首页</a> > <a href=\"\">电脑、办公</a> > <a href=\"\">笔记本</a> >'+ name+'</h2>';
    //alert(html);
    $(".breadcrumb").html(html);
}
//2.类summary_name
function setSummaryName(name) {
    html = '\"'+name+'\"';
    $(".summary_head").text(name);
}

//3.midpic 设置商品具体图片
function setMidPic(goodId) {
    //alert("进来图片");
    $.ajax({
        type : "get",    //请求类型
        data : {
            goodId:goodId
        },
        url : "getSinglePicServlet",//请求的 URL地址
        dataType :"text",//返回的数据类型 json
        success: function (data) {
            html = '<a href=\"images/'+data+'\" class=\"jqzoom\" rel=\"gal1\"><img src='+
                '\"images/'+data+'\" width=\"350\" height=\"350\" alt=\"\" /></a>';
            //alert(html);
            $(".midpic").html(html);

        },
        error:function (data) {
            alert("发生错误!!!！");
        }
    });
}
//4.类smallpic_wrap设置预浏览图
function getSmallPic(goodId) {
    $.ajax({
        type : "get",    //请求类型
        data : {
            goodId:goodId
        },
        url : "getAllPicServlet",//请求的 URL地址
        dataType :"json",//返回的数据类型 json
        success: function (data) {
            //alert(data);
            html ="<a class=\"zoomThumbActive\" href=\"javascript:void(0);\" rel=\"{gallery: 'gal1', smallimage:" +
                " 'images/"+data[0]+"',largeimage: 'images/"+data[0]+"'}\"><img src=\"images/"+data[0]+"\"></a>";

            $(".cur").html(html);
            //alert(html);
            for(var i=0; i<data.length-1; i++){
                html = "<li><a href=\"javascript:void(0);\" rel=\"{gallery: 'gal1', smallimage:" +
                    " 'images/"+data[i]+"',largeimage: 'images/"+data[i]+"'}\"><img src=\"images/"+data[i]+"\"></a></li>";
                $(".smallpic_wrap").append(html);
                //alert(html);
            }
            refresh();
        },
        error:function (data) {
            alert("发生错误!!!！");
        }
    });
}

function refresh() {
    $("#backward").click(function () {
        var left = parseInt($(".smallpic_wrap ul").css("left")); //获取ul水平方向偏移量
        var offset = left + 62;
        if (offset <= 0) {
            $(".smallpic_wrap ul").stop(true, false).animate({left: offset}, "slow", '', function () {
                //动画完成之后，判断是否到了左边缘
                if (parseInt($(".smallpic_wrap ul").css("left")) >= 0) {
                    $("#backward").removeClass("on").addClass("off");
                }
            });
            //开启右边的按钮
            $("#forward").removeClass("off").addClass("on");
        }

        $(this).blur(); //去除ie 虚边框
    });
    //点击前进
    $("#forward").click(function () {
        var left = parseInt($(".smallpic_wrap ul").css("left")); //获取ul水平方向偏移量
        var len = $(".smallpic_wrap li").size() * 62; //获取图片的整体宽度(图片数 * 图片宽度)558
        var offset = left - 62;
        if (offset >= -(len - 62 * 5)) {
            $(".smallpic_wrap ul").stop(true, false).animate({left: offset}, "slow", '', function () {
                //判断是否到了右边缘
                if (parseInt($(".smallpic_wrap ul").css("left")) <= -(len - 62 * 5)) {
                    $("#forward").removeClass("on").addClass("off");
                }
            });
            //开启左边的按钮
            $("#backward").addClass("on").removeClass("off");

        }
        $(this).blur(); //去除ie 虚边框
    });
    //还要设置动态效果
    $('.jqzoom').jqzoom({
        zoomType: 'standard',
        lens:true,
        preloadImages: false,
        alwaysOn:false,
        title:false,
        zoomWidth:400,
        zoomHeight:400
    });
    //商品详情效果
    $(".detail_hd li").click(function () {
        $(".detail_div").hide().eq($(this).index()).show();
        $(this).addClass("on").siblings().removeClass("on");
    });
    //选择货品，如颜色、版本等
    $(".product a").click(function () {
        $(this).addClass("selected").siblings().removeClass("selected");
        $(this).find("input").attr({checked: "checked"});
        //去除虚边框
        $(this).blur();
    });
    //购买数量
    //减少
    $("#reduce_num").click(function () {
        if (parseInt($(".amount").val()) <= 1) {
            alert("商品数量最少为1");
        } else {
            $(".amount").val(parseInt($(".amount").val()) - 1);
        }
    });

    //增加
    $("#add_num").click(function () {
        $(".amount").val(parseInt($(".amount").val()) + 1);
    });

    //直接输入
    $(".amount").blur(function () {
        if (parseInt($(".amount").val()) < 1) {
            alert("商品数量最少为1");
            $(this).val(1);
        }
    });
}
//4.类goodsinfo 设置商品的具体数据
function setGoodsInfo(good) {
    html = "<br/><ul><li><span>商品编号： </span>"+good.goodId+"</li><li class=\"market_price\"><span>定价：</span><em>"+good.dingJia+"</em></li>" +
        "<li class=\"shop_price\"><span>本店价：</span> <strong><a class='price' style='font-weight: bold;color: red'>"+good.benDianJia+"</a></strong> <a href=\"\">(降价通知)</a></li>" +
        "<li><span>上架时间：</span>"+good.shangJiaShiJian+"</li><span>商品评分："+good.shangPinPingFen+"</span></a></li> </ul>";
    $(".goodsinfo").append(html);
}
function setGoodsInfo2() {
    html = "<form action=\"doCartServlet\" method=\"post\" class=\"choose\"><ul><li class=\"product\"><dl><dt>颜色：</dt><dd>" +
        "<a class=\"selected\" href=\"javascript:;\">黑色 <input type=\"radio\" name=\"color\" value=\"黑色\" checked=\"checked\" /></a>" +
        "<a href=\"javascript:;\">白色 <input type=\"radio\" name=\"color\" value=\"白色\" /></a>" +
        "<a href=\"javascript:;\">蓝色 <input type=\"radio\" name=\"color\" value=\"蓝色\" /></a>" +
        "<input type=\"hidden\" name=\"\" value=\"\" /></dd></dl></li><li class=\"product\"><dl>" +
        "<dt>版本：</dt><dd><a href=\"javascript:;\">i5 4G内存版 <input type=\"radio\" name=\"ver\" value=\"i5 4G内存版\" /></a>" +
        "<a href=\"javascript:;\">i5 8G内存版 <input type=\"radio\" name=\"ver\" value=\"i5 8G内存版\"  /></a>" +
        "<a class=\"selected\" href=\"javascript:;\">i7 8G内存版<input type=\"radio\" name=\"ver\" value=\"i7 8G内存版\" checked=\"checked\" /></a>" +
        "<input type=\"hidden\" name=\"\" value=\"\" /></dd></dl></li><li><dl><dt>购买数量：</dt><dd>" +
        "<a href=\"javascript:;\" id=\"reduce_num\"></a><input type=\"text\" name=\"amount\" value=\"1\" class=\"amount\"/>" +
        "<a href=\"javascript:;\" id=\"add_num\"></a></dd></dl></li><li><dl><dt>&nbsp;</dt><dd>" +
        "<input type=\"submit\" value=\"\" class=\"add_btn\" /></dd></dl></li></ul></form>";
    $(".goodsinfo").append(html);
}
//5.类attr设置下面的文字内容
function setAttrWords(good) {
    html = "<ul><span>商品名称：</span>"+good.shangPinMingCheng+"</li><br/><li><span>商品编号：</span>"+good.goodId+"" +
        "<li><span>品牌：</span>"+good.pinPai+"</li><li><span>上架时间：</span>"+good.shangJiaShiJian+"</li>" +
        "<li><span>商品毛重：</span>"+good.maoZhong+"</li><li><span>商品产地：</span>"+good.chanDi+"</li><li><span>显卡：</span>"+good.xianKa+"</li>" +
        "<li><span>触控：</span>"+good.chuKong+"</li><li><span>厚度：</span>"+good.houDu+"</li><li><span>处理器：</span>"+good.chuLiQi+"</li>" +
        "<li><span>尺寸：</span>"+good.chiCun+"</li></ul>";
    //alert(html);
    $(".attr").html(html);
}
//6.类desc设置下面的图片内容
function setAttrPic(goodId) {
    $.ajax({
        type : "get",    //请求类型
        data : {
            goodId:goodId
        },
        url : "getAllPicfServlet",//请求的 URL地址
        dataType :"json",//返回的数据类型 json
        success: function (data) {
            html="";
            for(var i=0; i<data.length-1; i++){
                html += "<img src=\"images/"+data[i]+"\" alt=\"\" /><p style=\"height:10px;\"></p>"
            }
            //alert(html);
            $(".desc").html(html);
        },
        error:function (data) {
            alert("发生错误!!!！");
        }
    });
}
function addToCart() {
    //alert("进入购物车啦");
    //获取颜色
    var color = $('input[name="color"]:checked').val();
    //获取版本
    var version = $('input[name="ver"]:checked').val();
    //获取数量
    var amount = $("input[name=amount]").val();
    //获取单价
    var price =$(".price").text();
    //跳转到servlet
    //location.href = "/京东商城/doCartServlet";
}