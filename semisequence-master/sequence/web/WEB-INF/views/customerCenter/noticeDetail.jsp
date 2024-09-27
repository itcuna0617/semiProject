<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/board.css" type="text/css"/>
<title>Insert title here</title>
<style>
.boardTable{

  border: 1px solid #ccc;
  line-height: 4;
  margin: 0px 0px 0px 0px
}
.boardTable th{

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
a {
  text-decoration: none;
	color: #4b4b4b;
}
textarea{
	margin : 10px 0 0 0;
}
</style>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
	
	<div class="customerCenterTitle">
		<p>공지사항</p>
	</div>
		<div class="boardSettingWrap">
			<div class="boardSettingRoot">
				<a href="index.jsp">홈/</a>
				<a href="#">마이페이지/</a>
				계정설정
			</div>
		</div>
			<nav class="menubar">
				<ul>
		            <li><a id="menuLink" href="${ pageContext.servletContext.contextPath }/noticeList">공지사항</a></li>
		            <li><a id="menuLink" href="${ pageContext.servletContext.contextPath }/questionList">1:1 문의</a></li>
		            <li><a id="menuLink" href="${ pageContext.servletContext.contextPath }/oftenQuestion">자주 묻는 질문</a></li>
		            <li><a id="menuLink" href="${ pageContext.servletContext.contextPath }/userAgreement">이용약관</a></li>
		        </ul>
		    </nav>
		
		    <form>
				<div class="table-area" style="height:800px; margin: 0px 50px 50px 300px !important;">
				<table class="boardTable" style="text-align: center; height:500px; border-collapse: separate; align: center;">
					<tr>
						<th width="200px">번호</th>
						<th width="300px">제목 </th>
						<th width="200px">작성일</th>
					</tr>
					<tr>
						<td width="100px"><p><c:out value="${ requestScope.notice.noticeNo }"/></p></td>
						<td width="400px"><p><c:out value="${ requestScope.notice.noticeTitle }"/></p></td>
						<td width="200px"><p><c:out value="${ requestScope.notice.noticeDate }"/></p></td>
					</tr>
					<tr>
						<td colspan=3>내용</td>
					</tr>
					<tr>
						<td colspan=3>
							<textarea style="resize:none;  border: 1px solid #ccc; width:500px; height:200px;" readonly><c:out value="${ requestScope.notice.noticeContent }"/></textarea>
						</td><!-- 안이쁘게 나오면 c:out 빼도 됨 -->
					</tr>
				</table>
				
				<br>
				<a class="noticeList" href="${ pageContext.servletContext.contextPath }/noticeList">목록</a>
			
			</div>
		</form>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>