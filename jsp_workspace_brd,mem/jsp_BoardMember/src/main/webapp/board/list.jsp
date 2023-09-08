<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board list Page</title>
</head>
<body>
<table border="1">
<tr>
	<th>BNO</th>
	<th>TITLE</th>
	<th>WRITER</th>
	<th>REGDATE</th>
	<th>MODDATE</th>
</tr>
<c:forEach items="${list }" var="tmp">
<tr>
	<td><a href="/brd/detail?bno=${tmp.bno }">${tmp.bno }</td></a>
	<td><a href="/brd/detail?bno=${tmp.title }">${tmp.title }</td></a>
	<td>${tmp.writer }</td>
	<td>${tmp.regdate }</td>
	<td>${tmp.moddate }</td>
</tr>
</c:forEach>
</table>
<a href="/index.jsp"><button type="button">index</button></a>
<a href="/board/register.jsp"><button type="button">글 등록</button></a>
</body>
</html>