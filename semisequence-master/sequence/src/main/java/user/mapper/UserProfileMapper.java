package user.mapper;

import java.util.List;

import user.model.dto.UserAddFileDTO;
import user.model.dto.UserPhotoDTO;
import user.model.dto.UserProfileDTO;

public interface UserProfileMapper {

	List<UserProfileDTO> selectUserProfile(int userNo);

	UserProfileDTO selectUserProfileByNo(int userProfileNo);

	int insertUserProfile(UserProfileDTO userProfile);

	int insertUserPhoto(UserPhotoDTO userphoto);

	int selectUserProfileNoLastSequence();

	UserProfileDTO selectUserProfileByProfileNo(int userProfileNo);

	int updateUserProfile(UserProfileDTO userProfile);

	int updateUserPhoto(UserPhotoDTO userphoto);

	int insertUserAddFile(UserAddFileDTO list);

	List<UserAddFileDTO> selectUserAddFileByProfileNo(int userProfileNo);

	UserAddFileDTO selectUserAddFileByFileNo(int userFileNo);

	int deleteUserAddFile(int userProfileNo);

	int deleteUserPhoto(int userProfileNo);

	int deleteUserProfile(int userProfileNo);

	List<UserAddFileDTO> selectUserAddFileSavedName(int userProfileNo);

	UserPhotoDTO selectUserPhotoByUserProfileNo(int userProfileNo);

	int updateUserProfileByUserProfileInfo(UserProfileDTO userProfile);

	int updateUserPhotoByUserProfileInfo(UserPhotoDTO userphoto);

	int updateAddFileByUserProfileInfo(UserAddFileDTO list);

	int updatedeleteFile(UserAddFileDTO list);

	UserAddFileDTO selectDeleteFile(UserAddFileDTO list);

	UserProfileDTO selectDeleteBeforePhoto(int profileNo);


}
