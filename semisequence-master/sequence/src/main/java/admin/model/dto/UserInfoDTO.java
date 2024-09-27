package admin.model.dto;

import java.io.Serializable;

public class UserInfoDTO implements Serializable{

	private static final long serialVersionUID = -4026696394663099694L;
	
	private int userNo;
	private String userName;
	private String UserId;
	private String UserPassword;
	private String UserAddress;
	private String UserPhone;
	private String UserEmail;
	private int UserBalnce;
	private int UserAvgScore;
	private String UserDropYn;
	private String UserSanctionYn;
	private String UserActiveYn;
	private String UserClassName;
	
	public UserInfoDTO() {
	}

	public UserInfoDTO(int userNo, String userName, String userId, String userPassword, String userAddress,
			String userPhone, String userEmail, int userBalnce, int userAvgScore, String userDropYn,
			String userSanctionYn, String userActiveYn, String userClassName) {
		this.userNo = userNo;
		this.userName = userName;
		UserId = userId;
		UserPassword = userPassword;
		UserAddress = userAddress;
		UserPhone = userPhone;
		UserEmail = userEmail;
		UserBalnce = userBalnce;
		UserAvgScore = userAvgScore;
		UserDropYn = userDropYn;
		UserSanctionYn = userSanctionYn;
		UserActiveYn = userActiveYn;
		UserClassName = userClassName;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getUserPassword() {
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}

	public String getUserAddress() {
		return UserAddress;
	}

	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}

	public String getUserPhone() {
		return UserPhone;
	}

	public void setUserPhone(String userPhone) {
		UserPhone = userPhone;
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}

	public int getUserBalnce() {
		return UserBalnce;
	}

	public void setUserBalnce(int userBalnce) {
		UserBalnce = userBalnce;
	}

	public int getUserAvgScore() {
		return UserAvgScore;
	}

	public void setUserAvgScore(int userAvgScore) {
		UserAvgScore = userAvgScore;
	}

	public String getUserDropYn() {
		return UserDropYn;
	}

	public void setUserDropYn(String userDropYn) {
		UserDropYn = userDropYn;
	}

	public String getUserSanctionYn() {
		return UserSanctionYn;
	}

	public void setUserSanctionYn(String userSanctionYn) {
		UserSanctionYn = userSanctionYn;
	}

	public String getUserActiveYn() {
		return UserActiveYn;
	}

	public void setUserActiveYn(String userActiveYn) {
		UserActiveYn = userActiveYn;
	}

	public String getUserClassName() {
		return UserClassName;
	}

	public void setUserClassName(String userClassName) {
		UserClassName = userClassName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserInfoDTO [userNo=" + userNo + ", userName=" + userName + ", UserId=" + UserId + ", UserPassword="
				+ UserPassword + ", UserAddress=" + UserAddress + ", UserPhone=" + UserPhone + ", UserEmail="
				+ UserEmail + ", UserBalnce=" + UserBalnce + ", UserAvgScore=" + UserAvgScore + ", UserDropYn="
				+ UserDropYn + ", UserSanctionYn=" + UserSanctionYn + ", UserActiveYn=" + UserActiveYn
				+ ", UserClassName=" + UserClassName + "]";
	}
	
}
