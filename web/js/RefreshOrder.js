/**
 * ˢ���ҵĶ���
 * ���׿
 * 2019.7.4
 */
$(document).ready(function () {
        var html = "";
        var look = "�鿴";
        var datel = "ɾ��";
        var suc = "�ѳɹ�";
        $.ajax({
            type:"POST",
            url:"ServletOrder",
            data:{},
            dataType:"json",

            success : function (data) {
                for (var i = 0; i < data.length;i++){
                    var orderId = data[i].orderId;
                    var goodId = data[i].goodId;
                    var userId = data[i].userId;
                    var receiverId = data[i].receiverId;
                    var zhiFuFangShi = data[i].zhiFuFangShi;
                    var dingDanJinE = data[i].dingDanJinE;
                    var xiaDanShiJian = data[i].xiaDanShiJian;
                    var dingDanZhuangTai = data[i].dingDanZhuangTai;
                    var Image = null;
                    $.ajax({
                        type: "POST",
                        url: "ServletOrderImage",
                        data: {
                            userId:userId,
                            goodId:goodId
                        },
                        dataType: "json",
                        success : function (data1) {
                            image = data1[0].imagePath;
                            var html = html + "</tr>";
                            html = html + "<td><a href=\"\">"+ orderId +"</a></td>";
                            html = html + "<td><a href=\"\"><img src=\"images/"+ image +"\" alt=\"\" /></a></td>";
                            html = html + "<td>" + userId + "</td>";
                            html = html + "<td>"+ dingDanJinE + zhiFuFangShi +"</td>";
                            html = html + "<td>"+ xiaDanShiJian +"</td>";
                            html = html + "<td>" + suc + "</td>";
                            html = html + "<td><a href=\"\">"+look+ "</a> | <a href=\"\">" + datel+ "</a></td>";
                            html = html + "</tr>";
                            alert(html)
                            $("#datalist").html(html);
                        },
                        error : function () {
                            alert("�ڲ����");
                        }
                    })
                }
            },
            error:function () {
                alert("����");
            }
        })
})