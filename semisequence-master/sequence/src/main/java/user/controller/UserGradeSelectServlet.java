package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/grade")
public class UserGradeSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 현재 등급, 현재 평균 평점, 총 내가 받은 평점횟수, 최근평점내역 */
		
		String path = "/WEB-INF/views/user/userGrade.jsp";

		request.getRequestDispatcher(path).forward(request, response);
	}

}
