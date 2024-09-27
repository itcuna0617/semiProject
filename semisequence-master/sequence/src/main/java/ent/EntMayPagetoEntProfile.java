package ent;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ent.model.dto.EntProfileDTO;
import ent.model.service.EntService;

@WebServlet("/ent/profilepage")
public class EntMayPagetoEntProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EntService entService = new EntService();
		
		String path = "";
		
		EntProfileDTO entProfileDTO = new EntProfileDTO();
		
		entProfileDTO = entService.selectProfYn((int)session.getAttribute("entNo"));
		
		System.out.println("정보 조회 잘 되나연? " + entProfileDTO);
		
		if(entProfileDTO == null) {
			System.out.println("등록된 프로필이 없음");
			path = "/WEB-INF/views/ent/entProfile.jsp";
		} else {
			System.out.println("등록된 프로필이 있음");
			path = "/WEB-INF/views/ent/entProFileDetail.jsp";
			request.setAttribute("entProfile", entProfileDTO);
			request.setAttribute("profStatusCode", "등록된 프로필이 있습니다. 프로필 수정 페이지로 이동합니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
