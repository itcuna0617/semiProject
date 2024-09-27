package customerCenter.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.paging.Pagenation;
import common.paging.SelectCriteria;
import customerCenter.model.dto.NoticeDTO;
import customerCenter.model.service.NoticeService;
import customerCenter.model.service.QuestionService;

@WebServlet("/noticeList")
public class NoticeSelectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/* paging 처리 */
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		QuestionService questionService = new QuestionService();
		int totalCount = questionService.selectTotalCount();
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 10;		
		
		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = null;
		
		selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		
		
		/* 조회 시작 */
		List<NoticeDTO> noticeList = new NoticeService().selectAllNoticeList(selectCriteria);
		
		System.out.println(noticeList);
		
		String path = "";
		if(noticeList != null) {
			path = "/WEB-INF/views/customerCenter/noticeList.jsp";
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("selectCriteria", selectCriteria);
		} else {
			path = "/WEB-INF/views/error/500error.jsp";
			request.setAttribute("message", "공지 조회를 실패했습니다!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}
		
	}

