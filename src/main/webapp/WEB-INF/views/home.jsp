<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p><img src ="resources/image/chunsik.png" height="200"> </p>

<c:if test="${empty sessionScope.member}" >
<a href="./member/login.gang">Login</a>
<a href="./member/join.gang">Join</a>
</c:if>

<c:if test="${not empty sessionScope.member}">
<h3>${sessionScope.member.userName}님 환영합니다.</h3>
<a href="./member/logout.gang">Logout</a>
<a href="#">MyPage</a>
</c:if>


<a href="./member/search.gang">Search</a>
<a href="./bankbook/list.gang">List</a>
<a href ="./bankbook/detail.gang">Detail</a>
<a href ="./bankbook/add.gang">BankBook 상품등록</a>
<a href ="./board/list.gang">게시판 목록 보기</a>
</body>
</html>
