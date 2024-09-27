package posting.model.dto;

import java.sql.Date;

public class PostingAndProjectDTO {
	
	private int postingNo;
	private String postingTitle;
	private String postingDetail;
	private String postingOpenYN;
	private int views;
	private Date postingDate;
	private int projectNo;
	private int entNo;
	private int userNo;
	private int jobNo;
	private int genreNo;
	private String projectName;
	private String projectContent;
	private Date projectStartDate;
	private Date projectEndDate;
	private String projectActiveYN;
	private String managerName;
	private String managerPhone;
	private String ManagerEmail;
	private String jobName;
	private String genreName;
	private String entPhotoSavedPath;
	private int entProfNo;
	private String entPhotoSavedName;

	public PostingAndProjectDTO() {
	}

	public PostingAndProjectDTO(int postingNo, String postingTitle, String postingDetail, String postingOpenYN,
			int views, Date postingDate, int projectNo, int entNo, int userNo, int jobNo, int genreNo,
			String projectName, String projectContent, Date projectStartDate, Date projectEndDate,
			String projectActiveYN, String managerName, String managerPhone, String managerEmail, String jobName,
			String genreName, String entPhotoSavedPath, int entProfNo, String entPhotoSavedName) {
		this.postingNo = postingNo;
		this.postingTitle = postingTitle;
		this.postingDetail = postingDetail;
		this.postingOpenYN = postingOpenYN;
		this.views = views;
		this.postingDate = postingDate;
		this.projectNo = projectNo;
		this.entNo = entNo;
		this.userNo = userNo;
		this.jobNo = jobNo;
		this.genreNo = genreNo;
		this.projectName = projectName;
		this.projectContent = projectContent;
		this.projectStartDate = projectStartDate;
		this.projectEndDate = projectEndDate;
		this.projectActiveYN = projectActiveYN;
		this.managerName = managerName;
		this.managerPhone = managerPhone;
		this.ManagerEmail = managerEmail;
		this.jobName = jobName;
		this.genreName = genreName;
		this.entPhotoSavedPath = entPhotoSavedPath;
		this.entProfNo = entProfNo;
		this.entPhotoSavedName = entPhotoSavedName;
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

	public String getPostingDetail() {
		return postingDetail;
	}

	public void setPostingDetail(String postingDetail) {
		this.postingDetail = postingDetail;
	}

	public String getPostingOpenYN() {
		return postingOpenYN;
	}

	public void setPostingOpenYN(String postingOpenYN) {
		this.postingOpenYN = postingOpenYN;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public Date getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}

	public int getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}

	public int getEntNo() {
		return entNo;
	}

	public void setEntNo(int entNo) {
		this.entNo = entNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getJobNo() {
		return jobNo;
	}

	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}

	public int getGenreNo() {
		return genreNo;
	}

	public void setGenreNo(int genreNo) {
		this.genreNo = genreNo;
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

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
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
		return ManagerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		ManagerEmail = managerEmail;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public String getEntPhotoSavedPath() {
		return entPhotoSavedPath;
	}

	public void setEntPhotoSavedPath(String entPhotoSavedPath) {
		this.entPhotoSavedPath = entPhotoSavedPath;
	}

	public int getEntProfNo() {
		return entProfNo;
	}

	public void setEntProfNo(int entProfNo) {
		this.entProfNo = entProfNo;
	}

	public String getEntPhotoSavedName() {
		return entPhotoSavedName;
	}

	public void setEntPhotoSavedName(String entPhotoSavedName) {
		this.entPhotoSavedName = entPhotoSavedName;
	}

	@Override
	public String toString() {
		return "PostingAndProjectDTO [postingNo=" + postingNo + ", postingTitle=" + postingTitle + ", postingDetail="
				+ postingDetail + ", postingOpenYN=" + postingOpenYN + ", views=" + views + ", postingDate="
				+ postingDate + ", projectNo=" + projectNo + ", entNo=" + entNo + ", userNo=" + userNo + ", jobNo="
				+ jobNo + ", genreNo=" + genreNo + ", projectName=" + projectName + ", projectContent=" + projectContent
				+ ", projectStartDate=" + projectStartDate + ", projectEndDate=" + projectEndDate + ", projectActiveYN="
				+ projectActiveYN + ", managerName=" + managerName + ", managerPhone=" + managerPhone
				+ ", ManagerEmail=" + ManagerEmail + ", jobName=" + jobName + ", genreName=" + genreName
				+ ", entPhotoSavedPath=" + entPhotoSavedPath + ", entProfNo=" + entProfNo + ", entPhotoSavedName="
				+ entPhotoSavedName + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	

}
