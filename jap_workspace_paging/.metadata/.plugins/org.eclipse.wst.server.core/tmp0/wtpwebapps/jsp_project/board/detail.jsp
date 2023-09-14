<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Detail Page</title>
</head>
<body>
	<h1>Board Detail Page</h1>
	<table border="1">
		<tr>
			<th>BNO</th>
			<td>${bvo.bno }</td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td>${bvo.title }</td>
		</tr>
		<tr>
			<th>WRITER</th>
			<td>${bvo.writer }</td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td>${bvo.content }</td>
		</tr>
		<tr>
			<th>REG_DATE</th>
			<td>${bvo.regdate }</td>
		</tr>
		<tr>
			<th>MOD_DATE</th>
			<td>${bvo.moddate }</td>
		</tr>
	</table>
	
	<a href="/brd/modify?bno=${bvo.bno }"><button>수정</button></a>
	<a href="/brd/remove?bno=${bvo.bno }"><button>삭제</button></a>
	<a href="/brd/pageList"><button>목록으로</button></a>
	<a href="/index.jsp"><button>인덱스로</button></a>


</body>
</html>