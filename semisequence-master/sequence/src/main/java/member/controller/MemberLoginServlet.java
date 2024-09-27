package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.reflection.SystemMetaObject;

import ent.model.dto.EntDTO;
import ent.model.service.EntService;
import member.model.dto.MemberDTO;
import member.model.service.MemberService;

@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {
   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      
      HttpSession session = request.getSession();
      session.setAttribute("member", null);
      
      String memberId = request.getParameter("userId");
      String memberPwd = request.getParameter("userPassword");
      String userType = request.getParameter("userType");
      
      System.out.println("memberId : " + memberId);
      System.out.println("memberPwd : " + memberPwd);
      System.out.println("회원구분 : " + userType);
      
      MemberDTO loginMember = null;
      EntDTO loginEnt = null;
      /* 체크박스로 넘어온 개인/기업 여부를 통해 DTO 결정 */
      if("user".equals(userType)) {
         MemberDTO requestMember = new MemberDTO();
         requestMember.setUserId(memberId);
         requestMember.setUserPassword(memberPwd);
        
         
         MemberService memberService = new MemberService();
         
         loginMember = memberService.loginCheck(requestMember, userType);
         
         System.out.println("로그인한 회원의 정보 : " + loginMember);
         if(loginMember != null) {
            session.setAttribute("loginMember", loginMember);
            /* 회원정보 수정 시 기존 덮어씌울 session 만듬 */
            session.setAttribute("loginMember2", loginMember);
            
            System.out.println(session.getAttribute("loginMember"));
            session.setAttribute("userNo", loginMember.getUserNo());
            session.setAttribute("userId", loginMember.getUserId());
            session.setAttribute("userType", userType);
            
            session.setAttribute("successCode", "성공");
            session.setAttribute("userLoginCode", "개인");
            
            response.sendRedirect(request.getContextPath());
         } else {
        	 String path = "/WEB-INF/views/common/userFailed.jsp";
  			request.setAttribute("message", "로그인에 실패했습니다.");
  			request.getRequestDispatcher(path).forward(request, response);
         }
      } else if("ent".equals(userType)) {
         EntDTO requestMember = new EntDTO();
         requestMember.setEntId(memberId);
         requestMember.setEntPwd(memberPwd);
         
         System.out.println(requestMember.getEntId());
         System.out.println(requestMember.getEntPwd());
         
         EntService entService = new EntService();
         
         loginEnt = entService.loginCheck(requestMember, userType);
         System.out.println("로그인한 회원의 정보 : " + loginEnt);
         
         if(loginEnt != null) {
            session.setAttribute("loginMember", loginEnt);
            session.setAttribute("entNo", loginEnt.getEntNo());
            session.setAttribute("entPhone", loginEnt.getEntPhone());
            session.setAttribute("entName", loginEnt.getEntName());
            session.setAttribute("entEmail", loginEnt.getEntEmail());
            session.setAttribute("member", "ent");
            
            session.setAttribute("entLoginCode", "기업");
            session.setAttribute("entId", loginEnt.getEntId());
            session.setAttribute("member", "ent");
            System.out.println(session.getAttribute("loginMember"));
            session.setAttribute("userType", userType);
            
            String entProfileImg = entService.selectProfileImg((int)session.getAttribute("entNo"));
            session.setAttribute("entProfileImg", entProfileImg);
            
            session.setAttribute("successCode", "성공");
            response.sendRedirect(request.getContextPath());
         } else {
        	String path = "/WEB-INF/views/common/userFailed.jsp";
 			request.setAttribute("message", "로그인에 실패했습니다.");
 			request.getRequestDispatcher(path).forward(request, response);
         }
      }
      
   }
}
