<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<h1>등급</h1>
	<p>이시원 고객님은 현재 4.0 등급입니다.</p>
	
	<h1>평균 평점</h1>
	<p> 3.7점</p>
	
	<h1>합격 합산</h1>
	<p> 총 78회</p>
	
	<h1>최근 평점 내역</h1>
	<button onclick="location.href='${ pageContext.servletContext.contextPath }/user/grade/posting/list'">구인 평점 확인</button>
	<button onclick="location.href='${ pageContext.servletContext.contextPath }/user/grade/application/list'">구직 평점 확인</button>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>