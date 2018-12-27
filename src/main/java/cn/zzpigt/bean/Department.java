package cn.zzpigt.bean;

public class Department {
    private Integer departmentid;

    private String departmentname;

    private Integer pid;

    private Integer userid;

    public Integer getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname == null ? null : departmentname.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

	@Override
	public String toString() {
		return "Department [departmentid=" + departmentid + ", departmentname=" + departmentname + ", pid=" + pid
				+ ", userid=" + userid + "]";
	}
    
    
}