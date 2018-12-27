package cn.zzpigt.bean;

import java.util.List;

public class AffairmodelitemVo {
    private Integer modelitemid;

    private String modelitemname;

    private Integer modelitemtype;

    private List<String> modelitemoption;

    private Integer affairmodelid;
    
    
    //构造传po，变vo
    public AffairmodelitemVo(Affairmodelitem po) {
		this.modelitemid = po.getModelitemid();
		this.modelitemname = po.getModelitemname();
		this.modelitemtype = po.getModelitemtype();
		this.affairmodelid = po.getAffairmodelid();
	}

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

    public List<String> getModelitemoption() {
        return modelitemoption;
    }

    public void setModelitemoption(List<String> modelitemoption) {
        this.modelitemoption = modelitemoption;
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