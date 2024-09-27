<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/entPaymentHistory.css" type="text/css"/>
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
			<p>홈/마이페이지/결제 관리</p>
		</div>
		<h1 class="payment-member-rate"><c:out value="${ sessionScope.loginMember.entName }"/>님은 <c:out value="${ requestScope.ratePlanByEntInfo.planName }"/>회원입니다.</h1>
		<h2 class="plan-info-title">남은 혜택 내역</h2>
		<div class="plan-info">
			<h2>구인 공고</h2>
			<h3>잔여 횟수:&nbsp;<c:out value="${ requestScope.ratePlanByEntInfo.planOfferCount }"/>회</h3>
			<h2>영입 제의</h2>
			<h3>잔여 횟수:&nbsp;<c:out value="${ requestScope.ratePlanByEntInfo.planProjectCount }"/>회</h3>
			<button type="button" onclick="location.href='${ pageContext.servletContext.contextPath}/ent/paymentupdate'">정액제 변경</button>
		</div>
		<h1 class="payment-history-title">최근 결제 내역</h1>
		<div class="payment-history-wrap">
			<ol class="paymet-history" start="1">
				<c:forEach items="${ requestScope.paymentHistory }" var="History">
					<li><c:out value="${ History.planName }"/>&nbsp;<fmt:formatNumber type="number" maxFractionDigits="3" value="${ History.planPrice.planPrice }"/>원&nbsp;<fmt:formatDate pattern="yyyy년MM월dd일" value="${ History.entPaymentTime }"/></li>
				</c:forEach>
			</ol>
		</div>
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>