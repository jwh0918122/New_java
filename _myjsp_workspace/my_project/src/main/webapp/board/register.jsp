<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Register Page</title>
</head>
<body>
<h1>Board Register Page</h1>

<form action="/brd/write">
 <table border="1">
 <tr>
 <th>TITLE</th>
 <td><input type="text" name="title"></td>
 </tr>
  <tr>
 <th>WRITER</th>
 <td><input type="text" name="writer" value="${ses.id }" readonly="readonly"></td>
 </tr>
  <tr>
 <th>CONTENT</th>
 <td><textarea rows="3" cols="30" name="content"></textarea> </td>
 </tr>
 </table>
 <button type="submit">글 등록</button>
 </form>

</body>
</html>