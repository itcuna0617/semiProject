package project.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class ProjectDTO implements Serializable{
	private static final long serialVersionUID = 5278574008405922586L;
	
	private int projectNo;
	private String projectName;
	private String projectContent;
	private java.sql.Date projectStartDate;
	private java.sql.Date projectEndDate;
	private String projectActiveYN;
	private String managerName;
	private String managerPhone;
	private String managerEmail;
	private int entNo;
	private int genreNo;
	@Override
	public String toString() {
		return "ProjectDTO [projectNo=" + projectNo + ", projectName=" + projectName + ", projectContent="
				+ projectContent + ", projectStartDate=" + projectStartDate + ", projectEndDate=" + projectEndDate
				+ ", projectActiveYN=" + projectActiveYN + ", managerName=" + managerName + ", managerPhone="
				+ managerPhone + ", managerEmail=" + managerEmail + ", entNo=" + entNo + ", genreNo=" + genreNo + "]";
	}
	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectContent() {
		return projectContent;
	}
	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}
	public java.sql.Date getProjectStartDate() {
		return projectStartDate;
	}
	public void setProjectStartDate(java.sql.Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	public java.sql.Date getProjectEndDate() {
		return projectEndDate;
	}
	public void setProjectEndDate(java.sql.Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	public String getProjectActiveYN() {
		return projectActiveYN;
	}
	public void setProjectActiveYN(String projectActiveYN) {
		this.projectActiveYN = projectActiveYN;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPhone() {
		return managerPhone;
	}
	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	public int getEntNo() {
		return entNo;
	}
	public void setEntNo(int entNo) {
		this.entNo = entNo;
	}
	public int getGenreNo() {
		return genreNo;
	}
	public void setGenreNo(int genreNo) {
		this.genreNo = genreNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ProjectDTO() {
		super();
	}
	public ProjectDTO(int projectNo, String projectName, String projectContent, Date projectStartDate,
			Date projectEndDate, String projectActiveYN, String managerName, String managerPhone, String managerEmail,
			int entNo, int genreNo) {
		super();
		this.projectNo = projectNo;
		this.projectName = projectName;
		this.projectContent = projectContent;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.projectActiveYN = projectActiveYN;
		this.managerName = managerName;
		this.managerPhone = managerPhone;
		this.managerEmail = managerEmail;
		this.entNo = entNo;
		this.genreNo = genreNo;
	}
	
}
