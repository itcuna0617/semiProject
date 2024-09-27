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
	
	<div>
		<form action="${ pageContext.servletContext.contextPath }/user/info" method="get">		<!-- 구현 x로 회원정보로 이동하게 했음 -->
			<table>
				<tr>
					<td> 결제금액 </td>
					<td><input type="number" name="payment"> 원</td>		<!-- 10000원 단위로 입력받아야함 -->
				</tr>
			</table>
			<br>
			<div>
				<button type="submit">결제하기</button>					<!-- 결제API사용 (이후 구현 x) -->
			</div>
		</form>
	</div>
	
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>