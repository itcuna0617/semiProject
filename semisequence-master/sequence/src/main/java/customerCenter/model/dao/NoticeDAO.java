package customerCenter.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.paging.SelectCriteria;
import customerCenter.model.dto.NoticeDTO;

	
public class NoticeDAO {

		public NoticeDTO selectNoticeDetail(SqlSession session, int noticeNo) {
			
			return session.selectOne("NoticeDAO.selectNoticeDetail", noticeNo);
		}

		public int selectTotalCount(SqlSession session) {

			return session.selectOne("NoticeDAO.selectTotalCount");
		}

		public List<NoticeDTO> selectAllNoticeList(SqlSession session, SelectCriteria selectCriteria) {

			return session.selectList("NoticeDAO.selectAllNoticeList", selectCriteria);
		}


}
