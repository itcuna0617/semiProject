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
	<script >
		$("deleteProject").on({
			click: function () {
				alert("삭제가 완료되었습니다.");
			}
		});
	</script>
	<jsp:include page="../common/header.jsp" />
	<%-- 여기에 마이페이지 영역 include 해야함 --%>
	<section id="projectListSection">
		<p id="projectList">프로젝트 목록</p>

		<div>
			<!-- 여기서 c:foreach로 selectList 반복돌려서
				갯수 얻고, div 갯수만큼 반복시킨다.
				float:right로 우측에 수정, 삭제 버튼 생성하고 
				반복문 종료시 마찬가지 floatright 버튼으로 프로젝트 추가-->
			
			<%-- <c:forEach var="project" items="${ requestScope.projectList }" var="">
				</c:forEach>   ${ requestScope.projectName } --%>
				<!-- 현재는 sessionScope.entNo는 일단 selectProjectListServlet에서 값을 1로 넣어주는 상태임. -->
			<c:forEach var="project" items="${ requestScope.projectList }" varStatus="status">
			
				<script>
					function deleteProject() {
						if (confirm("정말로 삭제하시겠습니까?") == true) {
							location.href="${ pageContext.servletContext.contextPath }/project/delete?projectNo=${ project.projectNo }";
						}
					}
				</script>
				
				<div class="project" id="project${ status.index }" >
					<div>  <%-- 삭제 버튼은 confirm 띄워서 이벤트처리하여 확인 받아야한다. --%>
						<button id="deleteProject" onclick="deleteProject()">삭제</button>
	 					<button id="updateProject" onclick="location.href='${ pageContext.servletContext.contextPath }/project/update?projectNo=${ project.projectNo }';">수정</button>
						<div id="projectName" onclick="location.href='${ pageContext.servletContext.contextPath }/project/detail?projectNo=<c:out value='${ project.projectNo }'/>';">
							${ status.count }번 프로젝트<br>
							 ※※${ project.projectName }※※
						</div>
					</div>
				</div>
			</c:forEach>
			<c:if test="${ empty requestScope.projectList }">
				<div>
					<p>프로젝트가 없습니다! 새로운 프로젝트를 지금 등록해보세요!</p>
				</div> 
			</c:if>
		</div>
			<div>
				<button id="insertProject" onclick="location.href='${ pageContext.servletContext.contextPath }/project/insert'">프로젝트 추가</button>
			</div>
				

	</section>

	<jsp:include page="../common/footer.jsp" />

</body>
<style>
#projectListSection {
	border-top: 1px solid #4b4b4b;
	padding: 20px 300px 20px 300px;
}

#projectName {
	float: left;
	margin: 0 2px 0 2px;
}

#updateProject {
	float: right;
	margin: 14px 2px 5px 2px;
}

#deleteProject {
	float: right;
	margin: 14px 10px 5px 2px;
}

#insertProject {
	float: right;
	margin: 20px 0 0 0;
}

.project {
	cursor: pointer;
	height: 60px;
	border: 1px solid #4b4b4b;
}
</style>

</html>