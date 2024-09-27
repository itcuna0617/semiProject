package customerCenter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import customerCenter.model.dto.QuestionAndAnswerAndFileDTO;
import customerCenter.model.service.QuestionService;

@WebServlet("/questionDetail")
public class QuestionDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 조회 */
		int queNo = Integer.parseInt(request.getParameter("queNo"));
		
		System.out.println("queNo : " + queNo);
		QuestionService questionService = new QuestionService();
		QuestionAndAnswerAndFileDTO queDetail = questionService.selectQuestionDetail(queNo);
		
		System.out.println("queDetail : " + queDetail);
		
		/* DTO에 값 담아오기 */
		QuestionAndAnswerAndFileDTO questionFile = questionService.selectQuestionFile(queNo);
		
		System.out.println(questionFile);
		
		/* 본인만 열람할 수 있도록 세션에서 회원번호 불러오기 위한 코드 */
		HttpSession session = request.getSession();
		
		String path = "";
		if(queDetail != null) {
			
			if((Integer)(session.getAttribute("userNo")) == (queDetail.getUserNo())) {
				path = "/WEB-INF/views/customerCenter/questionDetail.jsp";
				request.setAttribute("question", queDetail);
				request.setAttribute("questionFile", questionFile);

			} else if((Integer)(session.getAttribute("entNo")) == (queDetail.getEntNo())) {
				path = "/WEB-INF/views/customerCenter/questionDetail.jsp";
				request.setAttribute("question", queDetail);
				request.setAttribute("questionFile", questionFile);
			} else {
				path = "/WEB-INF/views/error/500error.jsp";
				request.setAttribute("failMessage", "본인의 문의 내역만 확인할 수 있습니다!");
			}
			
		} else {
			path = "/WEB-INF/views/error/500error.jsp";
			request.setAttribute("message", "문의 조회를 실패했습니다!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
}
