package cn.zzpigt.bean;

public class UserRole {
    private Integer userid;

    private Integer roleid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

	@Override
	public String toString() {
		return "UserRole [userid=" + userid + ", roleid=" + roleid + "]";
	}
    
    
    
}