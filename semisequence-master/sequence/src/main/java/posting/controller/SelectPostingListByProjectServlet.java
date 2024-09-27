package posting.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
/*
 * ajax 학습이 부족한 상태에서 닌자코드로 쓰여진 면이 있다.
 * 당장은 다른 팀원과 같이 쓸 일이 없는 서블릿이므로 냅둘 예정이나,
 * 추후 수정할 여유가 생긴다면 수정할 예정
 */
@WebServlet("/posting/list/by/project")
public class SelectPostingListByProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//다른 데에서 postinglistByProject.jsp를 열고싶을 경우 사용?할까
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostingService postingService = new PostingService();
		System.out.println("doPost까지는 왔음");
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		/* 임시로 projectList에서 set된 속성을 사용. */
		int projectNo = Integer.parseInt( request.getParameter("projectNo"));
		System.out.println(projectNo);
		List<PostingDTO> postingList = new ArrayList<>();
		postingList = postingService.selectPostingListByProject(projectNo);
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		if(!postingList.isEmpty()) {
			/*
			 * 이렇게 하지말고 json으로 넘기고, data.변수명의 형태로 꺼내서 사용하면된다.
			 * 하지만, 이렇게 하는 것이 더 간단한 것 같기도 하다.
			 */
			int i = 0;
			for (PostingDTO posting : postingList) {
				System.out.println(posting);
				System.out.println(posting.getPostingDeleteYN());
				if(posting.getPostingDeleteYN().equals("N")) {
					i++;
					out.println("<br>");
					out.println("<p>구인 공고 "+ i +"번</p>");
					out.println("<div class='posting' id='posting"+ i +"'>" );
					out.println("<h1 style='text-align:center' onclick='location.href=\""+request.getContextPath()+"/posting/detail?postingNo="+ posting.getPostingNo() + "\"'>"+posting.getPostingTitle() + "</h1>");
					out.println("<br> <p style='text-align:center' onclick='location.href=\""+request.getContextPath()+"/posting/detail?postingNo="+ posting.getPostingNo() + "\"'>"+posting.getPostingDetail() + "</p>");
					// 여기서 삭제,수정,비공개처리 가능해야함.  JSON으로 넘겨서 하는 게 이상적일 듯.
					out.println("<br>");
					out.println("<br>");
					out.println("</div>");
				}
			}
			
		} else {

			out.println("<p id='postingNotFound'> 공고가 등록되어있지 않습니다! </p>");
			
		}
		
		out.flush();
		out.close();
		
		
		
	}

}
