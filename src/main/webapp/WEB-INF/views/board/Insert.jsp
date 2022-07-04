<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<form action="InsertReg" method="POST">
	<table border="">
		<tr>
			<th>글 제목</th>
			<td><input type="text" name="title" id="title" /></td>
		</tr>
		<tr>
			<th>본문</th>
			<td><textarea name="mainText" id="mainText" cols="30" rows="10"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="저장" Style="float:right;" /></td>
		</tr>
	</table>
</form>