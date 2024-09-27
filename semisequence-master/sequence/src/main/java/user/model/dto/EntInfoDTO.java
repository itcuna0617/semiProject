package user.model.dto;

public class EntInfoDTO {
	
	private int entNo;
	private String entName;
	private String entId;
	private String entPwd;
	private String entPhone;
	private String entEmail;
	private String entDropYn;
	private String entSanctionYn;
	private String entActiveYn;
	public EntInfoDTO() {
		super();
	}
	public EntInfoDTO(int entNo, String entName, String entId, String entPwd, String entPhone, String entEmail,
			String entDropYn, String entSanctionYn, String entActiveYn) {
		super();
		this.entNo = entNo;
		this.entName = entName;
		this.entId = entId;
		this.entPwd = entPwd;
		this.entPhone = entPhone;
		this.entEmail = entEmail;
		this.entDropYn = entDropYn;
		this.entSanctionYn = entSanctionYn;
		this.entActiveYn = entActiveYn;
	}
	public int getEntNo() {
		return entNo;
	}
	public void setEntNo(int entNo) {
		this.entNo = entNo;
	}
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}
	public String getEntId() {
		return entId;
	}
	public void setEntId(String entId) {
		this.entId = entId;
	}
	public String getEntPwd() {
		return entPwd;
	}
	public void setEntPwd(String entPwd) {
		this.entPwd = entPwd;
	}
	public String getEntPhone() {
		return entPhone;
	}
	public void setEntPhone(String entPhone) {
		this.entPhone = entPhone;
	}
	public String getEntEmail() {
		return entEmail;
	}
	public void setEntEmail(String entEmail) {
		this.entEmail = entEmail;
	}
	public String getEntDropYn() {
		return entDropYn;
	}
	public void setEntDropYn(String entDropYn) {
		this.entDropYn = entDropYn;
	}
	public String getEntSanctionYn() {
		return entSanctionYn;
	}
	public void setEntSanctionYn(String entSanctionYn) {
		this.entSanctionYn = entSanctionYn;
	}
	public String getEntActiveYn() {
		return entActiveYn;
	}
	public void setEntActiveYn(String entActiveYn) {
		this.entActiveYn = entActiveYn;
	}
	@Override
	public String toString() {
		return "EntInfoDTO [entNo=" + entNo + ", entName=" + entName + ", entId=" + entId + ", entPwd=" + entPwd
				+ ", entPhone=" + entPhone + ", entEmail=" + entEmail + ", entDropYn=" + entDropYn + ", entSanctionYn="
				+ entSanctionYn + ", entActiveYn=" + entActiveYn + "]";
	}
	
	
	
}
