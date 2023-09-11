<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board list Page</title>
</head>
<body>
<table border="1">
<tr>
	<th>BNO</th>
	<th>TITLE</th>
	<th>WRITER</th>
	<th>REGDATE</th>
	<th>MODDATE</th>
</tr>
<c:forEach items="${list }" var="tmp">
<tr>
	<td><a href="/brd/detail?bno=${tmp.bno }">${tmp.bno }</a></td>
	<td><a href="/brd/detail?bno=${tmp.bno }">${tmp.title }</a></td>
	<td>${tmp.writer }</td>
	<td>${tmp.regdate }</td>
	<td>${tmp.moddate }</td>
</tr>
</c:forEach>
</table>
<!-- 페이지네이션 표시 구역 -->
<div>
	<!-- prev -->
	<c:if test="${ph.prev }">
	<a href="/brd/pageList?pageNo=${ph.startPage-1 }&qty=${ph.pgvo.qty}"> ◁ | </a>
	</c:if>
	<c:forEach begin="${ph.startPage }" end="${ph.endPage }" var="i">
	<a href="/brd/pageList?pageNo=${i }&qty=${ph.pgvo.qty}">${i } </a>
	</c:forEach>
	<!-- next -->
	<c:if test="${ph.next }">
	<a href="/brd/pageList?pageNo=${ph.endPage+1 }&qty=${ph.pgvo.qty}"> | ▷ </a>
	</c:if>
</div>
<!-- 페이지네이션 구역 끝 -->

<a href="/index.jsp"><button type="button">index</button></a>
<a href="/board/register.jsp"><button type="button">글 등록</button></a>
</body>
</html>