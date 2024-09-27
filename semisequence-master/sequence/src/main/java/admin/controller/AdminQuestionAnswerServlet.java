package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.dto.QuestionAndAnswerAndFileDTO;
import admin.model.service.AdminService;

@WebServlet("/adminQuestionAnswer")
public class AdminQuestionAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/* 문의 내역 조회 */
		int queNo = Integer.parseInt(request.getParameter("queNo"));
		
		System.out.println("queNo : " + queNo);
		AdminService adminService = new AdminService();
		QuestionAndAnswerAndFileDTO adminQuestionDetail = adminService.selectAdminQuestionAnswerDetail(queNo);
		
		System.out.println("adminQuestionDetail : " + adminQuestionDetail);
		
		/* 문의 파일 조회(파일이 없는 경우도 있기 때문에 분리) */
		QuestionAndAnswerAndFileDTO adminQuestionFile = adminService.selectAdminQuestionAnswerDetail(queNo);
		
		System.out.println(adminQuestionFile);
		
		String path = "";
		if(adminQuestionDetail != null) {
			path = "/WEB-INF/views/admin/adminQuestionAnswer.jsp";
			request.setAttribute("adminQuestionDetail", adminQuestionDetail);
			request.setAttribute("adminQuestionFile", adminQuestionFile);
			request.setAttribute("queNo", queNo);
		} else {
			path = "/WEB-INF/views/error/500error.jsp";
			request.setAttribute("message", "공지 조회를 실패했습니다!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminService adminService = new AdminService();
		/* 문의 답변 등록 */
		
		System.out.println("도착했니");
		/* 입력받은 값들의 변수 선언 */
		Integer queNo = Integer.parseInt(request.getParameter("queNo"));
		System.out.println("서블릿 도착 : " + queNo);
		
		String ansTitle = request.getParameter("ansTitle");
		String ansContent = request.getParameter("ansContent");
		
		/* 입력받은 값들을 DTO에 담는다 */
		QuestionAndAnswerAndFileDTO adminAnswer = new QuestionAndAnswerAndFileDTO();
		adminAnswer.setAnsTitle(ansTitle);
		adminAnswer.setAnsContent(ansContent);
		adminAnswer.setQueNo(queNo);

		System.out.println("adminAnswer 입력 확인 : " + adminAnswer);
		
		int adminAnswerResult = adminService.insertAdminAnswer(adminAnswer);
	
		System.out.println("adminAnswerResult result: " + adminAnswerResult);
		
		int updateAnswer = adminService.updateAnswerYN(queNo);
		
		
		String path = "";
		if(adminAnswer != null && updateAnswer > 0) {
			path = "/WEB-INF/views/admin/insertAnswerSuccess.jsp";
			request.setAttribute("message", "insertAnswer");
			
		} else {
			path = "/WEB-INF/views/error/500)error.jsp";
			request.setAttribute("message", "답변 입력을 실패했습니다!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);

	}
}


