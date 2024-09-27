package user.mapper;

import user.model.dto.UserInfoDTO;

public interface UserInfoMapper {

	UserInfoDTO selectUserInfo(int userNo);

	int userInfoUpdate(UserInfoDTO userInfoDTO);

	String selectEncryptedPwd(UserInfoDTO userInfo);
	
	int userInfoDelete(UserInfoDTO userInfo);

	int userInfoPasswordUpdate(UserInfoDTO userInfo);

	String selectUserInfoPasswordUpdate(int userNo);


}
