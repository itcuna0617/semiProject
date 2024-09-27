<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/userCss/userProfileUpdateForm.css" type="text/css"/>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
   <jsp:include page="../common/header.jsp"/>
   
  	<div class="title">
		<p>프로필 수정</p>
	</div>	
   
   	<div class="userMyPageWrap">
		<div class="userMyPageRoot">
			<p>홈 / 마이페이지 / 프로필관리 / 프로필수정</p>
		</div>
     	<div>
       		<form action="${ pageContext.servletContext.contextPath }/user/profile/update" method="post" encType="multipart/form-data" name="frm">
	            <div class="thumbnail-insert-area">
	            <table class="protfolio-setting">
	               <tr>
	                  <td>대표 사진</td>
	                  <td colspan="3">
	                     <div class="title-img-area" id="titleImgArea">
	                        <img  id="userProfilePhoto" src="${ pageContext.servletContext.contextPath }${ userProfile.userPhoto }" width="350" height="200">
	                     </div>
	                     
	                     <div style="display: none;">
	                        <input type="file" id="thumbnailImg1" name="thumbnailImg1" onchange="loadImg(this,1)" accept=".jpg, .png">
	                     </div>
	                  </td>
	               </tr>
	               <tr>
	                  <td>미니프로필 제목</td>
	                  <td><input type="text" id="userMiniTitle" name="userMiniTitle" value="${ userProfile.userMiniTitle }"></td>
	               </tr>
	               <tr>
	                  <td>분야</td>
	                  <td>
	                      <select name="jobNo" id="jobNo">
	                         <c:if test="${ userProfile.job.jobNo eq 1}">
	                           <option value="1" selected>배우</option>
	                           <option value="2">촬영</option>
	                           <option value="3">연출</option>
	                           <option value="4">음향</option>
	                           <option value="5">조명</option>
	                           <option value="6">미술</option>
	                           <option value="7">메이크업</option>
	                         </c:if>
	                         <c:if test="${ userProfile.job.jobNo eq 2}">
	                           <option value="1">배우</option>
	                           <option value="2" selected>촬영</option>
	                           <option value="3">연출</option>
	                           <option value="4">음향</option>
	                           <option value="5">조명</option>
	                           <option value="6">미술</option>
	                           <option value="7">메이크업</option>
	                         </c:if>
	                         <c:if test="${ userProfile.job.jobNo eq 3}">
	                           <option value="1">배우</option>
	                           <option value="2">촬영</option>
	                           <option value="3" selected>연출</option>
	                           <option value="4">음향</option>
	                           <option value="5">조명</option>
	                           <option value="6">미술</option>
	                           <option value="7">메이크업</option>
	                         </c:if>
	                         <c:if test="${ userProfile.job.jobNo eq 4}">
	                           <option value="1">배우</option>
	                           <option value="2">촬영</option>
	                           <option value="3">연출</option>
	                           <option value="4" selected>음향</option>
	                           <option value="5">조명</option>
	                           <option value="6">미술</option>
	                           <option value="7">메이크업</option>
	                         </c:if>
	                         <c:if test="${ userProfile.job.jobNo eq 5}">
	                           <option value="1">배우</option>
	                           <option value="2">촬영</option>
	                           <option value="3">연출</option>
	                           <option value="4">음향</option>
	                           <option value="5" selected>조명</option>
	                           <option value="6">미술</option>
	                           <option value="7">메이크업</option>
	                         </c:if>
	                         <c:if test="${ userProfile.job.jobNo eq 6}">
	                           <option value="1">배우</option>
	                           <option value="2">촬영</option>
	                           <option value="3">연출</option>
	                           <option value="4">음향</option>
	                           <option value="5">조명</option>
	                           <option value="6" selected>미술</option>
	                           <option value="7">메이크업</option>
	                         </c:if>
	                         <c:if test="${ userProfile.job.jobNo eq 7}">
	                           <option value="1">배우</option>
	                           <option value="2">촬영</option>
	                           <option value="3">연출</option>
	                           <option value="4">음향</option>
	                           <option value="5">조명</option>
	                           <option value="6">미술</option>
	                           <option value="7" selected>메이크업</option>
	                         </c:if>
	                       </select>
	                  </td>
	               </tr>
	               <tr>
	                  <td>지역 (시/군/구)</td>
	                  <td><input type="text" id="userArea" name="userArea" value="${ userProfile.userArea }"></td>
	               </tr>
	               <tr>
	                  <td>소개</td>
	                  <td><textarea id="userMainText" name="userMainText">${ userProfile.userMainText }</textarea></td>
	               </tr>
	               <tr>
	                  <td>경력사항</td>
	                  <td><textarea id="userResume" name="userResume">${ userProfile.userResume }</textarea></td>
	               </tr>
	               <tr>
	                  <td>포트폴리오 추가</td>
	                  <td><input type="file" name="userFile" multiple><br></td>
	                  <td class="deleteFile">
	                  </td>
	                  <td>
	                     <input type="text" name="count" value="0" class="deleteFileCount" style="display: none;">
	                  </td>
	                </tr>
	                <tr>
	                	<td>포트폴리오 삭제 </td>
						<td>
						<c:forEach items="${ userAddFileList }" var="userAddFileList" varStatus="st">
					      	<div class="portfolio uploadResult${st.count}"><a href="${ pageContext.servletContext.contextPath }\resources\upload\original\file\<c:out value="${userAddFileList.userFileSavedName}"/>" download><c:out value="${ userAddFileList.userFileOriginalName }"/></a></div>
							<div class="portfolio uploadResultButton${st.count}">X</div>
						<script>
				  	 		var count = 0;
						
							$(".uploadResultButton${st.count}").on("click", function(){
							   if(confirm("정말로 삭제하시겠습니까?")){
							      $(".uploadResult${st.count}").hide();
							      $(".uploadResultButton${st.count}").hide();
							      $(".deleteFile").hide();
							      $(".deleteFile").append("<input type='text' name='deleteFile${st.count}' value='${ userAddFileList.userFileNo }'>");
							      
							      count++;
							      console.log(count);
							   }
							});
						</script>
					</c:forEach>
						</td>
	               </tr>
	            </table>
	         </div>
	         
	         <div class="thumbnail-btn-area">
	            <button class="submitButton" id="button" type="button">수정하기</button>
	         </div>
         </form>
         <div class="backButton">
         	<button onclick="location.href='${ pageContext.servletContext.contextPath }/user/profile'">돌아가기</button>
         </div>
      </div>
   </div>
   
   <script>
      const titleImgArea = document.getElementById("titleImgArea");
      
      titleImgArea.onclick = function() { 
         document.getElementById("thumbnailImg1").click(); 
      }
      
      /* 이미지 미리보기 관련 함수(File API 활용하기) */
      function loadImg(value, num) {
         if (value.files && value.files[0]) {         
            const reader = new FileReader();
            reader.readAsDataURL(value.files[0]);      
            reader.onload = function(e) {            
               switch(num){
               case 1:
                  console.log(e.target.result);      
                  document.getElementById("userProfilePhoto").src = e.target.result;
                  break;
               }
            }
         }
      }
      
      $(".submitButton").on("click", function(){
		   $(".deleteFileCount").val(count);
		});
   </script>
   
   <script>
		$("#button").on("click", function(){
			if($("#userMiniTitle").val()=="" || $("#jobNo").val()=="" || $("#userBirth").val()=="" || $("#userArea").val()=="" || $("#userMainText").val()=="" || $("#userResume").val()=="" || $("#userFile").val()==""){
				alert("모든 값을 작성해주세요");
			} else{
				frm.submit();
			}
		});
	</script>
   <jsp:include page="../common/footer.jsp"/>
   
</body>
</html>