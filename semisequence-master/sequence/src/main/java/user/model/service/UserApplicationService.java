package user.model.service;

import static common.mybatis.Template.getSqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import user.mapper.UserApplicationMapper;
import user.model.dto.UserAppliactionByPostingDTO;
import user.model.dto.UserApplicationHistoryDTO;
import user.model.dto.UserPostingDTO;
import user.paging.SelectCriteria;

public class UserApplicationService {
	
	private UserApplicationMapper userApplicationMapper;

	public int selectTotalCount(int userNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		userApplicationMapper = sqlSession.getMapper(UserApplicationMapper.class);
		
		int totalCount  = userApplicationMapper.selectTotalCount(userNo);
		
		sqlSession.close();
		
		return totalCount;
	}

	public List<UserApplicationHistoryDTO> selectUserApplicationList(int userNo, SelectCriteria selectCriteria) {
		SqlSession sqlSession = getSqlSession();
		
		userApplicationMapper = sqlSession.getMapper(UserApplicationMapper.class);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("selectCriteria", selectCriteria);
		map.put("userNo", userNo);
		
		List<UserApplicationHistoryDTO> userApplicationList = userApplicationMapper.selectUserApplicationList(map);
		
		sqlSession.close();
		
		return userApplicationList;
	}

	public UserPostingDTO selectUserPostingByPostingNo(int postingNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		userApplicationMapper = sqlSession.getMapper(UserApplicationMapper.class);
		
		UserPostingDTO userPostring = userApplicationMapper.selectUserPostingByPostingNo(postingNo);
		
		sqlSession.close();
		
		return userPostring;
		
	}

	public List<UserAppliactionByPostingDTO> selectUSerApplicationByPosting(int userNo, SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		
		userApplicationMapper = sqlSession.getMapper(UserApplicationMapper.class);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("selectCriteria", selectCriteria);
		map.put("userNo", userNo);
		
		List<UserAppliactionByPostingDTO> userApplicationByPostingList = userApplicationMapper.selectUSerApplicationByPosting(map);
		
		sqlSession.close();
		
		return userApplicationByPostingList;
	}
	
}
