package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.dto.SearchUserProfileDTO;
import user.model.dto.UserAddFileDTO;
import user.model.service.UserProfileSearchService;
import user.model.service.UserProfileService;

@WebServlet("/memberProfileDetail")
public class MemberProfileDetailChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer no = Integer.parseInt(request.getParameter("no"));
		
		System.out.println("넘어온 no 값 : " + no);
		
		UserProfileSearchService userProfileSearchService = new UserProfileSearchService();
		UserProfileService userProfileService = new UserProfileService();
		
		SearchUserProfileDTO searchUserProfileDetail = userProfileSearchService.selectSearchUserProfileDetail(no);
		System.out.println("searchUserProfileDetail : " + searchUserProfileDetail);

		/* 포트폴리오 파일 조회 */
		List<UserAddFileDTO> userAddFileList = userProfileService.selectUserAddFileByProfileNo(no);
		System.out.println("포트폴리오 리스트 : " + userAddFileList);
		
		String path = "";
		if(searchUserProfileDetail != null) {
			path = "/WEB-INF/views/member/profileDetail.jsp";
			request.setAttribute("searchUserProfileDetail", searchUserProfileDetail);
			request.setAttribute("userPortfolio", userAddFileList);
			
			HttpSession session = request.getSession();
			session.setAttribute("userProfileNo", no);
			
		} else {
			path = "/WEB-INF/views/error/500error.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
	
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
