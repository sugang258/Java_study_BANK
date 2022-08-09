<%@page import="com.gang.start.members.BankMembersDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%ArrayList<BankMembersDTO> ar = (ArrayList<BankMembersDTO>) request.getAttribute("join"); %>
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
	<form action="join" class="align-center" method="post">
	<h1>join page</h1>
        ID
        <input type="text" name="id" placeholder="id를 입력하세요"><br><br>
        PW
        <input type="text" name="pw" placeholder="pw를 입력하세요"><br><br>
        이름
        <input type="text" name="name" placeholder="이름을 입력하세요"><br><br>
        Email
        <input type="text" name="email" placeholder="Email을 입력하세요"><br><br>
        Phone
        <input type="text" name="phone" placeholder="Phone을 입력하세요"><br><br>
        <input type="submit" value="회원가입" onclick="location.href='login'">
        <input type="button" value="뒤로가기" onclick="location.href='login'">
        
    </form>

</body>
</html>