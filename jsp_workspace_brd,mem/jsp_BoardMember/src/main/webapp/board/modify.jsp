<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify page</title>
</head>
<body>
<form action="/brd/edit">
<table border="1">
<tr>
	<th>BNO</th>
	<td><input type="text" name="bno" value="${bvo.bno}" readonly="readonly"></td>
</tr>
<tr>
	<th>TITLE</th>
	<td><input type="text" name="title" value="${bvo.title}"></td>
</tr>
<tr>
	<th>WRITER</th>
	<td>${bvo.writer}</td>
</tr>
<tr>
	<th>CONTENT</th>
	<td><input type="text" name="content" value="${bvo.content}"></td>
</tr>
<tr>
	<th>REGDATE</th>
	<td>${bvo.regdate}</td>
</tr>
<tr>
	<th>MODDATE</th>
	<td>${bvo.moddate}</td>
</tr>
</table>
<button type="submit">수정</button>
</form>
</body>
</html>