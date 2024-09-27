<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/registEnt.css" type="text/css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="registForm">
		<h1>기업회원가입</h1>
		<form action="${pageContext.servletContext.contextPath}/ent/regist" method="post" encType="multipart/form-data">
			<table class="registInputTable">
				<tr>
					<td>아이디</td>
				</tr>
				<tr>
					<td><input type="text" name="entId" id="entId" placeholder="아이디를 입력해 주세요."/></td>
				</tr>
				<tr>
					<td>비밀번호</td>
				</tr>
				<tr>
					<td><input type="password" name="entPassword" id="entPassword" placeholder="비밀번호를 입력해 주세요."/></td>
				</tr>
				<tr>
					<td>기업명</td>
				</tr>
				<tr>
					<td><input type="text" name="entName" id="entName" placeholder="기업명을 입력해 주세요."/></td>
				</tr>
				<tr>
					<td>이메일</td>
				</tr>
				<tr>
					<td><input type="email" name="entEmail" id="entEmail" placeholder="example@example.com"/></td>
				</tr>
				<tr>
					<td>대표번호</td>
				</tr>
				<tr>
					<td><input type="text" name="entPhone" id="entPhone" placeholder="대표번호를 입력하세요"/></td>
				</tr>
				<tr>
					<td>사업자등록증</td>
				</tr>
				<tr>
					<td><input type="file" id="enrollmentImg" name="enrollmentImg"></td>
				<tr>
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