
$(document).ready(function (){
   var arrCookie = document.cookie.split(";");
   var getCookieUserName = null;
   for (var i = 0;i < arrCookie.length;i++){
      var tString = arrCookie[i].split("=");
       if (tString[0] == "userNameSix")
       {
           getCookieUserName = tString[1];
       }
    }
   if (getCookieUserName != null){
       var Message = "欢迎尊贵的用户：" +  getCookieUserName;
   }else {
       var Message = "<span>您好，欢迎来到京东!" + '<a href="login.html">' + "[登陆]"+ '</a><a href="login.html">'+"[免费注册]"+"</a>" + "</span>"
   }

    $("#loginRefreahSix").html(Message);
})