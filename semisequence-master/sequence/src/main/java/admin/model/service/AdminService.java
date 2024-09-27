package admin.model.service;

import static common.mybatis.Template.getSqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import admin.mapper.AdminMapper;
import admin.model.dao.AdminDAO;
import admin.model.dto.ApprovalAndEntInfoDTO;
import admin.model.dto.ApprovalDTO;
import admin.model.dto.QuestionAndAnswerAndFileDTO;
import customerCenter.model.dto.QuestionAndAnswerDTO;
import ent.model.dto.EntDTO;
import user.mapper.UserApplicationMapper;
import user.model.dto.UserInfoDTO;
import user.paging.SelectCriteria;

public class AdminService {
	
	private AdminMapper adminMapper;
	
	private final AdminDAO adminDAO;
	
	public AdminService() {
		adminDAO = new AdminDAO();
	}

	public int selectTotalCount() {

		SqlSession sqlSession = getSqlSession();
		
		adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		int totalCount  = adminMapper.selectTotalCount();
		
		sqlSession.close();
		
		return totalCount;
		
	}
	public List<ApprovalDTO> selectApproval() {
		
		SqlSession sqlSession = getSqlSession();
		
		adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		List<ApprovalDTO> approvalList = adminMapper.selectApproval();
		
		sqlSession.close();
		
		return approvalList;
	}
	public ApprovalAndEntInfoDTO selectApprovalAndEntInfoList(int entNo, SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		
		adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("selectCriteria", selectCriteria);
		map.put("entNo", entNo);
		
		ApprovalAndEntInfoDTO approval = adminMapper.selectApprovalAndEntInfoList(map);
		
		sqlSession.close();
		
		return approval;
	}
	
	/* 1:1 문의 리스트 조회 */
	public List<QuestionAndAnswerAndFileDTO> adminSelectAllQuestionList(common.paging.SelectCriteria selectCriteria) {
		
		SqlSession session = getSqlSession();
		
		List<QuestionAndAnswerAndFileDTO> adminQuestionList = adminDAO.adminSelectAllQuestionList(session, selectCriteria);
		
		session.close();
		
		return  adminQuestionList;
		
	}
	
	/* 문의 상세내역 조회 */
	public QuestionAndAnswerAndFileDTO selectAdminQuestionAnswerDetail(int queNo) {
		
		SqlSession session = getSqlSession();
		
		QuestionAndAnswerAndFileDTO adminQuestionDetail = adminDAO.selectAdminQuestionDetail(session, queNo);

		if(adminQuestionDetail != null) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
				
		return adminQuestionDetail;
	}
	
	/* 문의 파일 조회 */
	public QuestionAndAnswerAndFileDTO selectAdminQuestionFile(int queNo) {
		
		SqlSession session = getSqlSession();
		
		QuestionAndAnswerAndFileDTO adminQuestionFile =  adminDAO.selectAdminQuestionFile(session, queNo);
		
		if(adminQuestionFile != null) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return adminQuestionFile;
	}
	
	/* 답변 insert */
	public int insertAdminAnswer(QuestionAndAnswerAndFileDTO adminAnswer) {
		
		SqlSession session = getSqlSession();
		
		int adminAnswerResult =  adminDAO.insertAdminAnswer(session, adminAnswer);
		
		/* insert 후 커밋 */
		if(adminAnswerResult > 0) {
			session.commit();
			
		}else {
			session.rollback();
		}
		
		session.close();
		
		return adminAnswerResult;
	
	}

	public int updateAnswerYN(int queNo) {

		SqlSession session = getSqlSession();

		int updateAnswerResult = adminDAO.updateAnswerYN(session, queNo);
		
		if( updateAnswerResult > 0) {
			session.commit();
			
		} else {
			session.rollback();
		}
	
		session.close();
		
		return updateAnswerResult > 0? 1 : 0;
	}

	public List<UserInfoDTO> selectUserInfo() {
		SqlSession sqlSession = getSqlSession();
		adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		List<UserInfoDTO> memberList = adminMapper.selectUserInfo();
		
		sqlSession.close();
		
		return memberList;
	}
	public void userStatusUpdate(String userNo) {
		SqlSession sqlSession = getSqlSession();
		adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		int result = adminMapper.userStatusUpdate(userNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return;
	}
	public void userStatusUpdateY(String userNo) {
		SqlSession sqlSession = getSqlSession();
		adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		int result = adminMapper.userStatusUpdateY(userNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return;
	}
	public List<EntDTO> selectEntInfo() {
		SqlSession sqlSession = getSqlSession();
		adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		List<EntDTO> entList = adminMapper.selectEntInfo();
		
		sqlSession.close();
		
		return entList;
	}
	public void entStatusUpdate(String userNo) {
		SqlSession sqlSession = getSqlSession();
		adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		int result = adminMapper.entStatusUpdate(userNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return;
	}
	public void entStatusUpdateY(String userNo) {
		SqlSession sqlSession = getSqlSession();
		adminMapper = sqlSession.getMapper(AdminMapper.class);
		
		int result = adminMapper.entStatusUpdateY(userNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return;
	}
	
	
}


