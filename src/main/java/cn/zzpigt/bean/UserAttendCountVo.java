package cn.zzpigt.bean;

public class UserAttendCountVo {
	private Department departmenid;

	private Integer userid;

	private String uname;

	private String upwd;

	private String nickname;

	private Integer leaderid;

	private String face;

	// 实际全勤天数
	private Integer attendday;
	// 总出勤天数
	private Integer daycount;
	//矿工
	private Integer nevercount;
	//迟到
	private Integer latecount;
	//早退
	private Integer earlycount;
	//上班未登记
	private Integer comesign;
	//下班未登记
	private Integer backsign;

	public UserAttendCountVo(User po) {
		this.userid = po.getUserid();
		this.uname = po.getUname();
		this.upwd = po.getUpwd();
		this.nickname = po.getNickname();
		this.leaderid = po.getLeaderid();
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
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
		this.face = face;
	}

	public Department getDepartmenid() {
		return departmenid;
	}

	public void setDepartmenid(Department departmenid) {
		this.departmenid = departmenid;
	}

	public Integer getAttendday() {
		return attendday;
	}

	public void setAttendday(Integer attendday) {
		this.attendday = attendday;
	}

	public Integer getDaycount() {
		return daycount;
	}

	public void setDaycount(Integer daycount) {
		this.daycount = daycount;
	}

	public Integer getNevercount() {
		return nevercount;
	}

	public void setNevercount(Integer nevercount) {
		this.nevercount = nevercount;
	}

	public Integer getLatecount() {
		return latecount;
	}

	public void setLatecount(Integer latecount) {
		this.latecount = latecount;
	}

	public Integer getEarlycount() {
		return earlycount;
	}

	public void setEarlycount(Integer earlycount) {
		this.earlycount = earlycount;
	}

	public Integer getComesign() {
		return comesign;
	}

	public void setComesign(Integer comesign) {
		this.comesign = comesign;
	}

	public Integer getBacksign() {
		return backsign;
	}

	public void setBacksign(Integer backsign) {
		this.backsign = backsign;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", uname=" + uname + ", upwd=" + upwd + ", nickname=" + nickname
				+ ", leaderid=" + leaderid + ", face=" + face + "]";
	}

}