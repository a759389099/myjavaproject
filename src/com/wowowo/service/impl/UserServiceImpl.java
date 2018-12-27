package com.wowowo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wowowo.bean.CstCustomerExample;
import com.wowowo.bean.PageBean;
import com.wowowo.bean.QueryVo;
import com.wowowo.bean.SysRole;
import com.wowowo.bean.SysUser;
import com.wowowo.bean.SysUserExample;
import com.wowowo.bean.SysUserExample.Criteria;
import com.wowowo.bean.SysUserRoleExample;
import com.wowowo.bean.SysUserRoleKey;
import com.wowowo.bean.SysUserVo;
import com.wowowo.mapper.SysRoleMapper;
import com.wowowo.mapper.SysUserMapper;
import com.wowowo.mapper.SysUserRoleMapper;
import com.wowowo.service.UserService;
import com.wowowo.utils.MD5Utils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SysUserMapper sm;
	
	@Autowired
	private SysUserRoleMapper surm;
	
	@Autowired
	private SysRoleMapper srm;

	@Override
	public SysUser getUserByUnameandUpwd(SysUser sysUser) throws Exception {
		// md5加密
		String md5 = MD5Utils.md5(sysUser.getUserPassword());
		sysUser.setUserPassword(md5);
		SysUserExample se = new SysUserExample();
		Criteria ca = se.createCriteria();
		// 单查一个用户名
		ca.andUserCodeEqualTo(sysUser.getUserCode());
		List<SysUser> list = sm.selectByExample(se);

		if (list.size() > 0 && list != null) {

			SysUser user = list.get(0);

			if (user.getUserPassword().equals(sysUser.getUserPassword())) {

				return user;
			} else {

				throw new Exception("密码错误");
			}

		} else {
			throw new Exception("用户名不存在");
		}

	}

	@Override
	public void regist(SysUser u) throws Exception {
		//创建查询对象
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		//把用户名放进查询对象
		criteria.andUserCodeEqualTo(u.getUserCode());
		//查询用户是否存在
		List<SysUser> list = sm.selectByExample(example);
		if (list != null && list.size() > 0) {
			//抛出异常给控制层处理
			throw new Exception("用户名已存在");
		} else {
			//注册
			u.setUserState("1");
			// md5加密
			String md5 = MD5Utils.md5(u.getUserPassword());
			u.setUserPassword(md5);
			sm.insertSelective(u);
		}
	}

	@Override
	public PageBean<SysUserVo> getUserList(QueryVo qvo) {
		
		SysUserExample example = new SysUserExample();
	
		if(qvo != null && qvo.getUser() != null && qvo.getUser().getUserCode() != null && qvo.getUser().getUserCode().length() > 0){
			Criteria criteria = example.createCriteria();
			criteria.andUserCodeLike("%" + qvo.getUser().getUserCode() + "%");
		}
		int count = sm.countByExample(example);
		
		PageBean<SysUserVo> pageBean =new PageBean<>(qvo.getPageNum(),qvo.getPageSize(),count);
		example.setOff(pageBean.getStartPage());
		example.setLen(pageBean.getPageSize());
		List<SysUser> userList = sm.selectByExample(example);
		List<SysUserVo> vo=new ArrayList<>();
		for (SysUser sysUser : userList) {
			SysUserRoleExample sure = new SysUserRoleExample();
			com.wowowo.bean.SysUserRoleExample.Criteria urcriteria = sure.createCriteria();
			urcriteria.andUserIdEqualTo(sysUser.getUserId());
			List<SysUserRoleKey> userRoleList = surm.selectByExample(sure);
			SysUserVo sysUserVo = new SysUserVo(sysUser);
			List<SysRole> roleList= new ArrayList<>();
			
			for (SysUserRoleKey sysUserRoleKey : userRoleList) {
				SysRole SysRole = srm.selectByPrimaryKey(sysUserRoleKey.getRoleId());
				roleList.add(SysRole);
			}
			sysUserVo.setRoleList(roleList);
			vo.add(sysUserVo);
		}
		
		pageBean.setList(vo);
		
		return pageBean;
	}

	@Override
	public SysUserVo selectByUserId(Long userId) {
		
		SysUser user = sm.selectByPrimaryKey(userId);
		SysUserRoleExample sure = new SysUserRoleExample();
		com.wowowo.bean.SysUserRoleExample.Criteria urcriteria = sure.createCriteria();
		urcriteria.andUserIdEqualTo(user.getUserId());
		List<SysUserRoleKey> userRoleList = surm.selectByExample(sure);
		SysUserVo sysUserVo = new SysUserVo(user);
		List<SysRole> roleList= new ArrayList<>();
		
		for (SysUserRoleKey sysUserRoleKey : userRoleList) {
			SysRole SysRole = srm.selectByPrimaryKey(sysUserRoleKey.getRoleId());
			roleList.add(SysRole);
		}
		sysUserVo.setRoleList(roleList);
		
		return sysUserVo;
	}

	@Override
	public void updateUser(QueryVo qvo) {
		System.out.println(qvo);
		Long userId = qvo.getUser().getUserId();
		//删除所有
		SysUserRoleExample example = new SysUserRoleExample();
		com.wowowo.bean.SysUserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		surm.deleteByExample(example);
		//插入选中的
		Long[] rId = qvo.getrId();
		if(rId!=null){
			for (Long long1 : rId) {
				surm.insertSelective(new SysUserRoleKey(long1,userId));
			}
		}

		//更新user
		sm.updateByPrimaryKeySelective(qvo.getUser());
		
	}

}
