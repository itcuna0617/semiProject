<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/reset.css" type="text/css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
     <section>		
     <h1 style="text-align: center;"> 탈락자 명단 </h1>
		<div class="header">
	     	<h1>총 ${ noticePaging.total }명의 탈락자가 있습니다. </h1>
	     		<c:if test="${ requestScope.criteria == '공고' }">
	     			<h1 id="projectName" onclick="goToProject()" style="cursor: pointer;">프로젝트 명 : ${ requestScope.applicationList[0].project.projectName }</h1>
	     			<h3 id="postingTitle" onclick="goToPosting()" style="cursor: pointer;">구인공고 명 : ${ requestScope.applicationList[0].posting.postingTitle }</h3>
	     			<br>
	     		</c:if>
	     		<c:if test="${ requestScope.criteria == '기업' }">
					<h1>${ requestScope.applicationList[0].entInfo.entName }에서 탈락한 지원자 목록입니다.</h1>     			
	     		</c:if>
	     		<c:if test="${ requestScope.criteria == '프로젝트' }">
	     			<h1 id="projectName" onclick="goToProject()" style="cursor: pointer;">프로젝트 명 : ${ requestScope.applicationList[0].project.projectName }</h1>
	     			
	     		</c:if>
		</div>
   		<div class="appOdd">
     		<c:forEach items="${ requestScope.applicationList }" var="application" varStatus="status">
     			<c:if test="${ status.count%2==1 }">
					
				<table>
					<tr>
						<th colspan="7"><br>소개말 - ${ application.applicationIntro }<br>&nbsp;</th>
						<!-- <td colspan="11">  </td> -->
					</tr>
					<tr>
						<td colspan="2" rowspan="7" >
							<img src="${ pageContext.servletContext.contextPath }${ application.userPhoto.userPhotoSavedPath }" alt="사진" width="160" height="200" border="10" style="float:left;" >
						</td>
						<td colspan="3">
						</td>
					</tr>	
					<c:if test="${ requestScope.criteria == '기업' }">
						<tr>
							<td colspan="2" >프로젝트&nbsp;<hr></td>
							<td>&nbsp;${ application.project.projectName }<hr></td>
						</tr>
						<tr>
							<td colspan="2" >지원공고&nbsp;<hr></td>
							<td >&nbsp;${ application.posting.postingTitle }<hr></td>
						</tr>
			     	</c:if>
					<c:if test="${ requestScope.criteria == '프로젝트' }">
						<tr>
							<td colspan="2" >지원공고&nbsp;<hr></td>
							<td >&nbsp;${ application.posting.postingTitle }<hr></td>
						</tr>
		   			</c:if>
					<tr>
						<td colspan="2">이름<hr></td>
						<td >&nbsp;${ application.userProfile.userName }<hr></td>
					</tr>
					<tr>
						<td colspan="2">직무<hr></td>
						<td >&nbsp;${ application.job.jobName }<hr></td>
					</tr>
					<tr>
						<td colspan="2">지원일<hr></td>
						<td>&nbsp;				
							<fmt:parseDate var="appDate" pattern="yyyy-MM-dd" value="${ application.applicationDate }"></fmt:parseDate>
							<fmt:formatDate value="${ appDate }" pattern="yy-MM-dd"></fmt:formatDate><hr>
						</td>
					</tr>
					
					<tfoot>
						<tr>
							<td colspan="4"></td>
							<td style="float: right;">
								<form action="${ pageContext.servletContext.contextPath }/user/profile/detail" method="post">
									<input type="hidden" value="${ application.userProfileNo }" name="no">
									<button>지원자 프로필 조회</button>
								</form>
							</td>
							<td style="float: right;">
								<form action="${ pageContext.servletContext.contextPath }/application/pass" method="post">
									<input type="hidden" value="${ application.applicationNo }" name="applicationNo">
									<input type="hidden" value="1" name="page">
									<c:if test="${  requestScope.criteria == '기업'  }">
										<input type="hidden" value="ent" name="criteria">
									</c:if>
									<c:if test="${  requestScope.criteria == '프로젝트'  }">
										<input type="hidden" value="project" name="criteria">
										<input type="hidden" name="projectNo" value="${ application.posting.projectNo }">
									</c:if>
									<c:if test="${  requestScope.criteria == '공고'  }">
										<input type="hidden" value="posting" name="criteria">
										<input type="hidden" name="postingNo" value="${ application.postingNo }">
									</c:if>									
									<button>합격</button>
								</form>
							</td>
						</tr>
					</tfoot>
				 </table>
			  <br>
			  </c:if>
			</c:forEach>
		</div> <!-- 홀수 끝 -->
		<!--  짝수 시작 -->
   		<div class="appEven">
     		<c:forEach items="${ requestScope.applicationList }" var="application" varStatus="status">
     			<c:if test="${ status.count%2==0 }">
     			
				<table>
					<tr>
						<th colspan="7"><br>소개말 - ${ application.applicationIntro }<br>&nbsp;</th>
						<!-- <td colspan="11">  </td> -->
					</tr>
					<tr>
						<td colspan="2" rowspan="8" >
							<img src="${ pageContext.servletContext.contextPath }${ application.userPhoto.userPhotoSavedPath }" alt="사진" width="160" height="200" border="10" style="float:left;" >
						</td>
						<td colspan="3">
						</td>
					</tr>	
					<c:if test="${ requestScope.criteria == '기업' }">
						<tr	>
							<td colspan="2" >프로젝트&nbsp;<hr></td>
							<td>&nbsp;${ application.project.projectName }<hr></td>
						</tr>
						<tr>
							<td colspan="2" >지원공고&nbsp;<hr></td>
							<td >&nbsp;${ application.posting.postingTitle }<hr></td>
						</tr>
			     	</c:if>
					<c:if test="${ requestScope.criteria == '프로젝트' }">
						<tr>
							<td colspan="2" >지원공고&nbsp;<hr></td>
							<td >&nbsp;${ application.posting.postingTitle }<hr></td>
						</tr>
		   			</c:if>
					<tr>
						<td colspan="2">이름<hr></td>
						<td >&nbsp;${ application.userProfile.userName }<hr></td>
					</tr>
					<tr>
						<td colspan="2">직무<hr></td>
						<td >&nbsp;${ application.job.jobName }<hr></td>
					</tr>
					<tr>
						<td colspan="2">지원일<hr></td>
						<td>&nbsp;				
							<fmt:parseDate var="appDate" pattern="yyyy-MM-dd" value="${ application.applicationDate }"></fmt:parseDate>
							<fmt:formatDate value="${ appDate }" pattern="yy-MM-dd"></fmt:formatDate><hr>
						</td>
					</tr>
					
					<tfoot>
						<tr>
							<td colspan="4"></td>
							<td style="float: right;">
								<form action="${ pageContext.servletContext.contextPath }/user/profile/detail" method="post">
									<input type="hidden" value="${ application.userProfileNo }" name="no">
									<button>지원자 프로필 조회</button>
								</form>
							</td>
							<td style="float: right;">
								<form action="${ pageContext.servletContext.contextPath }/application/pass" method="post">
									<input type="hidden" value="${ application.applicationNo }" name="applicationNo">
									<input type="hidden" value="1" name="page">
									<c:if test="${  requestScope.criteria == '기업'  }">
										<input type="hidden" value="ent" name="criteria">
									</c:if>
									<c:if test="${  requestScope.criteria == '프로젝트'  }">
										<input type="hidden" value="project" name="criteria">
										<input type="hidden" name="projectNo" value="${ application.posting.projectNo }">
									</c:if>
									<c:if test="${  requestScope.criteria == '공고'  }">
										<input type="hidden" value="posting" name="criteria">
										<input type="hidden" name="postingNo" value="${ application.postingNo }">
										
									</c:if>	
									<button>합격</button>
								</form>
							</td>
						</tr>
					</tfoot>
				 </table>
			  <br>
			  </c:if>
			</c:forEach>
		</div> <!-- 홀수 행 끝 -->
	</section>
	<br clear="both"/>
	<jsp:include page="/WEB-INF/views/application/failPaging.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
	<script>
				function goToProject(){
					location.href="${ pageContext.servletContext.contextPath }/project/detail?projectNo=${requestScope.applicationList[0].posting.projectNo}"
				}
				function goToPosting(){
					location.href="${ pageContext.servletContext.contextPath }/posting/detail?postingNo=${requestScope.applicationList[0].postingNo}"
				}
				$("#postingTitle").hover(function(){
					$("#postingTitle").css("backgroundColor","#ccc");
				}, function(){
					$("#postingTitle").css("backgroundColor","#fff");
				});   // 호버이벤트 웨 않됌?
				$("#projectName").hover(function(){
					$("#projectName").css("backgroundColor","#ccc");
				}, function(){
					$("#projectName").css("backgroundColor","#fff");
				});
	</script>
	<style>
		h1{
			text-align: center;
		}
		body{
			margin: 0 auto;
		}
		img{
			padding: 10px;
		}
		td{
		text-align: center;
		}
		th{
			text-align: center;
		}
		table{
			border-collapse: collapse;
			color: black;
			background-color: grey;
			padding:10px;
			border: 1px solid #444444
		}
		hr{
			color: red;
		}
		section{
			padding: 20px 100px 20px 100px;
			width:1000px;
			margin: 0 auto;
		}
		.appOdd{
			margin: 10px auto;
			padding: 10px;
			float: left;
		}
		.appEven{
			margin: 10px auto;
			padding: 10px;
			float: left;
		}
		.introText{
			margin: auto;
			padding-top: 10px;
		}
		.appPicture{
			width: 100px;
			height: 130px;
			float:left;
		}
		.appNonPicture{
			height: 130px;
			float:left;
		}
		.applicationOdd{
			border: 1px solid black;
			width: 330px;
			float: left;
			margin: 5px auto;
			
		}
		.applicationEven{
			border: 1px solid black;
			width: 330px;
			float: right;
			margin: 5px auto;
		}
		.appIntro{
			height: 70px;
			text-align: center;
		}
		.appUserName{
			text-align: center;
			font-size: 30px;
			font: bold;
		}
		
	</style>
</html>