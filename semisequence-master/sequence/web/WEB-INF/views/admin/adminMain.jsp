<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${ pageContext.servletContext.contextPath }/notice/list?page=1">공지사항 페이지로</a> <br>
	<a href="${ pageContext.servletContext.contextPath }/adminQuestionList">1:1문의 목록으로</a> <br>
	<a href="${ pageContext.servletContext.contextPath }/admin/membermanagement">이용자 제재 페이지로</a> <br>
	<a href="${ pageContext.servletContext.contextPath }/admin/entRegist/approval">기업 신청 승인</a> <br>
	<a href="/WEB-INF/views/main.jsp">메인페이지로</a> <br>
</body>
<style>
	body{
		background-color: black;
		
	}
	a{
		color: white;
	}
</style>
</html>