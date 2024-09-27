package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import member.model.dto.MemberDTO;
import member.model.service.MemberService;

@WebServlet("/member/regist")
public class MemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* POST 방식이므로 인코딩 설정 */
		request.setCharacterEncoding("UTF-8");
		
		/* 비밀번호 인코딩을 위한 BCryptPasswordEncoder */
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		/* 입력받은 정보들을 변수로 받음 */
		String userId = request.getParameter("userId");
		String userPwd = passwordEncoder.encode(request.getParameter("userPassword"));
		String userName = request.getParameter("userName");
		String userAdd = request.getParameter("userAdd");
		String userPhone = request.getParameter("userPhone");
		String userEmail = request.getParameter("userEmail");
		
		/* MemberDTO에 받아온 값들 넣기 */
		MemberDTO requestMember = new MemberDTO();
		requestMember.setUserId(userId);
		requestMember.setUserPassword(userPwd);
		requestMember.setUserName(userName);
		requestMember.setUserAddress(userAdd);
		requestMember.setUserPhone(userPhone);
		requestMember.setUserEmail(userEmail);
		
		/* DTO에 담긴 값 확인차 출력 */
		System.out.println("DTO에 담긴 값 : " + requestMember);
		
		int result = new MemberService().registMember(requestMember);
		
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
