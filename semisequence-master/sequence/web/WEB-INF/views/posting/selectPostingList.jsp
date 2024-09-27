<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script >
		$("deleteposting").on({
			click: function () {
				alert("삭제가 완료되었습니다.");
			}
		});
	</script>
	<jsp:include page="../common/header.jsp" />
	<%-- 여기에 마이페이지 영역 include 해야함 --%>
	<section id="postingListSection">
		<p id="postingList">구인 공고 전체 목록</p>

		<div>
		<%-- 임시로 entNo 1로 넣어준 상태 --%>
			<c:forEach var="posting" items="${ requestScope.postingList }" varStatus="status">
				<script>
					function deletePosting() {
						if (confirm("정말로 삭제하시겠습니까?") == true) {
							location.href = '${ pageContext.servletContext.contextPath }/posting/delete?postingNo=${ posting.postingNo }';
						}
					}
				</script>
				<c:if test="${posting.postingOpenYN == 'Y'}">
				<div class="posting" id="posting${ status.index }" >
					<div>
	 					<button id="closePosting" onclick="location.href='${ pageContext.servletContext.contextPath }/posting/close?postingNo=${ posting.postingNo }';">비공개</button>
						<button type="button" id="deletePosting" onclick="deletePosting()">삭제</button>
	 					<button id="updatePosting" onclick="location.href='${ pageContext.servletContext.contextPath }/posting/update?postingNo=${ posting.postingNo }';">수정</button>
						<div id="postingName" onclick="location.href='${ pageContext.servletContext.contextPath }/posting/detail?postingNo=${ posting.postingNo }';">
							${ status.count }번 공고 &nbsp; &nbsp; 등록일 : ${ posting.postingDate }<br>
							 ※※ ${ posting.postingTitle } ※※<br>
							 프로젝트 명 : 
							<a id="projectName" href="${ pageContext.servletContext.contextPath }/project/detail?projectNo=${ posting.projectNo }">
								${ posting.project.projectName }
							</a>
						</div>
					</div>
				</div>
				</c:if>
				<c:if test="${posting.postingOpenYN=='N'}">
				<div class="closedPosting" id="posting${ status.index }" >
					<div>
						<button id="openPosting" onclick="location.href='${ pageContext.servletContext.contextPath }/posting/open?postingNo=${ posting.postingNo }';">공개</button>
						<button type="button" id="deletePosting" onclick="deletePosting()">삭제</button>
	 					<button id="updatePosting" onclick="location.href='${ pageContext.servletContext.contextPath }/posting/update?postingNo=${ posting.postingNo }';">수정</button>
						<div id="postingName" onclick="location.href='${ pageContext.servletContext.contextPath }/posting/detail?postingNo=${ posting.postingNo }';">
							${ status.count }번 공고 &nbsp; &nbsp; 등록일 : ${ posting.postingDate }<br>
							※※ ${ posting.postingTitle }※※<br><br>
							프로젝트 명 : 
							<a id="projectName" href="${ pageContext.servletContext.contextPath }/project/detail?projectNo=${ posting.projectNo }">
								${ posting.project.projectName }
							</a>
						</div>
					</div>
				</div>
				</c:if>
			</c:forEach>
			<c:if test="${ empty requestScope.postingList }">
				<div>
					<p>등록된 공고가 없습니다! 새로운 공고를 지금 등록해보세요!</p>
				</div>
			</c:if>
			<div>
				<button id="insertPosting" onclick="location.href='${ pageContext.servletContext.contextPath }/posting/insert/by/list'">공고 등록</button>
			</div>
			<br>
			<br>
		</div>
				

	</section>

	<jsp:include page="../common/footer.jsp" />

</body>

<style>
#postingListSection {
	border-top: 1px solid #4b4b4b;
	padding: 20px 300px 20px 300px;
}

#postingName {
	float: left;
	margin: 0 2px 0 2px;
}

#updatePosting {
	float: right;
	margin: 14px 2px 5px 2px;
}

#deletePosting {
	float: right;
	margin: 14px 2px 5px 2px;
}
#closePosting {
	float: right;
	margin: 14px 2px 5px 2px;
}
#openPosting {
	float: right;
	margin: 14px 2px 5px 2px;
}

#insertPosting {
	float: right;
}

.posting {
	cursor: pointer;
	height: 80px;
	border: 1px solid #4b4b4b;
}
.closedPosting {
	cursor: pointer;
	height: 80px;
	border: 1px solid #4b4b4b;
	background-color: gray;
}
</style>

</html>