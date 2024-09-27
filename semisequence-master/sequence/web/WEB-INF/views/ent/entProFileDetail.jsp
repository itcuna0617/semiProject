<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/entProfile.css" type="text/css"/>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<script>
		<c:if test="${not empty requestScope.profStatusCode}">
			alert("${requestScope.profStatusCode}");
			/* location.href = "${ pageContext.servletContext.contextPath }/user/info" */
		</c:if>
	</script>
	<div class="profile-wrap">
	<form action="${ pageContext.servletContext.contextPath }/ent/profileupdate" method="post" encType="multipart/form-data">	<!-- input type="file"인 태그가 하나라도 있다면 무조건 encType="multipart/form-data" 를 추가해야함 -->
			<table class="profile-info">
				<tr class="profile-info-title">
					<td>대표 사진</td>
					<td>기업 정보(수정 불가)</td>
				</tr>
				<tr>
					<td rowspan="4">
						<div class="title-img-area" id="titleImgArea">
							<img id="titleImg" width="240" height="160" src="${ pageContext.servletContext.contextPath }${ requestScope.entProfile.entPhoto }">
						</div>
					</td>
					<td>기업명</td>
					<td>대표번호</td>
				</tr>
				<tr>
					<td><input type="text" name="entName" value="${ sessionScope.loginMember.entName }" disabled="disabled"/></td>
					<td colspan="2"><input type="text" name="entPhone" value="${ sessionScope.loginMember.entPhone }" disabled="disabled"/></td>
				</tr>
				<tr>
					<td colspan="2">대표 메일</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="entEmail" value="${ sessionScope.loginMember.entEmail }" disabled="disabled"//></td>
				</tr>
			</table>
			<h1 class="ent-title">기업 소개</h1>
			<textarea cols="50" rows="20" id="entIntroduce" name="entIntroduce" readonly>${ requestScope.entProfile.entIntro }</textarea>
			<h1 class="ent-title">기업 이력</h1>
			<textarea cols="50" rows="20" id="entHistory" name="entHistory" readonly>${ requestScope.entProfile.entResume }</textarea>
		<button id="update-submit" type="submit" style="display:none">수정 완료</button>
		<button id="update-cancle" type="button" style="display:none">취소 하기</button>
		<div class="thumbnail-file-area">
			<input type="file" id="thumbnailImg1" name="thumbnailImg1" onchange="loadImg(this)" >
		</div>
	</form>
	<button class="profile-update-button" id="profile-update" type="button">프로필 수정</button>
	</div>			
	<jsp:include page="../common/footer.jsp"/>
	<script>
		$("#profile-update").click(function() {
			$("#update-submit").show();
			$("#update-cancle").show();
			$("#profile-update").hide();
			
			$("#entIntroduce").attr("readonly", false);
			$("#entHistory").attr("readonly", false);
		});
		$("#update-cancle").click(function() {
			$("#update-submit").hide();
			$("#update-cancle").hide();
			$("#profile-update").show();
			
			$("#entIntroduce").attr("readonly", true);
			$("#entHistory").attr("readonly", true);
		});
	</script>
	<script>
		const $titleImgArea = document.getElementById("titleImgArea");
		
		$titleImgArea.onclick = function() { 
			document.getElementById("thumbnailImg1").click();
		}
		
		/* 이미지 미리보기 관련 함수(File API 활용하기) */
		function loadImg(value) {
			
			if (value.files && value.files[0]) {			// value.files[0]는 파일 이름
				const reader = new FileReader();
			
				reader.readAsDataURL(value.files[0]);		// Base64방식으로 파일을 FileReader에 전달 (Base64로 인코딩한 것은 브라우저가 원래 데이터로 만들게 됨)
				
				// load 이벤트의 핸들러로 읽기 동작이 성공적으로 완료 되었을 때마다 발생한다.
				reader.onload = function(e) {				// load EventListener에 function 등록 (FileReader에서 전달 받은 파일을 다 읽으면 리스너에 등록한 function이 호출 됨)
					console.log(e.target.result);		// e.target.result는 인코딩한 결과로 img태그의 src로 사용할 수 있음
					document.getElementById("titleImg").src = e.target.result;
	
				}
			}
		}
	</script>
</body>
</html>