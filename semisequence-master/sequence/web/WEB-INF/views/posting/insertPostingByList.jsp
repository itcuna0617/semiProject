<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<section>
		<h3>구인 공고 추가</h3>
		<br>
		<form action="${ pageContext.servletContext.contextPath }/posting/insert" method="post">
		
		구인 공고 제목 : <input type="text" name="postingTitle" maxlength="20" size="20" placeholder="공고 제목을 입력하세요"><br>
		프로젝트 : 
		<select id=selectProjectNo name='projectNo'>
		</select><br>
			<script>
				$.ajax({
					url : "${pageContext.servletContext.contextPath}/posting/insert/by/list",
					type : "post",
					success: function(data){
						$("#selectProjectNo").html(data)
					},
					error: function(request, status){
						alert("code: " + request.status + "\n"
								+ "message: " + request.responseText);
					}
				})
			</script>
		
		<br>공고 상세 내용 &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;  직군 
		<select id="selectJobNo" name="jobNo">
			<option value="1" selected>배우</option>
			<option value="2" >촬영</option>
			<option value="3" >연출</option>
			<option value="4" >음향</option>
			<option value="5" >조명</option>
			<option value="6" >미술</option>
			<option value="7" >메이크업</option>
		</select><br>
		<textarea rows="15" cols="40" name="postingDetail" maxlength="1000" placeholder="상세 내용을 입력하세요"></textarea><br>
		<button>등록 완료</button> 
		
		<!-- 취소 버튼 -->
		<button type="button" onclick="location.href='${ pageContext.servletContext.contextPath }/posting/list'">등록 취소</button>
		</form>
		
		
		
	</section>
	<jsp:include page="../common/footer.jsp"/>
</body>
<style>
	section{
		margin: 0 300px 0 300px;
		height: 700px;
		width: 600px;
		
	}
	#selectProjectNo{
	}
	#selectJobNo{
	}
</style>
</html>