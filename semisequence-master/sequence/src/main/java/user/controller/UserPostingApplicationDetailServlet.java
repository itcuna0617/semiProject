package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/posting/application/detail")
public class UserPostingApplicationDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 해당 no에 맞는 상세 내역 조회 */
		
		String path = "/WEB-INF/views/user/userPostingApplicationDetail.jsp";

		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
