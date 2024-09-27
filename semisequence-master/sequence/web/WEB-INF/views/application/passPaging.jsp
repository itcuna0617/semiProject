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
	<div class="pagingArea" align="center">
		<!-- 맨 앞으로 이동 버튼 -->
	    <button id="startPage"><<</button>
		
		<!-- 이전 페이지 버튼 -->
		<c:if test="${ requestScope.noticePaging.currentPage <= 1 }">
			<button disabled><</button>
		</c:if>
		<c:if test="${ requestScope.noticePaging.currentPage > 1 }">
			<button id="prevPage"><</button>
		</c:if>
		
		<!-- 숫자 버튼 -->
		<c:forEach var="p" begin="${ requestScope.noticePaging.startPage }" end="${ requestScope.noticePaging.endPage }" step="1">
			<c:if test="${ requestScope.noticePaging.currentPage eq p }">
				<button disabled><c:out value="${ p }"/></button>
			</c:if>
			<c:if test="${ requestScope.noticePaging.currentPage ne p }">
				<button onclick="location.href='${ pageContext.servletContext.contextPath }/application/select/pass?page=<c:out value="${ p }"/>&&criteria=<c:out value="${ requestScope.criteria }"/>'"><c:out value="${ p }"/></button>
			</c:if>
		</c:forEach>
		
		<!-- 다음 페이지 버튼 -->
		<c:if test="${ requestScope.noticePaging.currentPage >= requestScope.noticePaging.totalPages }">
			<button disabled>></button>
		</c:if>
		<c:if test="${ requestScope.noticePaging.currentPage < requestScope.noticePaging.totalPages }">
			<button id="nextPage">></button>
		</c:if>
		
		<!-- 마지막 페이지로 이동 버튼 -->
		<button id="totalPages">>></button> 
	</div>
	
	<script>
	
		const link = "${ pageContext.servletContext.contextPath }/application/select/pass";
		
		if(document.getElementById("startPage")) {
			const $startPage = document.getElementById("startPage");
			$startPage.onclick = function() {
				location.href = link + "?page=1&&criteria=<c:out value="${ requestScope.criteria }"/>";
			}
		}
		
		if(document.getElementById("prevPage")) {
			const $prevPage = document.getElementById("prevPage");
			$prevPage.onclick = function() {
				location.href = link + "?page=${ requestScope.noticePaging.currentPage - 1 }&&criteria=<c:out value="${ requestScope.criteria }"/>";
			}
		}
		
		if(document.getElementById("nextPage")) {
			const $nextPage = document.getElementById("nextPage");
			$nextPage.onclick = function() {
				location.href = link + "?page=${ requestScope.noticePaging.currentPage + 1 }&&criteria=<c:out value="${ requestScope.criteria }"/>";
			}
		}
		
		if(document.getElementById("totalPages")) {
			const $totalPages = document.getElementById("totalPages");
			$totalPages.onclick = function() {
				location.href = link + "?page=${ requestScope.noticePaging.totalPages }&&criteria=<c:out value="${ requestScope.criteria }"/>";
			}
		}
	</script>
</body>
</html>