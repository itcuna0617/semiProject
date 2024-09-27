package admin.notice.model.DTO;

import java.io.Serializable;
import java.sql.Date;

public class NoticeDTO implements Serializable{

	private static final long serialVersionUID = 1553882247455477800L;
	private int noticeNo;
	private String noticeTitle;
	private String noticeActiveYN;
	private String noticeContent;
	private java.sql.Date noticeDate;
	private String adminId;
	
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "NoticeDTO [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeActiveYN=" + noticeActiveYN
				+ ", noticeContent=" + noticeContent + ", noticeDate=" + noticeDate + "]";
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
	public String getNoticeActiveYN() {
		return noticeActiveYN;
	}
	public void setNoticeActiveYN(String noticeActiveYN) {
		this.noticeActiveYN = noticeActiveYN;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public java.sql.Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(java.sql.Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public NoticeDTO(int noticeNo, String noticeTitle, String noticeActiveYN, String noticeContent, Date noticeDate,
			String adminId) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeActiveYN = noticeActiveYN;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.adminId = adminId;
	}
	public NoticeDTO() {
		super();
	}
	
	
}
