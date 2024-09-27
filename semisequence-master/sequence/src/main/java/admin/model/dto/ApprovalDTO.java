package admin.model.dto;

public class ApprovalDTO {
	private int approvalNo;
	private int entNo;
	private String entYn;
	public ApprovalDTO() {
		super();
	}
	public ApprovalDTO(int approvalNo, int entNo, String entYn) {
		super();
		this.approvalNo = approvalNo;
		this.entNo = entNo;
		this.entYn = entYn;
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
	@Override
	public String toString() {
		return "ApprovalDTO [approvalNo=" + approvalNo + ", entNo=" + entNo + ", entYn=" + entYn + "]";
	}
	
}
