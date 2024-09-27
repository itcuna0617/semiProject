package posting.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import posting.model.service.PostingService;
import project.model.dto.ProjectDTO;
import project.model.service.ProjectService;

@WebServlet("/posting/insert/by/list")
public class InsertPostingByListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/views/posting/insertPostingByList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int entNo = (int)session.getAttribute("entNo");
		
		System.out.println("ajax 작동함");
		ProjectService projectService = new ProjectService();
		PostingService postingService = new PostingService();
		List<ProjectDTO> projectList = projectService.selectProjectList(entNo);
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		//여유 생기면 Json사용
//			out.println("<select id=selectProjectNo name='projectNo'>");	
		for (ProjectDTO project : projectList) {
			out.println("<option value='" + project.getProjectNo() + "' selected>"+project.getProjectName()+"</option>");
		}
//			out.println("</select>");
			out.flush();
			out.close();
	
	}

}
