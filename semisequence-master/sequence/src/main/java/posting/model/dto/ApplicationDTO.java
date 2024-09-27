package posting.model.dto;

import java.sql.Date;

public class ApplicationDTO {
	
	private int ApplicationNo;
	private String ApplicationConnectYN;
	private Date ApplicationDate;
	private String ApplicationIntro;
	private int userNo;
	private int postingNo;
	private int userProfileNo;
	
	
	
	public ApplicationDTO() {
	}

	public ApplicationDTO(int applicationNo, String applicationConnectYN, Date applicationDate, String applicationIntro,
			int userNo, int postingNo, int userProfileNo) {
		ApplicationNo = applicationNo;
		ApplicationConnectYN = applicationConnectYN;
		ApplicationDate = applicationDate;
		ApplicationIntro = applicationIntro;
		this.userNo = userNo;
		this.postingNo = postingNo;
		this.userProfileNo = userProfileNo;
	}

	public int getApplicationNo() {
		return ApplicationNo;
	}

	public void setApplicationNo(int applicationNo) {
		ApplicationNo = applicationNo;
	}

	public String getApplicationConnectYN() {
		return ApplicationConnectYN;
	}

	public void setApplicationConnectYN(String applicationConnectYN) {
		ApplicationConnectYN = applicationConnectYN;
	}

	public Date getApplicationDate() {
		return ApplicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		ApplicationDate = applicationDate;
	}

	public String getApplicationIntro() {
		return ApplicationIntro;
	}

	public void setApplicationIntro(String applicationIntro) {
		ApplicationIntro = applicationIntro;
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
		return "ApplicationDTO [ApplicationNo=" + ApplicationNo + ", ApplicationConnectYN=" + ApplicationConnectYN
				+ ", ApplicationDate=" + ApplicationDate + ", ApplicationIntro=" + ApplicationIntro + ", userNo="
				+ userNo + ", postingNo=" + postingNo + ", userProfileNo=" + userProfileNo + ", getApplicationNo()="
				+ getApplicationNo() + ", getApplicationConnectYN()=" + getApplicationConnectYN()
				+ ", getApplicationDate()=" + getApplicationDate() + ", getApplicationIntro()=" + getApplicationIntro()
				+ ", getUserNo()=" + getUserNo() + ", getPostingNo()=" + getPostingNo() + ", getUserProfileNo()="
				+ getUserProfileNo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
