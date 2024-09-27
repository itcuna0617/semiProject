package customerCenter.model.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class QuestionAndQuestionFileDTO implements Serializable {
	private static final long serialVersionUID = -7026498326087337554L;
	
	private Integer queNo;
	private String queTitle;
	private String queContent;
	private Date queDate;
	private int categoryNo;
	private Integer userNo;
	private Integer entNo;
	private String queFileName;
	private String queFileSavedPath;
	private String ansYN;
	
		
	public QuestionAndQuestionFileDTO() {
	}

	public QuestionAndQuestionFileDTO(Integer queNo, String queTitle, String queContent, Date queDate, int categoryNo,
			Integer userNo, Integer entNo, String queFileName, String queFileSavedPath, String ansYN) {
		this.queNo = queNo;
		this.queTitle = queTitle;
		this.queContent = queContent;
		this.queDate = queDate;
		this.categoryNo = categoryNo;
		this.userNo = userNo;
		this.entNo = entNo;
		this.queFileName = queFileName;
		this.queFileSavedPath = queFileSavedPath;
		this.ansYN = ansYN;
	}

	public Integer getQueNo() {
		return queNo;
	}

	public void setQueNo(Integer queNo) {
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

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public Integer getUserNo() {
		return userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	public Integer getEntNo() {
		return entNo;
	}

	public void setEntNo(Integer entNo) {
		this.entNo = entNo;
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

	public String getAnsYN() {
		return ansYN;
	}

	public void setAnsYN(String ansYN) {
		this.ansYN = ansYN;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "QuestionAndQuestionFileDTO [queNo=" + queNo + ", queTitle=" + queTitle + ", queContent=" + queContent
				+ ", queDate=" + queDate + ", categoryNo=" + categoryNo + ", userNo=" + userNo + ", entNo=" + entNo
				+ ", queFileName=" + queFileName + ", queFileSavedPath=" + queFileSavedPath + ", ansYN=" + ansYN
				+ ", getQueNo()=" + getQueNo() + ", getQueTitle()=" + getQueTitle() + ", getQueContent()="
				+ getQueContent() + ", getQueDate()=" + getQueDate() + ", getCategoryNo()=" + getCategoryNo()
				+ ", getUserNo()=" + getUserNo() + ", getEntNo()=" + getEntNo() + ", getQueFileName()="
				+ getQueFileName() + ", getQueFileSavedPath()=" + getQueFileSavedPath() + ", getAnsYN()=" + getAnsYN()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
