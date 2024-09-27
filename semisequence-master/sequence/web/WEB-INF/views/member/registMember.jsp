<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/registMember.css" type="text/css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="registForm">
		<h1>회원가입</h1>
		<form action="${pageContext.servletContext.contextPath}/member/regist" method="post">
			<table class="registInputTable">
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
				<tr>
					<td>이름</td>
				</tr>
				<tr>
					<td><input type="text" name="userName" id="userName" placeholder="이름을 입력해 주세요."/></td>
				</tr>
				<tr>
					<td>연락처</td>
				</tr>
				<tr>
					<td><input type="text" name="userPhone" id="userPhone" placeholder="휴대전화 번호를 입력하세요"/></td>
				</tr>
				<tr>
					<td>주소</td>
				</tr>
				<tr>
					<td><input type="text" name="userAdd" id="userAdd" placeholder="주소를 입력하세요"/></td>
				</tr>
				<tr>
					<td>이메일</td>
				</tr>
				<tr>
					<td><input type="email" name="userEmail" id="userEmail" placeholder="example@example.com"/></td>
				</tr>
			</table>
			<br>
			<br>
			<br>
			<button type="submit">회원가입</button>
		</form>
	</div>
	
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>