package com.supercaoO.bean;

import java.util.List;

public class Page <T> {
	//当前页码
	private int pageNumber;
	//总页数
	private int pageCount;
	//数据总条数
	private int total;
	//分页容量
	private int pageSize;
	//数据
	private List<T> pages;
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getTotal() {
		return total;
	}
	public int getPageCount() {
		pageCount = (int) Math.ceil((double) total / pageSize);
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getPages() {
		return pages;
	}
	public void setPages(List<T> pages) {
		this.pages = pages;
	}
	
}
