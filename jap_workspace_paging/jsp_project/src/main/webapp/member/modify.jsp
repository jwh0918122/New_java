<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Modify Page</title>
</head>
<body>
<h1>Member Modify Page</h1>
<form action="mem/update">
ID <input type="text" name="id" readonly="readonly" value="${ses.id }"><br>
PW <input type="text" name="pwd" value="${ses.pwd }"><br>
AGE <input type="number" name="age" value="${ses.age }"><br>
EMAIL <input type=""text"" name="email" value="${ses.email }"><br>
<button type="submit">수정</button><br>
</form>


</body>
</html>