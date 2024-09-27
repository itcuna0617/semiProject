package member.model.dto;

import java.io.Serializable;

public class MemberDTO implements Serializable{
	
	private static final long serialVersionUID = 8749902545628440723L;
	
	private int userNo;
	private String userName;
	private String userId;
	private String userPassword;
	private String userAddress;
	private String userPhone;
	private String userEmail;
	private int userBalance;
	private double userAvgScore;
	private String userDropYn;
	private String userSanctionYn;
	private String userActiveYn;
	private String userClassName;
	
	public MemberDTO() {
	}
	public MemberDTO(int userNo, String userName, String userId, String userPassword, String userAddress,
			String userPhone, String userEmail, int userBalance, double userAvgScore, String userDropYn,
			String userSanctionYn, String userActiveYn, String userClassName) {
		this.userNo = userNo;
		this.userName = userName;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.userBalance = userBalance;
		this.userAvgScore = userAvgScore;
		this.userDropYn = userDropYn;
		this.userSanctionYn = userSanctionYn;
		this.userActiveYn = userActiveYn;
		this.userClassName = userClassName;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getUserBalance() {
		return userBalance;
	}
	public void setUserBalance(int userBalance) {
		this.userBalance = userBalance;
	}
	public double getUserAvgScore() {
		return userAvgScore;
	}
	public void setUserAvgScore(double userAvgScore) {
		this.userAvgScore = userAvgScore;
	}
	public String getUserDropYn() {
		return userDropYn;
	}
	public void setUserDropYn(String userDropYn) {
		this.userDropYn = userDropYn;
	}
	public String getUserSanctionYn() {
		return userSanctionYn;
	}
	public void setUserSanctionYn(String userSanctionYn) {
		this.userSanctionYn = userSanctionYn;
	}
	public String getUserActiveYn() {
		return userActiveYn;
	}
	public void setUserActiveYn(String userActiveYn) {
		this.userActiveYn = userActiveYn;
	}
	public String getUserClassName() {
		return userClassName;
	}
	public void setUserClassName(String userClassName) {
		this.userClassName = userClassName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "MemberDTO [userNo=" + userNo + ", userName=" + userName + ", userId=" + userId + ", userPassword="
				+ userPassword + ", userAddress=" + userAddress + ", userPhone=" + userPhone + ", userEmail="
				+ userEmail + ", userBalance=" + userBalance + ", userAvgScore=" + userAvgScore + ", userDropYn="
				+ userDropYn + ", userSanctionYn=" + userSanctionYn + ", userActiveYn=" + userActiveYn
				+ ", userClassName=" + userClassName + "]";
	}

	
	
	
}
