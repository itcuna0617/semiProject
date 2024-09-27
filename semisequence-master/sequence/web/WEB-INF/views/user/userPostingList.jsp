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
	
	<h1>구인공고내역</h1>
	<div>
		<table>		
			<tr>
				<td>구인글 list 1</td>
			</tr>
			<tr>
				<td>구인글 list 2</td>
			</tr>
			<tr>
				<td>구인글 list 3</td>
			</tr>
		</table>
	</div>
	
	<script>
		if(document.getElementsByTagName("td")) {
			const $tds = document.getElementsByTagName("td");
			for(let i = 0; i < $tds.length; i++) {
								
				$tds[i].onclick = function() {									// 구인공고내역 클릭해서 상세보기
					
					/* const no = this.parentNode.children[0].innerText; */		// 해당 글의 no? 값을 변수에 담아줘야함(일단 0으로 하겠음)
					const no = 0;
					location.href = "${ pageContext.servletContext.contextPath }/user/posting/detail"/* ?no=" + no; */
				}
			}
		}
	</script>

	<jsp:include page="../common/footer.jsp"/>
</body>
</html>