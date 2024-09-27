package customerCenter.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class AnswerDTO implements Serializable{
	private static final long serialVersionUID = 2382060274199550831L;

	private int ansNo;
	private String ansTitle;
	private String ansContent;
	private Date ansDate;
	private String adminId;
	private int queNo;
	
	
	
	public AnswerDTO() {
	}

	public AnswerDTO(int ansNo, String ansTitle, String ansContent, Date ansDate, String adminDate, int queNo) {
		this.ansNo = ansNo;
		this.ansTitle = ansTitle;
		this.ansContent = ansContent;
		this.ansDate = ansDate;
		this.adminId = adminDate;
		this.queNo = queNo;
	}

	public int getAnsNo() {
		return ansNo;
	}

	public void setAnsNo(int ansNo) {
		this.ansNo = ansNo;
	}

	public String getAnsTitle() {
		return ansTitle;
	}

	public void setAnsTitle(String ansTitle) {
		this.ansTitle = ansTitle;
	}

	public String getAnsContent() {
		return ansContent;
	}

	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}

	public Date getAnsDate() {
		return ansDate;
	}

	public void setAnsDate(Date ansDate) {
		this.ansDate = ansDate;
	}

	public String getAdminDate() {
		return adminId;
	}

	public void setAdminDate(String adminDate) {
		this.adminId = adminDate;
	}

	public int getQueNo() {
		return queNo;
	}

	public void setQueNo(int queNo) {
		this.queNo = queNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AnswerDAO [ansNo=" + ansNo + ", ansTitle=" + ansTitle + ", ansContent=" + ansContent + ", ansDate="
				+ ansDate + ", adminDate=" + adminId + ", queNo=" + queNo + ", getAnsNo()=" + getAnsNo()
				+ ", getAnsTitle()=" + getAnsTitle() + ", getAnsContent()=" + getAnsContent() + ", getAnsDate()="
				+ getAnsDate() + ", getAdminDate()=" + getAdminDate() + ", getQueNo()=" + getQueNo() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
