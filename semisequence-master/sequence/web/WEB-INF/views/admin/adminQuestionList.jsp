<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
		<h2 align="center">문의 내역</h2>
		
				<table class="table" align="center" style="border-spacing: 20px; border-collapse: separate; text-align: center">
					<tr>
						<th>문의 번호</th>
						<th width="100px">문의 제목</th>
						<th width="100px">등록일</th>
						<th width="100px">답변여부</th>
					</tr>
					<c:forEach items="${ adminQuestionList }" var="adminQuestionList">
						<tr id="question">
							<td><c:out value="${ adminQuestionList.queNo }"/></td>
							<td><c:out value="${ adminQuestionList.queTitle }"/></td>
							<td><c:out value="${ adminQuestionList.queDate }"/></td>
							<td><c:out value="${ adminQuestionList.ansYN }"/></td>
						</tr>
					</c:forEach>
				</table>
		
		<script>
			if(document.getElementsByTagName("td")) {
				const $tds = document.getElementsByTagName("td");
				for(let i = 0; i < $tds.length; i++) {
					
					$tds[i].onmouseenter = function() {
						this.parentNode.style.color = "gray";
						this.parentNode.style.cursor = "pointer";
					}
					
					$tds[i].onmouseout = function() {
						this.parentNode.style.color = "#4b4b4b";
					}
					
					$tds[i].onclick = function() {
						/* 게시물 번호까지 알아왔으니 이제 상세보기는 할 수 있겠죠? */
						const no = this.parentNode.children[0].innerText;
						location.href = "${ pageContext.servletContext.contextPath }/adminQuestionAnswer?queNo="+no;
					}
				}
			}
		</script>
	<jsp:include page="../admin/adminQuestionPaging.jsp"/>
</body>
</html>