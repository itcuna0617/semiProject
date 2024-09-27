package ent.model.dto;

import java.io.Serializable;

public class RatePlanDTO implements Serializable{

	private static final long serialVersionUID = -9161329437238715119L;
	
	private String planName;
	private int planPrice;
	private int planPosting;
	private int planOffer;
	private int planProject;
	private PaymentHistoryDTO entPaymentNo;
	
	public RatePlanDTO() {
	}

	public RatePlanDTO(String planName, int planPrice, int planPosting, int planOffer, int planProject,
			PaymentHistoryDTO entPaymentNo) {
		this.planName = planName;
		this.planPrice = planPrice;
		this.planPosting = planPosting;
		this.planOffer = planOffer;
		this.planProject = planProject;
		this.entPaymentNo = entPaymentNo;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public int getPlanPrice() {
		return planPrice;
	}

	public void setPlanPrice(int planPrice) {
		this.planPrice = planPrice;
	}

	public int getPlanPosting() {
		return planPosting;
	}

	public void setPlanPosting(int planPosting) {
		this.planPosting = planPosting;
	}

	public int getPlanOffer() {
		return planOffer;
	}

	public void setPlanOffer(int planOffer) {
		this.planOffer = planOffer;
	}

	public int getPlanProject() {
		return planProject;
	}

	public void setPlanProject(int planProject) {
		this.planProject = planProject;
	}

	public PaymentHistoryDTO getEntPaymentNo() {
		return entPaymentNo;
	}

	public void setEntPaymentNo(PaymentHistoryDTO entPaymentNo) {
		this.entPaymentNo = entPaymentNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "RatePlanDTO [planName=" + planName + ", planPrice=" + planPrice + ", planPosting=" + planPosting
				+ ", planOffer=" + planOffer + ", planProject=" + planProject + ", entPaymentNo=" + entPaymentNo + "]";
	}
	
}
