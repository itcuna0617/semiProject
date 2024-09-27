package admin.notice;

import java.util.List;

import application.model.dto.ApplicationDTO;
import customerCenter.model.dto.NoticeDTO;

public class NoticePagenation {
	// 전체 글의 행의 수
	private int total;
	// 현재 페이지 번호
	private int currentPage;
	// 한 페이지에 담길 데이터 갯수
	private int size;
	// 화면에 보여줄 페이지 갯수
	private int pagingCount;
	/* 여기까지가 입력을 받아야하는 영역 */
	/* 아래부터는 직접 계산으로 구할 영역 */
	// 전체 페이지 개수
	private int totalPages;
	// 시작 페이지 번호
	private int startPage;
	// 종료 페이지 번호
	private int endPage;
//	// 데이터 담을 객체
//	private List<?> DTO;
	// 지원자 데이터 담을 객체
//	private List<ApplicationDTO> application;
	
	public NoticePagenation(int total, int size, int currentPage, int pagingCount) { //이 때는 어떻게 해야 여러개 가능?
		this.total = total;
		this.currentPage = currentPage;
		this.pagingCount = pagingCount;
		this.size = size;
		if(total == 0 ) { // select 결과가 없다면...
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else { // select 결과가 있다면...
			// 전체 페이지 개수 구하기(전체 글의 수 / 한 화면에 보여질 행의 수    이렇게해야 예외상황(1, 10, 11 등)에도 옳은 페이지수 나옴.
			totalPages = ((total-1) / size)+1;
			
			// startPage : '이전 [1] [2] [3] [4] [5] 다음' 일때 1을 의미
			// 공식 : 현재페이지 / 페이징의 개수 * 페이징의 개수 + 1;
			startPage = ((currentPage-1) / pagingCount )* pagingCount + 1;
			// 보정해줘야 할 경우는? 5 / 5 * 5 + 1 => 6 경우처럼
			
			// endPage   : '이전 [1] [2] [3] [4] [5] 다음' 일때 5을 의미
			endPage = startPage + pagingCount - 1 ;
			// 보정해줘야 할 경우는? endPage > totalPages 일때
			//					endPage를 totalPages로 바꿔줘야 함 
			if(endPage > totalPages) {
				endPage = totalPages;
			}
		}
	}
		
	
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getPagingCount() {
		return pagingCount;
	}
	public void setPagingCount(int pagingCount) {
		this.pagingCount = pagingCount;
	}
		

	
	
	
}
