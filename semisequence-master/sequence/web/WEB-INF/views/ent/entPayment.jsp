<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/entPayment.css" type="text/css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="entTitle">
		<p>결제 내역 조회</p>
	</div>
	<div class="entSettingWrap">
		<div class="entSettingRoot">
			<a href="index.jsp">홈/</a>
			<a href="#">마이페이지/</a>
			<a href="#">결제 관리/</a>
			결제 내역 조회
		</div>
		<table>
			<tr>
				<td rowspan="2">스탠다드</td>
				<td>구인 공고 월 3회 작성</td>
				<td rowspan="2">월 20,000원</td>
			</tr>
			<tr>
				<td>영입제의 월 20회</td>
			</tr>
		</table>
		<table>
			<tr>
				<td rowspan="2">비즈니스</td>
				<td>구인 공고 월 10회 작성</td>
				<td rowspan="2">월 50,000원</td>
			</tr>
			<tr>
				<td>영입제의 월 50회</td>
			</tr>
		</table>
		<table>
			<tr>
				<td rowspan="2">프리미엄</td>
				<td>구인 공고 월 무제한 작성</td>
				<td rowspan="2">월 100,000원</td>
			</tr>
			<tr>
				<td>영입제의 무제한</td>
			</tr>
		</table>
		<button type="button" onclick="location.href='${ pageContext.servletContext.contextPath}/ent/paymentupdate'">정액제 변경</button>
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>