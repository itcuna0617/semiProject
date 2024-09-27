package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/UserGradeApplicationServlet")
public class UserGradeApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 구직 최근 평점내역 select후 뿌려줌 */
		/* 미실시된 내역에 대해서는 평점부여하기 버튼 활성화 */
		
		String path = "/WEB-INF/views/user/userGradeApplication.jsp";

		request.getRequestDispatcher(path).forward(request, response);
	}

}
