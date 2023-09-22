<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
	
	<h1> Index Page </h1>
	<c:if test="${ses.id eq null }">
	<form action="/mem/login">
	아이디 : <input type=text name="id"><br>
	비밀번호 : <input type="password" name="pw" ><br>
	<button type="submit">로그인</button>
	</form>
	<a href="mem/register"><button type="submit">회원가입</button></a>	
	</c:if>
	
	<c:if test="${ses.id ne null }">
	<a href="/mem/logout"><button type="button">로그아웃</button></a>
	<a href="/mem/memList"><button type="button">회원리스트</button></a>
	<a href="/mem/remove"><button type="button">회원탈퇴</button></a>
	<hr>
	<a href="/brd/register"><button type="button">글 쓰기</button></a>
	<a href="/brd/brdList"><button type="button">게시판</button></a>
	
	
	
	</c:if>
	
	
	
</body>
</html>