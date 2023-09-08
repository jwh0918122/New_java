<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member List Page</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>PW</th>
			<th>EMAIL</th>
			<th>AGE</th>
			<th>REG_DATE</th>
			<th>LAST_LOGIN</th>
		</tr>
		<c:forEach items="${list }" var="tmp">
			<tr>
				<td>${tmp.id }</td>
				<td>${tmp.pwd }</td>
				<td>${tmp.email }</td>
				<td>${tmp.age }</td>
				<td>${tmp.regdate }</td>
				<td>${tmp.lastlogin }</td>
			</tr>

		</c:forEach>






	</table>

</body>
</html>