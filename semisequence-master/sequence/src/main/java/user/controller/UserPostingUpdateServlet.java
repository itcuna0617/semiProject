package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/posting/update")
public class UserPostingUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 상세내용 select해와서 다시 넘김 */
		String path = "/WEB-INF/views/user/userPostingUpdateForm.jsp";

		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		
		/* update하고 완료되면 alert창 보여줘야함  */
		String path = "/WEB-INF/views/user/userPostingDetail.jsp";

		request.getRequestDispatcher(path).forward(request, response);
	}

}
