package cn.zzpigt.bean;

import java.util.List;

public class PageBean<T> {

	private Integer pageNum;
	private Integer pageSize;
	private Integer totalCount;
	private Integer totalPage;
	private Integer start;
	private List<T> list;
	
	public PageBean() {
		super();
	}
	public PageBean(Integer pageNum, Integer pageSize, Integer totalCount) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		
		if(pageNum == null || pageNum <= 0){
			this.pageNum = 1;
		}
		
		if(pageSize == null || pageSize <= 0){
			this.pageSize = 2;
		}
		
		start = (this.pageNum - 1) * this.pageSize;
		totalPage = (this.totalCount + this.pageSize - 1) / this.pageSize;
		
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
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "PageBean [pageNum=" + pageNum + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", start=" + start + ", list=" + list + "]";
	}
	
}
