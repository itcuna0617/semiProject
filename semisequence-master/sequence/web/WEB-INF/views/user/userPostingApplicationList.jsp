<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>

	<h2>구인공고 지원자 내역</h2>		<!-- 내가 올린 공고에 지원한 지원자 내역 리스트 -->
	<div>
		<table id="listArea">
			<tr>
				<td>지원내역 list1</td>
			</tr>
			<tr>
				<td>지원내역 list2</td>
			</tr>
			<tr>
				<td>지원내역 list3</td>
			</tr>
			<tr>
				<td>지원내역 list4</td>
			</tr>
			<%-- <c:forEach items="${ noticeList }" var="notice">			<!-- ex) 조회한 리트스 반복문으로 뿌려주는 작업 -->
				<tr>
					<td><c:out value="${ notice.no }"/></td>
					<td><c:out value="${ notice.title }"/></td>
					<td><c:out value="${ notice.writer.nickname }"/></td>
					<td><c:out value="${ notice.count }"/></td>
					<td><c:out value="${ notice.createdDate }"/></td>
				</tr>
			</c:forEach> --%>
		</table>
	</div>
	
	<script>
		if(document.getElementsByTagName("td")) {
			const $tds = document.getElementsByTagName("td");
			for(let i = 0; i < $tds.length; i++) {
								
				$tds[i].onclick = function() {									// 지원내역 클릭해서 상세보기
					
					/* const no = this.parentNode.children[0].innerText; */		// 해당 내역의 no? 값을 변수에 담우줘야함(일단 0으로 하겠음)
					const no = 0;
					location.href = "${ pageContext.servletContext.contextPath }/user/posting/application/detail"/* ?no=" + no; */
				}
			}
		}
	</script>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>