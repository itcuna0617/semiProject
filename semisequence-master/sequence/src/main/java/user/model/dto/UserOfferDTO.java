package user.model.dto;

import java.util.Date;

public class UserOfferDTO {
	
	private int offerNo;
	private String offerConnectYn;
	private java.util.Date offerDate;
	private int userNo;
	private int postingNo;
	
	public UserOfferDTO() {
		super();
	}
	public UserOfferDTO(int offerNo, String offerConnectYn, Date offerDate, int userNo, int postingNo) {
		super();
		this.offerNo = offerNo;
		this.offerConnectYn = offerConnectYn;
		this.offerDate = offerDate;
		this.userNo = userNo;
		this.postingNo = postingNo;
	}
	public int getOfferNo() {
		return offerNo;
	}
	public void setOfferNo(int offerNo) {
		this.offerNo = offerNo;
	}
	public String getOfferConnectYn() {
		return offerConnectYn;
	}
	public void setOfferConnectYn(String offerConnectYn) {
		this.offerConnectYn = offerConnectYn;
	}
	public java.util.Date getOfferDate() {
		return offerDate;
	}
	public void setOfferDate(java.util.Date offerDate) {
		this.offerDate = offerDate;
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
	@Override
	public String toString() {
		return "UserOfferDTO [offerNo=" + offerNo + ", offerConnectYn=" + offerConnectYn + ", offerDate=" + offerDate
				+ ", userNo=" + userNo + ", postingNo=" + postingNo + "]";
	}
	
	
}
