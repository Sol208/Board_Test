<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>login</title>
</head>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<body>
<h1>
	Login
</h1>
<form action="Check" method="POST" onsubmit="return authCheck();" name="loginForm">
	<table border="">
		<tr>
			<th>
			ID
			</th>
			<td>
				<input type=text name="pid" id="pid">
			</td>
		</tr>
		<tr>
			<th>
			Password
			</th>
			<td>
				<input type=password name="pw" id="pw">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit"/>
			</td>
		</tr>
	</table>
</form>
</body>
<script>
	const form = document.loginForm;
	
	function authCheck(){
		var id = document.getElementById("pid").value;
		var pw = document.getElementById("pw").value;
		
		if(id!="" && pw!=""){
			return true
		} else if(id==""){
			alert("아이디를 입력해 주세요.")
			return false;
		} else if(pw==""){
			alert("비밀번호를 입력해주세요.")
			return false;
		}
	}
</script>
</html>
