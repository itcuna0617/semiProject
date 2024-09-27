package ent.model.dto;

import java.io.Serializable;

public class EntProfileDTO implements Serializable{

	private static final long serialVersionUID = -5938192779607158515L;
	
	private int entProfNo;
	private String entPhoto;
	private String entIntro;
	private String entResume;
	private int entNo;
	
	public EntProfileDTO() {
	}

	public EntProfileDTO(int entProfNo, String entPhoto, String entIntro, String entResume, int entNo) {
		this.entProfNo = entProfNo;
		this.entPhoto = entPhoto;
		this.entIntro = entIntro;
		this.entResume = entResume;
		this.entNo = entNo;
	}

	public int getEntProfNo() {
		return entProfNo;
	}

	public void setEntProfNo(int entProfNo) {
		this.entProfNo = entProfNo;
	}

	public String getEntPhoto() {
		return entPhoto;
	}

	public void setEntPhoto(String entPhoto) {
		this.entPhoto = entPhoto;
	}

	public String getEntIntro() {
		return entIntro;
	}

	public void setEntIntro(String entIntro) {
		this.entIntro = entIntro;
	}

	public String getEntResume() {
		return entResume;
	}

	public void setEntResume(String entResume) {
		this.entResume = entResume;
	}

	public int getEntNo() {
		return entNo;
	}

	public void setEntNo(int entNo) {
		this.entNo = entNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EntProfileDTO [entProfNo=" + entProfNo + ", entPhoto=" + entPhoto + ", entIntro=" + entIntro
				+ ", entResume=" + entResume + ", entNo=" + entNo + "]";
	}
	
}
