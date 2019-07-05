
function account() {

    var name = $("#name").val();
    var pwq = $("#pwq").val();
    var sex = $("#sex").val();
    var mail = $("#mail").val();
    var date = $("#date").val();
    alert("取得函数");
        $.ajax({
            url: "ReviseAccountServlet",
            type: "POST",    //请求类型
            data:{
                name:name,
                pwq : pwq,
                mail:mail,
                date : date,
                sex :sex
            },

                //请求的 URL地址
                dataType: "text",//返回的数据类型
                success: function (data) {
                    alert("修改信息成功");
                },
                error: function (data) {
                    alert("error");
                }

        });


}