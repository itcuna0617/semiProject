<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	table{
			border: 1px solid #444444;
		background-color: #ECD1D9;
			border-collapse: collapse;
			margin: 0 auto;
			padding: 10px;
	}
	#body{
		width: 820px;
		height: 700px;
		margin: 0 auto;
	}
	
</style>
<body>
	<jsp:include page="../common/header.jsp"/>
	<section>
		<div id="body">
		<table>
			<tr>
				<td colspan="6"><br>&nbsp;&nbsp;프로젝트 명 : ${requestScope.project.projectName}<hr></td>
				<td>
					<button id="updateProject" type="button" style="width: 100px">프로젝트 수정</button>
				</td>
				<td><button id="deleteProject" onclick="deleteProject()" style="width: 100px">프로젝트 삭제</button></td>
			</tr>
			
			<tr>
	            <td width="120px" height="40px" colspan="3">&nbsp;&nbsp;프로젝트 내용<hr></td>
	            <td colspan="2"> 프로젝트 명<hr>
	            <td colspan="3"> : ${requestScope.project.projectName}<hr></td>
	        </tr>
	        <tr>
	        	<td colspan="4" rowspan="4" width="500px">&nbsp;&nbsp;  ${requestScope.project.projectContent} </td>
	        	<td><br>매니저 이름<hr></td>
	            <td colspan="3"><br> : ${requestScope.project.managerName }<hr></td>
	        </tr>
	        <tr>
	        	<td>매니저 번호<hr></td>
	            <td colspan="3"> : ${requestScope.project.managerPhone }<hr></td>
	        </tr>
	        <tr>
	        	<td>매니저 메일<hr></td>
	            <td colspan="3"> : ${requestScope.project.managerEmail }<hr></td>
	        </tr>
        </table>
		<%-- 여기 화면 꾸밀 때, 15일 기준으로 공고 on/off, 다시 공개 기능 만들어야함. --%>
		<div id="postingList">
		<%-- json으로 주고 data.변수명 으로 입력하면 받을 수 있다. 나중에 다른 일들 끝내고 여유 있으면 json써서 다시 해보자. --%>
		</div>
		<br>
		
		<table >
			<tr>
				<td>    
					&nbsp;&nbsp;&nbsp;해당 프로젝트에 공고 등록 : <button id="insertPosting" type="button">공고 등록</button>
				</td>
				<td>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;프로젝트 단위 지원자 관리 : 
		<form action="${ pageContext.servletContext.contextPath }/application/select/by/ent" method="post" style="float: right">
			<input type="hidden" name="criteria" value="project">
			<input type="hidden" name="projectNo" value="${ requestScope.project.projectNo }">
			<input type="hidden" name="page" value="1">
			<button>지원 내역 전체 확인</button>
		</form>
				</td>
				<td>
		<form action="${ pageContext.servletContext.contextPath }/application/select/pass" method="post">
			<input type="hidden" name="criteria" value="project">
			<input type="hidden" name="projectNo" value="${ requestScope.project.projectNo }">
			<input type="hidden" name="page" value="1">
			<button>합격 명단</button>
		</form>
				</td>
				<td>
		<form action="${ pageContext.servletContext.contextPath }/application/select/fail" method="post">
			<input type="hidden" name="criteria" value="project">
			<input type="hidden" name="projectNo" value="${ requestScope.project.projectNo }">
			<input type="hidden" name="page" value="1">
			<button>탈락 명단</button>
		</form>
				</td>
			</tr>
		</table>
		
		</div>
	</section>
	<jsp:include page="../common/footer.jsp"/>
</body>

<script type="text/javascript">
	$('#insertPosting').click(function(){
		location.href='${pageContext.servletContext.contextPath}/posting/insert?projectNo=${ requestScope.project.projectNo }'
	});
	$('#updateProject').click(function(){
		location.href='${pageContext.servletContext.contextPath}/project/update?projectNo=${ requestScope.project.projectNo }'
	});
	function deleteProject() {
		if (confirm("정말로 삭제하시겠습니까?") == true) {
			location.href="${ pageContext.servletContext.contextPath }/project/delete?projectNo=${ requestScope.project.projectNo }";
		}
	}
	window.onload=function(){
		$.ajax({
			url: "${pageContext.servletContext.contextPath}/posting/list/by/project",
			method: "POST",
			data: {projectNo : ${requestScope.project.projectNo} },
			success: function(data){
				$("#postingList").html(data)
			},
			error: function(request, status){
				alert("code: " + request.status + "\n"
						+ "message: " + request.responseText);
			}
		})
	  };
</script>

<style>
	section{
		border-top: 1px solid #4b4b4b;
		padding: 20px 100px 20px 100px;
		margin: auto;
	}
	.posting{
		height: 56px;
		border: 1px solid #4b4b4b;
		cursor: pointer;
		margin: auto;
		weight: 700px;
	}
	#insertPosting{
		float: right;
	}
	#updatePosting{
		float: right;
	}
	#deletePosting{
		float: right;
	}
	#updateProject{
		float: right;
	}
	#deleteProject{
		float: right;
	}
</style>

</html>