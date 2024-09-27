package user.controller;

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

@WebServlet("/user/offer/posting/detail")
public class UserOfferPostingDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PostingService postingService = new PostingService();
		ProjectService projectService = new ProjectService();
		
		int postingNo = Integer.parseInt(request.getParameter("no"));
		PostingDTO posting = postingService.selectPostingDetail(postingNo);
		String path = "";
		
		if(posting!=null) {
			String projectName = projectService.selectProjectName(posting.getProjectNo());
			path="/WEB-INF/views/user/userOfferPostingDetail.jsp";
			request.setAttribute("posting", posting);
			request.setAttribute("projectName", projectName);
		} else {
			path="/WEB-INF/views/error/500error.jsp";
			request.setAttribute("message", "해당하는 포스팅이 없습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}


}
