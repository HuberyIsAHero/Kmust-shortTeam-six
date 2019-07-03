/*
@功能：登录页面js
@作者：WuChangzhuo
@时间：2019年07月03日
*/

function LoginTest(){
	alert("取得函数");
	var username =  $("#username").val();
	var password = $("#password").val();
	alert("username");
	$.ajax({
		type:"post",
		url:"/Kmust-shortTeam-six/ServletLogin",
		date:{
			userName: username,
			passWord: password
		},
		dateType:"json",
		success:function (data){
			alert("password");
		}


	})
}