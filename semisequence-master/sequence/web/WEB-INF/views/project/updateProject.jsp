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
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	<section>
		<h3>프로젝트 수정</h3>
		<br>
		<form action="${ pageContext.servletContext.contextPath }/project/update" method="post">
		<input type="hidden" name="projectNo" value="${ requestScope.project.projectNo }">	
		
		프로젝트 이름 : <input type="text" name="projectName" maxlength="33" size="33" value="${ requestScope.project.projectName }"><br>
		시작일 : <input type="date" name="projectStartDate" value="${ requestScope.project.projectStartDate }">&nbsp;
		종료일 : <input type="date" name="projectEndDate" value="${ requestScope.project.projectEndDate }"><br>
		
		
		프로젝트 상세 &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;  분야 
		<select name="genreNo" >
			<option value="1" ${ requestScope.project.genreNo eq "1"? "selected": "" }>영화</option>
			<option value="2" ${ requestScope.project.genreNo eq "2"? "selected": "" }>광고</option>
			<option value="4" ${ requestScope.project.genreNo eq "4"? "selected": "" }>다큐</option>
			<option value="5" ${ requestScope.project.genreNo eq "5"? "selected": "" }>드라마</option>
			<option value="3" ${ requestScope.project.genreNo eq "3"? "selected": "" }>기타</option>
		</select><br>
		<textarea rows="15" cols="40" name="projectContent">${ requestScope.project.projectContent }</textarea><br>
		
		
		<div id="managerInfo">
			<br>
			매니저 정보<br>
			<input name="managerName" type="text" value="${ requestScope.project.managerName }" placeholder="${ requestScope.project.managerName }"><br>
			<input name="managerPhone" type="tel" value="${ requestScope.project.managerPhone }" placeholder="${ requestScope.project.managerPhone }"><br>
			<input name="managerEmail" type="email" value="${ requestScope.project.managerEmail }" placeholder="${ requestScope.project.managerEmail }"><br>
		</div>
		
		<button>수정 완료</button> <button type="button" onclick="location.href='${ pageContext.servletContext.contextPath }/project/list'">수정 취소</button>
		</form>
		
		
		
	</section>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
<style>
	section{
		margin: 0 200px 0 200px;
	}
</style>
</html>
