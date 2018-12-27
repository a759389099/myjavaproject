package com.wowowo.service;

import java.util.List;

import com.wowowo.bean.PageBean;
import com.wowowo.bean.QueryVo;
import com.wowowo.bean.SysRole;

public interface SysRoleService {

	PageBean<SysRole> getRoleList(QueryVo qvo);

	void delete(Long roleId);

	List<SysRole> getRoleList2();

	void insert(SysRole role);

	SysRole selectByRoleId(Long roleId);

	void update(SysRole role);

}
