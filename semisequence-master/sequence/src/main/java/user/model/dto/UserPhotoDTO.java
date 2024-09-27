package user.model.dto;

public class UserPhotoDTO {
	
	private int userPhotoNo;
	private String userPhotoOriginalSavedPath;
	private String userPhotoSavedName;
	private String userPhotoSavedPath;
	private String userPhotoActiveYn;
	private int userProfileNo;
	public UserPhotoDTO() {
		super();
	}
	public UserPhotoDTO(int userPhotoNo, String userPhotoOriginalSavedPath, String userPhotoSavedName,
			String userPhotoSavedPath, String userPhotoActiveYn, int userProfileNo) {
		super();
		this.userPhotoNo = userPhotoNo;
		this.userPhotoOriginalSavedPath = userPhotoOriginalSavedPath;
		this.userPhotoSavedName = userPhotoSavedName;
		this.userPhotoSavedPath = userPhotoSavedPath;
		this.userPhotoActiveYn = userPhotoActiveYn;
		this.userProfileNo = userProfileNo;
	}
	public int getUserPhotoNo() {
		return userPhotoNo;
	}
	public void setUserPhotoNo(int userPhotoNo) {
		this.userPhotoNo = userPhotoNo;
	}
	public String getUserPhotoOriginalSavedPath() {
		return userPhotoOriginalSavedPath;
	}
	public void setUserPhotoOriginalSavedPath(String userPhotoOriginalSavedPath) {
		this.userPhotoOriginalSavedPath = userPhotoOriginalSavedPath;
	}
	public String getUserPhotoSavedName() {
		return userPhotoSavedName;
	}
	public void setUserPhotoSavedName(String userPhotoSavedName) {
		this.userPhotoSavedName = userPhotoSavedName;
	}
	public String getUserPhotoSavedPath() {
		return userPhotoSavedPath;
	}
	public void setUserPhotoSavedPath(String userPhotoSavedPath) {
		this.userPhotoSavedPath = userPhotoSavedPath;
	}
	public String getUserPhotoActiveYn() {
		return userPhotoActiveYn;
	}
	public void setUserPhotoActiveYn(String userPhotoActiveYn) {
		this.userPhotoActiveYn = userPhotoActiveYn;
	}
	public int getUserProfileNo() {
		return userProfileNo;
	}
	public void setUserProfileNo(int userProfileNo) {
		this.userProfileNo = userProfileNo;
	}
	@Override
	public String toString() {
		return "UserPhotoDTO [userPhotoNo=" + userPhotoNo + ", userPhotoOriginalSavedPath=" + userPhotoOriginalSavedPath
				+ ", userPhotoSavedName=" + userPhotoSavedName + ", userPhotoSavedPath=" + userPhotoSavedPath
				+ ", userPhotoActiveYn=" + userPhotoActiveYn + ", userProfileNo=" + userProfileNo + "]";
	}
	
	
}
