package cn.zzpigt.bean;

import java.util.List;

public class QueryVo {

	//用户表和用户验证码
	private User user;
	private String code;
	//表格当前页数和每页条数
	private Integer pageNum;
	private Integer pageSize;
	//部门表
	private Department department;
	
	//公文设计（affairmodel/affairmodelitem）
	private Affairmodel affairmodel;
	private List<Affairmodelitem> affairmodelitemList;

	public List<Affairmodelitem> getAffairmodelitemList() {
		return affairmodelitemList;
	}

	public void setAffairmodelitemList(List<Affairmodelitem> affairmodelitemList) {
		this.affairmodelitemList = affairmodelitemList;
	}

	public Affairmodel getAffairmodel() {
		return affairmodel;
	}

	public void setAffairmodel(Affairmodel affairmodel) {
		this.affairmodel = affairmodel;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "QueryVo [user=" + user + ", code=" + code + ", pageNum=" + pageNum + ", pageSize=" + pageSize
				+ ", department=" + department + ", affairmodel=" + affairmodel + ", affairmodelitemList="
				+ affairmodelitemList + "]";
	}


}
