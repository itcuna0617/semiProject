<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/entIdDrop.css" type="text/css"/>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<script>
		<c:if test="${not empty requestScope.message}">
			alert("${requestScope.message}");
			/* location.href = "${ pageContext.servletContext.contextPath }/user/info" */
		</c:if>
	</script>
	<div class="entTitle">
		<p>회원 탈퇴</p>
	</div>
	<div class="entSettingWrap">
		<div class="entSettingRoot">
			<p>홈/마이페이지/계정설정/회원탈퇴</p>
		</div>
		<div>
			<h1 class="drop-info-title">탈퇴 안내 사항</h1>
			<div class="drop-info">
				<ol>
					<li>탈퇴시 충전 금액 및 결제 서비스 이용 권한은 소멸되며 환불받을 수 없습니다.</li>
					<li>위 내용에 모두 확인하였고 탈퇴에 동의합니다.</li>
				</ol>
			</div>
		</div>
		<form name="frm" action="${ pageContext.servletContext.contextPath }/ent/drop" method="post">
			<table class="drop-form">
				<tr>
					<td class="form-label">비밀번호</td>
					<td class="form-input"><input id="pass1" type="password" name="pass1"></td>
				</tr>
				<tr>
					<td class="form-label">비밀번호 확인</td>
					<td class="form-input"><input id="pass2" type="password" name="pass2"></td>
				</tr>
				<tr>
					<td colspan="2"><button id="drop-button" type="button">회원 탈퇴</button></td>
				</tr>
			</table>
		</form>
	</div>
	<script>
    	$("#drop-button").on("click", function(){
         	if($("#pass1").val() =="" || $("#pass2").val()==""){
            	alert("모든 값을 작성해주세요");
            	console.log("dkdk");
         	} else{
            	frm.submit();
         	}
      	});
   	</script>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>