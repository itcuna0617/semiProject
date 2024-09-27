package posting.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import posting.model.dto.ApplicationDTO;
import posting.model.service.PostingService;

@WebServlet("/insertApplication")
public class PostingApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
	    int userNo =  (int)session.getAttribute("userNo");
	    String applicationIntro = request.getParameter("applicationIntro");
	    int userProfileNo = Integer.parseInt(request.getParameter("userProfileNo"));
	    int postingNo = (int)session.getAttribute("postingNo2");
	    
	    
	    ApplicationDTO newApplication = new ApplicationDTO();
	    newApplication.setUserNo(userNo);
	    newApplication.setPostingNo(postingNo);
	    newApplication.setApplicationIntro(applicationIntro);
	    newApplication.setUserProfileNo(userProfileNo);
	    
	    
	    System.out.println(newApplication);
	    
	    PostingService postingService = new PostingService();
	    int result = postingService.insertPostingApplication(newApplication);
	    
	    String path = "";
	    if(result > 0) {
	    	path = "/WEB-INF/views/posting/insertApplicationSuccess.jsp";
	    	request.setAttribute("successCode", "insertApplication");
	    } else {
	    	path = "/WEB-INF/views/error/500error.jsp";
			request.setAttribute("message", "지원에 실패하셨습니다.");
	    }
	    request.getRequestDispatcher(path).forward(request, response);	
	}
}
