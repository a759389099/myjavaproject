package cn.zzpigt.bean;

import java.util.List;

public class MenuVo {
    private Integer menuid;

    private String menuname;

    private String menuurl;

    private Menu pid;
    
    private List<Menu> childList;
    
    public MenuVo(Menu po) {
		this.menuid = po.getMenuid();
		this.menuname = po.getMenuname();
		this.menuurl = po.getMenuurl();
	}

	public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public String getMenuurl() {
        return menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl == null ? null : menuurl.trim();
    }

	public Menu getPid() {
		return pid;
	}

	public void setPid(Menu pid) {
		this.pid = pid;
	}

	public List<Menu> getChildList() {
		return childList;
	}

	public void setChildList(List<Menu> childList) {
		this.childList = childList;
	}

	public MenuVo(Integer menuid, String menuname, String menuurl, Menu pid, List<Menu> childList) {
		super();
		this.menuid = menuid;
		this.menuname = menuname;
		this.menuurl = menuurl;
		this.pid = pid;
		this.childList = childList;
	}
	

}