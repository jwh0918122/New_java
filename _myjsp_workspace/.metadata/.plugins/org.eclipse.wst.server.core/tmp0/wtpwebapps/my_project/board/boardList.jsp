<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List Page</title>
</head>
<body>
<h1>Board List Page</h1>
<!-- 검색 구역 -->
<div>
<form action="brd/brdList">
	<c:set value="${ph.pgv.type }" var="typed"></c:set>
	<select name="type">
		<option ${typed==null? 'selected':'' }>Choose...</option>
		<option value="t" ${typed eq 't'? 'selected':'' }>title</option>
		<option value="w" ${typed eq 'w'? 'selected':'' }>writer</option>
		<option value="c" ${typed eq 'c'? 'selected':'' }>content</option>
		<option value="tw" ${typed eq 'tw'? 'selected':'' }>title+writer</option>
		<option value="twc" ${typed eq 'twc'? 'selected':'' }>title+writer+content</option>
	</select>
	<input type="text" name="keyword" value="${ph.pgv.keyword }">
	<input type="hidden" name="paginaionNo" value="${ph.pgv.paginaionNo }">
	<input type="hidden" name="qty" value="${ph.pgv.qty }">
	<button type="submit">검색</button>
	${ph.totalCnt }
</form>
</div>
<!-- 검색 구역 끝 -->
<hr>
<table border="1">
<tr>
<th>BNO</th>
<th>TITLE</th>
<th>WRITER</th>
<th>REG_DATE</th>
<th>MOD_DATE</th>
<th>VIEW_CNT</th>
</tr>

<c:forEach items="${list }" var="tmp">
<tr>
<td><a href="brd/boardDetail?bno=${tmp.bno }">${tmp.bno }</a></td>
<td><a href="brd/boardDetail?bno=${tmp.bno }">${tmp.title }</a></td>
<td><a href="brd/boardDetail?bno=${tmp.bno }">${tmp.writer }</a></td>
<td><a href="brd/boardDetail?bno=${tmp.bno }">${tmp.regDate }</a></td>
<td><a href="brd/boardDetail?bno=${tmp.bno }">${tmp.modDate }</a></td>
<td><a href="brd/boardDetail?bno=${tmp.bno }">${tmp.viewCnt }</a></td>
</tr>
</c:forEach>
</table>

<!-- 페이지네이션 구역 -->
<div>
<c:if test="${ph.prev}">
<a href="/brd/brdList?paginaionNo=${ph.startPagination-1 }&qty=${ph.pgv.qty}&type=${ph.pgv.type}&keyword=${ph.pgv.keyword}"> ◁ | </a>
</c:if>
<c:forEach begin="${ph.startPagination}" end="${ph.endPagination}" var="i">
<a href="/brd/brdList?paginaionNo=${i }&qty=${ph.pgv.qty}&type=${ph.pgv.type}&keyword=${ph.pgv.keyword}">${i } </a>
</c:forEach>
<c:if test="${ph.next}">
<a href="/brd/brdList?paginaionNo=${ph.endPagination+1 }&qty=${ph.pgv.qty}&type=${ph.pgv.type}&keyword=${ph.pgv.keyword}"> | ▷ </a>
</c:if>
</div>
<a href="/index.jsp"><button type="button">index로 이동</button></a>

</body>
</html>