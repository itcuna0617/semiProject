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
		<h3>공지사항 등록</h3>
		<br>
		<form action="${ pageContext.servletContext.contextPath }/notice/insert" method="post">
			
			구인 공고 제목 : <input type="text" name="noticeTitle" maxlength="20" size="20" value="${ requestScope.notice.noticeTitle }"><br>
			
			공지 상세 내용 <br>
			<textarea rows="15" cols="40" name="noticeContent" maxlength="1000">${ requestScope.notice.noticeContent }</textarea><br>
			<input type="hidden" name="noticeNo" value="${ requestScope.notice.noticeNo }">
			<button>등록</button> 
			
			<button type="button" onclick="location.href='${ pageContext.servletContext.contextPath }/notice/list'">취소</button>
			
			
		</form>
</body>
<style>
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