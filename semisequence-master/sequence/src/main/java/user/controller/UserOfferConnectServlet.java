package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.service.UserOfferService;
@WebServlet("/user/offer/connect")
public class UserOfferConnectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int offerNo = Integer.valueOf(request.getParameter("no"));
		
		UserOfferService userOfferService = new UserOfferService();
		int result = userOfferService.updateConnectYn(offerNo);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/user/userOfferList.jsp";
			request.setAttribute("successCode", "해당 영입제의 수락이 완료되었습니다.");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
}
