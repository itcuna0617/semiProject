package user.model.service;

import static common.mybatis.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import user.mapper.UserInfoMapper;
import user.model.dto.UserInfoDTO;

public class UserInfoService {

	private UserInfoMapper userInfoMapper;
	
	/* 개인회원 정보 select */
	public UserInfoDTO selectUserInfo(int userNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
		
		UserInfoDTO userInfo = userInfoMapper.selectUserInfo(userNo);
		
		sqlSession.close();
		
		return userInfo;
	}

	/* 개인회원 정보 update */
	public int userInfoUpdate(UserInfoDTO userInfoDTO) {
		
		SqlSession sqlSession = getSqlSession();
		userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
		
		int result = userInfoMapper.userInfoUpdate(userInfoDTO);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	/* 개인회원 정보 delete */
	public int userInfoDelete(UserInfoDTO userInfo) {
		
		SqlSession sqlSession = getSqlSession();
		userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
		
		String encPwd = userInfoMapper.selectEncryptedPwd(userInfo);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		int result = 0;
		
		if(passwordEncoder.matches(userInfo.getUserPassword(), encPwd)) {
			result = userInfoMapper.userInfoDelete(userInfo);
			
			if(result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} 
		sqlSession.close();
		return result;
	}

	/* 개인회원 비밀번호 변경 */
	public int userInfoPasswordUpdate(UserInfoDTO userInfo) {
		
		SqlSession sqlSession = getSqlSession();
		userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
		
		int result = userInfoMapper.userInfoPasswordUpdate(userInfo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
	}

	/* 비밀번호 변경 시 현재 비밀번호 일치여부 확인 */
	public String selectUserInfoPasswordUpdate(int userNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
		
		String userBeforPassword = userInfoMapper.selectUserInfoPasswordUpdate(userNo);
		
		sqlSession.close();
		
		return userBeforPassword;
	}
	
}
