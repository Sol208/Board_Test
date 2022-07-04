<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<form action="UpdateReg?postNo=${post.postNo}" method="POST">
	<table border="">
		<tr>
			<th>글 제목</th>
			<td><input type="text" name="title" id="title" value="${post.title }" /></td>
		</tr>
		<tr>
			<th>본문</th>
			<td><textarea name="mainText" id="mainText" cols="30" rows="10" >${post.mainText }</textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="수정" Style="float:right;" /></td>
		</tr>
	</table>
</form>