<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	body{
		background-color: black;
	}
	a, h1, td{
		color: white;
	}
</style>
<title>Insert title here</title>
</head>
<body>

	<!-- 내역 없으면 다시 마이페이지로 이동 -->
	<script>
		<c:if test="${not empty requestScope.code}">
			alert("${requestScope.code}");
			location.href = "${ pageContext.servletContext.contextPath }/adminMain.jsp"
		</c:if>
	</script>
	
	<h1>기업 가입 신청 내역</h1>
	<table>
		<tr>
			<td>신청 번호</td>
			<td>기업 번호</td>
			<td>승인 여부</td>
			<td>기업명</td>
			<td>사업자등록파일</td>
		</tr>
		<c:forEach  var="list" items="${ approvalAndEntInfoList }" varStatus="st">			
			<tr>
			<td>"${ pageContext.servletContext.contextPath }\web\img\enrollment\<c:out value='${ list.entLicensePdf }'/>"</td>
				<td>${st.count } </td>
				<td><c:out value="${ list.approvalNo }"/></td>
				<td><c:out value="${ list.entNo }"/></td>
				<td><c:out value="${ list.entYn }"/></td>
				<td><c:out value="${ list.entName }"/></td>
				<td><a href="${ pageContext.servletContext.contextPath }\img\enrollment\<c:out value="${ list.entLicensePdf }"/>" download><c:out value="${ list.entLicensePdf }"/>.pdf</a></td>
			</tr>
			
			<%-- <td><button onclick="location.href='${ pageContext.servletContext.contextPath }/posting/entPostingDetail?no=${ list.postingNo  }'">승인</button></td> --%>
		</c:forEach>
	</table>
	
	<jsp:include page="adminRegistApprovalPaging.jsp"/>
</body>
</html>