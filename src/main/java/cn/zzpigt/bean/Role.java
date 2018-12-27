package cn.zzpigt.bean;

public class Role {
    private Integer roleid;

    private String rolename;

    private Integer departmentid;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

	@Override
	public String toString() {
		return "Role [roleid=" + roleid + ", rolename=" + rolename + ", departmentid=" + departmentid + "]";
	}
    
    
}