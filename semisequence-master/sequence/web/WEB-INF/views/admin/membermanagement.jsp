<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<meta charset="UTF-8">
<style>
	body{
		background-color: black;
	}
	
	a{
		color: white;
	}
	
	h1{
	 	color: white;
	}
	
	table {
	 border: 1px solid white;
	 color: white;
	}
	
	tr, th, td{
		border: 1px solid white;
		padding: 3px;
	}
	
</style>
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">회원 제재</h1>
	
	<div>
		<form name="userForm" action="${ pageContext.servletContext.contextPath }/AdminDropUserServlet" method="get">
			<table align="center">
				<tr>
					<td colspan="8">
						<select name="userType" id="listType">
							<option value="user">개인</option>
							<option value="ent">기업</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>선택</th>
					<th>회원번호</th>
					<th>회원명</th>
					<th>ID</th>
					<th>전화번호</th>
					<th>Email</th>
					<th>제재여부</th>
				</tr>
	 			<c:forEach var="userList" items="${ requestScope.userList }">
					<tr class="usertr">
						<td style="text-align:center;"><input name="RowCheck" type="checkbox" value="${ userList.userNo }"/></td>
						<td style="text-align:center;"><c:out value="${ userList.userNo }"></c:out></td>
						<td><c:out value="${ userList.userName }"></c:out></td>
						<td><c:out value="${ userList.userId }"></c:out></td>
						<td><c:out value="${ userList.userPhone }"></c:out></td>
						<td><c:out value="${ userList.userEmail }"></c:out></td>
						<td style="text-align:center;"><c:out value="${ userList.userSanctionYn }"></c:out></td>
					</tr>
				</c:forEach>
				<c:forEach var="entList" items="${ requestScope.entList }">
					<tr class="enttr" style="display:none;">
						<td style="text-align:center;"><input name="RowCheck" type="checkbox" value="${ entList.entNo }"/></td>
						<td style="text-align:center;"><c:out value="${ entList.entNo }"></c:out></td>
						<td><c:out value="${ entList.entName }"></c:out></td>
						<td><c:out value="${ entList.entId }"></c:out></td>
						<td><c:out value="${ entList.entPhone }"></c:out></td>
						<td><c:out value="${ entList.entEmail }"></c:out></td>
						<td style="text-align:center;"><c:out value="${ entList.entSanctionYn }"></c:out></td>
					</tr>
				</c:forEach>
				<tr>
					<td style="border:none;"><button type="button" onclick="fn_userDel()">제재</button></td>
					<td style="border:none;"><button type="button" onclick="fn_userY()">해제</button></td>
					<td style="border:none;"><input type="hidden" name="UseridStatus"/></td>
				</tr>
			</table>
			<input type="hidden" name="delUserid"/>
		</form>
	</div>
	<script>
		$(function() {
			$("#listType").change(function() {
				if(this.value == 'user') {
					$('.usertr').show();
					$('.enttr').hide();
				} else {
					$('.usertr').hide();
					$('.enttr').show();
				}
			})
		});
	</script>
	<script>
	function fn_userDel(){
		  var userNo = "";
		  var memberChk = document.getElementsByName("RowCheck");
		  var chked = false;
		  var indexid = false;
		  for(i=0; i < memberChk.length; i++){
			  if(memberChk[i].checked){
			  	if(indexid){
			     	userNo = userNo + '-';
			    }
			  	userNo = userNo + memberChk[i].value;
			    indexid = true;

			  }
		  }
		  if(!indexid){
		  	alert("제재할 사용자를 체크해 주세요");
		   	return;
		  }
		  document.userForm.delUserid.value = userNo;
		  document.userForm.UseridStatus.value = "N";
		  var agree = confirm("적용 하시겠습니까?");
		  if (agree){
		    document.userForm.submit();
		  }
	}﻿
	</script>
	<script>
	function fn_userY(){
		  var userNo = "";
		  var memberChk = document.getElementsByName("RowCheck");
		  var chked = false;
		  var indexid = false;
		  for(i=0; i < memberChk.length; i++){
			  if(memberChk[i].checked){
			  	if(indexid){
			     	userNo = userNo + '-';
			    }
			  	userNo = userNo + memberChk[i].value;
			    indexid = true;

			  }
		  }
		  if(!indexid){
		  	alert("해제할 사용자를 체크해 주세요");
		   	return;
		  }
		  document.userForm.delUserid.value = userNo;
		  document.userForm.UseridStatus.value = "Y";
		  var agree = confirm("적용 하시겠습니까?");
		  if (agree){
		    document.userForm.submit();
		  }
	}﻿
	</script>
</body>
</html>