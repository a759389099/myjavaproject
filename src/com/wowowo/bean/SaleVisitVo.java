package com.wowowo.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SaleVisitVo {
    private Long visitId;

    private CstCustomer customer;

    private SysUser user;

    private Date visitTime;

    private String visitInterviewee;

    private String visitAddr;

    private String visitDetail;

    private Date visitNexttime;
    

    public SaleVisitVo(SaleVisit po) {
		super();
		this.visitId = po.getVisitId();
		this.visitTime = po.getVisitTime();
		this.visitInterviewee = po.getVisitInterviewee();
		this.visitAddr = po.getVisitAddr();
		this.visitDetail = po.getVisitDetail();
		this.visitNexttime = po.getVisitNexttime();
	}

	public Long getVisitId() {
        return visitId;
    }

    public void setVisitId(Long visitId) {
        this.visitId = visitId;
    }


    public CstCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(CstCustomer customer) {
		this.customer = customer;
	}

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

	public String getVisitTime() {
        return new SimpleDateFormat("yyyy-MM-dd").format(this.visitTime);
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitInterviewee() {
        return visitInterviewee;
    }

    public void setVisitInterviewee(String visitInterviewee) {
        this.visitInterviewee = visitInterviewee == null ? null : visitInterviewee.trim();
    }

    public String getVisitAddr() {
        return visitAddr;
    }

    public void setVisitAddr(String visitAddr) {
        this.visitAddr = visitAddr == null ? null : visitAddr.trim();
    }

    public String getVisitDetail() {
        return visitDetail;
    }

    public void setVisitDetail(String visitDetail) {
        this.visitDetail = visitDetail == null ? null : visitDetail.trim();
    }

    public String getVisitNexttime() {
    	return new SimpleDateFormat("yyyy-MM-dd").format(this.visitNexttime);
    }

    public void setVisitNexttime(Date visitNexttime) {
        this.visitNexttime = visitNexttime;
    }
}