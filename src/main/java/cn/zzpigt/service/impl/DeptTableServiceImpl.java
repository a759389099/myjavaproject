package cn.zzpigt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zzpigt.bean.Department;
import cn.zzpigt.bean.PageBean;
import cn.zzpigt.bean.QueryVo;
import cn.zzpigt.bean.Role;
import cn.zzpigt.bean.RoleExample;
import cn.zzpigt.bean.User;
import cn.zzpigt.bean.UserRole;
import cn.zzpigt.bean.UserRoleExample;
import cn.zzpigt.bean.UserVo;
import cn.zzpigt.mybatis.mapper.DepartmentMapper;
import cn.zzpigt.mybatis.mapper.RoleMapper;
import cn.zzpigt.mybatis.mapper.UserMapper;
import cn.zzpigt.mybatis.mapper.UserRoleMapper;
import cn.zzpigt.service.DeptTableService;

@Service
public class DeptTableServiceImpl implements DeptTableService{


	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private UserMapper um;
	
	@Override
	public List<Department> getAllDepartment() {
		return departmentMapper.selectByExample(null);
	}
	
	@Override
	public PageBean<UserVo> getUserListOfDepartment(QueryVo vo) {
		List<UserVo> voList = new ArrayList<>();
		
		Integer departmentid = vo.getDepartment().getDepartmentid();
		//拿着部门id去角色表中查到所有的角色id
		RoleExample roleExample = new RoleExample();
		cn.zzpigt.bean.RoleExample.Criteria roleCriteria = roleExample.createCriteria();
		roleCriteria.andDepartmentidEqualTo(departmentid);
		
		List<Role> roleList = roleMapper.selectByExample(roleExample);
		//拿着这些角色id去用户角色表中查到对应的用户id
		for (Role role : roleList) {
			//每个角色对应着多个用户
			UserRoleExample userRoleExample = new UserRoleExample();
			cn.zzpigt.bean.UserRoleExample.Criteria userRoleCriteria = userRoleExample.createCriteria();
			userRoleCriteria.andRoleidEqualTo(role.getRoleid());
			
			List<UserRole> urList = userRoleMapper.selectByExample(userRoleExample);
			for (UserRole userRole : urList) {
				//更加这些用户id拿到用户po，最后po变Vo
				User user = um.selectByPrimaryKey(userRole.getUserid());
				//最后po变Vo
				UserVo userVo = new UserVo(user);
				//领导人的名字放进去
				userVo.setLeaderid(um.selectByPrimaryKey(user.getLeaderid()));
				//所属部门放进去
				userVo.setDepartment(departmentMapper.selectByPrimaryKey(departmentid));
				//所属角色，对应多个角色，是List
				UserRoleExample userRoleExample2 = new UserRoleExample();
				cn.zzpigt.bean.UserRoleExample.Criteria userRoleCriteria2 = userRoleExample2.createCriteria();
				userRoleCriteria2.andUseridEqualTo(user.getUserid());
				
				List<UserRole> urList2 = userRoleMapper.selectByExample(userRoleExample2);
				List<Role> rList = new ArrayList<>();
				for (UserRole userRole2 : urList2) {
					System.out.println(userRole2);
					rList.add(roleMapper.selectByPrimaryKey(userRole2.getRoleid()));
				}
				System.out.println(rList);
				userVo.setRoleList(rList);
				//最后这个vo对象放到volist中
				System.out.println(userVo);
				
				voList.add(userVo);
			}
			
		}
		
//		List<Integer> roleidList;
//		UserRoleExample ure = new UserRoleExample();
//		cn.zzpigt.bean.UserRoleExample.Criteria criteria = ure.createCriteria();
//		criteria.andRoleidIn(roleidList);
		
		
		//返回的就是拿到的userVo,没有分页功能，因为这不是一个表中拿到所有数据
		PageBean<UserVo> pageBean = new PageBean<>(vo.getPageNum(),vo.getPageSize(),voList.size());
		pageBean.setList(voList.subList(pageBean.getStart(), pageBean.getPageSize()+pageBean.getStart() < pageBean.getTotalCount()?pageBean.getStart()+pageBean.getPageSize():pageBean.getTotalCount()));
		
		for (UserVo vo2 : voList) {
			System.out.println("这是拿到了的uservo："+vo2);
		}
		return pageBean;
	}

	
}
