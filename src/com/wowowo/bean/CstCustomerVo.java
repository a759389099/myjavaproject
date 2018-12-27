package com.wowowo.bean;

import java.util.List;

public class CstCustomerVo {
    private Long custId;

    private String custName;

    private Long custUserId;

    private Long custCreateId;

    private BaseDict custSource;

    private BaseDict custIndustry;

    private BaseDict custLevel;
    //这个暂时用不到了
    private List<CstLinkman> cstLinkmanList;

    private String custPhone;

    private String custMobile;
    
    public CstCustomerVo(CstCustomer po){
    	this.custId = po.getCustId();
        this.custName = po.getCustName();
        this.custUserId = po.getCustUserId();
        this.custCreateId = po.getCustCreateId();
        this.custPhone = po.getCustPhone();
        this.custMobile = po.getCustMobile();
    }
    

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public Long getCustUserId() {
        return custUserId;
    }

    public void setCustUserId(Long custUserId) {
        this.custUserId = custUserId;
    }

    public Long getCustCreateId() {
        return custCreateId;
    }

    public void setCustCreateId(Long custCreateId) {
        this.custCreateId = custCreateId;
    }

    public BaseDict getCustSource() {
        return custSource;
    }

    public void setCustSource(BaseDict custSource) {
        this.custSource = custSource;
    }

    public BaseDict getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(BaseDict custIndustry) {
        this.custIndustry = custIndustry;
    }

    public BaseDict getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(BaseDict custLevel) {
        this.custLevel = custLevel;
    }


	public List<CstLinkman> getCstLinkmanList() {
		return cstLinkmanList;
	}


	public void setCstLinkmanList(List<CstLinkman> cstLinkmanList) {
		this.cstLinkmanList = cstLinkmanList;
	}


	public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile == null ? null : custMobile.trim();
    }


	@Override
	public String toString() {
		return "CstCustomerVo [custId=" + custId + ", custName=" + custName + ", custUserId=" + custUserId
				+ ", custCreateId=" + custCreateId + ", custSource=" + custSource + ", custIndustry=" + custIndustry
				+ ", custLevel=" + custLevel + ", cstLinkmanList=" + cstLinkmanList + ", custPhone=" + custPhone
				+ ", custMobile=" + custMobile + "]";
	}



	
    
}