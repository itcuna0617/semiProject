<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
	<h1>구인공고 수정페이지</h1>
	<div>
		<form action="${ pageContext.servletContext.contextPath }/user/posting/update" method="post">
			<table>	
				<tr>
					<td>구인 구분</td>
					<td>등록일</td>
					<td>직군 / 장르</td>
					<td>조회수</td>
				</tr>
				<tr>		
					<td>기업</td>
					<td>2022.01.11</td>
					<td>배우 / 영화</td>
					<td>1322</td>
				</tr>
				<tr>
					<td>제목</td>
				</tr>
				<tr>
					<td>영화 악마를 보았다.의사 역 단역 배우 모집합니다.</td>
				</tr>
				<tr>
					<td>구인상세내용</td>
				</tr>
				<tr>
					<td>역할 : 의사 성명 : 남자 연령대 4~60대</td>
				</tr>
				<tr>
					<td>프로젝트</td>
				</tr>
				<tr>
					<td>여기에는 프로젝트 파일이 들어갑니다.pdf</td>
				</tr>
			</table>
			<div>
				<button onclick="location.href='${ pageContext.servletContext.contextPath }/user/posting/detail'">취소하기</button>
				<button type="submit">수정하기</button>
			</div>
		</form>
	</div>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>