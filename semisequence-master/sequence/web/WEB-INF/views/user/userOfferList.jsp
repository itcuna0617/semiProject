<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/userCss/userOfferList.css" type="text/css"/>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<!-- 영입제의 내역이 없는 경우 -->
	<script>
		<c:if test="${not empty requestScope.OfferIsNullCode}">
			alert("${requestScope.OfferIsNullCode}");
			location.href = "${ pageContext.servletContext.contextPath }/index.jsp"
		</c:if>
		<c:if test="${not empty requestScope.successCode}">
			alert("${requestScope.successCode}");
			location.href = "${ pageContext.servletContext.contextPath }/user/offer/list"
		</c:if>
	</script>
	
	<div class="title">
		<p>영입내역</p>
	</div>
	<div class="userMyPageWrap">
		<div class="userMyPageRoot">
			<p>홈 / 마이페이지 / 영입내역</p>
		</div>
		<div>
			<table class="applicationTable">
				<tr class="menuTitle">
					<td>기업명</td>
					<td>공고 제목</td>
					<td>제의 날짜</td>
					<td>합격 여부</td>
				</tr>
				<c:forEach  var="list" items="${ OfferByPostingByentInfoList }" varStatus="st">			
					<tr class="menuText">
						<td><c:out value="${ list.entName }"/></td>
						<td><c:out value="${ list.postingTitle }"/></td>
						<td><fmt:formatDate pattern="yyyy/MM/dd" value="${ list.offerDate }"/></td>
						<td class="connectYn${st.count}"><c:out value="${ list.offerConnectYn }"/></td>
					</tr>
					<tr>
						<td class="connectN${st.count}"><button class="buttons" onclick="location.href='${ pageContext.servletContext.contextPath }/user/offer/connect?no=${ list.offerNo  }'">영입 수락</button></td>
						<td class="connectY${st.count}"><p>수락 완료</p></td>
						<td><button class="buttons" onclick="location.href='${ pageContext.servletContext.contextPath }/user/offer/posting/detail?no=${ list.postingNo  }'">구인글 상세보기</button></td>
					</tr>
					
					<script>
						$(function(){
							$(".connectN${st.count}").hide();
							$(".connectY${st.count}").hide();
							
							if("<c:out value="${ list.offerConnectYn }"/>" == 'Y'){
								$(".connectN${st.count}").hide();
								$(".connectY${st.count}").show();
							} else {
								$(".connectN${st.count}").show();
								$(".connectY${st.count}").hide();
							}
						});
					</script>
				</c:forEach>
			</table>
		</div>
		<jsp:include page="../user/offerPaging.jsp"/>
	</div>
	
	
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>