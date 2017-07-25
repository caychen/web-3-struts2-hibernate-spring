<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/functions.js"></script>
<script type="text/javascript">
	function validataForm() {
		var b1 = $('#admincode').require("帐号必须填写", $('#msg_admincode'));
		var b2 = $('#adminpwd').require('密码必须填写', $('#msg_adminpwd'));
	
		var b3 = $('#verifyCode').remote('verifycode.action', '验证码错误',
				$('#checkMsg'));
	
		return b1 && b2 && b3;
	}
	
	$(function() {
		$('#submit').click(function() {
			var bFlag = validataForm();
			if (bFlag)
				$('#loginform').submit();
		})
	});
</script>
<style>
	table {
		background-color: #3B9CFD;
		border: 1px solid black;
		border-collapse: 0;
		border-spacing: 0;
	}
	
	img.login {
		margin-left: 45px;
	}
	
	span{
		font-size: 10pt;
	}
</style>
</head>
<body>
	<form id="loginform" action="login.action" method="post"
		name="loginForm">
		<table>
			<tr>
				<td>用户名</td>
				<td colspan="2"><input name="admin.code" id="admincode" /></td>
				<td><span id="msg_admincode"></span></td>
			</tr>
			<tr>
				<td>密码</td>
				<td colspan="2"><input type="password" name="admin.password"
					id="adminpwd" /></td>
				<td><span id="msg_adminpwd"></span></td>
			</tr>
			<tr>
				<td>验证码</td>
				<td><input id="verifyCode" name="userCode" /></td>
				<td><img src="code.action"
					onclick="this.src='code.action?' + Math.random();" /></td>
				<td><span id="checkMsg"> </span></td>
			</tr>
			<tr>
				<td colspan="4"><a href="javascript:;" id="submit"><img
						alt="登录" src="../images/login_button.jpg" class="login" /></a></td>
			</tr>
		</table>
	</form>
</body>
</html>