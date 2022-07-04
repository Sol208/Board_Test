<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>login</title>
</head>
<body>
${UserInfo}

<c:choose>
	<c:when test="${UserInfo == Null}">
		<form action="Login/Login" method="POST">
			<input type="submit" value="login">
		</form>
		<form action="Member/SignUp" method="POST">
			<input type="submit" value="회원가입">
		</form>
	</c:when>
	<c:otherwise>
	<form action="Login/LogoutReg" method="POST">
		<input type="submit" value="logout">
	</form>
	<button onclick="location.href='Board/List'">게시판</button>
	</c:otherwise>
</c:choose>
</body>
<script>


</script>
</html>
