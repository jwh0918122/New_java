<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Board Register Page</h1>
<hr>
<form action="/brd/insert"> <!-- controller의 insert메서드로 이동 -->
제목 : <input type="text" name="title"><br>
작성자 : <input type="text" name="writer" value="${ses.id }" readonly="readonly"><br>
내용 : <textarea rows="3" cols="30" name="content"></textarea><br>
<button type="submit">등록</button>
</form>
</body>
</html>