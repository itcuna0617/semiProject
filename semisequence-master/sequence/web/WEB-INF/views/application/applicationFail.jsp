<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/header.jsp"/>
	
	<section>
	<h1 style="font-size: 150%; font-weight: bolder;">해당 지원자를 탈락 처리 했습니다.</h1>
	<table>
		<tr>
			<td>
				<form action="${ pageContext.servletContext.contextPath }/application/select/by/ent">
					<input type="hidden" name="page" value="${ page }">
					<c:if test="${  requestScope.criteria == 'ent'  }">
						<input type="hidden" value="ent" name="criteria">
					</c:if>
					<c:if test="${  requestScope.criteria == 'project'  }">
						<input type="hidden" value="project" name="criteria">
						<input type="hidden" name="projectNo" value="${ projectNo }">
					</c:if>
					<c:if test="${  requestScope.criteria == 'posting'  }">
						<input type="hidden" value="posting" name="criteria">
						<input type="hidden" name="postingNo" value="${ postingNo }">
					</c:if>
					<button>지원자 명단으로</button>
				</form>
			</td>
			<td>
				<form action="${ pageContext.servletContext.contextPath }/application/select/fail">
					<input type="hidden" name="page" value="${ page }">
					<c:if test="${  requestScope.criteria == 'ent'  }">
						<input type="hidden" value="ent" name="criteria">
					</c:if>
					<c:if test="${  requestScope.criteria == 'project'  }">
						<input type="hidden" value="project" name="criteria">
						<input type="hidden" name="projectNo" value="${ projectNo }">
					</c:if>
					<c:if test="${  requestScope.criteria == 'posting'  }">
						<input type="hidden" value="posting" name="criteria">
						<input type="hidden" name="postingNo" value="${ postingNo }">
					</c:if>
					<button>탈락자 명단으로</button>
				</form>
			</td>
			<td>
				<form action="${ pageContext.servletContext.contextPath }/application/select/pass">
					<input type="hidden" name="page" value="${ page }">
					<c:if test="${  requestScope.criteria == 'ent'  }">
						<input type="hidden" value="ent" name="criteria">
					</c:if>
					<c:if test="${  requestScope.criteria == 'project'  }">
						<input type="hidden" value="project" name="criteria">
						<input type="hidden" name="projectNo" value="${ projectNo }">
					</c:if>
					<c:if test="${  requestScope.criteria == 'posting'  }">
						<input type="hidden" value="posting" name="criteria">
						<input type="hidden" name="postingNo" value="${ postingNo }">
					</c:if>
					<button>합격자 명단으로</button>
				</form>
			</td>

		</tr>
	</table>
	</section>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>