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
	<form action="/brd/insert" method="post"><!-- href="/brd/insert" => 컨트롤러의 insert메서드로 이동 -->
		<br> title : <input type="text" name="title"><br>
		writer : <input type="text" name="writer"><br> 
		content : <textarea rows="3" cols="30" name="content"></textarea><br>
		<button type="submit">등록</button>

	</form>


</body>
</html>