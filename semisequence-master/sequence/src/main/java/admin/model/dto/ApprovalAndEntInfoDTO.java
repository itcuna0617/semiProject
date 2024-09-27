package admin.model.dto;

public class ApprovalAndEntInfoDTO {
	
	private int approvalNo;
	private int entNo;
	private String entYn;
	private String entName;
	private String entLicensePdf;
	private String entLicensePath;
	public ApprovalAndEntInfoDTO() {
		super();
	}
	public ApprovalAndEntInfoDTO(int approvalNo, int entNo, String entYn, String entName, String entLicensePdf,
			String entLicensePath) {
		super();
		this.approvalNo = approvalNo;
		this.entNo = entNo;
		this.entYn = entYn;
		this.entName = entName;
		this.entLicensePdf = entLicensePdf;
		this.entLicensePath = entLicensePath;
	}
	public int getApprovalNo() {
		return approvalNo;
	}
	public void setApprovalNo(int approvalNo) {
		this.approvalNo = approvalNo;
	}
	public int getEntNo() {
		return entNo;
	}
	public void setEntNo(int entNo) {
		this.entNo = entNo;
	}
	public String getEntYn() {
		return entYn;
	}
	public void setEntYn(String entYn) {
		this.entYn = entYn;
	}
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}
	public String getEntLicensePdf() {
		return entLicensePdf;
	}
	public void setEntLicensePdf(String entLicensePdf) {
		this.entLicensePdf = entLicensePdf;
	}
	public String getEntLicensePath() {
		return entLicensePath;
	}
	public void setEntLicensePath(String entLicensePath) {
		this.entLicensePath = entLicensePath;
	}
	@Override
	public String toString() {
		return "ApprovalAndEntInfoDTO [approvalNo=" + approvalNo + ", entNo=" + entNo + ", entYn=" + entYn
				+ ", entName=" + entName + ", entLicensePdf=" + entLicensePdf + ", entLicensePath=" + entLicensePath
				+ "]";
	}
	
	
}
