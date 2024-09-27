package posting.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import posting.model.dto.PostingAndProjectDTO;
import posting.model.service.PostingService;

@WebServlet("/entPostingDetail")
public class EntPostingDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer no = Integer.parseInt(request.getParameter("no"));
		
		System.out.println("공고 조회 번호는 넘어가나?" + no);
		PostingService postingService = new PostingService();
		
		PostingAndProjectDTO entPostingDetail = postingService.selectEntPostingDetail(no);
		System.out.println("entPostingDetail 담겼나?" + entPostingDetail);

		HttpSession session = request.getSession();
		String userType = (String)session.getAttribute("userType");
		
		String path = "";
		if(entPostingDetail != null) {
			path = "/WEB-INF/views/posting/entPostingDetail.jsp";
			request.setAttribute("entPostingDetail", entPostingDetail);
			session.setAttribute("postingNo2", no);
			
		    if("user".equals(userType)) {
		    	Integer userNo = (Integer)session.getAttribute("userNo");
		    	String userId = (String)session.getAttribute("userId");
		    }else if("ent".equals(userType)) {
		    	Integer entNo = (Integer)session.getAttribute("entNo");
		    	String entId = (String)session.getAttribute("entId");
		    }
		    
			
		} else {
			path = "/WEB-INF/views/error/500error.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
	
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
