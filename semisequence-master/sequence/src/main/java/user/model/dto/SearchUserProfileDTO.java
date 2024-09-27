package user.model.dto;

import java.io.Serializable;
import java.util.Date;

import member.model.dto.MemberDTO;

public class SearchUserProfileDTO implements Serializable{

	private static final long serialVersionUID = -2477871008429364440L;

	private int userProfileNo;
	private String userName;
	private java.util.Date userBirth;
	private String userArea;
	private String userMiniTitle;
	private String userMainText;
	private String userResume;
	private String userOpenYN;
	private JobDTO job;
	private int jobNo;
	private String jobName;
	private UserPhotoDTO userPhoto;
	private int userPhotoNo;
	private String userPhotoSavedName;
	private String userPhotoSavedPath;
	private MemberDTO user;
	private int userNo;
	private String userPhone;
	private String userEmail;
	
	public SearchUserProfileDTO() {
	}

	public SearchUserProfileDTO(int userProfileNo, String userName, Date userBirth, String userArea,
			String userMiniTitle, String userMainText, String userResume, String userOpenYN, JobDTO job, int jobNo,
			String jobName, UserPhotoDTO userPhoto, int userPhotoNo, String userPhotoSavedName,
			String userPhotoSavedPath, MemberDTO user, int userNo, String userPhone, String userEmail) {
		this.userProfileNo = userProfileNo;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userArea = userArea;
		this.userMiniTitle = userMiniTitle;
		this.userMainText = userMainText;
		this.userResume = userResume;
		this.userOpenYN = userOpenYN;
		this.job = job;
		this.jobNo = jobNo;
		this.jobName = jobName;
		this.userPhoto = userPhoto;
		this.userPhotoNo = userPhotoNo;
		this.userPhotoSavedName = userPhotoSavedName;
		this.userPhotoSavedPath = userPhotoSavedPath;
		this.user = user;
		this.userNo = userNo;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
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

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public UserPhotoDTO getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(UserPhotoDTO userPhoto) {
		this.userPhoto = userPhoto;
	}

	public int getUserPhotoNo() {
		return userPhotoNo;
	}

	public void setUserPhotoNo(int userPhotoNo) {
		this.userPhotoNo = userPhotoNo;
	}

	public String getUserPhotoSavedName() {
		return userPhotoSavedName;
	}

	public void setUserPhotoSavedName(String userPhotoSavedName) {
		this.userPhotoSavedName = userPhotoSavedName;
	}

	public String getUserPhotoSavedPath() {
		return userPhotoSavedPath;
	}

	public void setUserPhotoSavedPath(String userPhotoSavedPath) {
		this.userPhotoSavedPath = userPhotoSavedPath;
	}

	public MemberDTO getUser() {
		return user;
	}

	public void setUser(MemberDTO user) {
		this.user = user;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SearchUserProfileDTO [userProfileNo=" + userProfileNo + ", userName=" + userName + ", userBirth="
				+ userBirth + ", userArea=" + userArea + ", userMiniTitle=" + userMiniTitle + ", userMainText="
				+ userMainText + ", userResume=" + userResume + ", userOpenYN=" + userOpenYN + ", job=" + job
				+ ", jobNo=" + jobNo + ", jobName=" + jobName + ", userPhoto=" + userPhoto + ", userPhotoNo="
				+ userPhotoNo + ", userPhotoSavedName=" + userPhotoSavedName + ", userPhotoSavedPath="
				+ userPhotoSavedPath + ", user=" + user + ", userNo=" + userNo + ", userPhone=" + userPhone
				+ ", userEmail=" + userEmail + "]";
	}
}
