package ent.model.dto;

import java.io.Serializable;
import java.util.Date;

public class PaymentHistoryDTO implements Serializable{

	private static final long serialVersionUID = -986973843561859833L;
	
	private int entPaymentNo;
	private Date entPaymentTime;
	private String planName;
	private int entNo;
	private RatePlanDTO planPrice;
	
	public PaymentHistoryDTO() {
	}

	public PaymentHistoryDTO(int entPaymentNo, Date entPaymentTime, String planName, int entNo, RatePlanDTO planPrice) {
		this.entPaymentNo = entPaymentNo;
		this.entPaymentTime = entPaymentTime;
		this.planName = planName;
		this.entNo = entNo;
		this.planPrice = planPrice;
	}

	public int getEntPaymentNo() {
		return entPaymentNo;
	}

	public void setEntPaymentNo(int entPaymentNo) {
		this.entPaymentNo = entPaymentNo;
	}

	public Date getEntPaymentTime() {
		return entPaymentTime;
	}

	public void setEntPaymentTime(Date entPaymentTime) {
		this.entPaymentTime = entPaymentTime;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public int getEntNo() {
		return entNo;
	}

	public void setEntNo(int entNo) {
		this.entNo = entNo;
	}

	public RatePlanDTO getPlanPrice() {
		return planPrice;
	}

	public void setPlanPrice(RatePlanDTO planPrice) {
		this.planPrice = planPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PaymentHistoryDTO [entPaymentNo=" + entPaymentNo + ", entPaymentTime=" + entPaymentTime + ", planName="
				+ planName + ", entNo=" + entNo + ", planPrice=" + planPrice + "]";
	}

	
}
