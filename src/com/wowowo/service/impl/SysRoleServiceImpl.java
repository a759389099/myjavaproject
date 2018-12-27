package com.wowowo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wowowo.bean.PageBean;
import com.wowowo.bean.QueryVo;
import com.wowowo.bean.SysRole;
import com.wowowo.bean.SysRoleExample;
import com.wowowo.bean.SysRoleExample.Criteria;
import com.wowowo.mapper.SysRoleMapper;
import com.wowowo.service.SysRoleService;
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleMapper roleMapper;
	
	
	@Override
	public PageBean<SysRole> getRoleList(QueryVo qvo) {
		SysRoleExample example = new SysRoleExample();

		if(qvo!=null && qvo.getRole()!=null&&qvo.getRole().getRoleName()!=null&&qvo.getRole().getRoleName().length()>0)
		{
			Criteria criteria = example.createCriteria();
			criteria.andRoleNameLike("%"+qvo.getRole().getRoleName()+"%");
		}
		int count = roleMapper.countByExample(example);
		PageBean<SysRole> pageBean=new PageBean<>(qvo.getPageNum(),qvo.getPageSize(),count);
		example.setOff(pageBean.getStartPage());
		example.setLen(pageBean.getPageSize());
		List<SysRole> list = roleMapper.selectByExample(example);
		
		pageBean.setList(list);
		return pageBean;
	}


	@Override
	public void delete(Long roleId) {
		roleMapper.deleteByPrimaryKey(roleId);		
	}
	
	//edit的查询方法
	@Override
	public List<SysRole> getRoleList2() {
		List<SysRole> list = roleMapper.selectByExample(null);
		return list;
	}


	@Override
	public void insert(SysRole role) {
		roleMapper.insertSelective(role);
	}


	@Override
	public SysRole selectByRoleId(Long roleId) {
		SysRole role = roleMapper.selectByPrimaryKey(roleId);
		return role;
	}


	@Override
	public void update(SysRole role) {
		roleMapper.updateByPrimaryKeySelective(role);
	}

}
