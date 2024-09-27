package admin.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class QuestionAndAnswerAndFileDTO implements Serializable {
	private static final long serialVersionUID = -6754173839532471393L;
	
	
	private int queNo;
	private String queTitle;
	private String queContent;
	private Date queDate;
	private String ansYN;
	private int categoryNo;
	private int userNo;
	private int entNo;
	private int ansNo;	
	private String ansTitle;
	private String ansContent;
	private Date ansDate;
	private String adminId;
	private String queFileName;
	private String queFileSavedPath;
	private String userId;
	private String entId;
	
	
	
	public QuestionAndAnswerAndFileDTO() {
	}



	public QuestionAndAnswerAndFileDTO(int queNo, String queTitle, String queContent, Date queDate, String ansYN,
			int categoryNo, int userNo, int entNo, int ansNo, String ansTitle, String ansContent, Date ansDate,
			String adminId, String queFileName, String queFileSavedPath, String userId, String entId) {
		this.queNo = queNo;
		this.queTitle = queTitle;
		this.queContent = queContent;
		this.queDate = queDate;
		this.ansYN = ansYN;
		this.categoryNo = categoryNo;
		this.userNo = userNo;
		this.entNo = entNo;
		this.ansNo = ansNo;
		this.ansTitle = ansTitle;
		this.ansContent = ansContent;
		this.ansDate = ansDate;
		this.adminId = adminId;
		this.queFileName = queFileName;
		this.queFileSavedPath = queFileSavedPath;
		this.userId = userId;
		this.entId = entId;
	}



	public int getQueNo() {
		return queNo;
	}



	public void setQueNo(int queNo) {
		this.queNo = queNo;
	}



	public String getQueTitle() {
		return queTitle;
	}



	public void setQueTitle(String queTitle) {
		this.queTitle = queTitle;
	}



	public String getQueContent() {
		return queContent;
	}



	public void setQueContent(String queContent) {
		this.queContent = queContent;
	}



	public Date getQueDate() {
		return queDate;
	}



	public void setQueDate(Date queDate) {
		this.queDate = queDate;
	}



	public String getAnsYN() {
		return ansYN;
	}



	public void setAnsYN(String ansYN) {
		this.ansYN = ansYN;
	}



	public int getCategoryNo() {
		return categoryNo;
	}



	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}



	public int getUserNo() {
		return userNo;
	}



	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}



	public int getEntNo() {
		return entNo;
	}



	public void setEntNo(int entNo) {
		this.entNo = entNo;
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



	public String getAdminId() {
		return adminId;
	}



	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}



	public String getQueFileName() {
		return queFileName;
	}



	public void setQueFileName(String queFileName) {
		this.queFileName = queFileName;
	}



	public String getQueFileSavedPath() {
		return queFileSavedPath;
	}



	public void setQueFileSavedPath(String queFileSavedPath) {
		this.queFileSavedPath = queFileSavedPath;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getEntId() {
		return entId;
	}



	public void setEntId(String entId) {
		this.entId = entId;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "QuestionAndAnswerAndFileDTO [queNo=" + queNo + ", queTitle=" + queTitle + ", queContent=" + queContent
				+ ", queDate=" + queDate + ", ansYN=" + ansYN + ", categoryNo=" + categoryNo + ", userNo=" + userNo
				+ ", entNo=" + entNo + ", ansNo=" + ansNo + ", ansTitle=" + ansTitle + ", ansContent=" + ansContent
				+ ", ansDate=" + ansDate + ", adminId=" + adminId + ", queFileName=" + queFileName
				+ ", queFileSavedPath=" + queFileSavedPath + ", userId=" + userId + ", entId=" + entId + ", getQueNo()="
				+ getQueNo() + ", getQueTitle()=" + getQueTitle() + ", getQueContent()=" + getQueContent()
				+ ", getQueDate()=" + getQueDate() + ", getAnsYN()=" + getAnsYN() + ", getCategoryNo()="
				+ getCategoryNo() + ", getUserNo()=" + getUserNo() + ", getEntNo()=" + getEntNo() + ", getAnsNo()="
				+ getAnsNo() + ", getAnsTitle()=" + getAnsTitle() + ", getAnsContent()=" + getAnsContent()
				+ ", getAnsDate()=" + getAnsDate() + ", getAdminId()=" + getAdminId() + ", getQueFileName()="
				+ getQueFileName() + ", getQueFileSavedPath()=" + getQueFileSavedPath() + ", getUserId()=" + getUserId()
				+ ", getEntId()=" + getEntId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	
	
	
	
}
