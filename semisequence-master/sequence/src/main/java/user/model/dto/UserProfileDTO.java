package user.model.dto;

import java.util.Date;

public class UserProfileDTO {
	
	private int userProfileNo;
	private String userName;
	private String userPhoto;
	private java.util.Date userBirth;
	private String userArea;
	private String userMiniTitle;
	private String userMainText;
	private String userResume;
	private String userOpenYN;
	private int userNo;
	private JobDTO job;
	private int jobNo;
	
	public UserProfileDTO() {
	}
	public UserProfileDTO(int userProfileNo, String userName, String userPhoto, Date userBirth, String userArea,
			String userMiniTitle, String userMainText, String userResume, String userOpenYN, int userNo, JobDTO job,
			int jobNo) {
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
		this.job = job;
		this.jobNo = jobNo;
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
	public java.util.Date getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(java.util.Date userBirth) {
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
	public JobDTO getJob() {
		return job;
	}
	public void setJob(JobDTO job) {
		this.job = job;
	}
	public int getJobNo() {
		return jobNo;
	}
	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}
	@Override
	public String toString() {
		return "UserProfileDTO [userProfileNo=" + userProfileNo + ", userName=" + userName + ", userPhoto=" + userPhoto
				+ ", userBirth=" + userBirth + ", userArea=" + userArea + ", userMiniTitle=" + userMiniTitle
				+ ", userMainText=" + userMainText + ", userResume=" + userResume + ", userOpenYN=" + userOpenYN
				+ ", userNo=" + userNo + ", job=" + job + ", jobNo=" + jobNo + "]";
	}
	
	
}
