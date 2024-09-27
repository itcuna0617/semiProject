package ent.model.dto;

import java.io.Serializable;

public class RatePlanByEntDTO implements Serializable{

	private static final long serialVersionUID = 1426920681208639570L;
	
	private int entNo;
	private int entPaymentNo;
	private String planName;
	private int planOfferCount;
	private int planProjectCount;
	
	public RatePlanByEntDTO() {
	}

	public RatePlanByEntDTO(int entNo, int entPaymentNo, String planName, int planOfferCount, int planProjectCount) {
		this.entNo = entNo;
		this.entPaymentNo = entPaymentNo;
		this.planName = planName;
		this.planOfferCount = planOfferCount;
		this.planProjectCount = planProjectCount;
	}

	public int getEntNo() {
		return entNo;
	}

	public void setEntNo(int entNo) {
		this.entNo = entNo;
	}

	public int getEntPaymentNo() {
		return entPaymentNo;
	}

	public void setEntPaymentNo(int entPaymentNo) {
		this.entPaymentNo = entPaymentNo;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public int getPlanOfferCount() {
		return planOfferCount;
	}

	public void setPlanOfferCount(int planOfferCount) {
		this.planOfferCount = planOfferCount;
	}

	public int getPlanProjectCount() {
		return planProjectCount;
	}

	public void setPlanProjectCount(int planProjectCount) {
		this.planProjectCount = planProjectCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "RatePlanByEntDTO [entNo=" + entNo + ", entPaymentNo=" + entPaymentNo + ", planName=" + planName
				+ ", planOfferCount=" + planOfferCount + ", planProjectCount=" + planProjectCount + "]";
	}
	
	
}
