<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/board.css" type="text/css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.boardTable{

  border: 1px solid #ccc;
  line-height: 4;
  margin: 0px 0px 0px 0px
}
.boardTable th{

  border-bottom: 1px solid #ccc;
  border-right: 1px solid #ccc;
}
.boardTable tr{

  border-bottom: 1px solid #ccc;
}
.boardTable td{

  border-bottom: 1px solid #ccc;
}
#button_ {
  font-family: 'MinSans-Medium';
  border: 0;
  outline: none;
  font-size: 20px;
  margin: 30px;
  background: #4b4b4b;
  color: white;
  cursor: pointer;
  padding: 10px;
}
#button_:hover {
  color: white;
  background: gray;
}
</style>
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
	
	<form>
		<div class="table-area" style="height:1300px; margin: 30px 50px 50px 300px !important;">
	
	   	  <table class="boardTable" style="text-align: center; height:920px; border-collapse: separate; align: center;">      <!-- 테이블에서 Detail 정보 select해 온 것 넣어줘야함 -->
	        
	        <tr>
	         <td><p><c:out value="${ entPostingDetail.postingNo }"/></p></td>
	        </tr>
	         <tr>
	            <td width="200px">구인 구분</td>
	            <td width="200px">등록일</td>
	            <td width="200px">직군</td>
	            <td width="100px">장르</td>
	            <td width="200px">조회수</td>
	         </tr>
	         <tr>      
	            <td>기업</td>
	            <td><p><c:out value="${ entPostingDetail.postingDate }"/></p></td>
	            <td><p><c:out value="${ entPostingDetail.jobName }"/></p></td>
           	    <td><p><c:out value="${ entPostingDetail.genreName }"/></p></td>
	            <td><p><c:out value="${ entPostingDetail.views }"/></p></td>
	            
	         </tr>  
	         <tr>
	            <th>제목</th>
	            <td colspan=4><p><c:out value="${ entPostingDetail.postingTitle }"/>
	         </tr>	
	         <tr>
	            <th>구인상세내용</th>
	            <td colspan=4><c:out value="${ entPostingDetail.postingDetail }"/></td>
	         </tr>
	         <tr>
	         	<td colspan=5>담당자 정보</td>
	         </tr>
	         <tr>
	         	 <th>이름</th>
	            <td colspan=4><p><c:out value="${ entPostingDetail.managerName }"/></p></td>
	         </tr>
	         <tr>
	         	<th>메일</th>
	            <td colspan=2><p><c:out value="${ entPostingDetail.managerEmail }"/></p></td>
	           	<th>번호</th>
	            <td colspan=2><p><c:out value="${ entPostingDetail.managerPhone }"/></p></td>
	        </tr>
	         <tr>
	         		         	
	            <th>프로젝트 기간</th>
        	    <td colspan=2><p><c:out value="${ entPostingDetail.projectStartDate }"/></p></td>
        	    <td colspan=2><p><c:out value="${ entPostingDetail.projectEndDate }"/></p></td>
	         </tr>
	         <tr>	
	         	<th>제목</th>
	         	<td colspan=4><p><c:out value="${ entPostingDetail.projectName }"/></p></td>
	         </tr>
	         <tr>	
	         	<th>소개</th>
	         	<td colspan=4><p><c:out value="${ entPostingDetail.projectContent }"/></p></td>         	
	         </tr>

	    </table>
	  <a id="button_" href="${ pageContext.servletContext.contextPath }/postingApplication?userId=${ sessionScope.userId }" >지원</a>
      <button id="button_" onclick="location.href='${ pageContext.servletContext.contextPath }/postingList'">목록</button>
	   </div> 
	</form>
	
	
   <jsp:include page="../common/footer.jsp"/>
</body>
</html>