<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	<form action="add.gang" class="align-center" method="post">
	<h1> 글 작성</h1>
	title<br>
	<input type="text" name="title" value="${board.title }"><br><br>
	contexts<br>
	<input type="text" name="contexts" value="${board.contexts }">
	
	<br>
	<input type="submit" value="글 게시하기">
	
	</form>

</body>
</html>