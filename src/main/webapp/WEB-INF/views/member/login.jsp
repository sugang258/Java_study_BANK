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
	<form class="align-center" action ="login" method = "post">
	<h1>login page</h1>
        
      <!-- <img src="../Study/images/chunsik.png" width="200dp"><br>  -->  
        <a href="/index">Index Page</a><br>
        ID를 입력하세요<br>
        <input type="text" name="id" placeholder="id를 입력하세요"><br>
        PW를 입력하세요<br>
        <input type="text" name="pw" placeholder="pw를 입력하세요"><br>

        <input type="submit" value="로그인" onclick="alert('로그인되었을까요?')">
        <input type="button" name="join" value="회원가입" onclick="location.href='join'"/>
    </form>
</body>
</html>