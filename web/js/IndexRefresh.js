
$(document).ready(function (){
   var arrCookie = document.cookie.split(";");
   var getCookieUserName = null;
   var getCookieUserPwd = null;
   for (var i = 0;i < arrCookie.length;i++){
      var tString = arrCookie[i].split("=");
       if (tString[1] = "userNameSix")
       {
           getCookieUserName = tString[2];
       }
       if (tString[1] = "passWordSix") {
           getCookieUserPwd = tString[2];
       }
    }
   if (getCookieUserName != null && getCookieUserPwd != null){
       var Message = "欢迎尊贵的用户：" +  getCookieUserName;
   }else {
       var Message = "<span>您好，欢迎来到京东!" + '<a href="login.html">' + "[登陆]"+ '</a><a href="login.html">'+"[免费注册]"+"</a>" + "</span>"
       alert(Message);
   }

    $("#loginRefreahSix").html(Message);
})