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
@WebServlet("/notice/insert")
public class InsertNoticeByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 요청 도착");
		request.getRequestDispatcher("/WEB-INF/views/admin/adminNoticeInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		NoticeService noticeService = new NoticeService();
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		
		NoticeDTO notice = new NoticeDTO();
		
		notice.setNoticeTitle(noticeTitle);
		notice.setNoticeContent(noticeContent);
		
		boolean result = noticeService.insertNoticeByAdmin(notice);
		
		String path="";
		if(result) {
			path="/WEB-INF/views/admin/adminNoticeListForwarding.jsp";
		} else {
			path="/WEB-INF/views/error/500error.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
		
	}

}
