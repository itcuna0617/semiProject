<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/userCss/userProfileInsert.css" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<div class="title">
		<p>프로필등록</p>
	</div>	
	
	<div class="userMyPageWrap">
		<div class="userMyPageRoot">
			<p>홈 / 마이페이지 / 프로필관리 / 프로필등록</p>
		</div>
     	<div>
			<form action="${ pageContext.servletContext.contextPath }/user/profile/insert" method="post" encType="multipart/form-data" name="frm">
				<div class="thumbnail-insert-area">
					<table class="protfolio-setting">
						<tr>
							<td>대표 사진</td>
							<td colspan="3">
								<div class="title-img-area" id="titleImgArea">
									<img id="userProfilePhoto" width="350" height="200" >
								</div>
							</td>
							<td><p>(JPG, PNG 파일만 선택 가능)</p></td>
						</tr>
						<tr>
							<td>미니프로필 제목</td>
							<td><input type="text" name="userMiniTitle" id="userMiniTitle"></td>
						</tr>
						<tr>
							<td>분야</td>
							<td>
								 <select name="jobNo" id="jobNo">
						            <option value="1" selected>배우</option>
						            <option value="2">촬영</option>
						            <option value="3">연출</option>
						            <option value="4">음향</option>
						            <option value="5">조명</option>
						            <option value="6">미술</option>
						            <option value="7">메이크업</option>
						        </select>
							</td>
						</tr>
						<tr>
							<td>생년월일</td>
							<td><input type="date" name="userBirth" id="userBirth"></td>
						</tr>
						<tr>
							<td>지역 (시/군/구)</td>
							<td><input type="text" name="userArea" id="userArea"></td>
						</tr>
						<tr>
							<td>소개</td>
							<td><textarea name="userMainText" id="userMainText"></textarea></td>
						</tr>
						<tr>
							<td>경력사항</td>
							<td><textarea name="userResume" id="userResume"></textarea></td>
						</tr>
						<tr>
							<td>포트폴리오</td>
							<td><input type="file" name="userFile" multiple id="file"><br></td>
							<td>(다중선택 가능)</td>
						</tr>
					</table>
					<div style="display: none;">
						<input type="file" id="thumbnailImg1" name="thumbnailImg1" onchange="loadImg(this,1)" accept=".jpg, .png">
					</div>
				</div>
				<br>
				<div class="thumbnail-btn-area">
					<button type="button" id="button">작성완료</button>
				</div>
			</form>
		</div>
		<div class="backButton" >
			<button onclick="location.href='javascript:window.history.back();'" >취소하기</button>
		</div>
	</div>
	<script>
		
		const titleImgArea = document.getElementById("titleImgArea");
		
		titleImgArea.onclick = function() { 
			document.getElementById("thumbnailImg1").click(); 
		}
		
		/* 이미지 미리보기 관련 함수(File API 활용하기) */
		function loadImg(value, num) {
			/* https://developer.mozilla.org/ko/docs/Web/API/FileReader 참고 (MDN 사이트 참고)*/
			if (value.files && value.files[0]) {			// value.files[0]는 파일 이름
				const reader = new FileReader();
				/*
					FileReader 객체는 웹 애플리케이션이 비동기적으로 데이터를 읽기 위하여 읽을 파일을 가리키는 File 혹은 Blob 객체를
					이용해 파일의 내용을(혹은 raw data버퍼로) 읽고 사용자의 컴퓨터에 저장하는 것을 가능하게 하는 것	
					Blob(Binary large object) : 파일류의 불변하는 미가공 데이터로 텍스트와 이진 데이터의 형태로 읽을 수 있음
				*/
				// reader.readAsText(value.files[0]);			// 텍스트 파일을 읽을 때 사용 (이미지 파일을 텍스트로 읽어서 글자가 깨짐)			
				// reader.readAsArrayBuffer(value.files[0]);	// 데이터를 일정한 크기로 조금씩(파일을 표현하는 ArrayBuffer) 서버로 보낼 때
				// reader.readAsBinaryString(value.files[0]);	// 이진 데이터를 서버로 보낼 때 사용
				reader.readAsDataURL(value.files[0]);		// Base64방식으로 파일을 FileReader에 전달 (Base64로 인코딩한 것은 브라우저가 원래 데이터로 만들게 됨)
				
				// load 이벤트의 핸들러로 읽기 동작이 성공적으로 완료 되었을 때마다 발생한다.
				reader.onload = function(e) {				// load EventListener에 function 등록 (FileReader에서 전달 받은 파일을 다 읽으면 리스너에 등록한 function이 호출 됨)
					switch(num){
					case 1:
						console.log(e.target.result);		// e.target.result는 인코딩한 결과로 img태그의 src로 사용할 수 있음
						document.getElementById("userProfilePhoto").src = e.target.result;
						break;
					}
				}
			}
		}
	</script>

	<script>
		$("#button").on("click", function(){
			if($("#thumbnailImg1").val() =="" || $("#userMiniTitle").val()=="" || $("#jobNo").val()=="" || $("#userBirth").val()=="" || $("#userArea").val()=="" || $("#userMainText").val()=="" || $("#userResume").val()=="" || $("#userFile").val()==""){
				alert("모든 값을 작성해주세요");
			} else{
				frm.submit();
			}
		});
	</script>
	
	<jsp:include page="../common/footer.jsp"/>
	
</body>
</html>