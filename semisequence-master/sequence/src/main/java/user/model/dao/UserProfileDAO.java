package user.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class UserProfileDAO {

	public int selectTotalCount(SqlSession session) {
		return session.selectOne("UserProfileDAO.selectTotalCount");
	}

}
