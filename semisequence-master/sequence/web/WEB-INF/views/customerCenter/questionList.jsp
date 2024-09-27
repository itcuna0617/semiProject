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
a {
  text-decoration: none;
	color: #4b4b4b;
}
</style>
</head>
<body>
		

	 <jsp:include page="../common/header.jsp"/>
	<div class="customerCenterTitle">
		<p>1:1 문의</p>
	</div>
	<div class="boardSettingWrap">
		<div class="boardSettingRoot">
			<a href="index.jsp">홈/</a>
			<a href="#">마이페이지/</a>
			문의내역
		</div>
	
		<nav class="menubar">
			<ul>
	            <li><a id="menuLink" href="${ pageContext.servletContext.contextPath }/noticeList">공지사항</a></li>
	            <li><a id="menuLink" href="${ pageContext.servletContext.contextPath }/questionList">1:1 문의</a></li>
	            <li><a id="menuLink" href="${ pageContext.servletContext.contextPath }/oftenQuestion">자주 묻는 질문</a></li>
	            <li><a id="menuLink" href="${ pageContext.servletContext.contextPath }/userAgreement">이용약관</a></li>
	        </ul>
	    </nav>
		
			
			<div class="table-area" style="padding: 0px 0px 0px 10px !important;">
				<table class="boardTable" style="border-spacing: 20px; border-collapse: separate; text-align: center;">
					<tr>
						<td><a class="noticeList" href="${ pageContext.servletContext.contextPath }/newQuestionInsert" method="get" >문의하기</a>
			</td>
					</tr>
					<tr>
						<th width="100px">문의 번호</th>
						<th width="300px">문의 제목</th>
						<th width="100px">등록일</th>
						<th width="100px">답변여부</th>
					</tr>
					<c:forEach items="${ questionList }" var="question">
						<tr id="question">
							<td><c:out value="${ question.queNo }"/></td>
							<td><c:out value="${ question.queTitle }"/></td>
							<td><c:out value="${ question.queDate }"/></td>
							<td><c:out value="${ question.ansYN }"/></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

	<jsp:include page="../customerCenter/questionPaging.jsp"/>
			<script>
			if(document.getElementsByTagName("td")) {
				const questionTrs = document.querySelectorAll('tr#question');
				
				for(let i = 0; i < questionTrs.length; i++) {
					questionTrs[i].onmouseenter = function() {
						this.style.color = "gray";
						this.style.cursor = "pointer";
					}
					
					questionTrs[i].onmouseout = function() {
						this.style.color = "#4b4b4b";
						this.style.cursor = "pointer"
					}
					
					questionTrs[i].onclick = function() {
						
						const no = this.children[0].innerText;
						const ansYN = this.children[3].innerText;
						
						if(ansYN == 'Y'){
							location.href = "${ pageContext.servletContext.contextPath }/questionAnswerDetail?queNo="+no;
						} else{
							location.href = "${ pageContext.servletContext.contextPath }/questionDetail?queNo="+no;	
					}
				}
			}
		}
		</script>
	
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>