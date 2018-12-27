package cn.zzpigt.bean;

public class Affairmodel {
    private Integer affairmodelid;

    private String affairmodelname;

    private Integer userid;

    private String affairchain;

    public Integer getAffairmodelid() {
        return affairmodelid;
    }

    public void setAffairmodelid(Integer affairmodelid) {
        this.affairmodelid = affairmodelid;
    }

    public String getAffairmodelname() {
        return affairmodelname;
    }

    public void setAffairmodelname(String affairmodelname) {
        this.affairmodelname = affairmodelname == null ? null : affairmodelname.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAffairchain() {
        return affairchain;
    }

    public void setAffairchain(String affairchain) {
        this.affairchain = affairchain == null ? null : affairchain.trim();
    }

	@Override
	public String toString() {
		return "Affairmodel [affairmodelid=" + affairmodelid + ", affairmodelname=" + affairmodelname + ", userid="
				+ userid + ", affairchain=" + affairchain + "]";
	}
    
}