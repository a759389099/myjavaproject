package cn.zzpigt.bean;

public class Operate {
    private Integer operateid;

    private String operatename;

    private String operateaction;

    private String operateurl;

    private Integer pid;

    public Integer getOperateid() {
        return operateid;
    }

    public void setOperateid(Integer operateid) {
        this.operateid = operateid;
    }

    public String getOperatename() {
        return operatename;
    }

    public void setOperatename(String operatename) {
        this.operatename = operatename == null ? null : operatename.trim();
    }

    public String getOperateaction() {
        return operateaction;
    }

    public void setOperateaction(String operateaction) {
        this.operateaction = operateaction == null ? null : operateaction.trim();
    }

    public String getOperateurl() {
        return operateurl;
    }

    public void setOperateurl(String operateurl) {
        this.operateurl = operateurl == null ? null : operateurl.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}