<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>

.adminAnswerTable {
    width: 30%;
    border: 1px solid #ccc;
    border-collapse: collapse;
    margin-left: auto;
    margin-right: auto;
  }
.adminAnswerTable td {
    border-bottom: 1px solid #ccc;
    padding: 10px;
  }
 a {
   margin-left: auto;
   margin-right: auto;
}
.adminAnswer_btn{
  margin-left: auto;
  margin-right: auto;
}
.resetAnswer_btn{
  margin-left: auto;
  margin-right: auto;
}
</style>

<title>Insert title here</title>
</head>
<body>
	<div style="margin: auto;">
	 <form action="${ pageContext.servletContext.contextPath }/adminQuestionAnswer?queNo=${ requestScope.adminQuestionDetail.queNo }" method="post">
		
       <table class="adminAnswerTable" >
       		<tr>
       			<td>문의번호</td>
       			<td><c:out value="${ adminQuestionDetail.queNo }"/></td>
       		</tr>
			<tr>
				<td>제목</td>
				<td><p><c:out value="${ adminQuestionDetail.queTitle }"/></p>
			</tr>
			<tr>
				<td>작성자</td>
				<td><c:out value="${ adminQuestionDetail.userId }"/></td>
			</tr>
			<tr>	
				<td>작성일</td>
				<td><p><c:out value="${ adminQuestionDetail.queDate }"/></p></td>
			</tr>
			<tr>
				<td>내용 </td>
				<td>
				<textarea style="resize:none; width:90%; height:200px;" readonly><c:out value="${ adminQuestionDetail.queContent }"/></textarea>
				</td>
			</tr>
			<c:if test="${ questionFile.queFileName != null }">
				<tr>
					<td><a href="/sequence/question/<c:out value="${ questionFile.queFileName }"/>" download>첨부파일</a></td>
				</tr>
			</c:if>	
		
		</table>
		<br>
			<table class="adminAnswerTable">
				<tr>
					<td>답변 제목</td>
					<td><input type="text" name="ansTitle" style="resize:none; width:90%; height:30px;"></td>
				</tr>
				<tr>	
					<td>답변 내용</td>
					<td><textarea name="ansContent" style="resize:none; width:90%; height:200px;"></textarea>
				</td>
				</tr>
			</table>
		<button class="adminAnswer_btn" type="submit">답변완료</button> <button class="resetAnswer_btn" type="reset">답변취소</button>
	</form>
	<a href="${ pageContext.servletContext.contextPath }/adminQuestionList";>목록</a>
	
	</div>		
						
	
</body>
</html>