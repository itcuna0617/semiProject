package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/memberResetPassword")
public class MemberResetPasswordChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("userId");
		String userType = request.getParameter("userType");
		
		HttpSession session = request.getSession();
		session.setAttribute("userId", id);
		session.setAttribute("userType", userType);
		
		String url = "WEB-INF/views/member/resetPassword.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
