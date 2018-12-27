package com.wowowo.bean;

public class CountInfo {
	
	private String fid;
	
	private Integer count;
	
	private String dictItemName;

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getDictItemName() {
		return dictItemName;
	}

	public void setDictItemName(String dictItemName) {
		this.dictItemName = dictItemName;
	}

	@Override
	public String toString() {
		return "CountInfo [fid=" + fid + ", count=" + count + ", dictItemName=" + dictItemName + "]";
	}
	
	

}
