<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/entPasswordUpdate.css" type="text/css"/>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="entTitle">
		<p>비밀번호 변경</p>
	</div>
	<div class="entSettingWrap">
		<div class="entSettingRoot">
			<p>홈/마이페이지/계정설정/비밀번호 변경</p>
		</div>
	<div>
		<form name="frm" action="${ pageContext.servletContext.contextPath }/ent/passwordsetting" method="post">		
			<table class="member-setting">
				<tr>
					<td>현재 비밀번호</td>
					<td><input type="password" size="30" name="nowPassword" id="nowPassword"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" size="30" name="entPassword" id="entPassword"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" size="30" name="entPassword2" id="entPassword2"></td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div>
						<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>
					</td>
				</tr>
			</table>
			<button type="button" id="update-button" disabled="disabled">변경하기</button>
		</form>
		<button onclick="location.href='${ pageContext.servletContext.contextPath }/ent/setting'">돌아가기</button>
	</div>
	</div>
	<script>
    	$("#update-button").on("click", function(){
         	if($("#nowPassword").val() =="" || $("#entPassword").val()=="" || $("#entPassword2").val()==""){
            	alert("모든 값을 작성해주세요");
            	console.log("dkdk");
         	} else{
            	frm.submit();
         	}
      	});
   	</script>
	<script>
		$(function(){
			$("#alert-success").hide();
			$("#alert-danger").hide();
			$("input").keyup(function(){
				var entPassword = $("#entPassword").val();
				var entPassword2 = $("#entPassword2").val();
				if(entPassword !="" || entPassword2 !=""){
					if(entPassword == entPassword2){
						$("#alert-success").show();
						$("#alert-danger").hide();
						$("#update-button").removeAttr("disabled");
					} else{
						$("#alert-success").hide();
						$("#alert-danger").show();
						$("#update-button").attr("disabled", "disabled");
					}
				}
			});
		});	
	</script>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>