<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/entIdSetting.css" type="text/css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<!-- 회원정보 수정 완료 시 alert -->
	<script>
		<c:if test="${not empty requestScope.successCode}">
			alert("${requestScope.successCode}");
			/* location.href = "${ pageContext.servletContext.contextPath }/user/info" */
		</c:if>
		<c:if test="${not empty requestScope.message}">
		alert("${requestScope.message}");
		/* location.href = "${ pageContext.servletContext.contextPath }/user/info" */
		</c:if>
	</script>
	<div class="entTitle">
		<p>계정설정</p>
	</div>
	<div class="entSettingWrap">
		<div class="entSettingRoot">
			<p>홈/마이페이지/계정설정</p>
		</div>
		<table class="member-setting">
			<tr>
				<td>기업명</td>
				<td><c:out value="${ sessionScope.entName }"/></td>
			</tr>
			<tr>
				<td>대표 번호</td>
				<td><c:out value="${ sessionScope.entPhone }"/></td>
			</tr>
			<tr>
				<td>비밀 번호</td>
				<td>******</td>
				<td><button type="submit" onclick="location.href='${ pageContext.servletContext.contextPath}/ent/passwordsetting'">비밀번호 수정</button></td>
			</tr>
			<tr>
				<td>대표 이메일</td>
				<td><c:out value="${ sessionScope.entEmail }"/></td>
			</tr>
			<tr>
				<td><a href="${ pageContext.servletContext.contextPath }/ent/drop">회원 탈퇴</a></td>
				<td><button type="button" onclick="location.href='${ pageContext.servletContext.contextPath}/ent/idsetting'">정보수정</button></td>
			</tr>	
		</table>
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>