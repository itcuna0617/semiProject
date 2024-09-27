package customerCenter.model.service;

import static common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.paging.SelectCriteria;
import customerCenter.model.dao.NoticeDAO;
import customerCenter.model.dto.NoticeDTO;

public class NoticeService {

private final NoticeDAO noticeDAO;
	
	public NoticeService() {
		noticeDAO = new NoticeDAO();
	}
	
	
	public int selectTotalCount() {
		
		SqlSession session = getSqlSession();
		
		int totalCount = noticeDAO.selectTotalCount(session);
		
		session.close();
		
		return totalCount;

	}
	
	public List<NoticeDTO> selectAllNoticeList(SelectCriteria selectCriteria) {
		
		SqlSession session = getSqlSession();
		
		List<NoticeDTO> noticeList = noticeDAO.selectAllNoticeList(session, selectCriteria);
		
		session.close();
		
		return  noticeList;
	}

	public NoticeDTO selectNoticeDetail(int noticeNo) {
		
		SqlSession session = getSqlSession();
		
		NoticeDTO noticeDetail = noticeDAO.selectNoticeDetail(session, noticeNo);
			
		if(noticeDetail != null) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return noticeDetail;
	}

}
