package ent.model.dto;

import java.io.Serializable;

public class EntPhotoDTO implements Serializable{

	private static final long serialVersionUID = -309354288980991855L;
	
	private int entPhotoNo;
	private String photoOriginalSavedPath;
	private String photoSavedName;
	private String photoSavedPath;
	private int entProfNo;
	
	public EntPhotoDTO() {
	}

	public EntPhotoDTO(int entPhotoNo, String photoOriginalSavedPath, String photoSavedName, String photoSavedPath,
			int entProfNo) {
		this.entPhotoNo = entPhotoNo;
		this.photoOriginalSavedPath = photoOriginalSavedPath;
		this.photoSavedName = photoSavedName;
		this.photoSavedPath = photoSavedPath;
		this.entProfNo = entProfNo;
	}

	public int getEntPhotoNo() {
		return entPhotoNo;
	}

	public void setEntPhotoNo(int entPhotoNo) {
		this.entPhotoNo = entPhotoNo;
	}

	public String getPhotoOriginalSavedPath() {
		return photoOriginalSavedPath;
	}

	public void setPhotoOriginalSavedPath(String photoOriginalSavedPath) {
		this.photoOriginalSavedPath = photoOriginalSavedPath;
	}

	public String getPhotoSavedName() {
		return photoSavedName;
	}

	public void setPhotoSavedName(String photoSavedName) {
		this.photoSavedName = photoSavedName;
	}

	public String getPhotoSavedPath() {
		return photoSavedPath;
	}

	public void setPhotoSavedPath(String photoSavedPath) {
		this.photoSavedPath = photoSavedPath;
	}

	public int getEntProfNo() {
		return entProfNo;
	}

	public void setEntProfNo(int entProfNo) {
		this.entProfNo = entProfNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EntPhotoDTO [entPhotoNo=" + entPhotoNo + ", photoOriginalSavedPath=" + photoOriginalSavedPath
				+ ", photoSavedName=" + photoSavedName + ", photoSavedPath=" + photoSavedPath + ", entProfNo="
				+ entProfNo + "]";
	}
	
}
