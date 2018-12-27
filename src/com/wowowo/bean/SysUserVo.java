package com.wowowo.bean;

import java.util.Arrays;
import java.util.List;

public class SysUserVo {

	  	private Long userId;

	    private String userCode;

	    private String userName;

	    private String userPassword;

	    private String userState;

	    private List<SysRole> roleList;
	    

		public SysUserVo() {
	    	
	    }
	    
	    public SysUserVo(SysUser po) {
			super();
			this.userId = po.getUserId();
			this.userCode = po.getUserCode();
			this.userName = po.getUserName();
			this.userPassword = po.getUserPassword();
			this.userState = po.getUserState();
		}

		public List<SysRole> getRoleList() {
			return roleList;
		}

		public void setRoleList(List<SysRole> roleList) {
			this.roleList = roleList;
		}

		public Long getUserId() {
	        return userId;
	    }

	    public void setUserId(Long userId) {
	        this.userId = userId;
	    }

	    public String getUserCode() {
	        return userCode;
	    }

	    public void setUserCode(String userCode) {
	        this.userCode = userCode == null ? null : userCode.trim();
	    }

	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName == null ? null : userName.trim();
	    }

	    public String getUserPassword() {
	        return userPassword;
	    }

	    public void setUserPassword(String userPassword) {
	        this.userPassword = userPassword == null ? null : userPassword.trim();
	    }

	    public String getUserState() {
	        return userState;
	    }

	    public void setUserState(String userState) {
	        this.userState = userState == null ? null : userState.trim();
	    }

		@Override
		public String toString() {
			return "SysUserVo [userId=" + userId + ", userCode=" + userCode + ", userName=" + userName
					+ ", userPassword=" + userPassword + ", userState=" + userState + ", roleList=" + roleList
					+ "]";
		}
	
}
