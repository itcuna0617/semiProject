package ent.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.oreilly.servlet.MultipartRequest;

import ent.model.dto.EntDTO;
import ent.model.service.EntService;

@WebServlet("/ent/regist")
public class EntRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* POST 방식이므로 인코딩 설정 */
		request.setCharacterEncoding("UTF-8");
		
		/* 비밀번호 인코딩을 위한 BCryptPasswordEncoder */
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		/* 입력받은 파일이 저장될 경로 */
		String rootLocation = getServletContext().getRealPath("/");

		String savePath = rootLocation + "/img/enrollment/";
		
		/* form에서 multipart로 넘겨받았기 떄문에 MultiRequest의 getParameter를 사용해야 인자를 받을 수 있다. */ 
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, 10*1024*1024, "UTF-8");
		
		/* 입력받은 정보들을 변수로 받음 */
		String entId = multiRequest.getParameter("entId"); 
		String entPassword = passwordEncoder.encode(multiRequest.getParameter("entPassword")); 
		String entName = multiRequest.getParameter("entName"); 
		String entEmail = multiRequest.getParameter("entEmail"); 
		String entPhone = multiRequest.getParameter("entPhone");
		String filename = multiRequest.getFilesystemName("enrollmentImg");
		
		/* EntDTO에 받아온 값들 넣기 */
		EntDTO requestEnt = new EntDTO();
		requestEnt.setEntId(entId);
		requestEnt.setEntPwd(entPassword);
		requestEnt.setEntName(entName);
		requestEnt.setEntEmail(entEmail);
		requestEnt.setEntPhone(entPhone);
		requestEnt.setEnrollmentFileName(filename);
		
		/* DTO에 담긴 값 확인차 출력 */
		System.out.println("DTO에 담긴 값 : " + requestEnt);
		
		int result = new EntService().registEnt(requestEnt, savePath);
		
		System.out.println("registMember result : " + result);
		
		String page = "";
		
		if(result > 0) {
			page = "/WEB-INF/views/member/loginMember.jsp";
		} else {
			page = "/WEB-INF/views/common/userFailed.jsp";
			request.setAttribute("message", "회원가입 실패!");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

}
