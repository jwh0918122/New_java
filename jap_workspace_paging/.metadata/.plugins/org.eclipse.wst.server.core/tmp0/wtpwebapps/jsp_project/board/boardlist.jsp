<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List Page</title>
</head>
<body>
	<h1>Board List Page</h1>
	<table border="1">
		<tr>
			<th>BNO</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<th>REG_DATE</th>
			<th>MOD_DATE</th>
		</tr>
		<c:forEach items="${ list}" var="tmp">
			<tr>
				<td><a href="/brd/detail?bno=${tmp.bno }">${tmp.bno }</a></td>
				<td><a href="/brd/detail?bno=${tmp.bno }">${tmp.title }</a></td>
				<td>${tmp.writer }</td>
				<td>${tmp.regdate }</td>
				<td>${tmp.moddate }</td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>