<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../css/header.css">
<link rel="stylesheet" href="../../css/footer.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<h1>지원내역</h1>
	<div>
		<table>		<!-- 테이블에서 Detail 정보 select해 온 것 넣어줘야함 -->
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
				<td>프로젝트 소개</td>
				<td colspan="2">담당자 정보</td>
			</tr>
			<tr>
				<td rowspan="4">프로젝트 사진을 넣으세요~</td>
				<td>이름: </td>
				<td>번호: </td>
			</tr>
			<tr>
				<td>유호준</td>
				<td>010-1234-5555</td>
			</tr>
			<tr>
				<td colspan="2">메일</td>
			</tr>
			<tr>
				<td colspan="2">abcd123@bbb.com</td>
			</tr>
			<tr>
				<td>프로젝트 제목</td>
			</tr>
			<tr>
				<td>악마를 보았다</td>
			</tr>
			<tr>
				<td>소개</td>
			</tr>
			<tr>
				<td>이곳은 해당 기업의 프로젝트 소개 내용입니다..</td>
			</tr>
		</table>
	</div>

	<button onclick="location.href='${ pageContext.servletContext.contextPath }/user/application/list'">목록으로</button>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>