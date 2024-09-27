<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
	<jsp:include page="../common/header.jsp"/>
	
	<h1>지원내역</h1>
	<div>
		<table>		<!-- 테이블에서 Detail 정보 select해 온 것 넣어줘야함 -->
			<tr>
				<td>등록일</td>
				<td>직군</td>
			</tr>
			<tr>		
				<td>2022.01.11</td>
				<td>배우</td>
			</tr>
			<tr>
				<td>지원</td>
			</tr>
			<tr>
				<td>안녕하세요 열심히 이쁘게 연기하겠습니다!</td>
			</tr>
			<tr>
				<td>프로필 사진</td>
				<td colspan="2">담당자 정보</td>
			</tr>
			<tr>
				<td rowspan="4">프로젝트 사진을 넣으세요~</td>
				<td>이름: </td>
				<td>나이: </td>
				<td>번호: </td>
			</tr>
			<tr>
				<td>유호준</td>
				<td>27</td>
				<td>010-1234-5555</td>
			</tr>
			<tr>
				<td colspan="3">주소지</td>
			</tr>
			<tr>
				<td colspan="3">서울시 광진구</td>
			</tr>
			<tr>
				<td>자기 소개</td>
			</tr>
			<tr>
				<td>저는 사람들을 웃게할 수 있고 울게할 수 있는 배우입니다.</td>
			</tr>
			<tr>
				<td>경력사항</td>
			</tr>
			<tr>
				<td>경력1</td>
				<td>영화 괴물 맥주캔 던지는 남자 A 출연</td>
			</tr>
			<tr>
				<td>경력2</td>
				<td>
					드라마 천국으로 가는 공룡 잡아먹히는 남자 C 출연
					드라마 천국으로 가는 계단 계단 올라가는 남자 B 출연
				</td>
			</tr>
			<tr>
				<td>포트폴리오</td>
				<td>
					괴물 포트폴리오.pdf
					천국으로 가는 공룡 포트폴리오.pdf
				</td>
			</tr>
		</table>
	</div>

	<button onclick="location.href='${ pageContext.servletContext.contextPath }/user/application/list'">목록으로</button>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>