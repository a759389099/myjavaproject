package cn.zzpigt.bean;

public class User {
    private Integer userid;

    private String uname;

    private String upwd;

    private String nickname;

    private Integer leaderid;

    private String face;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd == null ? null : upwd.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getLeaderid() {
        return leaderid;
    }

    public void setLeaderid(Integer leaderid) {
        this.leaderid = leaderid;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face == null ? null : face.trim();
    }

	@Override
	public String toString() {
		return "User [userid=" + userid + ", uname=" + uname + ", upwd=" + upwd + ", nickname=" + nickname
				+ ", leaderid=" + leaderid + ", face=" + face + "]";
	}
    
}