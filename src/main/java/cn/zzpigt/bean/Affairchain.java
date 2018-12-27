package cn.zzpigt.bean;

import java.util.Date;

public class Affairchain {
    private Integer affairchainid;

    private Integer affairid;

    private Integer userid;

    private Byte affairchainorder;

    private Date affairchaintime;

    private String affairchainremark;

    private Byte affairchainstate;

    public Integer getAffairchainid() {
        return affairchainid;
    }

    public void setAffairchainid(Integer affairchainid) {
        this.affairchainid = affairchainid;
    }

    public Integer getAffairid() {
        return affairid;
    }

    public void setAffairid(Integer affairid) {
        this.affairid = affairid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Byte getAffairchainorder() {
        return affairchainorder;
    }

    public void setAffairchainorder(Byte affairchainorder) {
        this.affairchainorder = affairchainorder;
    }

    public Date getAffairchaintime() {
        return affairchaintime;
    }

    public void setAffairchaintime(Date affairchaintime) {
        this.affairchaintime = affairchaintime;
    }

    public String getAffairchainremark() {
        return affairchainremark;
    }

    public void setAffairchainremark(String affairchainremark) {
        this.affairchainremark = affairchainremark == null ? null : affairchainremark.trim();
    }

    public Byte getAffairchainstate() {
        return affairchainstate;
    }

    public void setAffairchainstate(Byte affairchainstate) {
        this.affairchainstate = affairchainstate;
    }

	@Override
	public String toString() {
		return "Affairchain [affairchainid=" + affairchainid + ", affairid=" + affairid + ", userid=" + userid
				+ ", affairchainorder=" + affairchainorder + ", affairchaintime=" + affairchaintime
				+ ", affairchainremark=" + affairchainremark + ", affairchainstate=" + affairchainstate + "]";
	}
    
    
}