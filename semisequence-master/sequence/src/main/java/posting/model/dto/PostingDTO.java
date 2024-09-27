package posting.model.dto;

import java.sql.Date;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import project.model.dto.ProjectDTO;

public class PostingDTO implements Serializable{

public PostingDTO(int postingNo, String postingTitle, String postingDetail, String postingOpenYN,
			String postingDeleteYN, int views, Date postingDate, int projectNo, int entNo, int userNo, int jobNo,
			int genreNo, ProjectDTO project, String genreName, String jobName, String userName, String entName) {
		super();
		this.postingNo = postingNo;
		this.postingTitle = postingTitle;
		this.postingDetail = postingDetail;
		this.postingOpenYN = postingOpenYN;
		this.postingDeleteYN = postingDeleteYN;
		this.views = views;
		this.postingDate = postingDate;
		this.projectNo = projectNo;
		this.entNo = entNo;
		this.userNo = userNo;
		this.jobNo = jobNo;
		this.genreNo = genreNo;
		this.project = project;
		this.genreName = genreName;
		this.jobName = jobName;
		this.userName = userName;
		this.entName = entName;
		}
	public PostingDTO() {
			super();
		}
	private static final long serialVersionUID = 3260764200541872432L;
	
	private int postingNo;
	private String postingTitle;
	private String postingDetail;
	private String postingOpenYN;
	private String postingDeleteYN;
	private int views;
	private java.sql.Date postingDate;
	private int projectNo;
	private int entNo;
	private int userNo;
	private int jobNo;
	private int genreNo;
	private ProjectDTO project;

	private String genreName;
	private String jobName;
	private String userName;
	private String entName;
	
	
	
	
	
	public ProjectDTO getProject() {
		return project;
	}
	public void setProject(ProjectDTO project) {
		this.project = project;
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
	public String getPostingDeleteYN() {
		return postingDeleteYN;
	}
	public void setPostingDeleteYN(String postingDeleteYN) {
		this.postingDeleteYN = postingDeleteYN;
	}
	public java.sql.Date getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(java.sql.Date postingDate) {
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
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
public PostingDTO(int postingNo, String postingTitle, String postingDetail, String postingOpenYN, int views,
			String postingDeleteYN, Date postingDate, int projectNo, int entNo, int userNo, int jobNo, int genreNo,
			String genreName, String jobName, String userName, String entName) {
		super();
		this.postingNo = postingNo;
		this.postingTitle = postingTitle;
		this.postingDetail = postingDetail;
		this.postingOpenYN = postingOpenYN;
		this.views = views;
		this.postingDeleteYN = postingDeleteYN;
		this.postingDate = postingDate;
		this.projectNo = projectNo;
		this.entNo = entNo;
		this.userNo = userNo;
		this.jobNo = jobNo;
		this.genreNo = genreNo;
		this.genreName = genreName;
		this.jobName = jobName;
		this.userName = userName;
		this.entName = entName;
	}

}
