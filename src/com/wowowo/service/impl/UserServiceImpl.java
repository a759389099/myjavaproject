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
		// md5����
		String md5 = MD5Utils.md5(sysUser.getUserPassword());
		sysUser.setUserPassword(md5);
		SysUserExample se = new SysUserExample();
		Criteria ca = se.createCriteria();
		// ����һ���û���
		ca.andUserCodeEqualTo(sysUser.getUserCode());
		List<SysUser> list = sm.selectByExample(se);

		if (list.size() > 0 && list != null) {

			SysUser user = list.get(0);

			if (user.getUserPassword().equals(sysUser.getUserPassword())) {

				return user;
			} else {

				throw new Exception("�������");
			}

		} else {
			throw new Exception("�û���������");
		}

	}

	@Override
	public void regist(SysUser u) throws Exception {
		//������ѯ����
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		//���û����Ž���ѯ����
		criteria.andUserCodeEqualTo(u.getUserCode());
		//��ѯ�û��Ƿ����
		List<SysUser> list = sm.selectByExample(example);
		if (list != null && list.size() > 0) {
			//�׳��쳣�����Ʋ㴦��
			throw new Exception("�û����Ѵ���");
		} else {
			//ע��
			u.setUserState("1");
			// md5����
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
		//ɾ������
		SysUserRoleExample example = new SysUserRoleExample();
		com.wowowo.bean.SysUserRoleExample.Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		surm.deleteByExample(example);
		//����ѡ�е�
		Long[] rId = qvo.getrId();
		if(rId!=null){
			for (Long long1 : rId) {
				surm.insertSelective(new SysUserRoleKey(long1,userId));
			}
		}

		//����user
		sm.updateByPrimaryKeySelective(qvo.getUser());
		
	}

}
