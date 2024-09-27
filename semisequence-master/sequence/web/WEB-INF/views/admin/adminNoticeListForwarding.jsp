<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>작업이 완료 되었습니다.</h1>
	<a href="${ pageContext.servletContext.contextPath }/notice/list?page=1">공지사항 목록으로 돌아가기</a>
</body>
<style>
	button{
		float: right;
		margin: 0 auto;
		margin-right: 10px;
	}
	table{
		color: black;
		margin: 0 auto;
		height: 700px;
	}
	tr{
		background-color: white;
	}
	td{
		width: 100px;
	}
	body{
		background-color: black;
		color: white;
	}
	h1{
		color: white;
	}
</style>
</html>