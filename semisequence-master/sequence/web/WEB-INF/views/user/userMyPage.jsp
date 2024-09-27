<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/userCss/userTitle.css" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<script>
		<c:if test="${not empty requestScope.successCode}">
			alert("${requestScope.successCode}");
		</c:if>
	</script>
	
	<div class="title">
		<p>홈페이지</p>
	</div>

	<div class="userMyPageWrap">
		<div class="userMyPageRoot">
			<p>홈 / 마이페이지</p>
		</div>
		
		<table class="userInfoTable">
			<tr>
		    	<td rowspan="2"><img src="../resources/upload/noProfilePhoto/noProfilePhoto.png" width="160px" height="160px"></td>
		        <td><a href="${ pageContext.servletContext.contextPath }/user/info"><c:out value="${ sessionScope.loginMember2.userName }"/> 회원님</a></td>		<!-- 변경해야함  -->
        	</tr>
		    <tr>
		       	<td>@<c:out value="${ sessionScope.loginMember.userId }"/></td>			<!-- 변경해야함  -->
		    </tr>
		</table>
		<hr>
		
		<table class="mypage-menu">
		<tr>
			<td class="menu-title">프로필 관리</td>
			<td class="menu-content">
				<a href="${ pageContext.servletContext.contextPath }/user/profile">프로필 조회</a>
			</td>
		</tr>
		</table>
		<table class="mypage-menu">
			<tr>
				<td rowspan="2" class="menu-title">구직 관리</td>
				<td  class="menu-content">
					<a href="${ pageContext.servletContext.contextPath }/user/application/list">지원 내역 조회</a>
				</td>
			</tr>
			<tr>
				<td  class="menu-content">
					<a href="${ pageContext.servletContext.contextPath }/user/offer/list">영입 제의 확인</a>
				</td>
			</tr>
		</table>
		<table class="mypage-menu">
			<tr>
				<td class="menu-title">구인 관리</td>
				<td  class="menu-content">
					<a href="${ pageContext.servletContext.contextPath }/user/posting/list">나의 공고 조회</a>
				</td>
			</tr>
		</table>
		<table class="mypage-menu">
			<tr>
				<td rowspan="2" class="menu-title">결제 관리</td>
				<td class="menu-content">
					<a href="${ pageContext.servletContext.contextPath }/user/payment">금액 충전</a>
				</td>
			</tr>
			<tr>
				<td class="menu-content">
					<a href="${ pageContext.servletContext.contextPath }/user/payment/Detail">충전 내역 조회</a>
				</td>
			</tr>
		</table>
		<table class="mypage-menu">
			<tr>
				<td class="menu-title">평가 관리</td>
				<td  class="menu-content">
					<a href="${ pageContext.servletContext.contextPath }/user/grade">평가 관리</a>
				</td>
			</tr>
		</table>
	</div>
		
	<table>
		<tr>
			<td>프리랜서 프로필 검색</td>
			<td>
				<a href="${ pageContext.servletContext.contextPath }/searchMemberProfile">프로필 검색</a>
			</td>
		</tr>
	</table>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>