package admin.notice.model.DAO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import admin.notice.model.DTO.NoticeDTO;

public class NoticeDAO {

	public int selectTotalNotice(SqlSession session) {
		return session.selectOne("NoticeDAObyAdmin.selectTotalNotice");
	}

	public List<NoticeDTO> selectNoticeList(SqlSession session, Map<String, Integer> criteria) {
		return session.selectList("NoticeDAObyAdmin.selectNoticeList", criteria);
	}

	public NoticeDTO selectNoticeDetail(SqlSession session, int noticeNo) {
		return session.selectOne("NoticeDAObyAdmin.selectNoticeDetail", noticeNo);
	}

	public int updateNoticeByAdmin(SqlSession session, NoticeDTO notice) {
		return session.update("NoticeDAObyAdmin.updateNoticeByAdmin", notice);
	}
	public int deleteNoticeByAdmin(SqlSession session, int noticeNo) {
		return session.update("NoticeDAObyAdmin.deleteNoticeByAdmin", noticeNo);
	}

	public int insertNoticeByAdmin(SqlSession session, NoticeDTO notice) {
		return session.insert("NoticeDAObyAdmin.insertNoticeByAdmin", notice);
	}

}
