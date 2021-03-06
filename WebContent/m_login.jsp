<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>管理员登录</title>
<meta name="description" content="这是一个 login 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">
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
				<form class="am-form"
					action="${ pageContext.request.contextPath }/manager_login.action"
					method="post" onsubmit="return checkInput()">
					<fieldset>
						<div class="am-form-group">
							<input type="text" name="managerId" class="" id="doc-ipt-email-1"
								placeholder="请输入管理员账号">
						</div>
						<div class="am-form-group">
							<input type="password" name="managerPassword" class=""
								id="doc-ipt-pwd-1" placeholder="请输入密码">
						</div>
						<p>
							<button type="submit" class="am-btn am-btn-default">登录</button>
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
		function checkInput() {
			var obj1 = document.getElementById("doc-ipt-email-1");
			var obj2 = document.getElementById("doc-ipt-pwd-1");
			if (obj1.value == "") {
				alert("请输入账号");
				return false;
			} else if (obj2.value == "") {
				alert("请输入密码");
				return false;
			}
			return true;
		}
	</script>
</body>

</html>