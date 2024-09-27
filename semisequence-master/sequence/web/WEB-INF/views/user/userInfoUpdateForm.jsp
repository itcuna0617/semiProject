<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/userCss/userInfoUpdateForm.css" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<div class="title">
		<p>회원 정보 수정</p>
	</div>
	
	
	<div class="userMyPageWrap">
		<div class="userMyPageRoot">
			<p>홈 / 마이페이지 / 계정설정 / 회원정보수정</p>
		</div>
		<div>
			<form action="${ pageContext.servletContext.contextPath }/user/info/update" method="post">
				<table class="member-setting">
					<tr>
						<td> 이름 </td>
						<td><input type="text" size="30" name="userName" value="${ requestScope.userInfo.userName }"></td>
					</tr>
					<tr>
						<td> 이메일 </td>
						<td><input type="email" size="30" name="userEmail" value="${ requestScope.userInfo.userEmail }"></td>
					</tr>
					<tr>
						<td> 연락처 </td>
						<td><input type="text" size="30" name="userPhone" value="${ requestScope.userInfo.userPhone }"></td>
					</tr>
				</table>
				<br>
				<div>
					<button type="submit">수정하기</button>
				</div>
			</form>
			<button onclick="location.href='${ pageContext.servletContext.contextPath }/user/info'">돌아가기</button>
		</div>
	</div>
	
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>