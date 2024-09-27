package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.dto.UserInfoDTO;
import user.model.service.UserInfoService;

@WebServlet("/user/delete")
public class UserInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/* 비밀번호 입력 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/user/userInfoDelete.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		int userNo = (int)session.getAttribute("userNo");
		String userPassword = request.getParameter("userPassword");
		
		UserInfoDTO userInfo = new UserInfoDTO();
		userInfo.setUserNo(userNo);
		userInfo.setUserPassword(userPassword);

		UserInfoService userInfoService = new UserInfoService();
		int result = userInfoService.userInfoDelete(userInfo);
		
		/* 로그아웃 시키고 메인페이지로 이동시켜야함 */
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/user/userMyPage.jsp";
			request.setAttribute("successCode", "성공적으로 회원탈퇴하였습니다.");
			session.removeAttribute("successCode");
			session.removeAttribute("loginMember");
			session.removeAttribute("loginMember2");
		} else {
			path = "/WEB-INF/views/user/userInfo.jsp";
			request.setAttribute("passwordFailCode", "회원탈퇴에 실패하셨습니다.");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

}
