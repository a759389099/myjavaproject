package cn.zzpigt.bean;

public class AttendconfigVo {

	private Integer dutytype;

	private String dutyname;

	private String general;

	private String dutytime1;

	private String dutytime2;

	private String dutytime3;

	private String dutytime4;

	private String dutytime5;

	private String dutytime6;

	private String dutytype1;

	private String dutytype2;

	private String dutytype3;

	private String dutytype4;

	private String dutytype5;

	private String dutytype6;

	private String date;
	
	
	public AttendconfigVo() {
		
	}

	public AttendconfigVo(Attendconfig po) {
		super();
		this.dutytype = po.getDutytype();
		this.dutyname = po.getDutyname();
		this.general = po.getGeneral();
		this.dutytime1 =po.getDutytime1();
		this.dutytime2 = po.getDutytime2();
		this.dutytime3 = po.getDutytime3();
		this.dutytime4 = po.getDutytime4();
		this.dutytime5 = po.getDutytime5();
		this.dutytime6 = po.getDutytime6();
		this.dutytype1 = po.getDutytype1();
		this.dutytype2 = po.getDutytype2();
		this.dutytype3 = po.getDutytype3();
		this.dutytype4 = po.getDutytype4();
		this.dutytype5 = po.getDutytype5();
		this.dutytype6 = po.getDutytype6();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getDutytype() {
		return dutytype;
	}

	public void setDutytype(Integer dutytype) {
		this.dutytype = dutytype;
	}

	public String getDutyname() {
		return dutyname;
	}

	public void setDutyname(String dutyname) {
		this.dutyname = dutyname == null ? null : dutyname.trim();
	}

	public String getGeneral() {
		return general;
	}

	public void setGeneral(String general) {
		this.general = general == null ? null : general.trim();
	}

	public String getDutytime1() {
		return dutytime1;
	}

	public void setDutytime1(String dutytime1) {
		this.dutytime1 = dutytime1 == null ? null : dutytime1.trim();
	}

	public String getDutytime2() {
		return dutytime2;
	}

	public void setDutytime2(String dutytime2) {
		this.dutytime2 = dutytime2 == null ? null : dutytime2.trim();
	}

	public String getDutytime3() {
		return dutytime3;
	}

	public void setDutytime3(String dutytime3) {
		this.dutytime3 = dutytime3 == null ? null : dutytime3.trim();
	}

	public String getDutytime4() {
		return dutytime4;
	}

	public void setDutytime4(String dutytime4) {
		this.dutytime4 = dutytime4 == null ? null : dutytime4.trim();
	}

	public String getDutytime5() {
		return dutytime5;
	}

	public void setDutytime5(String dutytime5) {
		this.dutytime5 = dutytime5 == null ? null : dutytime5.trim();
	}

	public String getDutytime6() {
		return dutytime6;
	}

	public void setDutytime6(String dutytime6) {
		this.dutytime6 = dutytime6 == null ? null : dutytime6.trim();
	}

	public String getDutytype1() {
		return dutytype1;
	}

	public void setDutytype1(String dutytype1) {
		this.dutytype1 = dutytype1 == null ? null : dutytype1.trim();
	}

	public String getDutytype2() {
		return dutytype2;
	}

	public void setDutytype2(String dutytype2) {
		this.dutytype2 = dutytype2 == null ? null : dutytype2.trim();
	}

	public String getDutytype3() {
		return dutytype3;
	}

	public void setDutytype3(String dutytype3) {
		this.dutytype3 = dutytype3 == null ? null : dutytype3.trim();
	}

	public String getDutytype4() {
		return dutytype4;
	}

	public void setDutytype4(String dutytype4) {
		this.dutytype4 = dutytype4 == null ? null : dutytype4.trim();
	}

	public String getDutytype5() {
		return dutytype5;
	}

	public void setDutytype5(String dutytype5) {
		this.dutytype5 = dutytype5 == null ? null : dutytype5.trim();
	}

	public String getDutytype6() {
		return dutytype6;
	}

	public void setDutytype6(String dutytype6) {
		this.dutytype6 = dutytype6 == null ? null : dutytype6.trim();
	}

	@Override
	public String toString() {
		return "AttendconfigVo [dutytype=" + dutytype + ", dutyname=" + dutyname + ", general=" + general
				+ ", dutytime1=" + dutytime1 + ", dutytime2=" + dutytime2 + ", dutytime3=" + dutytime3 + ", dutytime4="
				+ dutytime4 + ", dutytime5=" + dutytime5 + ", dutytime6=" + dutytime6 + ", dutytype1=" + dutytype1
				+ ", dutytype2=" + dutytype2 + ", dutytype3=" + dutytype3 + ", dutytype4=" + dutytype4 + ", dutytype5="
				+ dutytype5 + ", dutytype6=" + dutytype6 + ", date=" + date + "]";
	}

}
