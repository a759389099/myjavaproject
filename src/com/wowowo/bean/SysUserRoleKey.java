package com.wowowo.bean;

public class SysUserRoleKey {
    private Long roleId;

    private Long userId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public SysUserRoleKey(){
    	
    }
    
	public SysUserRoleKey(Long roleId, Long userId) {
		super();
		this.roleId = roleId;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "SysUserRoleKey [roleId=" + roleId + ", userId=" + userId + "]";
	}
    
    
    
}