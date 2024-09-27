<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>

	<section>
		<div id="projectName">
			<h1>프로젝트 명 : ${ requestScope.projectName }</h1>
		</div>
		<div id="postingTitle">
			<h1>공고 제목 : ${ requestScope.posting.postingTitle }</h1>
			<br>
			<p style='text-align: right'>${ requestScope.posting.postingDate }
			</p>
		</div>
		<h3>공고 내용</h3>
		<div id="postingDetail">
			${ requestScope.posting.postingDetail }
		</div>
		<div>
		<table style="float:right;">
		
			
			<tr>
				<td> 공고 관리 : &nbsp;</td>
				<td>
					<c:if test="${ requestScope.posting.postingOpenYN =='Y' }">
						<button id="closePosting"
							onclick="location.href='${ pageContext.servletContext.contextPath }
								/posting/close?postingNo=${ requestScope.posting.postingNo }';">비공개</button>
					</c:if>
					<c:if test="${ requestScope.posting.postingOpenYN =='N' }">
						<button id="openPosting"
							onclick="location.href='${ pageContext.servletContext.contextPath }
								/posting/open?postingNo=${ requestScope.posting.postingNo }';">공개</button>
					</c:if>
				</td>
				<td>
					<c:if test="${ requestScope.posting.postingDeleteYN =='N' }">
						<button type="button" id="deletePosting" onclick="deletePosting()">삭제</button>
					</c:if>
				</td>
				<td>
					<form action="${ pageContext.servletContext.contextPath }/posting/update" method="get">
						<input type="hidden" name="postingNo" value="${ requestScope.posting.postingNo }">
						<button>수정</button>
					</form>
				</td>
			</tr>
			<tr>
				<td>지원자 관리 : &nbsp;</td>
				<td>
					<form action="${ pageContext.servletContext.contextPath }/application/select/by/ent" method="post">
						<input type="hidden" name="criteria" value="posting">
						<input type="hidden" name="postingNo" value="${ requestScope.posting.postingNo }">
						<input type="hidden" name="page" value="1">
						<button>지원자 조회</button>
					</form>
				</td>
				<td>
					<form action="${ pageContext.servletContext.contextPath }/application/select/pass" method="post">
						<input type="hidden" name="criteria" value="posting">
						<input type="hidden" name="postingNo" value="${ requestScope.posting.postingNo }">
						<input type="hidden" name="page" value="1">
						<button>합격 명단</button>
					</form>
				</td>
				<td>
					<form action="${ pageContext.servletContext.contextPath }/application/select/fail" method="post">
						<input type="hidden" name="criteria" value="posting">
						<input type="hidden" name="postingNo" value="${ requestScope.posting.postingNo }">
						<input type="hidden" name="page" value="1">
						<button>탈락 조회</button>
					</form>
				</td>
			</tr>
			
			</table>
			
			<%-- <button id="selectApplication"
				onclick="location.href='${ pageContext.servletContext.contextPath }
					/application/select/by/ent?postingNo=${ requestScope.posting.postingNo }&&criteria=posting';">지원조회</button> --%>
		</div>
	</section>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
<script>
	function deletePosting() {
		if (confirm("정말로 삭제하시겠습니까?") == true) {
			location.href = "${ pageContext.servletContext.contextPath }/posting/delete?postingNo=${ posting.postingNo }";
		}
	}
</script>
<style>
section {
	border-top: 1px solid #4b4b4b;
	padding: 20px 300px 20px 300px;
	height: 600px;
}

.posting {
	height: 50px;
	border: 1px solid #4b4b4b;
}

#insertPosting {
	float: right;
}

#postingDetail {
	border: 1px solid #4b4b4b;
	height: 300px;
	background-color: #D3D3D3;
}

#postingTitle {
	border: 1px solid #4b4b4b;
		background-color: #D3D3D3;
	
}
</style>
</html>