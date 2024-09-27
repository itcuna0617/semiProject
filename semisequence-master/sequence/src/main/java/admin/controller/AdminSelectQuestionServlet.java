package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.dto.QuestionAndAnswerAndFileDTO;
import admin.model.service.AdminService;
import common.paging.Pagenation;
import common.paging.SelectCriteria;

@WebServlet("/adminQuestionList")
public class AdminSelectQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* paging 처리 */
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}

		AdminService adminService = new AdminService();
		
		int totalCount = adminService.selectTotalCount();
		
		int limit = 5;
		int buttonAmount = 5;
		SelectCriteria selectCriteria = null;
		selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);	
		
		/* 조회 시작 : 답변여부가 N인 질문만 조회 */
		List<QuestionAndAnswerAndFileDTO> adminQuestionList = adminService.adminSelectAllQuestionList(selectCriteria);
		
		System.out.println(adminQuestionList);
		
		String path = "";
		if(adminQuestionList != null) {
			path = "/WEB-INF/views/admin/adminQuestionList.jsp";
			request.setAttribute("adminQuestionList", adminQuestionList);
			request.setAttribute("selectCriteria", selectCriteria);
		} else {
			path = "/WEB-INF/views/error/500error.jsp";
			request.setAttribute("message", "리스트를 불러오지 못했습니다!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}
}
