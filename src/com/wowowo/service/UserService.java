package com.wowowo.service;

import java.util.List;

import com.wowowo.bean.PageBean;
import com.wowowo.bean.QueryVo;
import com.wowowo.bean.SysUser;
import com.wowowo.bean.SysUserVo;

public interface UserService {

	SysUser getUserByUnameandUpwd(SysUser sysUser)throws Exception;

	void regist(SysUser u) throws Exception;

	PageBean<SysUserVo> getUserList(QueryVo qvo);

	SysUserVo selectByUserId(Long userId);

	void updateUser(QueryVo qvo);

}
