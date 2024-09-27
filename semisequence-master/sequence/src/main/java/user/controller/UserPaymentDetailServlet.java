package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/payment/Detail")
public class UserPaymentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 최근 결제 내역 select 후 forward */
		
		String path = "/WEB-INF/views/user/userPaymentDetail.jsp";

		request.getRequestDispatcher(path).forward(request, response);
		
	}
}
