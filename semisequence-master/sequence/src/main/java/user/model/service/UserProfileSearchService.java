package user.model.service;

import static common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import common.paging.SelectCriteria;
import posting.model.dao.PostingDAO;
import posting.model.dto.PostingAndProjectDTO;
import posting.model.dto.PostingDTO;
import user.model.dao.UserProfileSearchDAO;
import user.model.dto.SearchUserProfileDTO;

public class UserProfileSearchService {
	UserProfileSearchDAO userProfileSearchDAO = new UserProfileSearchDAO();

	public int selectTotalProfileCount(Map<String, String> searchMap) {
		SqlSession session = getSqlSession();
		
		int totalCount = userProfileSearchDAO.selectTotalProfileCount(session, searchMap);
		
		session.close();
		
		return totalCount;
	}

	public List<SearchUserProfileDTO> selectUserProfileList(SelectCriteria selectCriteria) {
		SqlSession session = getSqlSession();
		
		List<SearchUserProfileDTO> profileList = userProfileSearchDAO.selectUserProfileList(session, selectCriteria);
		
		System.out.println("Service에서 profileList : " + profileList);
		
		session.close();
		
		return profileList;
	}

	public SearchUserProfileDTO selectSearchUserProfileDetail(Integer no) {
		SqlSession session = getSqlSession();
		
		SearchUserProfileDTO searchUserProfileDetail = userProfileSearchDAO.selectSearchUserProfileDetail(session, no);

		System.out.println("Service에서 searchUserProfileDetail : " + searchUserProfileDetail);
		
		session.close();
		
		return searchUserProfileDetail;
	}
	
}
