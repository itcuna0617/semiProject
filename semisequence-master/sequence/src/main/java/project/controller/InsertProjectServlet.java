package project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.model.dto.ProjectDTO;
import project.model.service.ProjectService;
@WebServlet("/project/insert")
public class InsertProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/project/insertProject.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ProjectService projectService = new ProjectService();
		HttpSession session = request.getSession();
		int entNo = (int) session.getAttribute("entNo");
		ProjectDTO project = new ProjectDTO();
		
		project.setEntNo(entNo);
		project.setGenreNo(Integer.valueOf(request.getParameter("genreNo")));
		project.setProjectName(request.getParameter("projectName"));
		project.setProjectContent(request.getParameter("projectContent"));
		project.setProjectStartDate(java.sql.Date.valueOf(request.getParameter("projectStartDate")));
		project.setProjectEndDate(java.sql.Date.valueOf(request.getParameter("projectEndDate")));
		project.setManagerName(request.getParameter("managerName"));
		project.setManagerPhone(request.getParameter("managerPhone"));
		project.setManagerEmail(request.getParameter("managerEmail"));
		project.setGenreNo(Integer.parseInt(request.getParameter("genreNo")));
		
		boolean result = projectService.insertProject(project);
		String path = "";
		
		if(result) {
			System.out.println("삽입 성공");
			path="/WEB-INF/views/project/insertSuccess.jsp";
			request.setAttribute("project", project);
		} else {
			System.out.println("삽입 실패");
			path="/WEB-INF/views/project/insertError.jsp";
			request.setAttribute("message", "프로젝트 추가에 실패했습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
//		response.setContentType("text/html; charset=UTF-8");
//		response.sendRedirect(path);
		
	}

}
