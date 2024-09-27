<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/entPaymentUpdate.css" type="text/css"/>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="entTitle">
		<p>정액제 변경</p>
	</div>
	<div class="entSettingWrap">
		<div class="entSettingRoot">
			<p>홈/마이페이지/결제 관리/정액제 변경</p>
		</div>
		<p class="plan-info">결제 상품을 선택해주세요.</p>
		<hr>
		<table id="standard">
			<tr>
				<td rowspan="2">스탠다드</td>
				<td>구인 공고 월 3회 작성</td>
				<td rowspan="2">월 20,000원</td>
			</tr>
			<tr>
				<td>영입제의 월 20회</td>
			</tr>
		</table>
		<table id="business">
			<tr>
				<td rowspan="2">비즈니스</td>
				<td>구인 공고 월 10회 작성</td>
				<td rowspan="2">월 50,000원</td>
			</tr>
			<tr>
				<td>영입제의 월 50회</td>
			</tr>
		</table>
		<table id="premium">
			<tr>
				<td rowspan="2">프리미엄</td>
				<td>구인 공고 월 무제한 작성</td>
				<td rowspan="2">월 100,000원</td>
			</tr>
			<tr>
				<td>영입제의 무제한</td>
			</tr>
		</table>
		<hr>
		<input id="agree" name="agree" type="radio"/><label for="agree">결제 내용을 확인하였으며, 결제에 동의합니다.(필수)</label>
		<form action="${ pageContext.servletContext.contextPath }/ent/paymentinsert" method="post">
			<input id="plan-name" name="planName" type="text" style="display:none;"/>
			<input id="plan-price" name="planPrice" type="text" style="display:none;"/>
			<button id="submit-button" type="submit" style="display:none; style="display:none;">전송</button>
		</form>
		<br>
		<button id="payment-button" type="submit" style="display:none;">결제</button>
		<button id="standard-button" type="submit" style="display:none;" value="스탠다드">스탠다드</button>
		<button id="business-button" type="submit" style="display:none;" value="비즈니스">비즈니스</button>
		<button id="premium-button" type="submit" style="display:none;" value="프리미엄">프리미엄</button>
	</div>
	<jsp:include page="../common/footer.jsp"/>
	<script>
		$("#agree").click(function(){
			$("#payment-button").show();
		});
		
		const $standard = document.getElementById("standard");
		const $business = document.getElementById("business");
		const $premium = document.getElementById("premium");
		const $planName = document.getElementById("plan-name");
		const $planPrice = document.getElementById("plan-price");
		
		$standard.onclick = function() { 
			document.getElementById("standard-button").click();
			$standard.style.border = "3px solid skyblue";
			$business.style.border = "0px";
			$premium.style.border = "0px";
			
			$planName.value = "스탠다드";
			$planPrice.value = "20000";
		}
		
		$business.onclick = function() { 
			document.getElementById("business-button").click();
			$standard.style.border = "0px";
			$business.style.border = "3px solid skyblue";
			$premium.style.border = "0px";
			
			$planName.value = "비즈니스";
			$planPrice.value = "50000";
		}
		
		$premium.onclick = function() { 
			document.getElementById("premium-button").click();
			$standard.style.border = "0px";
			$business.style.border = "0px";
			$premium.style.border = "3px solid skyblue";
			
			$planName.value = "프리미엄";
			$planPrice.value = "100000";
		}
	</script>
	<script>
	 $("#payment-button").click(function payed(){
		 	var planName = document.getElementById('plan-name').value;
		 	var price = document.getElementById('plan-price').value;
		 	var entEmail = "${ sessionScope.entEmail }";
		 	var entPhone = "${ sessionScope.entPhone }";
		 	var entName = "${ sessionScope.entName }";
		 
		 	console.log(planName);
		 	console.log(price);
		 	console.log(entEmail);
		 	console.log(entPhone);
		 	console.log(entName);
		 	
	        var IMP = window.IMP; // 생략가능
	        IMP.init('imp88319775'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
	        var msg;
	        
	        IMP.request_pay({
	            pg : 'kakaopay',
	            pay_method : 'card',
	            merchant_uid : 'merchant_' + new Date().getTime(),
	            name : planName,
	            amount : 1,
	            buyer_email : entEmail,
	            buyer_name : entName,
	            buyer_tel : entPhone,
	            //m_redirect_url : 'http://www.naver.com'
	        }, function(rsp) {
	            if ( rsp.success ) {
	                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
	                jQuery.ajax({
	                    url: "/ent/paymentinsert", //cross-domain error가 발생하지 않도록 주의해주세요
	                    type: 'POST',
	                    dataType: 'json',
	                    data: {
	                        imp_uid : rsp.imp_uid
	                        //기타 필요한 데이터가 있으면 추가 전달
	                    }
	                }).done(function(data) {
	                    //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
	                    if ( everythings_fine ) {
	                        msg = '결제가 완료되었습니다.';
	                        msg += '\n고유ID : ' + rsp.imp_uid;
	                        msg += '\n상점 거래ID : ' + rsp.merchant_uid;
	                        msg += '\결제 금액 : ' + rsp.paid_amount;
	                        msg += '카드 승인번호 : ' + rsp.apply_num;
	                        
	                        alert(msg);
	                    } else {
	                        //[3] 아직 제대로 결제가 되지 않았습니다.
	                        //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
	                    }
	                });
	                //성공시 이동할 페이지
	                location.href="<%=request.getContextPath()%>/entPaymentHistory.jsp";
	                document.getElementById("submit-button").click();
	            } else {
	                msg = '결제에 실패하였습니다.';
	                msg += '에러내용 : ' + rsp.error_msg;
	                //실패시 이동할 페이지
	                location.href="<%=request.getContextPath()%>/ent/entPaymentUpdate.jsp";
	                alert(msg);
	            }
	        });
	        
	    });
	</script>
</body>
</html>