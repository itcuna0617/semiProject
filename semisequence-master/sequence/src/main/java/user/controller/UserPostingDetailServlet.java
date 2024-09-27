package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/posting/detail")
public class UserPostingDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* no에 맞는 내가 작성 한 구인글 상세내용 조회 */
		
		String path = "/WEB-INF/views/user/userPostingDetail.jsp";

		request.getRequestDispatcher(path).forward(request, response);
	}


}
