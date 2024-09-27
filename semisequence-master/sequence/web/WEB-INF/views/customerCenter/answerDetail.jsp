<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/board.css" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
		<div class="customerCenterTitle">
		<p>고객센터</p>
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
		  <div class="table-area" style="padding: 10px 300px 10px 260px !important;" >
		    <form class="bodyForm" display="0 auto" margin="0 auto";>
       				 <table class="boardTable" style=" border-spacing: 20px; border-collapse: separate; align: center;">
						<tr>
							<td>제목 </td>
							<td colspan="3"><p><c:out value="${ answer.queTitle }"/></p>
						</tr>
						<tr>
							<td>작성일</td>
							<td><p><c:out value="${ answer.queDate }"/></p></td>
						</tr>
						<tr>
							<td>내용 </td>
							<td colspan="3">
								<textarea style="resize:none; width:90%; height:200px;" readonly><c:out value="${ answer.queContent }"/></textarea>
							</td>
						<c:if test="${ questionFile.queFileName != null }">
							<tr>
								<td><a href="/sequence/question/<c:out value="${ questionFile.queFileName }"/>" download>첨부파일</a></td>
							</tr>
						</c:if>
					</table>	
					<table>	
						<tr>
							<td>
							    답변제목
								<c:out value="${ answer.ansTitle }"/>
							</td>
						</tr>
						<tr>
							<td>
							    답변일
							    <c:out value="${ answer.ansDate }"/>
							</td>
						</tr>
						<tr>
							<td>
							    답변내용
							    <textarea style="resize:none; width:90%; height:200px;" readonly><c:out value="${ answer.ansContent }"/></textarea>
							</td>
						</tr>
				</table>
				<a class="noticeList" href="${ pageContext.servletContext.contextPath }/questionList">목록</a>
			</form>
		</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>