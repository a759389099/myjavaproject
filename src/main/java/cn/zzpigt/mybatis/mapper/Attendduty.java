package cn.zzpigt.mybatis.mapper;

import java.util.Date;

public class Attendduty {
    private Integer userid;

    private String registertype;

    private Date registertime;

    private String registerip;

    private String remark;

    private Integer dutytype;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getRegistertype() {
        return registertype;
    }

    public void setRegistertype(String registertype) {
        this.registertype = registertype == null ? null : registertype.trim();
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    public String getRegisterip() {
        return registerip;
    }

    public void setRegisterip(String registerip) {
        this.registerip = registerip == null ? null : registerip.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getDutytype() {
        return dutytype;
    }

    public void setDutytype(Integer dutytype) {
        this.dutytype = dutytype;
    }

	@Override
	public String toString() {
		return "Attendduty [userid=" + userid + ", registertype=" + registertype + ", registertime=" + registertime
				+ ", registerip=" + registerip + ", remark=" + remark + ", dutytype=" + dutytype + "]";
	}
    
    
    
}