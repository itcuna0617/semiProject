package user.model.service;

import static common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import common.paging.SelectCriteria;
import user.mapper.UserProfileMapper;
import user.model.dao.UserProfileDAO;
import user.model.dto.UserAddFileDTO;
import user.model.dto.UserPhotoDTO;
import user.model.dto.UserProfileDTO;

public class UserProfileService {
	
	private UserProfileMapper userProfileMapper;
	
	/* 개인 프로필 select */
	public List<UserProfileDTO> selectUserProfile(int userNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		userProfileMapper = sqlSession.getMapper(UserProfileMapper.class);
		
		List<UserProfileDTO> profileList = userProfileMapper.selectUserProfile(userNo);
		
		sqlSession.close();
		
		return profileList;
	}

	public UserProfileDTO selectUserProfileByNo(int userProfileNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		userProfileMapper = sqlSession.getMapper(UserProfileMapper.class);
		
		UserProfileDTO profileList = userProfileMapper.selectUserProfileByNo(userProfileNo);
		
		sqlSession.close();
		
		return profileList;

	}

	public int insertUserProfile(UserProfileDTO userProfile, UserPhotoDTO userphoto, List<UserAddFileDTO> userAddFileList) {
		
		SqlSession sqlSession = getSqlSession();
		userProfileMapper = sqlSession.getMapper(UserProfileMapper.class);
		
		int result = 0;
		
		/* 프로필 insert */
		int profileResult = userProfileMapper.insertUserProfile(userProfile);
		
		/* insert한 프로필번호 select */
		int profileNo = userProfileMapper.selectUserProfileNoLastSequence();
		userphoto.setUserProfileNo(profileNo);
		
		/* 프로필 사진 insert */
		int photoResult = userProfileMapper.insertUserPhoto(userphoto);
		
		/* 프로필 번호를 담아줌 */
		int addFileResult = 0;
		for(UserAddFileDTO list : userAddFileList) {
			list.setUserProfileNo(profileNo);
			System.out.println(list + " sasdfasfd");
			int addresult = userProfileMapper.insertUserAddFile(list);
			if(addresult == 1) {
				addFileResult++;
			}
		}
		
		if(profileResult > 0 && photoResult > 0 && addFileResult == userAddFileList.size()) {
			sqlSession.commit();
			result = 1;
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public UserProfileDTO selectUserProfileByProfileNo(int userProfileNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		userProfileMapper = sqlSession.getMapper(UserProfileMapper.class);
		
		UserProfileDTO userPrifile = userProfileMapper.selectUserProfileByProfileNo(userProfileNo);
		
		sqlSession.close();
		
		return userPrifile;
	}

	public int updateUserProfile(UserProfileDTO userProfile, UserPhotoDTO userphoto) {
		

		SqlSession sqlSession = getSqlSession();
		userProfileMapper = sqlSession.getMapper(UserProfileMapper.class);
		
		int result = 0;
		/* 프로필 정보 업데이트 */
		int profileResult = userProfileMapper.updateUserProfile(userProfile);
		
		
		int profileNo = userProfile.getUserProfileNo();
		userphoto.setUserProfileNo(profileNo);
		
		int photoResult = userProfileMapper.updateUserPhoto(userphoto);
		
		
		if(profileResult > 0 && photoResult > 0) {
			sqlSession.commit();
			result = 1;
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public List<UserAddFileDTO> selectUserAddFileByProfileNo(int userProfileNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		userProfileMapper = sqlSession.getMapper(UserProfileMapper.class);
		
		List<UserAddFileDTO> userAddFile = userProfileMapper.selectUserAddFileByProfileNo(userProfileNo);
		
		sqlSession.close();
		
		return userAddFile;
		
	}

	public UserAddFileDTO selectUserAddFileByFileNo(int userFileNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		userProfileMapper = sqlSession.getMapper(UserProfileMapper.class);
		
		UserAddFileDTO userAddFile = userProfileMapper.selectUserAddFileByFileNo(userFileNo);
		
		sqlSession.close();
		
		return userAddFile;
	}

	/* 프로필, 첨부파일, 사진 delete */
	public int deleteUserProfile(int userProfileNo) {
		
		SqlSession sqlSession = getSqlSession();
		userProfileMapper = sqlSession.getMapper(UserProfileMapper.class);
		int result = 0;
		
		int fileResult = userProfileMapper.deleteUserAddFile(userProfileNo);
		int photoResult = userProfileMapper.deleteUserPhoto(userProfileNo);
		int profileResult = userProfileMapper.deleteUserProfile(userProfileNo);
		
		if(fileResult >=0 && photoResult > 0 && profileResult >0) {
			result = 1;
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	/* 프로필의 모든 파일의 savedName select*/
	public List<UserAddFileDTO> selectUserAddFileSavedName(int userProfileNo) {
		SqlSession sqlSession = getSqlSession();
		
		userProfileMapper = sqlSession.getMapper(UserProfileMapper.class);
		
		List<UserAddFileDTO> userAddFile = userProfileMapper.selectUserAddFileSavedName(userProfileNo);
		
		sqlSession.close();
		
		return userAddFile;
	}

	public UserPhotoDTO selectUserPhotoByUserProfileNo(int userProfileNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		userProfileMapper = sqlSession.getMapper(UserProfileMapper.class);
		
		UserPhotoDTO userPhoto = userProfileMapper.selectUserPhotoByUserProfileNo(userProfileNo);
		
		sqlSession.close();
		
		return userPhoto;

	}


	/* 프로필, 프로필사진, 추가한 첨부파일 insert, 삭제한 기존 첨부파일 delete */
	public int updateUserProfile(UserProfileDTO userProfile, UserPhotoDTO userphoto,
		List<UserAddFileDTO> userAddFileList, List<UserAddFileDTO> deleteFileList) {
		
		SqlSession sqlSession = getSqlSession();
		userProfileMapper = sqlSession.getMapper(UserProfileMapper.class);
		
		int result = 0;
		
		/* 프로필 update */
		int profileResult = userProfileMapper.updateUserProfileByUserProfileInfo(userProfile);
		System.out.println("profileResult: " + profileResult);
		
		int photoResult = 0;
		if(userphoto.getUserPhotoSavedPath() != null) {
			/* 프로필 사진 insert */
			int pResult = userProfileMapper.updateUserPhotoByUserProfileInfo(userphoto);
			System.out.println("photoResult: " + photoResult);
			if(pResult == 1) {
				photoResult++;
				result ++;
			}
		}
		
		int addFileResult = 0;
		if(!userAddFileList.isEmpty()) {
			/* 포트폴리오 insert */
			for(UserAddFileDTO list : userAddFileList) {
				int addresult = userProfileMapper.updateAddFileByUserProfileInfo(list);
				if(addresult == 1) {
					addFileResult++;
					result++;
				}
			}
		} 
		
		System.out.println("addFileResult: " + addFileResult);
		
		int deleteFileResult = 0;
		if(!deleteFileList.isEmpty()) {
			/* 삭제된 파일 delete */
			for(UserAddFileDTO list : deleteFileList) {
				int deleteResult = userProfileMapper.updatedeleteFile(list);
				if(deleteResult == 1) {
					deleteFileResult++;
					result++;
				}
			}
		}
		System.out.println("deleteFileResult: " + deleteFileResult);
		
		if(result == (photoResult + addFileResult + deleteFileResult) && profileResult == 1) {
			sqlSession.commit();
			result = 1;
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public UserAddFileDTO selectDeleteFile(UserAddFileDTO list) {
		
		SqlSession sqlSession = getSqlSession();
		
		userProfileMapper = sqlSession.getMapper(UserProfileMapper.class);
		
		UserAddFileDTO userDeleteFile = userProfileMapper.selectDeleteFile(list);
		
		sqlSession.close();
		
		return userDeleteFile;
		
	}

	/* 프로필 수정 시 프로필 사진 수정되면 기존 사진 삭제하기 위한 사진 정보 select */
	public UserProfileDTO selectDeleteBeforePhoto(int profileNo) {
		
		SqlSession sqlSession = getSqlSession();
		
		userProfileMapper = sqlSession.getMapper(UserProfileMapper.class);
		
		UserProfileDTO result = userProfileMapper.selectDeleteBeforePhoto(profileNo);
		
		sqlSession.close();
		
		return result;
	}


}
