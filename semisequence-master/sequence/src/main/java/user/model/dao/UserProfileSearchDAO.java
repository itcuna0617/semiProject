package user.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import common.paging.SelectCriteria;
import user.model.dto.SearchUserProfileDTO;

public class UserProfileSearchDAO {

	public int selectTotalProfileCount(SqlSession session, Map<String, String> searchMap) {
		return session.selectOne("UserProfileSearchDAO.selectTotalProfileCount", searchMap);
	}

	public List<SearchUserProfileDTO> selectUserProfileList(SqlSession session, SelectCriteria selectCriteria) {
		return session.selectList("UserProfileSearchDAO.selectUserProfileList", selectCriteria);
	}

	public SearchUserProfileDTO selectSearchUserProfileDetail(SqlSession session, Integer no) {
		return session.selectOne("UserProfileSearchDAO.selectSearchUserProfileDetail", no);
	}
	
}
