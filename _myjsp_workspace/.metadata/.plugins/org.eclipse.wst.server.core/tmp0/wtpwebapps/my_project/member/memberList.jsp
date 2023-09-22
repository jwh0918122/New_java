<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List Page</title>
</head>
<body>
	<h1>Member List Page</h1>
	<!-- 검색 구역 -->
	<div>
	<form action="/mem/memList">
	<c:set value="${ph.pgv.type }" var="typed"></c:set>
	<select name="type">
	<option ${typed==null? 'selected':'' }>Choose...</option>
	<option value="i" ${typed eq 'i'? 'selected':'' }>id</option>
	<option value="n"  ${typed eq 'n'? 'selected':'' }>name</option>
	<option value="a"  ${typed eq 'a'? 'selected':'' }>age</option>
	<option value="g"  ${typed eq 'g'? 'selected':'' }>gender</option>
	<option value="na"  ${typed eq 'na'? 'selected':'' }>name+age</option>
	<option value="nag"  ${typed eq 'nag'? 'selected':'' }>name+age+gender</option>

		
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
			<th>ID</th>
			<th>NAME</th>
			<th>AGE</th>
			<th>GENDER</th>
		</tr>
		<c:forEach items="${list}" var="tmp">
			<tr>
				<td>
				<a href="/mem/memDetail?id=${tmp.id }">${tmp.id }</a>
				</td>
				<td>
				<a href="/mem/memDetail?id=${tmp.id }">${tmp.name }</a>
				</td>
				<td>
				<a href="/mem/memDetail?id=${tmp.id }">${tmp.age }</a>
				</td>
				<td>
				<a href="/mem/memDetail?id=${tmp.id }">${tmp.gender }</a>
				</td>
				</tr>
		</c:forEach>
		</table>

<div>
		<!-- 페이지네이션 구역 -->
		<!-- prev -->
		<c:if test="${ph.prev }">
			<a href="/mem/memList?paginaionNo=${ph.startPagination-1 }&qty=${ph.pgv.qty}&type=${ph.pgv.type}&keyword=${ph.pgv.keyword}">◁ | </a>
		</c:if>
		<!-- 페이지네이션 번호 -->
		<c:forEach begin="${ph.startPagination }" end="${ph.endPagination }" var="i">
			<a href="/mem/memList?paginaionNo=${i }&qty=${ph.pgv.qty}&type=${ph.pgv.type}&keyword=${ph.pgv.keyword}">${i }</a>
		</c:forEach>
		<!-- next -->
		<c:if test="${ph.next }">
			<a href="/mem/memList?paginaionNo=${ph.endPagination+1 }&qty=${ph.pgv.qty}&type=${ph.pgv.type}&keyword=${ph.pgv.keyword}"> | ▷  </a>
		</c:if>
		<!-- 페이지네이션 끝 -->
</div>
		<a href="/index.jsp"><button>index로 이동</button></a>
</body>
</html>