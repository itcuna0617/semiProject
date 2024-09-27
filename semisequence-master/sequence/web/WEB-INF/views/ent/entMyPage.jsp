<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/entMyPage.css" type="text/css"/>
<meta charset="UTF-8">
<title>SEQUENCE</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<script>
		<c:if test="${not empty requestScope.successCode}">
			alert("${requestScope.successCode}");
			/* location.href = "${ pageContext.servletContext.contextPath }/user/info" */
		</c:if>
	</script>
	<div class="entTitle">
		<p>마이페이지</p>
	</div>
	<div class="entMyPageWrap">
		<div class="entMyPageRoot">
			<p>홈/마이페이지</p>
		</div>
		<table class="entIdSetting">
			<tr>
		    	<td rowspan="2"><img width="240" height="160" src="${ pageContext.servletContext.contextPath }${sessionScope.entProfileImg}"></td>
		        <td><a href="ent/setting"><c:out value="${ sessionScope.entName }"/> 기업 고객님</a></td>
        	</tr>
		    <tr>
		       	<td>@<c:out value="${ sessionScope.loginMember.entId }"/></td>
		    </tr>
		</table>
		<hr>
	</div>
	<div class="menu-wrap">
		<table class="mypage-menu">
			<tr>
				<td class="menu-title" rowspan="2">결제 관리</td>
				<td class="menu-content"><a href="ent/paymenthistory">결제 관리</a></td>
			</tr>
		</table>
      <table class="mypage-menu">
         <tr>
            <td class="menu-title" rowspan="3">구인 관리</td>
            <td class="menu-content"><a href="${pageContext.servletContext.contextPath}/project/list">프로젝트 관리</a></td>
         </tr>
         <tr>
            <td class="menu-content"><a href="${pageContext.servletContext.contextPath}/posting/list">공고 관리</a></td>
         </tr>
         <tr>
            <td class="menu-content"><a href="${pageContext.servletContext.contextPath}/application/select/by/ent?page=1&&criteria=ent">지원자 관리</a></td>
         </tr>
      </table>
		<table class="mypage-menu">
			<tr>
				<td class="menu-title" rowspan="2">프로필 관리</td>
				<td class="menu-content"><a href="${ pageContext.servletContext.contextPath }/ent/profilepage">프로필 등록 / 수정</a></td>
			</tr>
		</table>
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>