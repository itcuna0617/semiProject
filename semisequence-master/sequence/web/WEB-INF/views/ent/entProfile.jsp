<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<div class="profile-wrap">
	<form name="frm" action="${ pageContext.servletContext.contextPath }/ent/profile" method="post" encType="multipart/form-data">	<!-- input type="file"인 태그가 하나라도 있다면 무조건 encType="multipart/form-data" 를 추가해야함 -->
			<table class="profile-info">
				<tr>
					<td>대표 사진</td>
					<td>기업 정보(수정 불가)</td>
				</tr>
				<tr>
					<td rowspan="4">
						<div class="title-img-area" id="titleImgArea">
							<img id="titleImg" width="240" height="160">
						</div>
					</td>
					<td>기업명</td>
					<td>대표번호</td>
				</tr>
				<tr>
					<td><input type="text" name="entName" value="${ sessionScope.entName }" disabled="disabled"/></td>
					<td colspan="2"><input type="text" name="entPhone" value="${ sessionScope.entPhone }" disabled="disabled"/></td>
				</tr>
				<tr>
					<td colspan="2">대표 메일</td>
				</tr>
				<tr>
					<td colspan="2"><input type="text" name="entEmail" value="${ sessionScope.entEmail }" disabled="disabled"//></td>
				</tr>
			</table>
			<h1>기업 소개</h1>
			<textarea id="ent-introduce" cols="50" rows="20" name="entIntroduce"></textarea>
			<h1>기업 이력</h1>
			<textarea id="ent-history" cols="50" rows="20" name="entHistory"></textarea>
		<button class="profile-update-button" type="button">프로필 등록</button>
		<div class="thumbnail-file-area">
			<input type="file" id="thumbnailImg1" name="thumbnailImg1" onchange="loadImg(this)" >
		</div>
	</form>
	</div>
	<script>
    	$(".profile-update-button").on("click", function(){
         	if($("#thumbnailImg1").val() =="" || $("#ent-introduce").val()=="" || $("#ent-history").val()==""){
            	alert("모든 값을 작성해주세요");
            	console.log("dkdk");
         	} else{
            	frm.submit();
         	}
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
			
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>