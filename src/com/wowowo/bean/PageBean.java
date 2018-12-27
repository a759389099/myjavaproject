package com.wowowo.bean;

import java.util.List;

public class PageBean<T> {

	private Integer pageNum;
	private Integer pageSize;
	private Integer startPage;
	private Integer total;
	private Integer totalPage;
	private List<T> list;

	public PageBean(Integer pageNum, Integer pageSize, Integer total) {

		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.total = total;
		if (pageNum == null || pageNum <= 0) {

			this.pageNum = 1;
		}
		if (pageSize == null || pageSize <= 0) {

			this.pageSize = 5;
		}
		startPage = (this.pageNum - 1) * this.pageSize;
		totalPage = (this.total + this.pageSize - 1) / this.pageSize;
		
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageBean [pageNum=" + pageNum + ", pageSize=" + pageSize + ", startPage=" + startPage + ", total="
				+ total + ", totalPage=" + totalPage + ", list=" + list + "]";
	}

}
