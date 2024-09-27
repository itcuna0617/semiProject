<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/userCss/userApplicationList.css" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<!-- 지원내역 없으면 다시 마이페이지로 이동 -->
	<script>
		<c:if test="${not empty requestScope.userApplicationIsnullCode}">
			alert("${requestScope.userApplicationIsnullCode}");
			location.href = "${ pageContext.servletContext.contextPath }/index.jsp"
		</c:if>
	</script>
	
	<div class="title">
		<p>지원내역</p>
	</div>
	
	<div class="userMyPageWrap">
		<div class="userMyPageRoot">
			<p>홈 / 마이페이지 / 지원내역</p>
		</div>
		<div>
			<table class="applicationTable">
				<tr class="menuTitle">
					<td>공고 제목</td>
					<td>공고 등록일</td>
					<td>지원 내용</td>
					<td>지원 날짜</td>
					<td>합격 여부</td>
				</tr>
				<c:forEach  var="list" items="${ userApplicationByPostingList }" varStatus="st">			
					<tr class="menuText">
						<td><c:out value="${ list.postingTitle }"/></td>
						<td><fmt:formatDate pattern="yyyy/MM/dd" value="${ list.postingDate }"/></td>
						<td><c:out value="${ list.applicationIntro }"/></td>
						<td><fmt:formatDate pattern="yyyy/MM/dd" value="${ list.applicationDate }"/></td>
						<td><c:out value="${ list.applicationConnectYn }"/></td>
					</tr>
					<td><button class="buttons" onclick="location.href='${ pageContext.servletContext.contextPath }/entPostingDetail?no=${ list.postingNo  }'">구인글 조회</button></td>
					<td><button class="buttons" onclick="location.href='${ pageContext.servletContext.contextPath }/user/profile/detail?no=${ list.userProfileNo  }'">지원 프로필 확인</button></td>
				</c:forEach>
			</table>
		</div>
	</div>
	<jsp:include page="../user/applicationPaging.jsp"/>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>