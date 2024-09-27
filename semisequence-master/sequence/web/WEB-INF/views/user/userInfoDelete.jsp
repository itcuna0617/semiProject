<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/userCss/userInfoDelete.css" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<div class="title">
		<p>회원탈퇴</p>
	</div>
	
	<div class="userMyPageWrap">
		<div class="userMyPageRoot">
			<p>홈 / 마이페이지 / 계정설정 / 회원탈퇴</p>
		</div>
		<form action="${ pageContext.servletContext.contextPath }/user/delete" method="post">		
			<table class="member-setting">
				<tr>
					<td style="color:red;">탈퇴 안내사항</td>
					<td>
						<p>탈퇴시 충전 금액 및 결제 서비스 이용 권한은 소멸되며 환불받을 수 없습니다.</p>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" size="30" name="userPassword" id="userPassword"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" size="30" name="userPassword2" id="userPassword2"></td>
					
				</tr>
			</table>
			<div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div>
			<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>
			<br>
			<button type="submit" id="submit" disabled="disabled">탈퇴하기</button>
		</form>
			<button onclick="location.href='${ pageContext.servletContext.contextPath }/user/info'">돌아가기</button>
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