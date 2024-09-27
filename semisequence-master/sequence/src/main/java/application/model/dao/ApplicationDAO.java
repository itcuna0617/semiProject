package application.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import application.model.dto.ApplicationDTO;

public class ApplicationDAO {

	public List<ApplicationDTO> selectApplicationByEnt(SqlSession session, Map<String, String> criteriaMap) {
		return session.selectList("ApplicationDAO.selectApplicationByEnt", criteriaMap);
	}

	public int selectTotalCount(SqlSession session, Map<String, String> criteriaMap) {
		return session.selectOne("ApplicationDAO.selectTotalCount", criteriaMap);
	}

	public int passApplication(SqlSession session, int applicationNo) {
		return session.update("ApplicationDAO.passApplication", applicationNo);
	}
	public int failApplication(SqlSession session, int applicationNo) {
		return session.update("ApplicationDAO.failApplication", applicationNo);
	}

	public List<ApplicationDTO> selectApplicationPass(SqlSession session, Map<String, String> criteriaMap) {
		return session.selectList("ApplicationDAO.selectApplicationPass", criteriaMap);
	}

	public List<ApplicationDTO> selectApplicationFail(SqlSession session, Map<String, String> criteriaMap) {
		return session.selectList("ApplicationDAO.selectApplicationFail", criteriaMap);
	}

	public int selectFailTotalCount(SqlSession session, Map<String, String> criteriaMap) {
		return session.selectOne("ApplicationDAO.selectFailTotalCount", criteriaMap);
	}
	public int selectPassTotalCount(SqlSession session, Map<String, String> criteriaMap) {
		return session.selectOne("ApplicationDAO.selectPassTotalCount", criteriaMap);
	}

}
