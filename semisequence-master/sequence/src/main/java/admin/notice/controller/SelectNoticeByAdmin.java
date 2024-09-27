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
@WebServlet("/notice/detail")
public class SelectNoticeByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeService noticeService = new NoticeService();
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		
		NoticeDTO notice = noticeService.selectNoticeDetail(noticeNo);
		
		String path="";
		
		if(notice != null) {
			path="/WEB-INF/views/admin/adminNoticeDetail.jsp";
			request.setAttribute("notice", notice);
		} else {
			path="/WEB-INF/views/error/500error.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

}
