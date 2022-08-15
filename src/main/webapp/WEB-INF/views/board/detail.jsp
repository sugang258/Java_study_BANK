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
	<h1>Board Detail</h1>
	
	<table border = "1">
	
	<tr>
	<th>num</th>
	<th>title</th>
	<th>contexts</th>
	<th>username</th>
	<th>textDate</th>
	<th>views</th>
	
	</tr>
	<tr>
	<td>${board.num }</td>
	<td>${board.title }</td>
	<td>${board.contexts }</td>
	<td>${board.userName }</td>
	<td>${board.textDate }</td>
	<td>${board.views }</td>
	</tr>
	</table>
	
	<a href="./update.gang?num=${board.num}">글 수정하기</a>
	<a href="./delete.gang?num=${board.num}">글 삭제하기</a>

</body>
</html>