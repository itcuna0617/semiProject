package project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.model.dto.ProjectDTO;
import project.model.service.ProjectService;

@WebServlet("/project/list")
public class SelectProjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProjectService projectService = new ProjectService();
		
		HttpSession session = request.getSession();
		
		int entNo = (int)(session.getAttribute("entNo"));
		List<ProjectDTO> projectList = projectService.selectProjectList(entNo);
		
//		int 
//		int maxProjectCount = projectService.selectProjectCount(entNo);
//		
//		if(projectList.size()<)
		
		String path = "";
		if(!projectList.isEmpty()) {
			path="/WEB-INF/views/project/selectProjectList.jsp";
			request.setAttribute("projectList", projectList);
		} else {
			path="/WEB-INF/views/project/selectProjectList.jsp";
			request.setAttribute("message", "프로젝트 조회 결과가 없습니다.");
			System.out.println("객체가 비어있습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
