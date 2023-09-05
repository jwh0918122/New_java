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
<h1>Board List Page</h1>
<table border="1">
<tr>
	<th>BNO</th>
	<th>TITLE</th>
	<th>WRITER</th>
	<th>REG_DATE</th>
</tr>
<!-- DB의 전체 리스트를 반복 c:foreach -->
	<c:forEach items="${list }" var="bvo">
		<tr>
		<!-- href="/brd/detail" => 컨트롤러의 detail메서드로 이동(?bno => 갈때 파라미터로 bno를 달고감)-->
		<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.bno }</a></td>  
		<td><a href="/brd/detail?bno=${bvo.bno }">${bvo.title }</a></td>
		<td>${bvo.writer }</td>
		<td>${bvo.regdate }</td>		
		</tr>
	</c:forEach>
</table>
<a href="/index.jsp"><button type="button">index</button></a>
<a href="/brd/register"><button type="button">regiter</button></a>


</body>
</html>