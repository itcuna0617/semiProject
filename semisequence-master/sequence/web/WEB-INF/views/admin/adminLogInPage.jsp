<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>관리자 로그인</h1>
	<form action="${ pageContext.servletContext.contextPath }/redHoundBlueBird" method="post">
		비밀번호 입력 : <input type="password" name="password">
	</form>
</body>
<style>
	body{
		background-color: black;
		color: white;
	}
	h1{
		color: white;
	}
</style>
</html>