package posting.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import posting.model.dto.PostingDTO;
import posting.model.service.PostingService;
import project.model.service.ProjectService;

@WebServlet("/posting/insert")
public class InsertPostingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("entNo : " + session.getAttribute("entNo"));
		System.out.println("projectNo : " + request.getParameter("projectNo"));
		System.out.println("insertPostingServlet Get 요청 정상도달 확인");
		request.setAttribute("projectNo", request.getParameter("projectNo"));
		
		/* 아무래도 parameter는 넘어가지 않는 듯 함 */
		request.getRequestDispatcher("/WEB-INF/views/posting/insertPostingByEnt.jsp").forward(request, response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("insertPostingServlet Post 요청 정상도달 확인");
		request.setCharacterEncoding("UTF-8");
		System.out.println("projectNo : " + request.getParameter("projectNo"));
		HttpSession session = request.getSession();
		ProjectService projectService = new ProjectService();
		PostingService postingService = new PostingService();
		
		int entNo = (int) session.getAttribute("entNo");
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		
		int genreNo = projectService.selectGenreNo(projectNo);
		PostingDTO posting = new PostingDTO();
		posting.setPostingTitle(request.getParameter("postingTitle"));
		posting.setPostingDetail(request.getParameter("postingDetail"));
		posting.setProjectNo(projectNo);
		posting.setEntNo(entNo);
		posting.setJobNo(Integer.parseInt(request.getParameter("jobNo")));
		posting.setGenreNo(genreNo);
		
		boolean result = postingService.insertPosting(posting);
		
		String path = "";
		if (result) {
			path="/WEB-INF/views/posting/insertPostingByEntSuccess.jsp";
			request.setAttribute("projectNo", projectNo);
		} else {
			path="/WEB-INF/views/error/500error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
