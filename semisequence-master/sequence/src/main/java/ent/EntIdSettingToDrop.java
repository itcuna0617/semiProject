package ent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ent.model.dto.EntDTO;
import ent.model.service.EntService;

@WebServlet("/ent/drop")
public class EntIdSettingToDrop extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "../WEB-INF/views/ent/entIdDrop.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		int entNo = (int)session.getAttribute("entNo");
		String inputPass = request.getParameter("pass1");
		
		EntDTO requestMember = new EntDTO();
		requestMember.setEntNo(entNo);
		requestMember.setEntPwd(inputPass);
		requestMember.setEntId(((EntDTO)session.getAttribute("loginMember")).getEntId());
		
		System.out.println(session.getAttribute("loginMember"));
		
		EntService entService = new EntService();
		int result = entService.passCheck(requestMember);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/ent/entMyPage.jsp";
			request.setAttribute("successCode", "성공적으로 회원탈퇴하였습니다.");
			session.removeAttribute("loginMember");
			session.removeAttribute("entNo");
			session.removeAttribute("entPhone");
			session.removeAttribute("entName");
			session.removeAttribute("entEmail");
			session.removeAttribute("successCode");
		} else {
			path = "/WEB-INF/views/entIdDrop/.jsp";
			request.setAttribute("message", "회원탈퇴에 실패하셨습니다.");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		
//		String inputPass1 = request.getParameter("pass1");
//		String inputPass2 = request.getParameter("pass2");
//		
//		
//		if(inputPass1.equals(inputPass2)) {
//			HttpSession session = request.getSession();
//			
//			EntDTO requestMember = new EntDTO();
//			requestMember.setEntNo((int)session.getAttribute("entNo"));
//			requestMember.setEntPwd(inputPass2);
//			
//			EntService entService = new EntService();
//			
//			int result = entService.passCheck(requestMember);
//			
//			System.out.println(result);
//			
//			
//		} else {
//			System.out.println("불일치");
//		}
//	}


}

