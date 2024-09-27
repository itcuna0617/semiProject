package member.model.service;

import static common.mybatis.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import member.model.dao.MemberDAO;
import member.model.dto.MemberDTO;

public class MemberService {

	private final MemberDAO memberDAO;
	
	public MemberService() {
		memberDAO = new MemberDAO();
	}

	public MemberDTO loginCheck(MemberDTO requestMember, String userType) {

		SqlSession session = getSqlSession();
		MemberDTO loginMember = null;
		
		/* Test용으로 비밀번호와 직접 비교하여 로그인 시키기 위해 비밀번호 불러옴 */
		/* 암호화된 비밀번호 저장 후에 다시 구현 */
		String encPwd = memberDAO.selectEncryptedPwd(session, requestMember);

		/* 암호화된 비밀번호와 비교하는 부분 */
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		System.out.println("받아온 비밀번호 : " + encPwd);
		
		if(passwordEncoder.matches(requestMember.getUserPassword(), encPwd)) {
			System.out.println("로그인 성공!");
			loginMember = memberDAO.selectLoginMember(session, requestMember);
		}
		
		System.out.println("Service에서 받은 login 정보 : " + loginMember);
		
		/* 로그인 기록을 insert */
		int result = 0;
		
		if(loginMember != null) {
			result = memberDAO.insertMemberLoginSucccessHistory(session, loginMember);
		}
		
		if(result > 0) {
			System.out.println("로그인 성공 기록 완료!");
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return loginMember;
	}

	public int registMember(MemberDTO requestMember) {
		SqlSession session = getSqlSession();
		System.out.println(requestMember);
		int result = memberDAO.insertMember(session, requestMember);
		System.out.println(result);
		if(result > 0) {
			session.commit();
			System.out.println("commit 됨");
		} else {
			session.rollback();
			System.out.println("rollback 됨");
		}
		
		session.close();
		
		return result;
	}

	public int updateMemberPassword(String passwordCheck, MemberDTO requestMember) {
		SqlSession session = getSqlSession();
		
		int result = memberDAO.updateMemberPassword(session, requestMember);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

}
