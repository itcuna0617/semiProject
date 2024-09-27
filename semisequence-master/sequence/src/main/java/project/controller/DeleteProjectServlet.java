package project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.model.service.ProjectService;

@WebServlet("/project/delete")
public class DeleteProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectService projectService = new ProjectService();
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		System.out.println("delete get요청 도착, projectNO : " + projectNo);
		boolean result = projectService.deleteProject(projectNo);
		
		String path="";
		
		if(result) {
			System.out.println("삭제 성공");
			path="/WEB-INF/views/project/deleteSuccess.jsp";
			boolean result2=projectService.deletePosting(projectNo);
			if(result2) {
				System.out.println("연동된 공고 비공개 처리 완료");
			}
			
		} else {
			System.out.println("삭제 실패");
			path="/WEB-INF/views/project/deleteError.jsp";
		}
//		response.setContentType("text/html; charset=UTF-8");
//		response.sendRedirect(path);
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
	}

}
