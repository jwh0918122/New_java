<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Board Detail Page</h1>
<table border="1">
<tr>
	<th>BNO</th>
	<td>${bvo.bno }</td>
</tr>
<tr>
	<th>TITLE</th>
	<td>${bvo.title }</td>
</tr>
<tr>
	<th>WRITER</th>
	<td>${bvo.writer }</td>
</tr>
<tr>
	<th>REGDATE</th>
	<td>${bvo.regdate }</td>
</tr>
<tr>
	<th>CONTENT</th>
	<td>${bvo.content }</td>
</tr>
</table>

<a href="/brd/modify?bno=${bvo.bno }"><button type="button">modify</button></a>
<a href="/brd/remove?bno=${bvo.bno }"><button type="button">remove</button></a>

</body>
</html>