<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>管理端登录</title>
  <meta name="description" content="这是一个 index 页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="assets/css/amazeui.min.css" />
  <link rel="stylesheet" href="assets/css/admin.css">
  <link rel="stylesheet" href="assets/css/app.css">
</head>

<body data-type="login">

  <div class="am-g myapp-login">
	<div class="myapp-login-logo-block  tpl-login-max">
		<div class="myapp-login-logo-text">
			<div class="myapp-login-logo-text">
				LAB<span> Login</span> <i class="am-icon-skyatlas"></i>
				
			</div>
		</div>

		<div class="am-u-sm-10 login-am-center">
			<form class="am-form" action="${ pageContext.request.contextPath }/manager_repwd.action" method="post">
				<fieldset>
					<div class="am-form-group">
						<input type="text" name="managerId" class="" id="doc-ipt-email-1" placeholder="请输入管理员账号">
					</div>
					<div class="am-form-group">
						<input type="password" name="managerPassword" class="" id="doc-ipt-pwd-1" placeholder="请输入原密码">
					</div>
					<br>
					<div class="am-form-group">
						<input type="password" id="newManagerPassword" name="newManagerPassword" class="" placeholder="请输入新密码">
					</div>
					<br>
					<div class="am-form-group">
						<input type="password" id="confirmManagerPassword" name="confirmManagerPassword" class="" placeholder="请再次输入新密码，并点击检查按钮确认无误">
					</div>
					<p>
						<button type="submit" class="am-btn am-btn-default">确认修改</button>
					</p>
					<p>
						<button type="button" name="check" class="am-btn am-btn-default" onclick="checkNewPwd()">检查</button>
					</p>
				</fieldset>
			</form>
		</div>
	</div>
</div>

  <script src="assets/js/jquery.min.js"></script>
  <script src="assets/js/amazeui.min.js"></script>
  <script src="assets/js/app.js"></script>
  <script>
	function checkNewPwd(){
		var obj1=document.getElementById("newManagerPassword");
		var obj2=document.getElementById("confirmManagerPassword");
		if(obj1.value != obj2.value)
			alert("确认新密码失败，请再次确认新密码");
		else
			alert("确认新密码成功");
	}
	</script>
</body>

</html>