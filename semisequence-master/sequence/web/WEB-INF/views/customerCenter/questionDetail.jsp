<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<style>
.boardTable{

  border: 1px solid #ccc;
  line-height: 4;
  margin: 20px 0px 0px 0px;

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
</style>
<meta charset="UTF-8">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/board.css" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
		
	<jsp:include page="../common/header.jsp"/>
		<div class="customerCenterTitle">
		<p>1:1문의</p>
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
		    <form  style="display: auto; margin: auto;">
		    	<div class="table-area" style="height:1500px;">
       				 <table class="boardTable" style="text-align: center; height:600px; border-collapse: separate; margin-left: auto; margin-right: auto; align: center;">
						<tr>
							<th width="300px">제목 </th>
							<th width="300px"><p><c:out value="${ question.queTitle }"/></p></th>
						</tr>
						<tr>
							<th width="300px">작성일</th>
							<th width="300px"><p><c:out value="${ question.queDate }"/></p></th>
						</tr>
						<tr>
							<td width="300px" colspan=2>내용 </td>
						</tr>
						<tr>
							<td colspan=2>
								<textarea style="resize: none; width: 500px; height: 200px; margin: 10px 50px 0px 60px;  resize:none;" readonly><c:out value="${ question.queContent }"/></textarea>
							</td>
						</tr>
					<c:if test="${ questionFile.queFileName != null }">
						<tr>
							<td><a href="/sequence/question/<c:out value="${ questionFile.queFileName }"/>" download>첨부파일</a></td>
						</tr>
					</c:if>
					</table>
				</div>
			</form>
						
				<a class="noticeList" href="${ pageContext.servletContext.contextPath }/questionList">목록</a>
			
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>