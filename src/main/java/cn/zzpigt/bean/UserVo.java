package cn.zzpigt.bean;

import java.util.List;

public class UserVo {
    private Integer userid;

    private String uname;

    private String upwd;

    private String nickname;

    private User leaderid;

    private String face;
    
    //部门
    private Department department;
    private List<Role> roleList;

    public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public UserVo(User po) {
		this.userid = po.getUserid();
		this.uname = po.getUname();
		this.upwd = po.getUpwd();
		this.nickname = po.getNickname();
		this.face = po.getFace();
	}

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

    public User getLeaderid() {
        return leaderid;
    }

    public void setLeaderid(User leaderid) {
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
		return "UserVo [userid=" + userid + ", uname=" + uname + ", upwd=" + upwd + ", nickname=" + nickname
				+ ", leaderid=" + leaderid + ", face=" + face + ", department=" + department + ", roleList=" + roleList
				+ "]";
	}

    
    
}