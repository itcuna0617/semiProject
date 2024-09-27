package user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import user.model.dto.UserInfoDTO;
import user.model.service.UserInfoService;

@WebServlet("/user/info/password/update")
public class UserInfoPasswordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/user/userInfoPasswordUpdateForm.jsp";			

		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		int userNo = (int)session.getAttribute("userNo");
		String userBeforePassword = request.getParameter("userBeforePassword");
		
		System.out.println("현재 비밀번호 입력값 : " + userBeforePassword);
		
		/* 저장되어있는 비밀번호 select */
		UserInfoService userInfoService = new UserInfoService();
		String selectUserBeforePassword = userInfoService.selectUserInfoPasswordUpdate(userNo);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		/* 현재 비밀번호가 일치하면 비밀번호 변경 진행 */
		if(passwordEncoder.matches(userBeforePassword, selectUserBeforePassword)) {
			String userPassword = request.getParameter("userPassword");
			
			UserInfoDTO userInfo = new UserInfoDTO();
			userInfo.setUserNo(userNo);
			userInfo.setUserPassword(userPassword);
			
			int result = userInfoService.userInfoPasswordUpdate(userInfo);

			System.out.println(result);
			String path = "";
			if(result > 0) {
				path = "/WEB-INF/views/user/userInfo.jsp";
				request.setAttribute("successCode", "비밀번호 변경 완료");
			} else {
				path = "/WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "비밀번호 변경에 실패하셨습니다.");
			}
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			String path = "/WEB-INF/views/user/userInfo.jsp";
			request.setAttribute("passwordFailCode", "현재 비밀번호가 일치하지 않습니다.");
			
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		
	}
}
