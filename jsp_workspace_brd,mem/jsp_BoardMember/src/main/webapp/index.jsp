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
<h1>Index Page</h1>

<form action="/mem/login" method="post"> <!--mem컨트롤러의 메서드로 이동  -->
	ID : <input type="text" name="id">
	PWD : <input type="text" name="pwd">
	<button type="submit">login</button>
</form>
<br>
<hr>
<div>
<c:if test="${ses.id ne null}" ><!-- session의 id가 null이 아니면(ne = not) -->
${ses.id } login 하였습니다.<br>
계정 생성일 : ${ses.regdate }<br>
마지막 접속 : ${ses.lastlogin }<br>
<hr>
<a href="/mem/modify"><button type="button">회원정보 수정</button></a><br>
<a href="/mem/list"><button type="button">회원리스트</button></a><br>
<a href="/mem/logout"><button type="button">로그아웃</button></a><br>
<a href="/brd/register"><button type="button">글 쓰기</button></a>
</c:if>
<hr>

</div>
<a href="/mem/join"><button type="button">회원가입</button></a><br>

<a href="/brd/pageList"><button type="button">리스트로 이동</button></a>

<%-- <c:out value="${msg_login }"></c:out> => c:out은 그냥 표현하는 것   --%>

<script type="text/javascript">
const msg_login = `<c:out value="${msg_login}"/>`;/*스크립트에서는 c:out이 안되서 이렇게 해야함  */
console.log(msg_login);
if(msg_login === '0'){
	alert("로그인 정보가 일치하지 않습니다.");
}
</script>


</body>
</html>