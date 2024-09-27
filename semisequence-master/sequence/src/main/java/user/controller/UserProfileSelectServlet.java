package user.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.dto.UserProfileDTO;
import user.model.service.UserProfileService;
@WebServlet("/user/profile")
public class UserProfileSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int userNo = (int)session.getAttribute("userNo");
		
		UserProfileService userProfileService = new UserProfileService();
		List<UserProfileDTO> userProfileList = userProfileService.selectUserProfile(userNo);
		
		for(UserProfileDTO pro : userProfileList) {
			System.out.println(pro);
		}
		String path = "";
		if(!userProfileList.isEmpty()) {														
			path = "/WEB-INF/views/user/userProfileList.jsp";					
			request.setAttribute("userProfileList", userProfileList);								
		} else if(userProfileList.isEmpty()) {	
			path = "/WEB-INF/views/user/userProfileList.jsp";
			request.setAttribute("profileIsEmpty", "profileIsEmpty");
		}else {	
			path = "/WEB-INF/views/common/userFailed.jsp";
			request.setAttribute("message", "프로필리스트 조회에 실패했습니다.");
		}

		request.getRequestDispatcher(path).forward(request, response);

	}


}
