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
		<h1 align="center">${ requestScope.message }</h1>
		
		<a href="${ pageContext.servletContext.contextPath }/project/list">프로젝트 목록으로 돌아가기</a>
		
	</section>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
<style>
	section{
		margin: 0 200px 0 200px;
	}
</style>
</html>
