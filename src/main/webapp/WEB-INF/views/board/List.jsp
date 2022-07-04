<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<hr />
<button onClick="location.href='Insert'">글쓰기</button>
<table border="">
	<tr>
		<th>번호</th>
		<th>글 제 목</th>
		<th>작 성 자</th>
		<th>조 회 수</th>
		<th>게 시 일 자</th>
	</tr>
	
	<c:forEach var="dto" items="${mainData }" varStatus="no">
		<tr>
			<td>${dto.postNo}</td>
			<td>
				<a href="<c:url value="Detail?postNo=${dto.postNo }"/>">${dto.title }</a>
			</td>
			<td>${dto.userName }</td>
			<td>${dto.views }</td>
			<td>
				<fmt:formatDate value="${dto.dateTime}" pattern="yy-MM-dd HH:mm"/>
			</td>
		</tr>
	</c:forEach>
</table>
