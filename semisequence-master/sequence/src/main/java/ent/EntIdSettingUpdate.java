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

@WebServlet("/ent/settingupdate")
public class EntIdSettingUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		int entNo = (int)session.getAttribute("entNo");
		String entName = request.getParameter("entName");
		String entPhone = request.getParameter("entPhone");
		String entEmail = request.getParameter("entEmail");
		
		EntDTO entDTO = new EntDTO();
		entDTO.setEntNo(entNo);
		entDTO.setEntName(entName);
		entDTO.setEntPhone(entPhone);
		entDTO.setEntEmail(entEmail);
		
		EntService EntService = new EntService();
		int result = EntService.entInfoUpdate(entDTO);
		
		String path = "";
		if(result > 0) {
			path = "/WEB-INF/views/ent/entIdSetting.jsp";
			request.setAttribute("successCode", "정보수정 완료");
			session.setAttribute("entName", entName);
			session.setAttribute("entPhone", entPhone);
			session.setAttribute("entEmail", entEmail);
		} else {
			path = "/WEB-INF/views/ent/entIdSetting.jsp";
			request.setAttribute("message", "정보수정 실패");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}

