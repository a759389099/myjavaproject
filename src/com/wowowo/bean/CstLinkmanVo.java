package com.wowowo.bean;

public class CstLinkmanVo {
    private Long lkmId;

    private String lkmName;

    private CstCustomer lkmCustomer;
    
    private String lkmGender;

    private String lkmPhone;

    private String lkmMobile;

    private String lkmEmail;

    private String lkmQq;

    private String lkmPosition;

    private String lkmMemo;

	public CstLinkmanVo(CstLinkman po) {
		this.lkmName=po.getLkmName();
		this.lkmId = po.getLkmId();
		this.lkmGender = po.getLkmGender();
		this.lkmPhone = po.getLkmPhone();
		this.lkmMobile = po.getLkmMobile();
		this.lkmEmail =po.getLkmMobile();
		this.lkmQq = po.getLkmQq();
		this.lkmPosition = po.getLkmPosition();
		this.lkmMemo = po.getLkmMemo();
	}

	public Long getLkmId() {
		return lkmId;
	}

	public void setLkmId(Long lkmId) {
		this.lkmId = lkmId;
	}

	public String getLkmName() {
		return lkmName;
	}

	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}


	public CstCustomer getLkmCustomer() {
		return lkmCustomer;
	}

	public void setLkmCustomer(CstCustomer lkmCustomer) {
		this.lkmCustomer = lkmCustomer;
	}

	public String getLkmGender() {
		return lkmGender;
	}

	public void setLkmGender(String lkmGender) {
		this.lkmGender = lkmGender;
	}

	public String getLkmPhone() {
		return lkmPhone;
	}

	public void setLkmPhone(String lkmPhone) {
		this.lkmPhone = lkmPhone;
	}

	public String getLkmMobile() {
		return lkmMobile;
	}

	public void setLkmMobile(String lkmMobile) {
		this.lkmMobile = lkmMobile;
	}

	public String getLkmEmail() {
		return lkmEmail;
	}

	public void setLkmEmail(String lkmEmail) {
		this.lkmEmail = lkmEmail;
	}

	public String getLkmQq() {
		return lkmQq;
	}

	public void setLkmQq(String lkmQq) {
		this.lkmQq = lkmQq;
	}

	public String getLkmPosition() {
		return lkmPosition;
	}

	public void setLkmPosition(String lkmPosition) {
		this.lkmPosition = lkmPosition;
	}

	public String getLkmMemo() {
		return lkmMemo;
	}

	public void setLkmMemo(String lkmMemo) {
		this.lkmMemo = lkmMemo;
	}

	@Override
	public String toString() {
		return "CstLinkmanVo [lkmId=" + lkmId + ", lkmName=" + lkmName + ", lkmCustomer=" + lkmCustomer + ", lkmGender="
				+ lkmGender + ", lkmPhone=" + lkmPhone + ", lkmMobile=" + lkmMobile + ", lkmEmail=" + lkmEmail
				+ ", lkmQq=" + lkmQq + ", lkmPosition=" + lkmPosition + ", lkmMemo=" + lkmMemo + "]";
	}

    
    

}