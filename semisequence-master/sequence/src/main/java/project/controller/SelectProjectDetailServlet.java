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

@WebServlet("/project/detail")
public class SelectProjectDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectService projectService = new ProjectService();
		/* 요청에 들어올 회원 번호를 이용해 select 해오는 과정 */
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		System.out.println(projectNo);
		
		ProjectDTO project = projectService.selectProjectDetail(projectNo);
		
		String path;
		
		if(project != null) {
			path="/WEB-INF/views/project/selectProjectDetail.jsp";
			request.setAttribute("project", project);
		} else {
			path="오류페이지";
			request.setAttribute("message", "project 객체가 비어있습니다!");
			System.out.println("project 객체가 비어있습니다!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//projectName 출력용 post
		request.setCharacterEncoding("utf-8");
		ProjectService projectService = new ProjectService();
		
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		
		String projectName = projectService.selectProjectName(projectNo);
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		if(projectName!=null & !projectName.equals("")) {
			out.println(projectName);
		}
		
		out.flush();
		out.close();
	}

}
