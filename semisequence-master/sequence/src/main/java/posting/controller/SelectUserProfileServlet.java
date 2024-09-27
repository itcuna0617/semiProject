package posting.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import posting.model.dto.UserProfileDTO;
import posting.model.service.PostingService;

@WebServlet("/postingApplication")
public class SelectUserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
	    String userId = (String)session.getAttribute("userId");
	    System.out.println(userId);
	    
	    PostingService postingService = new PostingService();
	    
	    List<UserProfileDTO> profileList = postingService.selectUserProfile(userId);		

		System.out.println("profileList : " + profileList);

		String path = "";
		if(profileList != null) {
			path = "/WEB-INF/views/posting/postingApplication.jsp";
			request.setAttribute("profileList", profileList);
			
		} else {
			path = "/WEB-INF/views/error/500error.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
