package ent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ent.model.dto.EntDTO;
import ent.model.service.EntService;

@WebServlet("/ent/passwordsetting")
public class EntIdSettingToPasswordSetting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "../WEB-INF/views/ent/entPasswordUpdate.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String path = "";
		
		/* session의 정보와 request의 정보를 변수로 담음 */
		HttpSession session = request.getSession();
		int entNo = (int)session.getAttribute("entNo");
		String nowPassword = request.getParameter("nowPassword");
		String entPassword = request.getParameter("entPassword");
		
		/* service로 정보를 보내고 리턴을 받기 위해 service 인스턴스 생성 */
		EntService EntService = new EntService();
		
		/* DB에 저장되어 있는 Password를 조회해서 변수에 담는다. */
		String dbPassword = EntService.entSelectPassword(entNo);
		
		/*
		 * DB에 담긴 비밀번호는 암호화 된 상태이기 때문에 화면에서 넘어온 비밀번호와 비교하기 위해
		 * BCryptPasswordEncoder에서 제공하는 matches 메소드를 사용하기 위해서 인스턴스를 생성한다.
		 */
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		/* 현재 비밀번호 input에서 넘어온 값과 DB에 저장되어 있는 비밀번호를 비교 */
		if(passwordEncoder.matches(nowPassword, dbPassword)) {			
			EntDTO entInfo = new EntDTO();
			entInfo.setEntNo(entNo);
			entInfo.setEntPwd(entPassword);
			
			int result = EntService.entInfoPasswordUpdate(entInfo);
			
			if(result > 0) {
				path = "/WEB-INF/views/ent/entIdSetting.jsp";
				request.setAttribute("successCode", "비밀번호 변경 완료");
			} else {
				path = "/WEB-INF/views/ent/entIdSetting.jsp";
				request.setAttribute("message", "비밀번호 변경 실패");
			}
		} else {
			path = "/WEB-INF/views/ent/entIdSetting.jsp";
			request.setAttribute("message", "비밀번호 변경 실패");
		}

		request.getRequestDispatcher(path).forward(request, response);
	}

}
