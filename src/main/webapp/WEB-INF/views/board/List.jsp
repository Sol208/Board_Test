<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<hr />
<button onClick="location.href='/prac'">뒤로가기</button>

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
			<td>${no.index+1}</td>
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
<c:if test="${pageStart>1 }">
				<a href="<c:url value="/Board/List?page=${pageStart-1 }"/>">[이전]</a>
			</c:if>
				<c:forEach var = "i" begin="${pageStart }" end = "${pageEnd }" step="1">
					<c:choose>
						<c:when test="${nowPage==i }">
							${i }
						</c:when>
						<c:otherwise>
							<a href="<c:url value="/Board/List?page=${i }"/>">${i }</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${pageEnd<pageTotal }">
				<a href="<c:url value="/Board/List?page=${pageEnd+1 }"/>">[다음]</a>
			</c:if>

