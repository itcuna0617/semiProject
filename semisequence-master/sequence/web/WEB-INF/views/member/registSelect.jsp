<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/registSelect.css" type="text/css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<section>
		<h1>회원가입</h1>
		<a href="${ pageContext.servletContext.contextPath }/registMember"><div><h2>개인회원</h2></div></a>
		<a href="${ pageContext.servletContext.contextPath }/registEnt"><div><h2>기업회원</h2></div></a>
	</section>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>