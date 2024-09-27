package member.model.dao;

import org.apache.ibatis.session.SqlSession;

import member.model.dto.MemberDTO;

public class MemberDAO {

	/* 데이터 베이스에서 비밀번호를 가져옴(로그인시 필요) */
	public String selectEncryptedPwd(SqlSession session, MemberDTO requestMember) {
		
		return session.selectOne("MemberDAO.selectUserEncryptedPwd", requestMember);
	}

	/* 로그인시 회원 정보 가져오기 */
	public MemberDTO selectLoginMember(SqlSession session, MemberDTO requestMember) {
		
		return session.selectOne("MemberDAO.selectUserLoginMember", requestMember);
	}

	public int insertMember(SqlSession session, MemberDTO requestMember) {
		return session.insert("MemberDAO.insertMember", requestMember);
	}

	public int updateMemberPassword(SqlSession session, MemberDTO requestMember) {
		return session.update("MemberDAO.updateMemberPassword", requestMember);
	}

	public int insertMemberLoginSucccessHistory(SqlSession session, MemberDTO loginMember) {
		return session.insert("MemberDAO.insertMemberLoginSuccessHistory", loginMember);
	}
	
}
