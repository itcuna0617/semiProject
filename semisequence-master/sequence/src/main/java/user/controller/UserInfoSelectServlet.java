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


@WebServlet("/user/info")
public class UserInfoSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int userNo = (int)session.getAttribute("userNo");
		System.out.println(userNo);
		
		UserInfoService userInfoService = new UserInfoService();
		UserInfoDTO userInfo = new UserInfoDTO();
		
		userInfo = userInfoService.selectUserInfo(userNo);
		
		session.setAttribute("userInfo", userInfo);
		/* System.out.println(userInfo); */
		
		String path = "";
		if(userInfo != null) {														
			path = "/WEB-INF/views/user/userInfo.jsp";					
			request.setAttribute("userInfo", userInfo);								
		} else {	
			path = "/WEB-INF/views/common/userFailed.jsp";
			request.setAttribute("message", "회원정보 상세 보기 조회에 실패하였습니다.");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

}
