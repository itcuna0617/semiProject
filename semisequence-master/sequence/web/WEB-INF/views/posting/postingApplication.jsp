<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/board.css" type="text/css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.table-area {
	color: #4b4b4b;
	display: block;
	font-family: 'MinSans-Medium';
	line-height: 30px; 
}
</style>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<div class="customerCenterTitle">
		<p>구인공고</p>
	</div>
		<div class="boardSettingWrap">
			<div class="boardSettingRoot">
				<a href="index.jsp">홈/</a>
				<a href="#">마이페이지/</a>
				계정설정
			</div>
		</div>
		
			<br>
			<div class="table-area" id="application" style="margin: 20px 300px 10px 370px !important;" >
				<h2>제출하실 프로필을 선택해주세요.</h2>
					<form action="${ pageContext.servletContext.contextPath }/insertApplication" method="post">
					
						<c:forEach items="${ profileList }" var="profileList">
							<input type="radio" id="profile" name="userProfileNo" value="${ profileList.userProfileNo }"><c:out value="${ profileList.userMiniTitle }"/><br>
						</c:forEach>
						<br><br>
						<h2>지원서에 제출될 소개문구를 적어주세요</h2>
							<textarea id="intro" name="applicationIntro" style="resize:none; width:90%; height:200px;"></textarea>
							<br>
						<button type="submit" id="submit"> 지원 </button> <button type="reset">취소</button>
					</form>
			</div>
		<jsp:include page="../common/footer.jsp"/>
	<script>
		$("#submit").on("click", function(){
			if($("#application").val()=="" || $("#profile").val()=="" || $("#intro").val()==""){
				alert("모든 항목을 작성해주세요");
			} else{
				frm.submit();
			}
		});
	</script>
			
</body>
</html>