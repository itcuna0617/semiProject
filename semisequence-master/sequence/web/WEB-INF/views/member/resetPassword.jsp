<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/resetPassword.css" type="text/css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="resetPasswordForm">
		<h1>비밀번호 재설정</h1>
		<form action="${pageContext.servletContext.contextPath}/member/resetPassword" method="post">
			<table class="resetPasswordInputTable">
				<tr>
					<td>새 비밀번호</td>
				</tr>
				<tr>
					<td><input type="password" name="newPassword" id="newPassword" placeholder="새 비밀번호를 입력해 주세요."/></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
				</tr>
				<tr>
					<td><input type="password" name="passwordCheck" id="passwordCheck" placeholder="비밀번호 확인"/></td>
				</tr>
			</table>
			<br>
			<br>
			
			<button type="submit">확인</button>
		</form>
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>