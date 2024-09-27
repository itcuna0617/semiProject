package posting.model.service;
import static common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import common.paging.SelectCriteria;
import posting.model.dao.PostingDAO;
import posting.model.dto.ApplicationDTO;
import posting.model.dto.PostingAndProjectDTO;
import posting.model.dto.PostingDTO;
import posting.model.dto.UserProfileDTO;

public class PostingService {
	PostingDAO postingDAO = new PostingDAO();
	public List<PostingDTO> selectPostingListByProject(int projectNo) {
		SqlSession session = getSqlSession();
		
		List<PostingDTO> postingList = postingDAO.selectPostingListByProject(session, projectNo);
		
		session.close();
		
		return postingList;
	}

	public PostingDTO selectPostingDetail(int postingNo) {
		SqlSession session = getSqlSession();
		
		PostingDTO posting = postingDAO.selectPostingDetail(session, postingNo);
		
		session.close();
		
		return posting;
	}

	public boolean insertPosting(PostingDTO posting) {
		SqlSession session = getSqlSession();
		
		int result = postingDAO.insertPosting(session, posting);
		
		if(result ==1) {
			session.commit();
			session.close();
			return true;
			
		} else {
			session.close();
			session.rollback();
			return false;
			
		}
		
		
		
	}


	public List<PostingDTO> selectPostingListByEnt(int entNo) {
		SqlSession session = getSqlSession();
		
		List<PostingDTO> postingList= postingDAO.selectPostingListByEnt(session, entNo);
		
		session.close();
		
		return postingList;
	}
	
	public List<PostingDTO> selectPostingListIncludeProjectName(int entNo) {
		SqlSession session = getSqlSession();
		
		List<PostingDTO> postingList= postingDAO.selectPostingListIncludeProjectName(session, entNo);
		
		session.close();
		
		return postingList;
	}

	public List<PostingDTO> selectPostingListByUser(int userNo) {
		SqlSession session = getSqlSession();
		
		List<PostingDTO> postingList= postingDAO.selectPostingListByUser(session, userNo);
		
		session.close();
		
		return postingList;
	}

	public boolean updatePosting(PostingDTO posting) {
		SqlSession session = getSqlSession();
		
		int result = postingDAO.updatePosting(session, posting);
		
		if(result==1) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		return result==1? true : false;
	}

	public boolean deletePosting(int postingNo) {
		SqlSession session = getSqlSession();
		
		int result = postingDAO.deletePosting(session, postingNo);
		
		if(result==1) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		return result==1?true : false;
	}

	public boolean openPosting(int postingNo) {
		SqlSession session = getSqlSession();
		
		int result = postingDAO.openPosting(session, postingNo);
		
		
		if(result==1) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		return result==1?true : false;
	}

	public boolean closePosting(int postingNo) {
		SqlSession session = getSqlSession();
		
		int result = postingDAO.closePosting(session, postingNo);
		
		
		if(result==1) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		return result==1?true : false;
	}

	public boolean deletePostingGroupByProject(int projectNo) {
		SqlSession session = getSqlSession();
		
		int result = postingDAO.deletePostingGroupByProject(session, projectNo);
		
		if(result==1) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		return result==1?true : false;
	}

	public int selectTotalCount(Map<String, String> searchMap) {
		
		SqlSession session = getSqlSession();
		
		int totalCount = postingDAO.selectTotalCount(session, searchMap);
		
		session.close();
		
		return totalCount;
	}

	public List<PostingDTO> selectPostingList(SelectCriteria selectCriteria) {
		
		SqlSession session = getSqlSession();
		
		List<PostingDTO> postingList = postingDAO.selectPostingList(session, selectCriteria);
		
		session.close();
		
		return postingList;
	}

	public PostingDTO selectUserPostingDetail(int no) {
		
		SqlSession session = getSqlSession();
		PostingDTO userPostingDetail = null; 
		
		int result = postingDAO.incrementPostingCount(session, no);
		
		if(result > 0) {
			
			userPostingDetail = postingDAO.selectUserPostingDetail(session, no);
			
			if(userPostingDetail != null) {
				session.commit();
			} else {
				session.rollback();
			}
		} else {
			session.rollback();
		}
		
		session.close();
				
		return userPostingDetail;
	}

	public PostingAndProjectDTO selectEntPostingDetail(int no) {
		
		SqlSession session = getSqlSession();
		PostingAndProjectDTO entPostingDetail = null;

		int result = PostingDAO.incrementPostingCount(session, no);
		
		if(result > 0) {
			entPostingDetail = postingDAO.selectEntPostingDetail(session, no);
			
			if(entPostingDetail != null) {
				session.commit();
			} else {
				session.rollback();
			}
		} else {
			session.rollback();
		}
		
		session.close();
		
		return entPostingDetail;
	}

	public List<UserProfileDTO> selectUserProfile(String userId){
		
		SqlSession session = getSqlSession();
		
		List<UserProfileDTO> profileList = postingDAO.selectUserProfile(session, userId);
		
		System.out.println(profileList);
		
		if(profileList != null) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return profileList;
	}

	public int insertPostingApplication(ApplicationDTO newApplication) {
		
		SqlSession session = getSqlSession();
		
		int result = postingDAO.insertPostingApplication(session, newApplication);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

}
