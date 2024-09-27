package posting.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import common.paging.SelectCriteria;
import posting.model.dto.ApplicationDTO;
import posting.model.dto.PostingAndProjectDTO;

import posting.model.dto.PostingDTO;
import posting.model.dto.UserProfileDTO;

public class PostingDAO {

	public int selectTotalCount(SqlSession session, Map<String, String> searchMap) {
		
		return session.selectOne("PostingDAO.selectTotalCount", searchMap);
	}

	public List<PostingDTO> selectPostingList(SqlSession session, SelectCriteria selectCriteria) {
		
		return session.selectList("PostingDAO.selectPostingList", selectCriteria);
	}

	public PostingDTO selectUserPostingDetail(SqlSession session, int no) {
		
		return session.selectOne("PostingDAO.selectUserPostingDetail", no);
	}

	public PostingAndProjectDTO selectEntPostingDetail(SqlSession session, int no) {
		
		return session.selectOne("PostingDAO.selectEntPostingDetail", no);
	}

	public static int incrementPostingCount(SqlSession session, int no) {
		
		return session.update("PostingDAO.incrementPostingCount", no);
	}

	public List<UserProfileDTO> selectUserProfile(SqlSession session, String userId){
		
		return session.selectList("PostingDAO.selectUserProfile", userId);	
	}

	public int insertPostingApplication(SqlSession session, ApplicationDTO newApplication) {
		
		return session.insert("PostingDAO.insertPostingApplication", newApplication);
	}
	

	public List<PostingDTO> selectPostingListByProject(SqlSession session, int projectNo) {
		return session.selectList("selectPostingListByProject", projectNo);
	}

	public PostingDTO selectPostingDetail(SqlSession session, int postingNo) {
		return session.selectOne("selectPostingDetail", postingNo);
	}

	public int insertPosting(SqlSession session, PostingDTO posting) {
		return session.insert("insertPosting", posting);
	}

	public List<PostingDTO> selectPostingList(SqlSession session, int memberNo) {
		return session.selectList("PostingDAO.selectPostingList", memberNo);
	}

	public List<PostingDTO> selectPostingListByEnt(SqlSession session, int entNo) {
		return session.selectList("PostingDAO.selectPostingListByEnt", entNo);
	}

	public List<PostingDTO> selectPostingListByUser(SqlSession session, int userNo) {
		return session.selectList("PostingDAO.selectPostingListByUser", userNo);
	}

	public int updatePosting(SqlSession session, PostingDTO posting) {
		return session.update("PostingDAO.updatePosting", posting);
	}

	public int deletePosting(SqlSession session, int postingNo) {
		return session.update("PostingDAO.deletePosting", postingNo);
	}

	public int openPosting(SqlSession session, int postingNo) {
		return session.update("PostingDAO.openPosting", postingNo);
	}

	public int closePosting(SqlSession session, int postingNo) {
		return session.update("PostingDAO.closePosting", postingNo);
	}

	public List<PostingDTO> selectPostingListIncludeProjectName(SqlSession session, int entNo) {
		return session.selectList("PostingDAO.selectPostingListIncludeProjectName", entNo);
	}

	public int deletePostingGroupByProject(SqlSession session, int projectNo) {
		return session.update("PostingDAO.deletePostingGroupByProject", projectNo);
	}
	
}
