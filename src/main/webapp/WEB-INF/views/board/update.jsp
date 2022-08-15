<%@page import="com.gang.start.board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%BoardDTO boardDTO = new BoardDTO(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    .align-center {text-align: center;}
</style>
<body>
	<form action="update.gang" class="align-center" method="post">
		<div>
		<h1>Update Page</h1>
		</div>
		num<br>
		<input type="text" name="num" readonly="readonly" value="${board.num }"><br>
		title<br>
		<input type="text" name="title" value="${board.title }"><br><br>
		contexts<br>
		<input type="text" name="contexts" value="${board.contexts }">
		<!--<textarea rows="70p" cols="100p" name="contexts" value="${board.contexts }"></textarea> -->
		<br>
		<input type ="submit" value="Update">
	<br>
	
	</form>

</body>
</html>