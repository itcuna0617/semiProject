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
			<div  class="table-area" style="padding: 0px 100px 0px 250px !important;">
				<table class="boardTable" style=" border-spacing: 20px; border-collapse: separate; text-align: center;">
				<!-- 이거..유형별로 조회해야하지 않을까.. -->
					<tr>
						<th width="100px">문의 번호</th>
						<th width="300px">질문내용</th>
						<th width="100px">구분</th>
					</tr>
					<tr>
						<td>1</td>
						<td width="300px">지원 내역은 보호가 되나요?</td>
						<td width="100px">이용</td>
					</tr>
					<tr>
						<td>2</td>
						<td width="300px">정부 지원 사업도 이용 가능한가요?</td>
						<td width="100px">이용</td>
					</tr>
					<tr>
						<td>3</td>
						<td width="300px">결제 방식은 어떻게 이루어지나요?</td>
						<td width="100px">결제</td>
					</tr>
					<tr>
						<td>4</td>
						<td width="300px">결제 이후 현금영수증을 신청할 수 있나요?</td>
						<td width="100px">결제</td>
					</tr>
					<tr>
						<td>5</td>
						<td width="300px">회원 탈퇴는 어떻게 이루어지나요?</td>
						<td width="100px">계정</td>
					</tr>
					<tr>
						<td>6</td>
						<td width="300px">신고 처리는 어떻게 이루어지나요?</td>
						<td width="100px">신고</td>
					</tr>
				</table>
				<jsp:include page="../common/paging.jsp"/>
			</div>
			
			
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