<%@page import="com.gang.start.board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%ArrayList<BoardDTO> ar = (ArrayList<BoardDTO>) request.getAttribute("board"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시판 목록</h1>
<table border = "1">
	<thead>
	<tr>
		<th> num </th> <th> title </th> <th> username </th> <th>textDate</th> <th> views </th>
	</tr>
	</thead>
	
	<tbody>
<!--  
	<c:forEach items="${requestScope.board }" var="board">
	<tr>
	<td>${pageScope.board.num }</td>
	<td>${pageScope.board.title }</td>
	<td>${pageScope.board.userName }</td>
	<td>${pageScope.board.textDate }</td>
	<td>${pageScope.board.views }</td>
	</tr>
	</c:forEach> -->
	<% for (BoardDTO boardDTO : ar) { %>
	<tr>
	<td><a href ="./detail.gang?num=<%= boardDTO.getNum() %>"><%= boardDTO.getNum() %></a></td>
	<td><%= boardDTO.getTitle() %></td>
	<td><%= boardDTO.getUserName() %></td>
	<td><%= boardDTO.getTextDate() %></td>
	<td><%= boardDTO.getViews() %></td>
	</tr>
	<%} %>
	
	</tbody>
</table>
<c:if test="${not empty sessionScope.member}">
<a href="./add.gang">글 작성하기</a>
</c:if>

</body>
</html>