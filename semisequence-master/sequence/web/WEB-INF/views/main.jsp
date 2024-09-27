<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/main.css" type="text/css"/>
<script src="https://kit.fontawesome.com/ab9db104b5.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="common/header.jsp"/>
	<br>
	
	<div class="slider">
	    <input type="radio" name="slide" id="slide1" checked>
	    <input type="radio" name="slide" id="slide2">
	    <input type="radio" name="slide" id="slide3">
	    <input type="radio" name="slide" id="slide4">
	    <ul id="imgholder" class="imgs">
	        <li><img src="./img/cam.jpg"></li>
	        <li><img src="./img/camera.jpg"></li>
	        <li><img src="./img/film.jpg"></li>
	        <li><img src="./img/staff.jpg"></li>
	    </ul>
	    <div class="bullets">
	        <label for="slide1">&nbsp;</label>
	        <label for="slide2">&nbsp;</label>
	        <label for="slide3">&nbsp;</label>
	        <label for="slide4">&nbsp;</label>
	    </div>
	</div>
	<nav class="menubar">
		<ul>
            <li><a id="menuLink" href="${ pageContext.servletContext.contextPath }/postingList"> 구인공고  </a></li>
            <li><a id="menuLink" href="${ pageContext.servletContext.contextPath }/searchMemberProfile">프로필 검색 </a></li>
            <% 
            if("개인".equals(session.getAttribute("userLoginCode"))){ %>
            	<li><a id="menuLink" href="${ pageContext.servletContext.contextPath }/user/myPage">마이페이지</a></li>
            <% } else if("ent".equals(session.getAttribute("member"))){ %>
            	<li><a id="menuLink" href="${ pageContext.servletContext.contextPath }/entMyPageChange">마이페이지</a></li>
            <% } else { %>
            	<li><a id="menuLink">마이페이지</a></li>
            <% } %>
            <li><a id="menuLink" href="${ pageContext.servletContext.contextPath }/noticeList">고객센터</a></li>
        </ul>
    </nav>
    <%-- <i class="icons fa-brands fa-quora"></i>
    <i class="icons fa-solid fa-pen-to-square"></i>
    <i class="icons fa-solid fa-users"></i>
    <i class="icons fa-brands fa-searchengin"></i>
	<jsp:include page="common/footer.jsp"/> --%>
</body>
</html>