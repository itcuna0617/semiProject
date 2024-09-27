package user.model.dto;

public class UserClassDTO {
	
	private String userClassName;
	private int userClassNo;
	private int userClassScore;
	
	public UserClassDTO() {
	}
	public UserClassDTO(String userClassName, int userClassNo, int userClassScore) {
		this.userClassName = userClassName;
		this.userClassNo = userClassNo;
		this.userClassScore = userClassScore;
	}
	public String getUserClassName() {
		return userClassName;
	}
	public void setUserClassName(String userClassName) {
		this.userClassName = userClassName;
	}
	public int getUserClassNo() {
		return userClassNo;
	}
	public void setUserClassNo(int userClassNo) {
		this.userClassNo = userClassNo;
	}
	public int getUserClassScore() {
		return userClassScore;
	}
	public void setUserClassScore(int userClassScore) {
		this.userClassScore = userClassScore;
	}
	@Override
	public String toString() {
		return "UserClassDTO [userClassName=" + userClassName + ", userClassNo=" + userClassNo + ", userClassScore="
				+ userClassScore + "]";
	}
	
	
}
