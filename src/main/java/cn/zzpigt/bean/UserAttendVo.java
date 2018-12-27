package cn.zzpigt.bean;

import java.util.List;

public class UserAttendVo {
    private User userid;

    private Attendconfig dutytype;

    private List<Attendduty> attenddutyList;
    
    
	public List<Attendduty> getAttenddutyList() {
		return attenddutyList;
	}

	public void setAttenddutyList(List<Attendduty> attenddutyList) {
		this.attenddutyList = attenddutyList;
	}

	public User getUserid() {
		return userid;
	}

	public void setUserid(User userid) {
		this.userid = userid;
	}

	public Attendconfig getDutytype() {
		return dutytype;
	}

	public void setDutytype(Attendconfig dutytype) {
		this.dutytype = dutytype;
	}

	@Override
	public String toString() {
		return "UserAttendVo [userid=" + userid + ", dutytype=" + dutytype + ", attenddutyList=" + attenddutyList + "]";
	}

    
   
}