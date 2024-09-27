package user.model.dto;

import java.util.Date;

public class UserApplicationHistoryDTO {
	
	private int applicationNo;
	private String applicationConnectYn;
	private java.util.Date applicationDate;
	private String applicationIntro;
	private int userNo;
	private int postingNo;
	private int userProfileNo;
	
	public UserApplicationHistoryDTO() {
		super();
	}
	public UserApplicationHistoryDTO(int applicationNo, String applicationConnectYn, Date applicationDate,
			String applicationIntro, int userNo, int postingNo, int userProfileNo) {
		super();
		this.applicationNo = applicationNo;
		this.applicationConnectYn = applicationConnectYn;
		this.applicationDate = applicationDate;
		this.applicationIntro = applicationIntro;
		this.userNo = userNo;
		this.postingNo = postingNo;
		this.userProfileNo = userProfileNo;
	}
	public int getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(int applicationNo) {
		this.applicationNo = applicationNo;
	}
	public String getApplicationConnectYn() {
		return applicationConnectYn;
	}
	public void setApplicationConnectYn(String applicationConnectYn) {
		this.applicationConnectYn = applicationConnectYn;
	}
	public java.util.Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(java.util.Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getApplicationIntro() {
		return applicationIntro;
	}
	public void setApplicationIntro(String applicationIntro) {
		this.applicationIntro = applicationIntro;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getPostingNo() {
		return postingNo;
	}
	public void setPostingNo(int postingNo) {
		this.postingNo = postingNo;
	}
	public int getUserProfileNo() {
		return userProfileNo;
	}
	public void setUserProfileNo(int userProfileNo) {
		this.userProfileNo = userProfileNo;
	}
	@Override
	public String toString() {
		return "UserApplicationHistoryDTO [applicationNo=" + applicationNo + ", applicationConnectYn="
				+ applicationConnectYn + ", applicationDate=" + applicationDate + ", applicationIntro="
				+ applicationIntro + ", userNo=" + userNo + ", postingNo=" + postingNo + ", userProfileNo="
				+ userProfileNo + "]";
	}
	
}
