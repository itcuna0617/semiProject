package customerCenter.model.dto;

import java.io.Serializable;

public class QuestionFileDTO implements Serializable{
	private static final long serialVersionUID = 9152539801709154228L;

	private String queFileName;
	private String queFileSavedPath;
	private int queNo;
	
	public QuestionFileDTO() {
	}

	public QuestionFileDTO(String queFileName, String queFileSavedPath, int queNo) {
		this.queFileName = queFileName;
		this.queFileSavedPath = queFileSavedPath;
		this.queNo = queNo;
	}

	public String getQueFileName() {
		return queFileName;
	}

	public void setQueFileName(String queFileName) {
		this.queFileName = queFileName;
	}

	public String getQueFileSavedPath() {
		return queFileSavedPath;
	}

	public void setQueFileSavedPath(String queFileSavedPath) {
		this.queFileSavedPath = queFileSavedPath;
	}

	public int getQueNo() {
		return queNo;
	}

	public void setQueNo(int queNo) {
		this.queNo = queNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "QuestionFileDTO [queFileName=" + queFileName + ", queFileSavedPath=" + queFileSavedPath + ", queNo="
				+ queNo + ", getQueFileName()=" + getQueFileName() + ", getQueFileSavedPath()=" + getQueFileSavedPath()
				+ ", getQueNo()=" + getQueNo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
