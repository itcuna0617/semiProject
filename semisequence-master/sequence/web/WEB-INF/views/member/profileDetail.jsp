<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<br><br>
	<h3>프리랜서 정보</h3>
	<div class="userInfo">
		<table>
			<tr>
				<td rowspan="6" width="150px" height="180px"><img src="${ pageContext.servletContext.contextPath }${ requestScope.searchUserProfileDetail.userPhoto.getUserPhotoSavedPath() }" width="150px" height="180px"></td>
				<td width="20px"></td>
				<td width="300px" height="30px"><c:out value="프리랜서 이름 : ${ requestScope.searchUserProfileDetail.userName }"/></td>
			</tr>
			<tr>
				<td width="20px"></td>
				<td width="300px" height="30px"><c:out value="희망 지역 : ${ requestScope.searchUserProfileDetail.userArea }"/></td>
			</tr>
			<tr>
				<td width="20px"></td>
				<td width="300px" height="30px"><c:out value="희망 직군 : ${ requestScope.searchUserProfileDetail.job.getJobName() }"/></td>
			</tr>
			<tr>
				<td width="20px"></td>
				<td width="60" height="30px">생년월일 : </td>
				<td width="240px"><fmt:formatDate pattern="yyyy-MM-dd" value="${requestScope.searchUserProfileDetail.userBirth}"/></td>
			</tr>
			<tr>
				<td width="20px"></td>
				<td width="300px" height="30px"><c:out value="전화번호 : ${ requestScope.searchUserProfileDetail.user.getUserPhone() }"/></td>
			</tr>
			<tr>
				<td width="20px"></td>
				<td width="300px" height="30px"><c:out value="이메일 : ${ requestScope.searchUserProfileDetail.user.getUserEmail() }"/></td>
			</tr>
		</table>
	</div>
	
	<br><br><br>
	<h3>프리랜서 소개</h3>
	<div class="userIntro">
	</div>
		<table>
			<tr>
				<td width="450px" height="200px"><c:out value="${ requestScope.searchUserProfileDetail.userMainText }"/></td>
			</tr>
		</table>
	<div>
	
	<br><br><br>
	<h3>경력 사항</h3>
	<div class="userResume">
		<table>
			<tr>
				<td width="450px" height="200px"><c:out value="${ requestScope.searchUserProfileDetail.userResume }"/></td>
			</tr>
		</table>
	</div>
	<br><br><br>
	<h3>포트폴리오</h3>
	<div class="userPortfo">
		<table>
			<tr>
				<c:forEach items="${ userPortfolio }" var="userPortfolio" varStatus="st">
					<td><a href="${ pageContext.servletContext.contextPath }\resources\upload\original\file\<c:out value="${userPortfolio.userFileSavedName}"/>" download><c:out value="${ userPortfolio.userFileOriginalName }"/></a></td>
				</c:forEach>
			</tr>
		</table>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>