/*
@功能：登录页面js
@作者：WuChangzhuo
@时间：2019年07月03日
*/

$(document).ready(function (){
	TestCookie();
});
function TestCookie(){
	$.ajax({
		type: "POST",
		url: "ServletLogin",
		data: {},
		dataType: "json",
		success: function (data) {
			for (var i = 0; i < data.length;i++) {
				var message = "";
				message = message + data[0].message;
				alert(message);
			}
			if (data.length > 0) {
				window.location.href = "index.html";
			}
		}
	})
}

function LoginTest(){
	alert("取得函数");
	var username =  $("#username").val();
	var password = $("#password").val();
	alert(username);
	alert(password);
	$.ajax({
		type:"POST",
		url:"ServletLogin",
		data:{
			userName: username,
			passWord: password
		},
		dataType:"json",
		success : function (data){
			for (var i = 0; i < data.length;i++) {
				var message = "";
				message = message + data[0].message;
				alert(message);
			}
			if (data.length > 0) {
				window.location.href = "index.html";
			}
		}
	})
}