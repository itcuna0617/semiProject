<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/entIdSettingInput.css" type="text/css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
	<div class="entTitle">
		<p>계정설정</p>
	</div>
	<div class="entSettingWrap">
		<div class="entSettingRoot">
			<p>홈/마이페이지/계정설정/계정설정 변경</p>
		</div>
		<form action="${ pageContext.servletContext.contextPath }/ent/settingupdate" method="post">
			<table class="member-setting">
				<tr>
					<td>기업명</td>
					<td><input type="text" name="entName" value="${ sessionScope.entName }"></td>
				</tr>
				<tr>
					<td>대표 번호</td>
					<td><input type="text" name="entPhone" value="${ sessionScope.entPhone }"></td>
				</tr>
				<tr>
					<td>대표 이메일</td>
					<td><input type="text" name="entEmail" value="${ sessionScope.entEmail }"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center;"><button type="submit">수정완료</button></td>
				</tr>	
			</table>
		</form>
	</div>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>