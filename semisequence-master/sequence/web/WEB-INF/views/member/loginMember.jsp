<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/loginMember.css" type="text/css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="loginForm">
		<h1>로그인</h1>
		<form action="${pageContext.servletContext.contextPath}/member/login" method="post">
			<table class="loginInputTable">
				<tr>
					<td>아이디</td>
				</tr>
				<tr>
					<td><input type="text" name="userId" id="userId" placeholder="아이디를 입력해 주세요."/></td>
				</tr>
				<tr>
					<td>비밀번호</td>
				</tr>
				<tr>
					<td><input type="password" name="userPassword" id="userPassword" placeholder="비밀번호를 입력해 주세요."/></td>
				</tr>
			</table>
			<br>
			<a class="findPassword" href="${ pageContext.servletContext.contextPath }/memberFindPassword">비밀번호 찾기</a>
			<br>
			<br>
			<input type="radio" id="user" name="userType" value="user" checked="checked">
        	<label for="user">개인회원</label>
        	<input type="radio" id="ent" name="userType" value="ent">
        	<label for="ent">기업회원</label>
			<br>
			<br>
			<button type="submit">로그인</button>
		</form>
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>