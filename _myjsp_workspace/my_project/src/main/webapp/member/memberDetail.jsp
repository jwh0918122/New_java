<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Detail Page</title>
</head>
<body>
<h1>Member Detail Page</h1>
<table border="1">
<tr>
<th>ID</th>
<td>${mvo.id }</td>
</tr>
<tr>
<th>PW</th>
<td>${mvo.pw }</td>
</tr>
<tr>
<th>NAME</th>
<td>${mvo.name }</td>
</tr>
<tr>
<th>AGE</th>
<td>${mvo.age }</td>
</tr>
<tr>
<th>GENDER</th>
<td>${mvo.gender }</td>
</tr>
<tr>
<th>REG_DATE</th>
<td>${mvo.regDate }</td>
</tr>
<tr>
<th>LAST_LOGIN</th>
<td>${mvo.lastLogin }</td>
</tr>

</table>

</body>
</html>