<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Member Modify Page</h1>
<form action="/mem/update" method="post">
	ID : <input type="text" name="id" value="${ses.id }" readonly="readonly"><br>
	PW : <input type="text" name="pwd" value="${ses.pwd }" ><br>
	EMAIL : <input type="text" name="email" value="${ses.email }" ><br>
	AGE : <input type="text" name="age" value="${ses.age }" ><br>
	
	<button type="submit">수정</button>
</form>
	<a href="mem/remove"><button type="button">회원탈퇴</button></a>
</body>
</html>