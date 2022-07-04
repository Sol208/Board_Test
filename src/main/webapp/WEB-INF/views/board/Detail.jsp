<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table border="">
	<c:if test="${sessionScope.UserInfo.pid  == post.userName }">
	<tr>
		<td colspan="5" >
			<input type="button" value="수정" onClick="location.href='Update?postNo=${post.postNo}'" Style="float:right;"/>
			<input type="button" value="삭제" onClick="location.href='DeleteReg?postNo=${post.postNo}'" Style="float:right;"/>
		</td>
	</tr>
	</c:if>
	<tr>
		<th>글제목</th>
		<th>작성자</th>
		<th>게시일자</th>
		<th>조회수</th>
	</tr>
	<tr>
		<td>${post.title }</td>
		<td>${post.userName}</td>
		<td><fmt:formatDate value="${post.dateTime}" pattern="yy-MM-dd HH:mm"/></td>
		<td>${post.views}</td>
	</tr>
	<tr>
		<td colspan="5">
			${post.mainText }
		</td>
	</tr>
</table>