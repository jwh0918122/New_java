<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Register Page</title>
</head>
<body>
	<h1>Board Register Page(글쓰기)</h1>
	<form action="/brd/insert" method="post" enctype="multipart/form-data"> 
		제목 :<input type="text" name="title"><br> 
		작성자 :<input type="text" name="writer" value="${ses.id }" readonly="readonly"><br>
		내용 :<textarea rows="3" cols="30" name="content"></textarea><br>	
		이미지 파일: <input type="file" name="image_file" 
		accept="image/png, image/jpg, image/jpeg, image/gif">
		<button type="submit">글 등록</button>
	</form>
</body>
</html>