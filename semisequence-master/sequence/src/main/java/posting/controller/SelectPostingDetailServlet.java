package posting.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import posting.model.dto.PostingDTO;
import posting.model.service.PostingService;
import project.model.service.ProjectService;

@WebServlet("/posting/detail")
public class SelectPostingDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostingService postingService = new PostingService();
		ProjectService projectService = new ProjectService();
		/* 이 서블릿은 단순히 포스팅 번호로 조회하고, 포스팅 정보를 모두 출력하므로, 어떤 관점에서건 다 사용할 수 있음. 
		 * 고객이건, 기업이건 똑같이 사용하되, session을 통해 구분한다.*/
		int postingNo = Integer.parseInt(request.getParameter("postingNo"));
		PostingDTO posting = postingService.selectPostingDetail(postingNo);
		String path = "";
		
		
		HttpSession session = request.getSession();
		/* session을 사용해 회원을 구분하고, 권한을 확인한다. */
		if(posting!=null && posting.getEntNo()==(int)session.getAttribute("entNo")) {
			String projectName = projectService.selectProjectName(posting.getProjectNo());
			path="/WEB-INF/views/posting/selectPostingDetail.jsp";
			request.setAttribute("posting", posting);
			request.setAttribute("projectName", projectName);
		} else {
			path="/WEB-INF/views/error/500error.jsp";
			request.setAttribute("message", "해당하는 포스팅이 없습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
