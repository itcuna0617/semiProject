<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		(function(){
			const successCode = "${ requestScope.successCode }";
			
			let successMessage = "";
			let movePath = "";
			
			switch(successCode){
				case "insertApplication" : 
					successMessage = "지원에 성공하였습니다!";
					movePath = "${ pageContext.servletContext.contextPath }/user/application/list";
					break;
			}

			alert(successMessage);
			
			location.replace(movePath);
		})();
	
	</script>
</body>
</html>