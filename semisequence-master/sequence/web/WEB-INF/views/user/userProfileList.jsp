<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/userCss/userProfileList.css" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<c:if test="${not empty requestScope.profileIsEmpty}">
		<script>
			$(function() {
				$(".userProfileList").hide();
				$(".head").after("<p>등록된 프로필이 없습니다. 프로필을 등록해주세요</p>");
			});
		</script>
	</c:if>
	
	<script>
		<c:if test="${not empty requestScope.successCode}">
			alert("${requestScope.successCode}");
			location.href = "${ pageContext.servletContext.contextPath }/user/profile"
		</c:if>
	</script>
	
	<div class="title">
		<p>프로필관리</p>
	</div>

	<div class="userMyPageWrap">
		<div class="userMyPageRoot">
			<p>홈 / 마이페이지 / 프로필관리</p>
		</div>
	
			<c:forEach items="${ userProfileList }" var="userProfileList" varStatus="st">			<!-- 조회한 리트스 반복문으로 뿌려주는 작업 -->
			<table class="profiles">
				<tr>
					<td style="display: none;"><c:out value="${ userProfileList.userProfileNo }"/></td>
					<td rowspan="2"><img class="photo" src="${ pageContext.servletContext.contextPath }${ userProfileList.userPhoto }" width="140px" height="160px"></td>
				</tr>
				<tr>
					<td style="display: none;"><c:out value="${ userProfileList.userProfileNo }"/></td>
					<td class="miniTitle"><c:out value="${ userProfileList.userMiniTitle }"/></td>
					<td class="profileText userName"><c:out value="${ sessionScope.loginMember2.userName }"/></td>
					<td class="profileText profileTexts"><c:out value="${ userProfileList.userArea }"/>  <fmt:formatDate pattern="yyyy/MM/dd" value="${userProfileList.userBirth}"/>  <c:out value="${ userProfileList.job.jobName }"/></td>
				</tr>
			</table>
			
			<script>
				if(<c:out value="${ st.index }"/> == 4){
					/* 프로필 5개까지만 등록 가능 */
					$(function() {
							$(".submitButton").attr("disabled", "disabled");
							$(".alert").show();
					});
				} 
			</script>
			</c:forEach>
		<button class="submitButton" onclick="location.href='${ pageContext.servletContext.contextPath }/user/profile/insert'">새 프로필 등록</button>
		<div class="alert">프로필은 최대 5까지 등록 가능합니다.</div>
	</div>
	
	<script>
		if(document.getElementsByTagName("td")) {
			const $tds = document.getElementsByTagName("td");
			for(let i = 0; i < $tds.length; i++) {
				$tds[i].onclick = function() {	
					const no = this.parentNode.children[0].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/user/profile/detail?no=" + no;		// no (글 번호를 parameter로 전송)
				}
			}
		}
	</script>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>