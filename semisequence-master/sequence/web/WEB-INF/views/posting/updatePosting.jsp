<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<section>
		<h3>구인 공고 수정</h3>
		<br>
		<form action="${ pageContext.servletContext.contextPath }/posting/update" method="post">
		
		구인 공고 제목 : <input type="text" name="postingTitle" maxlength="20" size="20" value="${ posting.postingTitle }"><br>
		
		공고 상세 내용&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;  직군 
		<select name="jobNo">
			<option value="1" <c:if test="${ posting.jobNo ==1 }">selected</c:if> >배우</option>
			<option value="2" <c:if test="${ posting.jobNo ==2 }">selected</c:if> >촬영</option>
			<option value="3" <c:if test="${ posting.jobNo ==3 }">selected</c:if> >연출</option>
			<option value="4" <c:if test="${ posting.jobNo ==4 }">selected</c:if> >음향</option>
			<option value="5" <c:if test="${ posting.jobNo ==5 }">selected</c:if> >조명</option>
			<option value="6" <c:if test="${ posting.jobNo ==6 }">selected</c:if> >미술</option>
			<option value="7" <c:if test="${ posting.jobNo ==7 }">selected</c:if> >메이크업</option>
		</select><br>
		<textarea rows="15" cols="40" name="postingDetail" maxlength="1000">${ posting.postingDetail }</textarea><br>
		<input type="hidden" name="postingNo" value="${ requestScope.posting.postingNo }">
		<button>수정 완료</button> 
		
		<!-- 취소 버튼 
		
			추후 user입장에서 list 서블릿 나오면 해당 서블릿 추가하는 c:if 태그 추가할 것.
			entNo=0, userNo=0 이용하면 됨.
		-->
		<button type="button" onclick="location.href='${ pageContext.servletContext.contextPath }/posting/list'">수정 취소</button>
		</form>
		
		
		
	</section>
	<jsp:include page="../common/footer.jsp"/>
</body>
<style>
	section{
		margin: 0 300px 0 300px;
	}
</style>
</html>