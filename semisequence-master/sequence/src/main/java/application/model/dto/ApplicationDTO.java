package application.model.dto;

import java.io.Serializable;
import java.sql.Date;

import ent.model.dto.EntDTO;
import posting.model.dto.JobDTO;
import posting.model.dto.PostingDTO;
import project.model.dto.ProjectDTO;
import user.model.dto.UserPhotoDTO;
import user.model.dto.UserProfileDTO;

public class ApplicationDTO implements Serializable{
	private static final long serialVersionUID = 9167971232812994583L;
	private int applicationNo;
	private String applicationConnectYN;
	private java.sql.Date applicationDate;
	private String applicationIntro;
	private int userNo;
	private int postingNo;
	private int userProfileNo;
	private PostingDTO posting;
	private UserProfileDTO userProfile;
	private ProjectDTO project;
	private EntDTO entInfo;
	private JobDTO job;
	private UserPhotoDTO userPhoto;
	
	
	
	public ApplicationDTO() {
		super();
	}
	public JobDTO getJob() {
		return job;
	}
	public void setJob(JobDTO job) {
		this.job = job;
	}
	public int getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(int applicationNo) {
		this.applicationNo = applicationNo;
	}
	public String getApplicationConnectYN() {
		return applicationConnectYN;
	}
	public void setApplicationConnectYN(String applicationConnectYN) {
		this.applicationConnectYN = applicationConnectYN;
	}
	public java.sql.Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(java.sql.Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getApplicationIntro() {
		return applicationIntro;
	}
	public void setApplicationIntro(String applicationIntro) {
		this.applicationIntro = applicationIntro;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getPostingNo() {
		return postingNo;
	}
	public void setPostingNo(int postingNo) {
		this.postingNo = postingNo;
	}
	public int getUserProfileNo() {
		return userProfileNo;
	}
	public void setUserProfileNo(int userProfileNo) {
		this.userProfileNo = userProfileNo;
	}
	public PostingDTO getPosting() {
		return posting;
	}
	public void setPosting(PostingDTO posting) {
		this.posting = posting;
	}
	public UserProfileDTO getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfileDTO userProfile) {
		this.userProfile = userProfile;
	}
	public ProjectDTO getProject() {
		return project;
	}
	public void setProject(ProjectDTO project) {
		this.project = project;
	}
	public EntDTO getEntInfo() {
		return entInfo;
	}
	public void setEntInfo(EntDTO entInfo) {
		this.entInfo = entInfo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public UserPhotoDTO getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(UserPhotoDTO userPhoto) {
		this.userPhoto = userPhoto;
	}
	@Override
	public String toString() {
		return "ApplicationDTO [applicationNo=" + applicationNo + ", applicationConnectYN=" + applicationConnectYN
				+ ", applicationDate=" + applicationDate + ", applicationIntro=" + applicationIntro + ", userNo="
				+ userNo + ", postingNo=" + postingNo + ", userProfileNo=" + userProfileNo + ", posting=" + posting
				+ ", userProfile=" + userProfile + ", project=" + project + ", entInfo=" + entInfo + ", job=" + job
				+ ", userPhoto=" + userPhoto + "]";
	}
	public ApplicationDTO(int applicationNo, String applicationConnectYN, Date applicationDate, String applicationIntro,
			int userNo, int postingNo, int userProfileNo, PostingDTO posting, UserProfileDTO userProfile,
			ProjectDTO project, EntDTO entInfo, JobDTO job, UserPhotoDTO userPhoto) {
		super();
		this.applicationNo = applicationNo;
		this.applicationConnectYN = applicationConnectYN;
		this.applicationDate = applicationDate;
		this.applicationIntro = applicationIntro;
		this.userNo = userNo;
		this.postingNo = postingNo;
		this.userProfileNo = userProfileNo;
		this.posting = posting;
		this.userProfile = userProfile;
		this.project = project;
		this.entInfo = entInfo;
		this.job = job;
		this.userPhoto = userPhoto;
	}
	
	
	
	
	
}
