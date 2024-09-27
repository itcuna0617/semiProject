<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/board.css" type="text/css"/>
<title>Insert title here</title>

<style>
select {
  width: 200px; 
  padding: 6px 10px; 
  font-size: 0.9rem;
  font-family: inherit; 
  background: url('./img/icon-arrow-down.svg') no-repeat 95% 50%; 
  background-size: 15px 15px;
  border: 1px solid #333;
  background-color: #fff;
  border-radius: 0; 
  -webkit-appearance: none; /* 네이티브 외형 감추기 */
  -moz-appearance: none;
  appearance: none;
  outline: none;
}

select:focus {
  border-color: #0094e1;
}
.boardTable{

  border: 1px solid #ccc;
  line-height: 4;
  margin: 30px 0px 0px 0px;
  text-align: center;
}
.boardTable th{

  border-bottom: 1px solid #ccc;
}
#button_ {
  font-family: 'MinSans-Medium';
  border: 0;
  outline: none;
  font-size: 20px;
  margin: 30px;
  background: #4b4b4b;
  color: white;
  cursor: pointer;
  padding: 10px;
}
#button_:hover {
  color: white;
  background: gray;
}
input {
  width: 410px;
  height: 30px;
}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"/>
		<div class="customerCenterTitle">
		<p>1:1 문의</p>
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
		<div class="table-area" style="height:800px; margin: 0px 50px 50px 300px !important;">
							
			<form action="${ pageContext.servletContext.contextPath }/newQuestionInsert" method="post" encType="multipart/form-data">
				<table  class="boardTable" style="text-align: center; height:520px; border-collapse: separate; align: center !important;">
					<tr>
						<td width="200">문의 분야</td>
						<td>
							<select name="categoryNo">
					            <option id="결제" value="1" selected>결제 문의</option>
					            <option id="이용" value="2">이용 문의</option>
					            <option id="계정" value="3">계정 문의</option>
					            <option id="신고" value="4">신고 문의</option>
					        </select>
						</td>
					</tr>
					
					<tr>
						<td width="200">문의 제목</td>
						<td><input type="text" name="queTitle"></td>
					</tr>
					
					<tr>
						<td width="200">내용</td>
						<td><textarea name="queContent" cols="60" rows="15" style="resize:none;" required></textarea></td>
					</tr>
					
					<tr>
						<td width="200">파일 첨부</td>
						<td><input type="file" id="queFile"" name="queFile"></td>
					</tr>
					
				</table>
			<br>
				<button id="button_" type="reset">취소</button>
				<button id="button_" type="submit" id="btn_questionInsert" onclick="alert(문의를 완료하였습니다.)">문의</button>
		</form>
	</div>
			
		<a class="noticeList" href="${ pageContext.servletContext.contextPath }/questionList">목록</a>
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>