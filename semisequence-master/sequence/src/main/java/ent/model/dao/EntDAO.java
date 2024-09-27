package ent.model.dao;

import org.apache.ibatis.session.SqlSession;

import ent.model.dto.EntDTO;

public class EntDAO {

	public String selectEncryptedPwd(SqlSession session, String entId) {
		return session.selectOne("ent.EntInfoMapper.selectEncryptedPwd", entId);
	}

	public int deleteEntMember(SqlSession session, EntDTO requestMember) {
		return session.update("ent.EntInfoMapper.deleteEntMember", requestMember);
	}
	
	/* 로그인시 회원 정보 가져오기 */
	public EntDTO selectLoginMember(SqlSession session, EntDTO requestMember) {
		return session.selectOne("ent.EntInfoMapper.selectEntLoginMember", requestMember);
	}
	
	public static int insertEnt(SqlSession session, EntDTO requestEnt) {
		return session.insert("ent.EntInfoMapper.insertEnt", requestEnt);
	}
	
	public static int updateEntPassword(SqlSession session, EntDTO requestMember) {
		return session.update("ent.EntInfoMapper.updateEntPassword", requestMember);
	}


	public static int selectEntNo(SqlSession session, EntDTO requestEnt) {
		return session.selectOne("ent.EntInfoMapper.selectEntNo", requestEnt);
	}

	public int insertEntEnrollmentFile(SqlSession session, EntDTO requestEnt) {
		return session.insert("ent.EntInfoMapper.insertEntEnrollmentFile", requestEnt);
	}

	public static int insertRegistApplicationEnt(SqlSession session, EntDTO requestEnt) {
		return session.insert("ent.EntInfoMapper.insertRegistApplicationEnt", requestEnt);
	}

	public int insertEntLoginSucccessHistory(SqlSession session, EntDTO loginMember) {
		return session.insert("ent.EntInfoMapper.insertEntLoginSuccessHistory", loginMember);
	}
}
