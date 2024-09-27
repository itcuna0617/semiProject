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
	
	<h2>충전 잔액 : 50000원</h2>
	
	<h2>최근 충전 내역 : </h2>
	<h2>최근 이용 내역 : </h2>
	
	<button onclick="location.href='${ pageContext.servletContext.contextPath }/user/payment'">금액충전</button>
	
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>