package com.wowowo.bean;

import java.util.Arrays;

public class QueryVo {

	private Integer pageNum;
	private Integer pageSize;
	private CstCustomer customer;
	private CstLinkman linkman;
	private SysRole role;
	private Boolean select;
	private	SysUser user; 
	private Long [] rId;
	

	public Long[] getrId() {
		return rId;
	}

	public void setrId(Long[] rId) {
		this.rId = rId;
	}

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

	public SysRole getRole() {
		return role;
	}

	public void setRole(SysRole role) {
		this.role = role;
	}

	public CstLinkman getLinkman() {
		return linkman;
	}

	public void setLinkman(CstLinkman linkman) {
		this.linkman = linkman;
	}

	public Boolean getSelect() {
		return select;
	}

	public void setSelect(Boolean select) {
		this.select = select;
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

	public CstCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(CstCustomer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "QueryVo [pageNum=" + pageNum + ", pageSize=" + pageSize + ", customer=" + customer + ", linkman="
				+ linkman + ", role=" + role + ", select=" + select + ", user=" + user + ", rId=" + Arrays.toString(rId)
				+ "]";
	}


}
