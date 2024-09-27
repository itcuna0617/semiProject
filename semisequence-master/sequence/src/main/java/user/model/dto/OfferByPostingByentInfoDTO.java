package user.model.dto;

import java.util.Date;

/* 개인회원 영입제의내역 관련 DTO */
public class OfferByPostingByentInfoDTO {
	
	private int offerNo;
	private String offerConnectYn;
	private java.util.Date offerDate;
	private int userNo;
	private int postingNo;
	private String postingTitle;		// 공고제목
	private String entName;				// 기업명

	public OfferByPostingByentInfoDTO() {
		super();
	}

	public OfferByPostingByentInfoDTO(int offerNo, String offerConnectYn, Date offerDate, int userNo, int postingNo,
			String postingTitle, String entName) {
		super();
		this.offerNo = offerNo;
		this.offerConnectYn = offerConnectYn;
		this.offerDate = offerDate;
		this.userNo = userNo;
		this.postingNo = postingNo;
		this.postingTitle = postingTitle;
		this.entName = entName;
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

	public String getPostingTitle() {
		return postingTitle;
	}

	public void setPostingTitle(String postingTitle) {
		this.postingTitle = postingTitle;
	}

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	@Override
	public String toString() {
		return "OfferByPostingByentInfoDTO [offerNo=" + offerNo + ", offerConnectYn=" + offerConnectYn + ", offerDate="
				+ offerDate + ", userNo=" + userNo + ", postingNo=" + postingNo + ", postingTitle=" + postingTitle
				+ ", entName=" + entName + "]";
	}
	
}
