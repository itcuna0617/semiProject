package posting.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import posting.model.dto.PostingDTO;
import posting.model.service.PostingService;

@WebServlet("/posting/update")
public class UpdatePostingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostingService postingService = new PostingService();
		int postingNo = Integer.parseInt(request.getParameter("postingNo"));
		
		PostingDTO posting = postingService.selectPostingDetail(postingNo);
		
		request.setAttribute("posting", posting);
		
		String path = "/WEB-INF/views/posting/updatePosting.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PostingService postingService = new PostingService();
		PostingDTO posting = new PostingDTO();
		posting.setPostingNo(Integer.parseInt(request.getParameter("postingNo")));
		posting.setPostingTitle(request.getParameter("postingTitle"));
		posting.setPostingDetail(request.getParameter("postingDetail"));
		posting.setJobNo(Integer.parseInt(request.getParameter("jobNo")));
		
		boolean result = postingService.updatePosting(posting);
		
		String path="";
		
		if(result) {
			path="/WEB-INF/views/posting/updatePostingSuccess.jsp";
			request.setAttribute("posting", posting);
		} else {
			path="/WEB-INF/views/error/500error.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
