package cn.zzpigt.bean;

public class Affairmodelitem {
    private Integer modelitemid;

    private String modelitemname;

    private Integer modelitemtype;

    private String modelitemoption;

    private Integer affairmodelid;

    public Integer getModelitemid() {
        return modelitemid;
    }

    public void setModelitemid(Integer modelitemid) {
        this.modelitemid = modelitemid;
    }

    public String getModelitemname() {
        return modelitemname;
    }

    public void setModelitemname(String modelitemname) {
        this.modelitemname = modelitemname == null ? null : modelitemname.trim();
    }

    public Integer getModelitemtype() {
        return modelitemtype;
    }

    public void setModelitemtype(Integer modelitemtype) {
        this.modelitemtype = modelitemtype;
    }

    public String getModelitemoption() {
        return modelitemoption;
    }

    public void setModelitemoption(String modelitemoption) {
        this.modelitemoption = modelitemoption == null ? null : modelitemoption.trim();
    }

    public Integer getAffairmodelid() {
        return affairmodelid;
    }

    public void setAffairmodelid(Integer affairmodelid) {
        this.affairmodelid = affairmodelid;
    }

	@Override
	public String toString() {
		return "Affairmodelitem [modelitemid=" + modelitemid + ", modelitemname=" + modelitemname + ", modelitemtype="
				+ modelitemtype + ", modelitemoption=" + modelitemoption + ", affairmodelid=" + affairmodelid + "]";
	}
    
}