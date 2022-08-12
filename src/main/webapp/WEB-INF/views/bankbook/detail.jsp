<%@page import="com.gang.start.bankbook.BankBookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
    <%
	//요청이 발생하면 생성, 응답이 나가면 소멸 : RequestScope 
    BankBookDTO bankbookDTO = (BankBookDTO) request.getAttribute("dto"); 
    %>
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook Detail</h1>
	<%-- <% if (bankbookDTO != null) { %> --%>
	
	<table border = "4">
	
		<tr>
		<th>num</th>
		<th>name</th>
		<th>rate</th>
		<th>sale</th>
		
		</tr>
		
		<tr>
		<td>${requestScope.dto.booknum}</td>
		<td>${requestScope.dto.bookname}</td>
		<td>${dto.bookrate}</td>
		<td>${dto.booksale}</td>
		<%-- <td><%= bankbookDTO.getBooknum() %> </td>
		<td><%= bankbookDTO.getBookname() %> </td>
		<td><%= bankbookDTO.getBookrate() %> </td> --%>
		<%-- <td><% if (${dto.bookrate} == true) { %>
		판매중
		<% } else { %>
		판매금지
		<% } %>
		
		</td> --%>
		
		</tr>
	</table>
	<%-- <% }else { %>
	<h3>data가 없다</h3>
	<% } %> --%>
	<a href="./list.gang">리스트보기</a>
	<input type="button" value="뒤로가기" onClick="location.href='list'">
	<!-- 상대경로 -->
	<a href = "../member/login.gang" >Login</a>
	<!-- 절대경로 -->
	<a href ="../member/join.gang">Join</a>
	<a href ="./update.gang?booknum=${dto.booknum}">Update</a>
	<a href ="./delete.gang?booknum=${dto.booknum }">Delete</a>
	<c:if test="${not empty sessionScope.member}">
	<a href ="../bankaccount/add.gang?bookNum=${dto.booknum }">가입하기</a>
	</c:if>
</body>
</html>