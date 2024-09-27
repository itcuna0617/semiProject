 package member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.paging.Pagenation;
import common.paging.SelectCriteria;
import user.model.dto.SearchUserProfileDTO;
import user.model.service.UserProfileSearchService;

@WebServlet("/searchMemberProfile")
public class SearchProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 현재 페이지 불러오기 */
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		/* 검색 조건 불러오기 */
		String searchCondition1 = request.getParameter("searchCondition1");
		String searchCondition2 = request.getParameter("searchCondition2");
		String searchValue = request.getParameter("searchValue");
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition1", searchCondition1);
		searchMap.put("searchCondition2", searchCondition2);
		searchMap.put("searchValue", searchValue);
		
		/* 전체 게시물 수 지정 */
		
		UserProfileSearchService userProfileSearchService = new UserProfileSearchService();
		int totalCount = userProfileSearchService.selectTotalProfileCount(searchMap);
		
		System.out.println("totalProfileCount : " + totalCount);
		
		/* 한 페이지에서 보여줄 게시물 수(간단조회 면적을 고려해 적게 설정) */ 
		int limit = 4;
		
		/* 한 번에 보여 줄 페이징 버튼 개수 */
		int buttonAmount = 5;
		
		/* 페이징 처리에 대한 정보를 담을 변수 선언 */
		SelectCriteria selectCriteria = null;
		System.out.println("searchCondition1 : " + searchCondition1);
		System.out.println("searchCondition2 : " + searchCondition2);
		System.out.println("searchValue : " + searchValue);
//		System.out.println(searchCondition1 != null && searchCondition2 != null && !"".equals(searchValue));
		
		
		/* 해당 페이지만 볼 수 있도록 페이징 처리 */
		if(searchCondition1 != null && searchCondition2 != null && !"".equals(searchValue)) {
			System.out.println("searchCondition1 , 2 : " + searchCondition1 + "/"  + searchCondition2);
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition1, searchCondition2, searchValue);
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);		
		}
		
		System.out.println(selectCriteria);
		
		List<SearchUserProfileDTO> profileList = userProfileSearchService.selectUserProfileList(selectCriteria);
		
		System.out.println("profileList : " + profileList);
		
		for(SearchUserProfileDTO i : profileList) {
			System.out.println(i);
		}
		
		HttpSession session = request.getSession();
		
		String path = "";
		if(profileList != null) {
			path = "/WEB-INF/views/member/searchProfile.jsp";
			request.setAttribute("profileList", profileList);
			request.setAttribute("selectCriteria", selectCriteria);
		} else {
			path = "/WEB-INF/views/error/500error.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);

		
		
	}

}
