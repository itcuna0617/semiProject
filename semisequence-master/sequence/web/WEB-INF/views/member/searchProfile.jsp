<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${ pageContext.servletContext.contextPath }/css/searchProfile.css" type="text/css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <jsp:include page="../common/header.jsp"/>
		 <div class="SearchUserProfile">
			<div class="title">
				<p>프로필 검색</p>
			</div>
				<div class="search-area" align="center">
					<form name="selectCategory" method="get" style="display:inline-block">	
						<input type="hidden" name="currentPage" value="1"> 
						<div class="searchCategory">
					  	  	<select id="searchCondition1" name="searchCondition1" onchange="firstChange();" size=1>
								<option>구분</option>
								<option value='job' ${ requestScope.selectCriteria.searchCondition1 eq "job"? "selected": "" }>직군</option>
								<option value='genre' ${ requestScope.selectCriteria.searchCondition1 eq "genre"? "selected": "" }>장르</option>
								<option value='writer' ${ requestScope.selectCriteria.searchCondition1 eq "writer"? "selected": "" }>작성자</option>
							</select>
						
							<select id="searchCondition2" name="searchCondition2" onchange="secondChange();" size=1>
							 	<option>구분을 먼저 선택하세요</option>
							</select>
							
							<input type="search" id="searchValue" name="searchValue" value="<c:out value="${ selectCriteria.searchValue }"/>">
		
							<button type="submit">검색하기</button>
						</div>	
					</form>
				</div>
		</div>
			<div class="table-area">
				<c:forEach items="${ profileList }" var="profile">
					<table class="profileTable">
						<tr>
							<td rowspan="4" width="20px" height="120px"><c:out value="${ profile.userProfileNo }"/></td>
							<td colspan="2" rowspan="4" width="100px" height="120px"><img src="${ pageContext.servletContext.contextPath }${ profile.userPhoto.getUserPhotoSavedPath() }" width="150px" height="200px"></td>
							<td colspan="4" width="600px" height="40px"><c:out value="${ profile.userMiniTitle }"/></td>
						</tr>
						<tr>
							<td colspan="4" width="600px" height="40px"><c:out value="${ profile.userName }"/></td>
						</tr>
						<tr>
							<td width="150px" height="40px"><c:out value="${ profile.job.getJobName() }"/></td>
							<td width="250"><c:out value="${ profile.userArea }"/></td>
							<td colspan="2" width="200px"><fmt:formatDate pattern="yyyy-MM-dd" value="${ profile.userBirth }"/></td>
						</tr>
					</table>
				</c:forEach>
			</div>
			
			<jsp:include page="../common/paging.jsp"/>
			
        <script>
		if(document.getElementsByTagName("td")) {
			const $tds = document.getElementsByTagName("td");
			for(let i = 0; i < $tds.length; i++) {
				
				$tds[i].onmouseenter = function() {
					this.parentNode.style.cursor = "pointer";
				}
				
				$tds[i].onmouseout = function() {
					this.parentNode.style.backgroundColor = "white";
				}
				
				$tds[i].onclick = function() {
					const no = this.parentNode.children[0].innerText;
					location.href = "${ pageContext.servletContext.contextPath }/memberProfileDetail?no=" + no;
				}
				
			}
			
		}
	</script>
			<script>
				function firstChange() {// 대분류 변한 경우
					 var x = document.selectCategory.searchCondition1.options.selectedIndex;//선택한 인덱스
					 var groups=document.selectCategory.searchCondition1.options.length;//대분류 갯수
					 var group=new Array(groups);//배열 생성
						 for (i=0; i<groups; i++) {
							group[i]=new Array();
						}//for
						 // 옵션(<option>) 생성
						 group[0][0]=new Option("구분을 먼저 선택하세요","구분");
						 group[1][0]=new Option("직군","직군");
						 group[1][1]=new Option("배우","배우");
						 group[1][2]=new Option("촬영","촬영");
						 group[1][3]=new Option("연출","연출");
						 group[1][4]=new Option("음향","음향");
						 group[1][5]=new Option("조명","조명");
						 group[1][6]=new Option("미술","미술");
						 group[1][7]=new Option("메이크업","메이크업");
						 group[2][0]=new Option("장르","장르");
						 group[2][1]=new Option("영화","영화");
						 group[2][2]=new Option("광고","광고");
						 group[2][3]=new Option("다큐","다큐");
						 group[2][4]=new Option("드라마","드라마");
						 group[2][5]=new Option("기타","기타");
						 group[3][0]=new Option("작성자","작성자");
						
						 temp = document.selectCategory.searchCondition2;//두번 째 셀렉트 얻기(<select name=second>)
						 for (m = temp.options.length-1 ; m > 0 ; m--) {//현재 값 지우기
						  temp.options[m]=null
						 }
						 for (i=0;i<group[x].length;i++){//값 셋팅
						  
						  temp.options[i]=new Option(group[x][i].text,group[x][i].value);
						 }
						 temp.options[0].selected=true//인덱스 0번째, 즉, 첫번째 선택
						}//firstChange
			
				 function secondChange() {//중분류 변한 경우
				 var first = document.selectCategory.searchCondition1.options.selectedIndex;
				 var x = document.selectCategory.searchCondition2.options.selectedIndex;
			}//secondChang
		</script>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>