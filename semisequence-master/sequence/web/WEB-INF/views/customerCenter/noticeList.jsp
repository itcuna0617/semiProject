<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<p>공지사항</p>
	</div>
	<div class="boardSettingWrap">
		<div class="boardSettingRoot">
			<a href="index.jsp">홈/</a>
			<a href="#">마이페이지/</a>
			계정설정
		</div>
	<div class="noticeList">

		<nav class="menubar">
			<ul>
	            <li><a id="menuLink" href="${ pageContext.servletContext.contextPath }/noticeList">공지사항</a></li>
	            <li><a id="menuLink" href="${ pageContext.servletContext.contextPath }/questionList">1:1 문의</a></li>
	            <li><a id="menuLink" href="${ pageContext.servletContext.contextPath }/oftenQuestion">자주 묻는 질문</a></li>
	            <li><a id="menuLink" href="${ pageContext.servletContext.contextPath }/userAgreement">이용약관</a></li>
	        </ul>
	    </nav>
			<div class="table-area" style="padding: 0px 0px 0px 60px !important;">
				<table class="boardTable" style=" border-spacing: 20px; border-collapse: separate; text-align: center;">
					<tr>
						<th >글번호</th>
						<th width="300px">제목</th>
						<th width="200px">등록일</th>
					</tr>

					<c:forEach items="${ noticeList }" var="notice">
						<tr>
							<td><c:out value="${ notice.noticeNo }"/></td>
							<td><c:out value="${ notice.noticeTitle }"/></td>
							<td><c:out value="${ notice.noticeDate }"/></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<jsp:include page="../customerCenter/noticePaging.jsp"/>
	<script>
		if(document.getElementsByTagName("td")) {
			const $tds = document.getElementsByTagName("td");
			for(let i = 0; i < $tds.length; i++) {
				
				$tds[i].onmouseenter = function() {
					this.parentNode.style.color = "gray";
					this.parentNode.style.cursor = "pointer";
				}
				
				$tds[i].onmouseout = function() {
					this.parentNode.style.color = "#4b4b4b";
				}
				
				$tds[i].onclick = function() {
					/* 게시물 번호까지 알아왔으니 이제 상세보기는 할 수 있겠죠? */
					const no = this.parentNode.children[0].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/noticeDetail?noticeNo="+no;
				}
			}
		}
	</script>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>