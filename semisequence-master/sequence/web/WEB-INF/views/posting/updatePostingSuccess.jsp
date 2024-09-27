<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<section>
		<br>
		<h1 align="center">공고 수정을 성공적으로 마쳤습니다.</h1>
		
		<a href="${ pageContext.servletContext.contextPath }/posting/list">공고 목록으로 돌아가기</a>
		
	</section>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
<style>
	section{
		margin: 0 200px 0 200px;
	}
</style>
</html>