<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Join Page</title>
</head>
<body>
<h1>Member Join Page</h1>
<form action="mem/register"><br>
ID : <input type="text" name="id"><br>
PW : <input type="text" name="pwd"><br>
AGE : <input type="number" name="age"><br>
EMAIL : <input type="email" name="email"><br>
<button type="submit">회원가입</button>
</form>

</body>
</html>