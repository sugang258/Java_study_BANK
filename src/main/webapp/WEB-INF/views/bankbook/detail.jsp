<%@page import="com.gang.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% BankBookDTO bankbookDTO = (BankBookDTO) request.getAttribute("dto"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Detail</h1>
	<% if (bankbookDTO != null) { %>
	
	<table border = "4">
	
		<tr>
		<th>num</th>
		<th>name</th>
		<th>rate</th>
		<th>sale</th>
		
		</tr>
		<tr>
		<td><%= bankbookDTO.getBooknum() %> </td>
		<td><%= bankbookDTO.getBookname() %> </td>
		<td><%= bankbookDTO.getBookrate() %> </td>
		<td><% if (bankbookDTO.isBookSale() == true) { %>
		판매중
		<% } else { %>
		판매금지
		<% } %>
		
		</td>
		
		</tr>
	</table>
	<% }else { %>
	<h3>data가 없다</h3>
	<% } %>
	<a href="./list">리스트보기</a>
	<input type="button" value="뒤로가기" onClick="location.href='list'">
	<!-- 상대경로 -->
	<a href = "../member/login" >Login</a>
	<!-- 절대경로 -->
	<a href ="../member/join">Join</a>

</body>
</html>