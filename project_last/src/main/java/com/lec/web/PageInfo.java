package com.lec.web;

public class PageInfo {

	private int page;
	private int totalPage;
	private int startPage;
	private int endPage;
	private int listCount =10;
	int nextPage;
	int prevPage;
	
	int startRow;
	int endRow; 
	
	int pageCount = 10;
	int totalCount;
	
	
	public void setPageInfo(int page) {
		this.page = page;
		if(page%pageCount==0) { // 10 20 30
			startPage = page - pageCount + 1;
		} else {
			startPage = page - (page%pageCount-1);
		}
		
		endPage = startPage + pageCount - 1;
		
		if (endPage > totalPage) {
			endPage = totalPage;
			nextPage = 1;
		} else {
			nextPage = endPage + 1;
		}
		prevPage = startPage - 1;
		startRow = (page-1) * listCount;
		endRow = startRow + listCount - 1;
		   if (endRow > totalCount-1) {
		         endRow = totalCount-1;
		      }

	}
	
	









	@Override
	public String toString() {
		return "PageInfo [page=" + page + ", totalPage=" + totalPage + ", startPage=" + startPage + ", endPage="
				+ endPage + ", listCount=" + listCount + ", nextPage=" + nextPage + ", prevPage=" + prevPage
				+ ", startRow=" + startRow + ", endRow=" + endRow + ", pageCount=" + pageCount + ", totalCount="
				+ totalCount + "]";
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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


	public int getListCount() {
		return listCount;
	}


	public void setListCount(int listCount) {
		this.listCount = listCount;
	}


	public int getNextPage() {
		return nextPage;
	}


	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}


	public int getPrevPage() {
		return prevPage;
	}


	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
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


	public int getPageCount() {
		return pageCount;
	}


	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	

	
}
