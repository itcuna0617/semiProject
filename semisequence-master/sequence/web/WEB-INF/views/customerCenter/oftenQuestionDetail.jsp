<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<p>자주 묻는 질문</p>
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
        <table class="boardTable">
							<tr>
								<td>등록일 </td>
								<td>2022.03.21</td>
								</tr>
							<tr>
								<td>질문 내용 </td>
								<td>평점은 수정이 가능한가요?</td>
							<tr>
								<td>답변 </td>
								<td colspan="3">
								<textarea style="resize:none; width:90%; height:200px;">평점은 수정이 불가합니다.</textarea>
								</td>
							</tr>
						</table>
					<a class="oftenQuestion" href="${ pageContext.servletContext.contextPath }/oftenQuestion">자주 묻는 질문</a>
	<jsp:include page="../common/footer.jsp"/>

</body>
</html>