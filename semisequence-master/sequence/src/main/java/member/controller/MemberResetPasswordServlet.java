package member.controller;

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
import member.model.dto.MemberDTO;
import member.model.service.MemberService;

@WebServlet("/member/resetPassword")
public class MemberResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* POST 방식이므로 인코딩 설정 */
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		/* 비밀번호 인코딩을 위한 BCryptPasswordEncoder */
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		/* 입력받은 정보들을 변수로 받음 */
		String id = (String)session.getAttribute("userId");
		String newPassword = request.getParameter("newPassword");
		String passwordCheck = request.getParameter("passwordCheck");
		String userType = (String)session.getAttribute("userType");
		
		/* 값이 잘 넘어오는지 확인 */
		System.out.println("새 비밀번호 : " + newPassword);
		System.out.println("비밀번호 확인 : " + passwordCheck);
		System.out.println("회원구분 : " + userType);
		System.out.println("아이디 : " + id);

		int result = 0;
		
		/* 두 값이 일치하면 비밀번호 변경 진행 */
		if(newPassword.equals(passwordCheck)) {
			System.out.println("비밀번호 일치! 비밀번호 재설정 진행");
			
			/* 비밀번호 암호화 */
			passwordCheck = passwordEncoder.encode(passwordCheck);
			
			System.out.println("암호화 후 : " + passwordCheck);
			
			/* 회원 종류에 따라 다른 Service로 이동 */
			if("user".equals(userType)) {
				MemberDTO requestMember = new MemberDTO();
				requestMember.setUserId(id);
				requestMember.setUserPassword(passwordCheck);
				
				MemberService memberService = new MemberService();
				
				result = memberService.updateMemberPassword(passwordCheck, requestMember);
			} else if("ent".equals(userType)) {
				EntDTO requestMember = new EntDTO();
				requestMember.setEntId(id);
				requestMember.setEntPwd(passwordCheck);
				
				EntService entService = new EntService();
				
				result = entService.updateEntPassword(passwordCheck, requestMember);
			}
		} else if(!newPassword.equals(passwordCheck)) {
			System.out.println("비밀번호 불일치!");
		} 
		
		System.out.println("result : " + result);
		
		String page = "";
		
		if(result > 0) {
			page = "/WEB-INF/views/member/loginMember.jsp";
		} else {
			page = "/WEB-INF/views/common/userFailed.jsp";
			
			request.setAttribute("message", "비밀번호 변경 실패!");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

}
