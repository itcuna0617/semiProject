package admin.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.notice.NoticePagenation;
import admin.notice.model.DTO.NoticeDTO;
import admin.notice.model.service.NoticeService;
@WebServlet("/notice/list")
public class SelectNoticeListByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeService noticeService = new NoticeService();
		int currentPage = Integer.parseInt(request.getParameter("page"));
		System.out.println("전달받은 현재 페이지 : " + currentPage );
		int size = 10;
		int pagingCount = 5;
		
		int endSelect = currentPage*10;
		int startSelect = endSelect-9;
		int total = noticeService.selectTotalNotice();
		
		System.out.println(total);

		NoticePagenation noticePaging = new NoticePagenation(total, size, currentPage, pagingCount);
		
		List<NoticeDTO> noticeList = noticeService.selectNoticeList(startSelect, endSelect);
		
		for (NoticeDTO notice : noticeList) {
			System.out.println(notice);
		}
		
		System.out.println(noticePaging);
		String path="";
		if(!noticeList.isEmpty() && noticeList != null) {
			path="/WEB-INF/views/admin/adminNoticeList.jsp";
			request.setAttribute("noticeList", noticeList);
			request.setAttribute("noticePaging", noticePaging);
		} else {
			path="/WEB-INF/views/error/500error.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
