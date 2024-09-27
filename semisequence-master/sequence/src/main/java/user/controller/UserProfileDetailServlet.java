package user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.dto.UserAddFileDTO;
import user.model.dto.UserProfileDTO;
import user.model.service.UserProfileService;

@WebServlet("/user/profile/detail")
public class UserProfileDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   int userProfileNo = Integer.valueOf(request.getParameter("no"));
		
		/* 프로필 정보 조회 */
		UserProfileService userProfileService = new UserProfileService();
		UserProfileDTO userProfile = userProfileService.selectUserProfileByNo(userProfileNo);
		
		/* 포트폴리오 파일 조회 */
		List<UserAddFileDTO> userAddFileList = userProfileService.selectUserAddFileByProfileNo(userProfileNo);
		HttpSession session = request.getSession();
		session.setAttribute("userProfile", userProfile);
		
		String path = "";
		if(userProfile != null) {														
			path = "/WEB-INF/views/user/userProfileDetail.jsp";					
			request.setAttribute("userAddFileList", userAddFileList);								
			request.setAttribute("userProfile", userProfile);								
		} else {	
			path = "/WEB-INF/views/common/userFailed.jsp";
			request.setAttribute("message", "해당 프로필 상세 조회에 실패하였습니다.");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}
