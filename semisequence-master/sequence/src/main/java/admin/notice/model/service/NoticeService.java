package admin.notice.model.service;
import static common.mybatis.Template.getSqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import admin.notice.model.DAO.NoticeDAO;
import admin.notice.model.DTO.NoticeDTO;

public class NoticeService {
	NoticeDAO noticeDAO;
	public NoticeService() {
		noticeDAO=new NoticeDAO();
	}
	public List<NoticeDTO> selectNoticeList(int startSelect, int endSelect) {
		SqlSession session = getSqlSession();
		
		Map<String, Integer> criteria= new HashMap<>();
		
		criteria.put("startSelect", startSelect);
		criteria.put("endSelect", endSelect);
		
		System.out.println("시작 숫자 : " + criteria.get("startSelect"));
		System.out.println("끝 숫자 : " + criteria.get("endSelect"));
		List<NoticeDTO> noticeList = noticeDAO.selectNoticeList(session, criteria);
		
		session.close();
		
		return noticeList;
	}
	public int selectTotalNotice() {
		SqlSession session = getSqlSession();
		
		int total = noticeDAO.selectTotalNotice(session);
		
		session.close();
		
		return total;
	}
	public NoticeDTO selectNoticeDetail(int noticeNo) {
		SqlSession session = getSqlSession();
		
		NoticeDTO notice = noticeDAO.selectNoticeDetail(session, noticeNo);
		
		session.close();
		
		
		return notice;
	}
	public boolean updateNoticeByAdmin(NoticeDTO notice) {
		SqlSession session = getSqlSession();
		
		int result = noticeDAO.updateNoticeByAdmin(session, notice);
		System.out.println(result);
		if(result==1) {
			session.commit();
		} else {
			session.rollback();
		}
		
		return result==1? true:false;
	}
	public boolean deleteNoticeByAdmin(int noticeNo) {
		SqlSession session = getSqlSession();
		
		int result = noticeDAO.deleteNoticeByAdmin(session, noticeNo);
		
		if(result==1) {
			session.commit();
		} else {
			session.rollback();
		}
		return result==1? true:false;
	}
	public boolean insertNoticeByAdmin(NoticeDTO notice) {
		SqlSession session = getSqlSession();
		
		int result = noticeDAO.insertNoticeByAdmin(session, notice);
		
		if(result==1) {
			session.commit();
		} else {
			session.rollback();
		}
		
		return result==1? true:false;
	}
}
