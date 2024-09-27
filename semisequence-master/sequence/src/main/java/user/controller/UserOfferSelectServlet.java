package user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.dto.OfferByPostingByentInfoDTO;
import user.model.service.UserApplicationService;
import user.model.service.UserOfferService;
import user.paging.Pagenation;
import user.paging.SelectCriteria;

@WebServlet("/user/offer/list")
public class UserOfferSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int userNo = (int)session.getAttribute("userNo");
		
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		UserOfferService userOfferService = new UserOfferService();
		int totalCount = userOfferService.selectTotalCount(userNo);
		
		System.out.println("totalCount: " + totalCount);
		
		int limit = 2;
		int buttonAmount = 5;
		SelectCriteria selectCriteria = null;
		selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		System.out.println("selectCriteria: " +selectCriteria);
		
		List<OfferByPostingByentInfoDTO> OfferByPostingByentInfoList = userOfferService.selectUSerApplicationByPosting(userNo, selectCriteria);
		System.out.println(OfferByPostingByentInfoList);
		
		String path = "";
		if(OfferByPostingByentInfoList.size() >0) {
			path = "/WEB-INF/views/user/userOfferList.jsp";
			request.setAttribute("OfferByPostingByentInfoList", OfferByPostingByentInfoList);
			request.setAttribute("selectCriteria", selectCriteria);
		} else if(OfferByPostingByentInfoList.size() ==0) {
			path = "/WEB-INF/views/user/userOfferList.jsp";
			request.setAttribute("OfferIsNullCode", "영입 제의 내역이 없습니다.");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
