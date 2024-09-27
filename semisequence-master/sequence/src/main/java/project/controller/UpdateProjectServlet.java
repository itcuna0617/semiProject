package project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.model.dto.ProjectDTO;
import project.model.service.ProjectService;

@WebServlet("/project/update")
public class UpdateProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectService projectService = new ProjectService();
		/* get요청으로 프로젝트 번호 획득 */
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		System.out.println(projectNo);
		
		ProjectDTO project = projectService.selectProjectDetail(projectNo);
		
		String path;
		
		if(project != null) {
			path="/WEB-INF/views/project/updateProject.jsp";
			request.setAttribute("project", project);
		} else {
			path="오류페이지";
			request.setAttribute("message", "project 객체가 비어있습니다!");
			System.out.println("project 객체가 비어있습니다!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ProjectService projectService = new ProjectService();
		ProjectDTO project = new ProjectDTO();
		project.setProjectNo(Integer.parseInt(request.getParameter("projectNo")));
		project.setProjectName(request.getParameter("projectName"));
		project.setProjectContent(request.getParameter("projectContent"));
		project.setProjectStartDate(java.sql.Date.valueOf(request.getParameter("projectStartDate")));
		project.setProjectEndDate(java.sql.Date.valueOf(request.getParameter("projectEndDate")));
		project.setManagerName(request.getParameter("managerName"));
		project.setManagerPhone(request.getParameter("managerPhone"));
		project.setManagerEmail(request.getParameter("managerEmail"));
		project.setGenreNo(Integer.parseInt(request.getParameter("genreNo")));
		
		boolean result=projectService.updateProject(project);
		String path = "";
		if (result) {
			path="/WEB-INF/views/project/updateSuccess.jsp";
			request.setAttribute("project", project);
		} else {
			path="/WEB-INF/views/project/updateError.jsp";
			request.setAttribute("message", "업데이트 실패....");
		}
		
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
