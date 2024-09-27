<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/findPassword.css" type="text/css"/>
<meta charset="UTF-8">

<script type="text/javascript">
	if(!emailValCheck()){
		return false;
	}
	var url = "confirmEmail"
</script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="findPasswordForm">
		<h1>비밀번호 찾기</h1>
		<form action="${pageContext.servletContext.contextPath}/memberResetPassword" method="post">
			<table class="findPasswordInputTable">
				<tr>
					<td>아이디</td>
				</tr>
				<tr>
					<td><input type="text" name="userId" id="userId" placeholder="아이디를 입력해 주세요."/></td>
				</tr>
			</table>
			<br><br>
			<input type="radio" id="user" name="userType" value="user">
        	<label for="user">개인회원</label>
        	<input type="radio" id="ent" name="userType" value="ent">
        	<label for="ent">기업회원</label>
        	<br><br>
			<button type="submit">확인</button>
		</form>
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>