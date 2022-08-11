<%@page import="com.gang.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%BankBookDTO bankBookDTO = new BankBookDTO(); %>
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
	<form action="update" class="align-center" method="post" >
		<div>
		<h1>Update Page</h1>
		</div>
		BookNum<input type="text" name="booknum" readonly="readonly" value="${dto.booknum}" >
		<div>
		BookName<input type="text" name="bookname" value = "${dto.bookname}">
		</div>
		<div>
		BookRate<input type="text" name="bookrate" value = "${dto.bookrate}">
		</div>
		<input type ="submit" value="Update">
	
</form>
</body>
</html>