package user.model.dto;


public class UserAddFileDTO {
	
	private int userFileNo;
	private String userFileOriginalName;
	private String userFileSavedName;
	private String userFileActiveYn;
	private int userProfileNo;
	
	public UserAddFileDTO() {
		super();
	}
	public UserAddFileDTO(int userFileNo, String userFileOriginalName, String userFileSavedName,
			String userFileActiveYn, int userProfileNo) {
		super();
		this.userFileNo = userFileNo;
		this.userFileOriginalName = userFileOriginalName;
		this.userFileSavedName = userFileSavedName;
		this.userFileActiveYn = userFileActiveYn;
		this.userProfileNo = userProfileNo;
	}
	public int getUserFileNo() {
		return userFileNo;
	}
	public void setUserFileNo(int userFileNo) {
		this.userFileNo = userFileNo;
	}
	public String getUserFileOriginalName() {
		return userFileOriginalName;
	}
	public void setUserFileOriginalName(String userFileOriginalName) {
		this.userFileOriginalName = userFileOriginalName;
	}
	public String getUserFileSavedName() {
		return userFileSavedName;
	}
	public void setUserFileSavedName(String userFileSavedName) {
		this.userFileSavedName = userFileSavedName;
	}
	public String getUserFileActiveYn() {
		return userFileActiveYn;
	}
	public void setUserFileActiveYn(String userFileActiveYn) {
		this.userFileActiveYn = userFileActiveYn;
	}
	public int getUserProfileNo() {
		return userProfileNo;
	}
	public void setUserProfileNo(int userProfileNo) {
		this.userProfileNo = userProfileNo;
	}
	@Override
	public String toString() {
		return "UserAddFileDTO [userFileNo=" + userFileNo + ", userFileOriginalName=" + userFileOriginalName
				+ ", userFileSavedName=" + userFileSavedName + ", userFileActiveYn=" + userFileActiveYn
				+ ", userProfileNo=" + userProfileNo + "]";
	}
	
}
