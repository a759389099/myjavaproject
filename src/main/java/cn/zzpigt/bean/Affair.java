package cn.zzpigt.bean;

import java.util.Date;

public class Affair {
    private Integer affairid;

    private Integer userid;

    private Date affairtime;

    private Byte affairstate;

    private Integer affairmodelid;

    private String affaircontent;

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

    public Date getAffairtime() {
        return affairtime;
    }

    public void setAffairtime(Date affairtime) {
        this.affairtime = affairtime;
    }

    public Byte getAffairstate() {
        return affairstate;
    }

    public void setAffairstate(Byte affairstate) {
        this.affairstate = affairstate;
    }

    public Integer getAffairmodelid() {
        return affairmodelid;
    }

    public void setAffairmodelid(Integer affairmodelid) {
        this.affairmodelid = affairmodelid;
    }

    public String getAffaircontent() {
        return affaircontent;
    }

    public void setAffaircontent(String affaircontent) {
        this.affaircontent = affaircontent == null ? null : affaircontent.trim();
    }

	@Override
	public String toString() {
		return "Affair [affairid=" + affairid + ", userid=" + userid + ", affairtime=" + affairtime + ", affairstate="
				+ affairstate + ", affairmodelid=" + affairmodelid + ", affaircontent=" + affaircontent + "]";
	}
    
}