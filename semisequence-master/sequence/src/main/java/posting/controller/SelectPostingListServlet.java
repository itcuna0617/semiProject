package posting.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import posting.model.dto.PostingDTO;
import posting.model.service.PostingService;
import project.model.service.ProjectService;

@WebServlet("/posting/list")
public class SelectPostingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SelectPostingList get요청 도달");
		
		HttpSession session = request.getSession();
		
		int entNo = 0;
		PostingService postingService = new PostingService();
		ProjectService projectService = new ProjectService();
		//여기서 굳이 arrayList 다형성 적용을 시키지 않는 이유는 xml방식에서 내부적으로 arraylist를 사용해 반환하기 때문이다.
		List<PostingDTO> postingList = null;
		String path = "";
		
		if(session.getAttribute("entNo")!=null && session.getAttribute("entNo")!="0") {
			entNo = (int) session.getAttribute("entNo");
			postingList = postingService.selectPostingListIncludeProjectName(entNo);
		
			/* 15일이 넘는 공고를 걸러내는 과정 */
			long nowTime = System.currentTimeMillis();
			List<PostingDTO> returnPostingList = new ArrayList<>();
			
			for (PostingDTO posting : postingList) {
				System.out.println("조회된 posting객체 : " + posting);
				long postingDate = posting.getPostingDate().getTime();
				System.out.println(postingDate);
				String deleteYN = posting.getPostingDeleteYN();
				System.out.println(nowTime-postingDate);
				System.out.println(deleteYN);
				if(((nowTime - postingDate) < 1296000000) && (deleteYN.equals("N"))) {
					returnPostingList.add(posting);
				}
			}
			
			/* 기업 공고 jsp로 보냄. project단위로 볼 수 있다. */
			if(!returnPostingList.isEmpty() && returnPostingList!=null) {
				path="/WEB-INF/views/posting/selectPostingList.jsp";
				request.setAttribute("postingList", returnPostingList);
			} else {
				path="/WEB-INF/views/posting/selectPostingList.jsp";
				request.setAttribute("message", "공고를 조회하는데 실패했습니다.");
			}
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
