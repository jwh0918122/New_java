<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
	<th>BNO</th>
	<td>${bvo.bno}</td>
</tr>
<tr>
	<th>TITLE</th>
	<td>${bvo.title}</td>
</tr>
<tr>
	<th>WRITER</th>
	<td>${bvo.writer}</td>
</tr>
<tr>
	<th>CONTENT</th>
	<td>${bvo.content}</td>
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
<a href="/brd/pageList"><button type="button">목록(list)</button></a>
<a href="/brd/modify?bno=${bvo.bno }"><button type="button">수정(modify)</button></a>
<a href="/brd/remove?bno=${bvo.bno }"><button type="button">삭제(remove)</button></a>
</body>
</html>