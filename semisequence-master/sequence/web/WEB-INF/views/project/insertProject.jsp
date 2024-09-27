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
		<h3>프로젝트 추가</h3>
		<br>
		<form action="${ pageContext.servletContext.contextPath }/project/insert" method="post">
		 
		프로젝트 이름 : <input type="text" name="projectName" maxlength="33" size="33" placeholder="프로젝트 이름을 입력하세요"><br>
		시작일 : <input type="date" name="projectStartDate">&nbsp;
		종료일 : <input type="date" name="projectEndDate"><br>
		
		
		프로젝트 상세 &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;  분야 
		<select name="genreNo">
			<option value="1" selected>영화</option>
			<option value="2" >광고</option>
			<option value="4" >다큐</option>
			<option value="5" >드라마</option>
			<option value="3" >기타</option>
		</select><br>
		<textarea rows="15" cols="40" name="projectContent" maxlength="1000"></textarea><br>
		
		
		<div id="managerInfo">
			<br>
			매니저 정보<br>
			이름 : <input name="managerName" type="text" placeholder="홍길동"><br>
			번호 : <input name="managerPhone" type="tel" placeholder="01020639206" maxlength="13"><br>
			메일 : <input name="managerEmail" type="email" placeholder="hoon1545@gmail.com" maxlength="27"><br>
		</div>
		
		<button>등록 완료</button> 
		<button type="button" onclick="location.href='${ pageContext.servletContext.contextPath }/project/list'">등록 취소</button>
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