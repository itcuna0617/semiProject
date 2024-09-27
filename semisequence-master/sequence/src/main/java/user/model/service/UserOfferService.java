package user.model.service;

import static common.mybatis.Template.getSqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import user.mapper.UserApplicationMapper;
import user.mapper.UserOfferMapper;
import user.model.dto.OfferByPostingByentInfoDTO;
import user.model.dto.UserApplicationHistoryDTO;
import user.paging.SelectCriteria;

public class UserOfferService {

	private UserOfferMapper userOfferMapper;
	
	public int selectTotalCount(int userNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		userOfferMapper = sqlSession.getMapper(UserOfferMapper.class);
		
		int totalCount  = userOfferMapper.selectTotalCount(userNo);
		
		sqlSession.close();
		
		return totalCount;
	}
	
	
	public List<OfferByPostingByentInfoDTO> selectUSerApplicationByPosting(int userNo, SelectCriteria selectCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		
		userOfferMapper = sqlSession.getMapper(UserOfferMapper.class);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("selectCriteria", selectCriteria);
		map.put("userNo", userNo);
		
		List<OfferByPostingByentInfoDTO> OfferByPostingByentInfoList= userOfferMapper.selectUSerApplicationByPosting(map);
		
		sqlSession.close();
		
		return OfferByPostingByentInfoList;
	}


	public int updateConnectYn(int offerNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		userOfferMapper = sqlSession.getMapper(UserOfferMapper.class);
		
		int result  = userOfferMapper.updateConnectYn(offerNo);
		
		if(result>0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}



	
}
