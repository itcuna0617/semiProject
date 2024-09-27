package admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/redHoundBlueBird")
public class AdminLogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get요청 도착확인");
		
		request.getRequestDispatcher("/WEB-INF/views/admin/adminLogInPage.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String password=request.getParameter("password");
		String path="";
		
		if("920309600616".equals(password)) {
			path="/WEB-INF/views/admin/adminMain.jsp";
			System.out.println("성공");
		} else {
			path="/WEB-INF/views/admin/adminLogInPage.jsp";
			System.out.println("실패");
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
