package ent.model.dto;

import java.io.Serializable;

public class EntDTO implements Serializable{
	
	private static final long serialVersionUID = -3341980252643389947L;
	
	int entNo;
	String entName;
	String entId;
	String entPwd;
	String entPhone;
	String entEmail;
	String entDropYn;
	String entSanctionYn;
	String entActiveYn;
	String enrollmentFileName;
	
	public EntDTO() {
	}

	public EntDTO(int entNo, String entName, String entId, String entPwd, String entPhone, String entEmail,
			String entDropYn, String entSanctionYn, String entActiveYn, String enrollmentFileName) {
		this.entNo = entNo;
		this.entName = entName;
		this.entId = entId;
		this.entPwd = entPwd;
		this.entPhone = entPhone;
		this.entEmail = entEmail;
		this.entDropYn = entDropYn;
		this.entSanctionYn = entSanctionYn;
		this.entActiveYn = entActiveYn;
		this.enrollmentFileName = enrollmentFileName;
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

	public String getEnrollmentFileName() {
		return enrollmentFileName;
	}

	public void setEnrollmentFileName(String enrollmentFileName) {
		this.enrollmentFileName = enrollmentFileName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EntDTO [entNo=" + entNo + ", entName=" + entName + ", entId=" + entId + ", entPwd=" + entPwd
				+ ", entPhone=" + entPhone + ", entEmail=" + entEmail + ", entDropYn=" + entDropYn + ", entSanctionYn="
				+ entSanctionYn + ", entActiveYn=" + entActiveYn + ", enrollmentFileName=" + enrollmentFileName + "]";
	}

	
}
