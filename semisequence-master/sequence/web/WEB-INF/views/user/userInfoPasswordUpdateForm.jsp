<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/userCss/userInfoPasswordUpdateForm.css" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<div class="title">
		<p>비밀번호 변경</p>
	</div>
	
	<div class="userMyPageWrap">
		<div class="userMyPageRoot">
			<p>홈 / 마이페이지 / 계정설정 / 비밀번호 변경</p>
		</div>
	
		<div>
			<form action="${ pageContext.servletContext.contextPath }/user/info/password/update" method="post">		
				<table class="member-setting">
				
					<tr>
						<td>현재 비밀번호</td>
						<td><input type="password" size="30" name="userBeforePassword" id="userBeforePassword"></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" size="30" name="userPassword" id="userPassword"></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" size="30" name="userPassword2" id="userPassword2"></td>
					</tr>
					<tr>
						<td colspan="2" class="successMessage">
							<div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div>
							<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>
						</td>
					</tr>
				</table>
				<button type="submit" id="submit" disabled="disabled">변경하기</button>
			</form>
				<button onclick="location.href='${ pageContext.servletContext.contextPath }/user/info'">돌아가기</button>
			
		</div>
	</div>
	
	<script>
		$(function(){
			$("#alert-success").hide();
			$("#alert-danger").hide();
			$("input").keyup(function(){
				var userPassword = $("#userPassword").val();
				var userPassword2 = $("#userPassword2").val();
				if(userPassword !="" || userPassword2 !=""){
					if(userPassword == userPassword2){
						$("#alert-success").show();
						$("#alert-danger").hide();
						$("#submit").removeAttr("disabled");
					} else{
						$("#alert-success").hide();
						$("#alert-danger").show();
						$("#submit").attr("disabled", "disabled");
					}
				}
			});
		});	
	</script>
	
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>