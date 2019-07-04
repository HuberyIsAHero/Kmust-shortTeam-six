/**
 * 注册页面
 *吴昌卓
 * 2019.7.4
 */
function registered() {
    alert("取得函数");
    var username = $("#username").val();
    var password1 = $("#password1").val();
    var password2 = $("#password2").val();
    var sex = $("#sex").val();
    var birthday = $("#birthday").val();
    var Mail = $("#Mail").val();
    if(password1 != password2){
        alert("两次密码不同");
    }else {
        $.ajax({
            type:"POST",
            url:"ServletRegistered",
            data:{
                username:username,
                password1:password1,
                password2:password2,
                sex:sex,
                birthday:birthday,
                Mail:Mail,
            },
            dataType:"json",
            success:function (data) {
                alert(data[0].Message);
            },
            error:function () {
                alert("出错");
            }
        })
    }

}