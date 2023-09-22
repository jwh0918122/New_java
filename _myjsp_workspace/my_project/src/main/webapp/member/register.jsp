<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Page</title>
</head>
<body>
<h1> register Page </h1>
<form action="/mem/join">
이름 : <input type="text" name="name"><br>
나이 : <input type="number" name="age"><br>
성별 : 
<input type="radio" name="gender" id="m" value="m">
<label for="m">남</label>
<input type="radio" name="gender" id="g" value="g">
<label for="g">여</label><br>
연락처 : <input type="text" name="phone"><br>
사용할 아이디 : <input type="text" name="id"><br>
사용할 비밀번호 : <input type="text" name="pw"><br>
<button type="submit">회원가입</button>
</form>

</body>
</html>