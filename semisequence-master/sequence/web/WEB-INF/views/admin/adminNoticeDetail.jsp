<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr height="30px">
			<th>공지사항</th>
			<th width="300px">${ requestScope.notice.noticeNo } 번 게시물 상세 내용</th>
			<th>
				<form action="${ pageContext.servletContext.contextPath }/notice/delete" method="post">
					<input type="hidden" name="noticeNo" value="${ requestScope.notice.noticeNo }">
					<button>삭제</button>
				</form>
				<form action="${ pageContext.servletContext.contextPath }/notice/update" method="get">
					<input type="hidden" name="noticeNo" value="${ requestScope.notice.noticeNo }">
					<button>수정</button>
				</form>
				<form action="${ pageContext.servletContext.contextPath }/notice/list" method="get">
					<input type="hidden" name="page" value="1">
					<button>목록</button>
				</form>
			</th>
		</tr>
		<tr height="30px">
			<th>작성자 : ${ requestScope.notice.adminId }</th>
			<th width="300px">제목 : ${ requestScope.notice.noticeTitle }</th>
			<th>날짜 : ${ requestScope.notice.noticeDate }</th>
		</tr>
		<tr >
			<th colspan="3">${ requestScope.notice.noticeContent }</th>
		<tr>
	</table>

</body>
<style>
	button{
		float: right;
		margin: 0 auto;
	}
	table{
		color: black;
		margin: 0 auto;
		height: 700px;
	}
	tr{
		background-color: white;
	}
	td{
		width: 100px;
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