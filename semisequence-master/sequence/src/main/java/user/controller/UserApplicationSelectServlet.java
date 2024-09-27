package user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.dto.UserAppliactionByPostingDTO;
import user.model.service.UserApplicationService;
import user.paging.Pagenation;
import user.paging.SelectCriteria;

@WebServlet("/user/application/list")
public class UserApplicationSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int userNo = (int)session.getAttribute("userNo");
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		UserApplicationService userApplicationService = new UserApplicationService();
		int totalCount = userApplicationService.selectTotalCount(userNo);
		
		System.out.println("totalCount: " + totalCount);
		
		int limit = 2;
		int buttonAmount = 5;
		SelectCriteria selectCriteria = null;
		selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		System.out.println("selectCriteria: " +selectCriteria);
		
		/* 지원관련 내용 select */
		List<UserAppliactionByPostingDTO> userApplicationByPostingList = userApplicationService.selectUSerApplicationByPosting(userNo, selectCriteria);
		System.out.println("userApplicationByPostingList : " + userApplicationByPostingList);
		
		
		String path = "";
		if(userApplicationByPostingList.size() > 0) {
			path = "/WEB-INF/views/user/userApplicationList.jsp";
			request.setAttribute("userApplicationByPostingList", userApplicationByPostingList);
			request.setAttribute("selectCriteria", selectCriteria);
		} else if(userApplicationByPostingList.size() == 0) {
			path = "/WEB-INF/views/user/userApplicationList.jsp";
			request.setAttribute("userApplicationIsnullCode", "지원내역이 없습니다. 구인글에 지원해주세요!!");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
}
