package cn.zzpigt.bean;

public class AffairmodelVo {
    private Integer affairmodelid;

    private String affairmodelname;

    private User userid;

    private String affairchain;
    
    public AffairmodelVo(Affairmodel po, String affairchain) {
		this.affairmodelid = po.getAffairmodelid();
		this.affairmodelname = po.getAffairmodelname();
		this.affairchain = affairchain;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

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


    public String getAffairchain() {
        return affairchain;
    }

    public void setAffairchain(String affairchain) {
        this.affairchain = affairchain == null ? null : affairchain.trim();
    }

	@Override
	public String toString() {
		return "AffairmodelVo [affairmodelid=" + affairmodelid + ", affairmodelname=" + affairmodelname + ", userid="
				+ userid + ", affairchain=" + affairchain + "]";
	}
    
    
    
}