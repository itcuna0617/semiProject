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

@WebServlet("/user/info/update")
public class UserInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("no"));
		/* System.out.println("userNo : " + userNo); */
		
		UserInfoService userInfoService = new UserInfoService();
		
		UserInfoDTO userInfo = new UserInfoDTO();
		
		userInfo = userInfoService.selectUserInfo(userNo);
		
		/* System.out.println(userInfo); */
		
		String path = "";
		if(userInfo != null) {														
			path = "/WEB-INF/views/user/userInfoUpdateForm.jsp";					
			request.setAttribute("userInfo", userInfo);								
		} else {	
			path = "/WEB-INF/views/common/userFailed.jsp";
			request.setAttribute("message", "회원정보 상세 보기 조회에 실패하였습니다.");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		int userNo = (int)session.getAttribute("userNo");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
		
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		
		userInfoDTO.setUserNo(userNo);
		userInfoDTO.setUserName(userName);
		userInfoDTO.setUserEmail(userEmail);
		userInfoDTO.setUserPhone(userPhone);
		
		System.out.println(userInfoDTO);
		
		UserInfoService userInfoService = new UserInfoService();
		int result = userInfoService.userInfoUpdate(userInfoDTO);
		
		/* header의 이름 수정을 위해 session에 담아줄 값 */
		UserInfoDTO loginMember2 = userInfoDTO;
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/user/userInfo.jsp";
			request.setAttribute("successCode", "회원정보 수정이 완료되었습니다.");
		    session.setAttribute("loginMember2", loginMember2);
			
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원정보 수정에 실패하셨습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}


}
