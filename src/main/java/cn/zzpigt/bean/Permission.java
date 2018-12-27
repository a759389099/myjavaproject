package cn.zzpigt.bean;

public class Permission {
    private Integer permissionid;

    private String permissionname;

    private String permissiontype;

    private Integer pid;

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname == null ? null : permissionname.trim();
    }

    public String getPermissiontype() {
        return permissiontype;
    }

    public void setPermissiontype(String permissiontype) {
        this.permissiontype = permissiontype == null ? null : permissiontype.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}