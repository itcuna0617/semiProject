package user.model.dto;

import java.util.Date;

public class UserPostingDTO {
	
	private int postingNo;
	private String postingTitle;
	private String postingDetail;
	private String postingOpenYn;
	private String postingDeleteYn;
	private int views;
	private java.util.Date postingDate;
	private int projectNo;
	private int rNum;
	private int entNo;
	private int userNo;
	private int job_no;
	private int genreNo;
	public UserPostingDTO() {
		super();
	}
	public UserPostingDTO(int postingNo, String postingTitle, String postingDetail, String postingOpenYn,
			String postingDeleteYn, int views, Date postingDate, int projectNo, int rNum, int entNo, int userNo,
			int job_no, int genreNo) {
		super();
		this.postingNo = postingNo;
		this.postingTitle = postingTitle;
		this.postingDetail = postingDetail;
		this.postingOpenYn = postingOpenYn;
		this.postingDeleteYn = postingDeleteYn;
		this.views = views;
		this.postingDate = postingDate;
		this.projectNo = projectNo;
		this.rNum = rNum;
		this.entNo = entNo;
		this.userNo = userNo;
		this.job_no = job_no;
		this.genreNo = genreNo;
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
	public String getPostingOpenYn() {
		return postingOpenYn;
	}
	public void setPostingOpenYn(String postingOpenYn) {
		this.postingOpenYn = postingOpenYn;
	}
	public String getPostingDeleteYn() {
		return postingDeleteYn;
	}
	public void setPostingDeleteYn(String postingDeleteYn) {
		this.postingDeleteYn = postingDeleteYn;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public java.util.Date getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(java.util.Date postingDate) {
		this.postingDate = postingDate;
	}
	public int getProjectNo() {
		return projectNo;
	}
	public void setProjectNo(int projectNo) {
		this.projectNo = projectNo;
	}
	public int getrNum() {
		return rNum;
	}
	public void setrNum(int rNum) {
		this.rNum = rNum;
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
	public int getJob_no() {
		return job_no;
	}
	public void setJob_no(int job_no) {
		this.job_no = job_no;
	}
	public int getGenreNo() {
		return genreNo;
	}
	public void setGenreNo(int genreNo) {
		this.genreNo = genreNo;
	}
	@Override
	public String toString() {
		return "UserPostingDTO [postingNo=" + postingNo + ", postingTitle=" + postingTitle + ", postingDetail="
				+ postingDetail + ", postingOpenYn=" + postingOpenYn + ", postingDeleteYn=" + postingDeleteYn
				+ ", views=" + views + ", postingDate=" + postingDate + ", projectNo=" + projectNo + ", rNum=" + rNum
				+ ", entNo=" + entNo + ", userNo=" + userNo + ", job_no=" + job_no + ", genreNo=" + genreNo + "]";
	}
	
	
}
