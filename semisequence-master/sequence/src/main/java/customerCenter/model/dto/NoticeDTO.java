package customerCenter.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class NoticeDTO implements Serializable {
	private static final long serialVersionUID = -6709959443797880002L;
	
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private String noticeActiveYN;
	private String adminId;
	private Date noticeDate;
	
	
	
	public NoticeDTO() {
	}

	public NoticeDTO(int noticeNo, String noticeTitle, String noticeContent, String noticeActiveYN, String adminId,
			Date noticeDate) {
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeActiveYN = noticeActiveYN;
		this.adminId = adminId;
		this.noticeDate = noticeDate;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeActiveYN() {
		return noticeActiveYN;
	}

	public void setNoticeActiveYN(String noticeActiveYN) {
		this.noticeActiveYN = noticeActiveYN;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "NoticeDTO [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", noticeActiveYN=" + noticeActiveYN + ", adminId=" + adminId + ", noticeDate=" + noticeDate
				+ ", getNoticeNo()=" + getNoticeNo() + ", getNoticeTitle()=" + getNoticeTitle()
				+ ", getNoticeContent()=" + getNoticeContent() + ", getNoticeActiveYN()=" + getNoticeActiveYN()
				+ ", getAdminId()=" + getAdminId() + ", getNoticeDate()=" + getNoticeDate() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
