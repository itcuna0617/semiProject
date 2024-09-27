<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/header.css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <header>
      <h1 class="headerTitle">
           <a href="${ pageContext.servletContext.contextPath }/index.jsp">SEQUENCE</a>
        </h1>
        <nav class="headerNav">
		<c:if test="${ not empty sessionScope.successCode}">
			<c:if test="${ not empty sessionScope.userLoginCode }">
				<p><c:out value="${ sessionScope.loginMember2.userName } 님 환영합니다."/></p>
                <a class="logout" href="${ pageContext.servletContext.contextPath }/logoutMember">로그아웃</a>
            </c:if>
            <c:if test="${ empty sessionScope.userLoginCode }">
                <p><c:out value="${ sessionScope.entName } 님 환영합니다."/></p>
                <a class="logout" href="${ pageContext.servletContext.contextPath }/logoutMember">로그아웃</a>
            </c:if>
        </c:if>
  		<c:if test="${ empty sessionScope.successCode}">
             <a class="login" href="${ pageContext.servletContext.contextPath }/loginMember">로그인</a>
             <a class="registMember" href="${ pageContext.servletContext.contextPath }/registSelect">회원가입</a>
       	</c:if>
    	</nav>
   </header>
</body>
</html>