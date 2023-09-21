<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index page</title>
</head>
<body>
	<h1> Index Page </h1>
	<c:if test="${ses.id eq null}">
	<form action="mem/login" method="post"> <!-- mem컨트롤러의 메서드로 이동 -->
	ID : <input type="text" name="id"><br>
	PW : <input type="text" name="pwd"><br>
	<button type="submit">login</button>
	</form>
	</c:if>
	<hr>
	<div>
	<c:if test="${ses.id ne null }">
	${ses.id }님 login 하였습니다.<br>
	계정 생성일 : ${ses.regdate }<br>
	마지막 접속 : ${ses.lastlogin }<br>
	<hr>
	<a href="/mem/modify"><button type="button">회원정보 수정</button></a>
	<a href="/mem/list"><button type="button">회원 리스트</button></a>
	<a href="/mem/logout"><button type="button">로그아웃</button></a>
	<a href="/mem/remove"><button type="button">회원탈퇴</button></a>
	<a href="/brd/register"><button type="button">글 쓰기</button></a>
	</c:if>	
	</div>
	
	<hr>
	<a href="/mem/join"><button type="button">회원가입</button></a>
	<a href="/brd/pageList"><button type="button">게시판으로 이동</button></a>
	
	
	<script type="text/javascript">
	const login_msg=`<c:out value="${login_msg}"/>`; 
	consol.log(login_msg);
	if(login_msg=='0'){
		alert("로그인 정보가 일치하지 않습니다.")
	}
	</script>
	
	
	
	
	
	
</body>
</html>