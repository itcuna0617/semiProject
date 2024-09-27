package posting.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import posting.model.service.PostingService;

@WebServlet("/posting/close")
public class ClosePostingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostingService postingService = new PostingService();
		
		int postingNo = Integer.parseInt(request.getParameter("postingNo"));
		boolean result = postingService.closePosting(postingNo);
		
		
		String path ="";
		if(result) {
			path="/posting/list";
		} else {
			path="/WEB-INF/views/error/500error.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
