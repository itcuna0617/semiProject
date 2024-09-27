<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/userCss/userProfileDetail.css" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<div class="title">
		<p>프로필관리</p>
	</div>

	<div class="userMyPageWrap">
		<div class="userMyPageRoot">
			<p>홈 / 마이페이지 / 프로필관리 / 상세프로필</p>
		</div>
		<div class="userInfoTitle">프리랜서 정보</div>
		<table>
			<tr>
				<td rowspan="2"><img class="userPhoto" src="${ pageContext.servletContext.contextPath }${ requestScope.userProfile.userPhoto }"  width="140px" height="160px"></td>
			</tr>
			<tr class="userInfos">
				<td class="userInfo">프리랜서 이름: <c:out value="${ sessionScope.loginMember2.userName }"/></td>
				<td class="userInfo">희망 지역: <c:out value="${ requestScope.userProfile.userArea }"/></td>
				<td class="userInfo">생년월일: <fmt:formatDate pattern="yyyy/MM/dd" value="${requestScope.userProfile.userBirth}"/></td>
				<td class="userInfo">이메일: <c:out value="${ sessionScope.loginMember2.userEmail }"/></td>
				<td class="userInfo">희망 분야: <c:out value="${ requestScope.userProfile.job.jobName }"/></td>
			</tr>
			<tr>
				<td><div class="userInfoTitle">프리랜서 소개</div></td>
			</tr>
			<tr>
				<td class="userInfoText"><c:out value="${ requestScope.userProfile.userMainText }"/></td>
			</tr>
			<tr>
				<td><div class="userInfoTitle">경력사항</div></td>
			</tr>
			<tr>
				<td class="userInfoText"><c:out value="${ requestScope.userProfile.userResume }"/></td>
			</tr>
			<tr>
				<td><div class="userInfoTitle">포트폴리오</div></td>
			</tr>
			<tr>
				<td class="userInfoText">
				<c:forEach items="${ userAddFileList }" var="userAddFileList" varStatus="st">
						<a href="${ pageContext.servletContext.contextPath }\resources\upload\original\file\<c:out value="${userAddFileList.userFileSavedName}"/>" download><c:out value="${ userAddFileList.userFileOriginalName }"/></a>
						<br>
				</c:forEach>
				</td>
			</tr>
		</table>
		<div>
			<button onclick="location.href='${ pageContext.servletContext.contextPath }/user/profile/update?no=${ requestScope.userProfile.userProfileNo }'" >프로필 수정</button>
			<button class="deleteButton">프로필 삭제</button>
		</div>
	</div>
	<script>
		$(".deleteButton").click(function(){
			var result = confirm('정말로 삭제하시겠습니까?');
			
			if(result){
				location.href="${ pageContext.servletContext.contextPath }/user/profile/delete?no=${ requestScope.userProfile.userProfileNo }";
			}
		});
	</script>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>