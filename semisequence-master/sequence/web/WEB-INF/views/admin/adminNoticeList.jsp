<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>공지사항 관리</h1>
	<table>
		<tr>
			<th>글 번호</th>
			<th width="300px">글 제목</th>
			<th>등록일</th>
		</tr>
	<c:forEach items="${ requestScope.noticeList }" var="notice" varStatus="status">
		<tr
			<c:if test="${ notice.noticeActiveYN==N }">style="background-color: grey"</c:if>
			<c:if test="${ notice.noticeActiveYN==Y }">style="background-color: white"</c:if>
			>
			<td>${ notice.noticeNo }</td>
			<td onclick="location.href='${pageContext.servletContext.contextPath}/notice/detail?noticeNo=<c:out value="${ notice.noticeNo }"/>'">${ notice.noticeTitle }</td>
			<td>${ notice.noticeDate }</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="3" style="background-color: black">
			<button class="insert" type="button" onclick="location.href='${pageContext.servletContext.contextPath}/notice/insert'">등록</button>
		</td>
	</tr>
	</table>
	<jsp:include page="/WEB-INF/views/admin/noticePaging.jsp"></jsp:include>
</body>
<style>
	.insert{
		float : right;
		
	}
	table{
		color: black;
		margin: 0 auto;
	}
	tr{
		background-color: white;
	}
	td{
		width: 100px;
		cursor: pointer;
	}
	body{
		background-color: black;
		color: white;
	}
	h1{
		color: white;
	}
</style>
</html>