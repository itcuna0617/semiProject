package posting.model.dto;

import java.sql.Date;
import java.util.List;

import user.model.dto.UserInfoDTO;

public class UserProfileDTO {
	
	private int userProfileNo;
	private String userName;
	private String userPhoto;
	private Date userBirth;
	private String userArea;
	private String userMiniTitle;
	private String userMainText;
	private String userResume;
	private String userOpenYN;
	private int userNo;
	private int jobNo;
	private String userId;
	private String userSactionYN;
	private String userActiveYN;
	
	
	
	
	public UserProfileDTO() {
	}




	public UserProfileDTO(int userProfileNo, String userName, String userPhoto, Date userBirth, String userArea,
			String userMiniTitle, String userMainText, String userResume, String userOpenYN, int userNo, int jobNo,
			String userId, String userSactionYN, String userActiveYN) {
		this.userProfileNo = userProfileNo;
		this.userName = userName;
		this.userPhoto = userPhoto;
		this.userBirth = userBirth;
		this.userArea = userArea;
		this.userMiniTitle = userMiniTitle;
		this.userMainText = userMainText;
		this.userResume = userResume;
		this.userOpenYN = userOpenYN;
		this.userNo = userNo;
		this.jobNo = jobNo;
		this.userId = userId;
		this.userSactionYN = userSactionYN;
		this.userActiveYN = userActiveYN;
	}




	public int getUserProfileNo() {
		return userProfileNo;
	}




	public void setUserProfileNo(int userProfileNo) {
		this.userProfileNo = userProfileNo;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getUserPhoto() {
		return userPhoto;
	}




	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}




	public Date getUserBirth() {
		return userBirth;
	}




	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}




	public String getUserArea() {
		return userArea;
	}




	public void setUserArea(String userArea) {
		this.userArea = userArea;
	}




	public String getUserMiniTitle() {
		return userMiniTitle;
	}




	public void setUserMiniTitle(String userMiniTitle) {
		this.userMiniTitle = userMiniTitle;
	}




	public String getUserMainText() {
		return userMainText;
	}




	public void setUserMainText(String userMainText) {
		this.userMainText = userMainText;
	}




	public String getUserResume() {
		return userResume;
	}




	public void setUserResume(String userResume) {
		this.userResume = userResume;
	}




	public String getUserOpenYN() {
		return userOpenYN;
	}




	public void setUserOpenYN(String userOpenYN) {
		this.userOpenYN = userOpenYN;
	}




	public int getUserNo() {
		return userNo;
	}




	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}




	public int getJobNo() {
		return jobNo;
	}




	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}




	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}




	public String getUserSactionYN() {
		return userSactionYN;
	}




	public void setUserSactionYN(String userSactionYN) {
		this.userSactionYN = userSactionYN;
	}




	public String getUserActiveYN() {
		return userActiveYN;
	}




	public void setUserActiveYN(String userActiveYN) {
		this.userActiveYN = userActiveYN;
	}




	@Override
	public String toString() {
		return "UserProfileDTO [userProfileNo=" + userProfileNo + ", userName=" + userName + ", userPhoto=" + userPhoto
				+ ", userBirth=" + userBirth + ", userArea=" + userArea + ", userMiniTitle=" + userMiniTitle
				+ ", userMainText=" + userMainText + ", userResume=" + userResume + ", userOpenYN=" + userOpenYN
				+ ", userNo=" + userNo + ", jobNo=" + jobNo + ", userId=" + userId + ", userSactionYN=" + userSactionYN
				+ ", userActiveYN=" + userActiveYN + ", getUserProfileNo()=" + getUserProfileNo() + ", getUserName()="
				+ getUserName() + ", getUserPhoto()=" + getUserPhoto() + ", getUserBirth()=" + getUserBirth()
				+ ", getUserArea()=" + getUserArea() + ", getUserMiniTitle()=" + getUserMiniTitle()
				+ ", getUserMainText()=" + getUserMainText() + ", getUserResume()=" + getUserResume()
				+ ", getUserOpenYN()=" + getUserOpenYN() + ", getUserNo()=" + getUserNo() + ", getJobNo()=" + getJobNo()
				+ ", getUserId()=" + getUserId() + ", getUserSactionYN()=" + getUserSactionYN() + ", getUserActiveYN()="
				+ getUserActiveYN() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	

}
