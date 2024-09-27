<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>

	<section>
		<div id="projectName">
			<h1>프로젝트 명 : ${ requestScope.projectName }</h1>
		</div>
		<div id="postingTitle">
			<h1>공고 제목 : ${ requestScope.posting.postingTitle }</h1>
			<br>
			<p style='text-align: right'>${ requestScope.posting.postingDate }
			</p>
		</div>
		<h3>공고 내용</h3>
		<div id="postingDetail">
			${ requestScope.posting.postingDetail }
		</div>
		<button onclick="location.href='${ pageContext.servletContext.contextPath }/user/offer/list'">돌아가기</button>
	</section>
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
<style>
section {
	border-top: 1px solid #4b4b4b;
	padding: 20px 300px 20px 300px;
}

.posting {
	height: 50px;
	border: 1px solid #4b4b4b;
}

#insertPosting {
	float: right;
}

#postingDetail {
	border: 1px solid #4b4b4b;
	height: 200px;
	color: aqua;
}

#postingTitle {
	border: 1px solid #4b4b4b;
	color: lime;
}
</style>
</html>