package customerCenter.model.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class QuestionDTO implements Serializable {
	private static final long serialVersionUID = 2665419146033934123L;
	
	private int queNo;
	private String queTitle;
	private String queContent;
	private Date queDate;
	private int categoryNo;
	private Integer userNo;
	private Integer entNo;
	private String ansYN;
	
	public QuestionDTO() {
	}

	public QuestionDTO(int queNo, String queTitle, String queContent, Date queDate, int categoryNo, Integer userNo,
			Integer entNo, String ansYN) {
		this.queNo = queNo;
		this.queTitle = queTitle;
		this.queContent = queContent;
		this.queDate = queDate;
		this.categoryNo = categoryNo;
		this.userNo = userNo;
		this.entNo = entNo;
		this.ansYN = ansYN;
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
		return "QuestionDTO [queNo=" + queNo + ", queTitle=" + queTitle + ", queContent=" + queContent + ", queDate="
				+ queDate + ", categoryNo=" + categoryNo + ", userNo=" + userNo + ", entNo=" + entNo + ", ansYN="
				+ ansYN + ", getQueNo()=" + getQueNo() + ", getQueTitle()=" + getQueTitle() + ", getQueContent()="
				+ getQueContent() + ", getQueDate()=" + getQueDate() + ", getCategoryNo()=" + getCategoryNo()
				+ ", getUserNo()=" + getUserNo() + ", getEntNo()=" + getEntNo() + ", getAnsYN()=" + getAnsYN()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
	
	
	
	
}
