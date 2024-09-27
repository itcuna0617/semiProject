package common.paging;

public class SelectCriteria implements java.io.Serializable {
	private static final long serialVersionUID = 5942028854052073017L;
	
	private int pageNo;		
	private int totalCount;	
	private int limit;				
	private int buttonAmount;		
	private int maxPage;		
	private int startPage;			
	private int endPage;		
	private int startRow;				
	private int endRow;				
	private String searchCondition1;		//검색 조건 1
	private String searchCondition2;		//검색 조건 2
	private String searchValue;			
	
	
	
	public SelectCriteria() {
	}



	public SelectCriteria(int pageNo, int totalCount, int limit, int buttonAmount, int maxPage, int startPage,
			int endPage, int startRow, int endRow, String searchCondition1, String searchCondition2,
			String searchValue) {
		this.pageNo = pageNo;
		this.totalCount = totalCount;
		this.limit = limit;
		this.buttonAmount = buttonAmount;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
		this.startRow = startRow;
		this.endRow = endRow;
		this.searchCondition1 = searchCondition1;
		this.searchCondition2 = searchCondition2;
		this.searchValue = searchValue;
	}



	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getButtonAmount() {
		return buttonAmount;
	}

	public void setButtonAmount(int buttonAmount) {
		this.buttonAmount = buttonAmount;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
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

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public String getSearchCondition1() {
		return searchCondition1;
	}



	public void setSearchCondition1(String searchCondition1) {
		this.searchCondition1 = searchCondition1;
	}



	public String getSearchCondition2() {
		return searchCondition2;
	}



	public void setSearchCondition2(String searchCondition2) {
		this.searchCondition2 = searchCondition2;
	}



	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	@Override
	public String toString() {
		return "SelectCriteria [pageNo=" + pageNo + ", totalCount=" + totalCount + ", limit=" + limit
				+ ", buttonAmount=" + buttonAmount + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", startRow=" + startRow + ", endRow=" + endRow + ", searchCondition1=" + searchCondition1
				+ ", searchCondition2=" + searchCondition2 + ", searchValue=" + searchValue + ", getPageNo()="
				+ getPageNo() + ", getTotalCount()=" + getTotalCount() + ", getLimit()=" + getLimit()
				+ ", getButtonAmount()=" + getButtonAmount() + ", getMaxPage()=" + getMaxPage() + ", getStartPage()="
				+ getStartPage() + ", getEndPage()=" + getEndPage() + ", getStartRow()=" + getStartRow()
				+ ", getEndRow()=" + getEndRow() + ", getSearchCondition1()=" + getSearchCondition1()
				+ ", getSearchCondition2()=" + getSearchCondition2() + ", getSearchValue()=" + getSearchValue()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}
