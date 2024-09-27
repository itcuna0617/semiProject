<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/board.css" type="text/css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <jsp:include page="../common/header.jsp"/>
	<div class="customerCenterTitle">
		<p>구인공고</p>
	</div>
	<div class="boardSettingWrap">
		<div class="boardSettingRoot">
			<a href="index.jsp">홈/</a>
			<a href="#">마이페이지/</a>
			계정설정
		</div>
	</div>
   <h1 style="font-size: 25px; font-weight: bolder" align="center">구인공고</h1>
   <form>
      <table style="border: 1px solid #444444;">
         <tr>
            <th>구분</th>
            <th>등록일</th>
            <th>직군</th>
            <th>장르</th>
            <th>조회수</th>
         </tr>
         <tr>      
            <td>개인</td>
            <td><p><c:out value="${ requestScope.userPostingDetail.postingDate }"/></p></td>
            <td><p><c:out value="${ requestScope.userPostingDetail.jobName }"/></p></td>
            <td><p><c:out value="${ requestScope.userPostingDetail.genreName }"/></p></td>
            <td>1322</td>
         </tr>
         <tr>
            <td>제목</td>
            <td colspan="3"><p><c:out value="${ requestScope.userPostingDetail.postingTitle }"/></p></td>
         </tr>
         <tr>
            <td>구인상세내용</td>
            <td><textarea style="resize:none; width:90%; height:200px;" readonly><c:out value="${ requestScope.userPostingDetail.postingDetail }"/></textarea></td>
         </tr>
         <tr>
         	<td colspan="2">프로젝트 제목</td>
         	<td colspan="2">프로젝트 시작일</td><td colspan="2">프로젝트 종료일</td>
            <td colspan="2">프로젝트 소개</td>
            <td colspan="2">프로젝트 파일</td>
         </tr>
         <tr>
         	<td colspan="3"><p><c:out value="${ requestScope.userPostingDetail.projectName }"/></p></td>
        	<td colspan="3"><p><c:out value="${ requestScope.usrPostingDetail.projectStartDate }"/></p></td><td colspan="3"><p><c:out value="${ entPostingDetail.projectEndDate }"/></p></td>
        	<td colspan="3"><p><c:out value="${ requestScope.userPostingDetail.projectContent }"/></p></td>
        	<td colspan="3"><a href="http://localhost:8888/posting/filedownload.jsp">프로젝트 파일</a></td>
         </tr>
         <tr>
         	<td colspan="2">담당자명</td>
         	<td colspan="2">담당자 번호</td>
            <td colspan="2">담당자 이메일</td>
         </tr>
         <tr>
         	<td colspan="3"><p><c:out value="${ requestScope.userPostingDetail.managerName }"/></p></td>
        	<td colspan="3"><p><c:out value="${ requestScope.userPostingDetail.managerPhone }"/></p></td>
        	<td colspan="3"><p><c:out value="${ requestScope.userPostingDetail.managerEmail }"/></p></td>
         </tr>
      </table>
	</form>
	<input type="button" value="지원" onclick="btn_Application();" />
	
   <button onclick="location.href='${ pageContext.servletContext.contextPath }/entPostingList'">목록</button>
   
   <script>
  		function btn_Application() { 
  			window.open("/postingApplication.jsp", "공고 지원", "width=600, height=600, left=50, top=50"); }
   </script>
   
   <jsp:include page="../common/footer.jsp"/>
</body>
</html>