<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/userCss/userInfo.css" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<!-- 회원정보 수정 완료 시 alert -->
	<script>
		<c:if test="${not empty requestScope.successCode}">
			alert("${requestScope.successCode}");
			location.href = "${ pageContext.servletContext.contextPath }/user/info"
		</c:if>
		<c:if test="${not empty requestScope.passwordFailCode}">
			alert("${requestScope.passwordFailCode}");
			location.href = "${ pageContext.servletContext.contextPath }/user/info"
		</c:if>
		
	</script>
	
	<div class="title">
		<p>계정설정</p>
	</div>
	
	<div class="userMyPageWrap">
		<div class="userMyPageRoot">
			<p>홈 / 마이페이지 / 계정설정</p>
		</div>

		<table class="member-setting">
			<tr>
				<td>이름</td>
				<td><p><c:out value="${ requestScope.userInfo.userName }"/></p></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><c:out value="${ requestScope.userInfo.userEmail }"/></td>
			</tr>
			<tr>
				<td>비밀 번호</td>
				<td>******</td>
				<td><button onclick="location.href='${ pageContext.servletContext.contextPath }/user/info/password/update'">비밀번호 수정</button></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td><c:out value="${ requestScope.userInfo.userPhone }"/></td>
			</tr>
			<tr>
				<td>정보수정</td>
				<td><button onclick="location.href='${ pageContext.servletContext.contextPath }/user/info/update?no=${ requestScope.userInfo.userNo }'">회원정보 변경</button></td>
			</tr>
			<tr>
				<td>회원탈퇴</td>
				<td><button onclick="location.href='${ pageContext.servletContext.contextPath }/user/delete?no=${ requestScope.userInfo.userNo }'">회원 탈퇴</button></td>
			</tr>
		</table>
		
	</div>
	

	
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>