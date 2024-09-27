package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/posting/list")
public class UserPostingSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 내가 작성한 구인글 내역 리스트로 조회 */
		
		String path = "/WEB-INF/views/user/userPostingList.jsp";

		request.getRequestDispatcher(path).forward(request, response);
	}
}
