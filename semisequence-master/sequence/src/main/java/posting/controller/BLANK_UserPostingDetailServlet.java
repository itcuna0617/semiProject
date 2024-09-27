package posting.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import posting.model.dto.PostingDTO;
import posting.model.service.PostingService;

@WebServlet("/userPostingDetail")
public class BLANK_UserPostingDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		int no = Integer.parseInt(request.getParameter("no"));
		
		PostingService postingService = new PostingService();
		PostingDTO userPostingDetail = postingService.selectUserPostingDetail(no); 
		
		System.out.println("userPostingDetail : " + userPostingDetail);
		
		String path = "";
		if(userPostingDetail != null) {
			path = "/WEB-INF/views/posting/userPostingDetail.jsp";
			request.setAttribute("userPostingDetail", userPostingDetail);
		} else {
			path = "/WEB-INF/views/error/500error.jsp";
			request.setAttribute("message", "공지사항 상세 보기 조회에 실패하였습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
