package posting.model.dto;

public class GenreDTO {

	
	private int genreNo;
	private String genreName;
	
	
	
	public GenreDTO() {
	}



	public GenreDTO(int genreNo, String genreName) {
		this.genreNo = genreNo;
		this.genreName = genreName;
	}



	public int getGenreNo() {
		return genreNo;
	}



	public void setGenreNo(int genreNo) {
		this.genreNo = genreNo;
	}



	public String getGenreName() {
		return genreName;
	}



	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}



	@Override
	public String toString() {
		return "GenreDTO [genreNo=" + genreNo + ", genreName=" + genreName + ", getGenreNo()=" + getGenreNo()
				+ ", getGenreName()=" + getGenreName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
