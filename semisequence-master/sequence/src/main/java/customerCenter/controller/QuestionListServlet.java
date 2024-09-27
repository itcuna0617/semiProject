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
import customerCenter.model.dto.QuestionAndAnswerDTO;
import customerCenter.model.service.QuestionService;

@WebServlet("/questionList")
public class QuestionListServlet extends HttpServlet {
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
		

		/* 조회 시작*/
		List<QuestionAndAnswerDTO> questionList = questionService.selectAllQuestionList(selectCriteria);
		
		System.out.println(questionList);
		
		String path = "";
		if(questionList != null) {
			path = "/WEB-INF/views/customerCenter/questionList.jsp";
			request.setAttribute("questionList", questionList);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("selectCriteria", selectCriteria);
			request.setAttribute("successCode", "문의내역 페이지로 이동합니다.");
			
			
		} else {
			path = "/WEB-INF/views/customerCenter/noticeList.jsp";
			request.setAttribute("failCode", "로그인 회원만 문의에 접근할 수 있습니다.");
			
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	
	}
}
