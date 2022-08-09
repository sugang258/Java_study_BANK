<%@page import="com.gang.start.bankbook.BankBookDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%ArrayList<BankBookDTO> ar = (ArrayList<BankBookDTO>) request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BankBook List</h1>
	<!-- /bankbook/list -->
	
	<!-- /bankbook/detail jsp:detail.jsp  -->
	<!-- link 주소는 상대경로 작성 -->
	<table border = "1">
		</thead>
		<tr>
			<th> name </th> <th> rate </th>
			
		</tr>
		
		</thead>
		
		<tbody>
			<tr>
				<td>name1</td>
				<td>0.012</td>
			</tr>
			
			<tr>
				<td>name2</td>
				<td>0.133</td>
			</tr>
			
			<% for (BankBookDTO bankbookDTO : ar) { %>
			
			<tr>
			<td><a href ="./detail?bookNum=<%=bankbookDTO.getBooknum() %>"><%= bankbookDTO.getBookname() %></a> </td>
			<td><%= bankbookDTO.getBookrate() %></td>
			</tr>
			<%} %>
				
		</tbody>
			
			
	
	</table>
	

</body>
</html>