package cn.zzpigt.service.impl;

import cn.zzpigt.bean.Menu;
import cn.zzpigt.bean.MenuExample;
import cn.zzpigt.bean.MenuVo;
import cn.zzpigt.bean.Operate;
import cn.zzpigt.bean.OperateExample;
import cn.zzpigt.bean.PageBean;
import cn.zzpigt.bean.PermissionMenu;
import cn.zzpigt.bean.PermissionMenuExample;
import cn.zzpigt.bean.PermissionOperate;
import cn.zzpigt.bean.PermissionOperateExample;
import cn.zzpigt.bean.QueryVo;
import cn.zzpigt.bean.Role;
import cn.zzpigt.bean.RoleExample;
import cn.zzpigt.bean.RolePermission;
import cn.zzpigt.bean.RolePermissionExample;
import cn.zzpigt.bean.User;
import cn.zzpigt.bean.UserExample;
import cn.zzpigt.bean.UserExample.Criteria;
import cn.zzpigt.bean.UserRole;
import cn.zzpigt.bean.UserRoleExample;
import cn.zzpigt.bean.UserVo;
import cn.zzpigt.mybatis.mapper.DepartmentMapper;
import cn.zzpigt.mybatis.mapper.MenuMapper;
import cn.zzpigt.mybatis.mapper.OperateMapper;
import cn.zzpigt.mybatis.mapper.PermissionMenuMapper;
import cn.zzpigt.mybatis.mapper.PermissionOperateMapper;
import cn.zzpigt.mybatis.mapper.RoleMapper;
import cn.zzpigt.mybatis.mapper.RolePermissionMapper;
import cn.zzpigt.mybatis.mapper.UserMapper;
import cn.zzpigt.mybatis.mapper.UserRoleMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zzpigt.service.UserService;
import cn.zzpigt.utils.MD5Utils;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper um;
	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	@Autowired
	private PermissionMenuMapper permissionMenuMapper;
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private PermissionOperateMapper perOperateMapper;
	@Autowired
	private OperateMapper operateMapper;

	@Override
	public String getCode() {

		String str = "";
		char[] ch = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
				'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
				'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
				'z' };
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			char num = ch[random.nextInt(ch.length)];
			str += num;
		}
		System.out.println(str);
		return str;

	}

	@Override
	public User checkUserAndCode(QueryVo vo,HttpSession session) throws Exception {
		if (session.getAttribute("code") == null ) {
			throw new Exception("验证码为空");
		} 
		if(!session.getAttribute("code").toString().toLowerCase().equals(vo.getCode().toLowerCase())){
			throw new Exception("验证码错误");
		}
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUnameEqualTo(vo.getUser().getUname());
		List<User> list = um.selectByExample(example);

		if (list != null && list.size() > 0) {
			User user = list.get(0);
			String upwd = vo.getUser().getUpwd();
			String md5 = MD5Utils.md5(upwd);
			if (user.getUpwd().equals(md5)) {
				return user;
			} else {
				throw new Exception("密码错误");
			}
		} else {
			throw new Exception("用户名不存在");

		}

	}

	

	@Override
	public List<MenuVo> getMenuVo(User user) {
		System.out.println("user"+user);
//		登陆成功后，根据用户id查询该用户的所有角色id（用户角色表）
		List<Integer> permissionidList = getPerListByUserid(user.getUserid());
//		根据所有权限id查询所有菜单id（权限菜单表）
		PermissionMenuExample permissionMenuExample = new PermissionMenuExample();
		cn.zzpigt.bean.PermissionMenuExample.Criteria permissMenuCriteria = permissionMenuExample.createCriteria();
		permissMenuCriteria.andPermissionidIn(permissionidList);
		List<PermissionMenu> permenuList = permissionMenuMapper.selectByExample(permissionMenuExample);
		List<Integer> menuidList = new ArrayList<>();
		if(permenuList == null || permenuList.size() == 0){
			return null;
		}
		for (PermissionMenu pm : permenuList) {
			menuidList.add(pm.getMenuid());
		}
		System.out.println("所有菜单id"+menuidList);
//		根据所有菜单id查询菜单信息（菜单表）
//		菜单信息PO -> VO（内部包含自己的List）
		List<MenuVo> list = new ArrayList<>();
		for (Integer menuid : menuidList) {
			//根据id查到这个menu
			Menu menu = menuMapper.selectByPrimaryKey(menuid);
			MenuVo menuVo = new MenuVo(menu);
			//vo中的pid父菜单
			menuVo.setPid(menuMapper.selectByPrimaryKey(menu.getPid()));
			//list中的子菜单
			MenuExample menuExample = new MenuExample();
			cn.zzpigt.bean.MenuExample.Criteria menuCriteria = menuExample.createCriteria();
			menuCriteria.andPidEqualTo(menuid);
			List<Menu> childList = menuMapper.selectByExample(menuExample);
			menuVo.setChildList(childList);
			list.add(menuVo);
		}
		for (MenuVo menuVo : list) {
			System.out.println("这是menuvo测试循环: "+menuVo);
		}
		return list;
	}

	@Override
	public List<String> getPermissionOp(User user) {
//		从session取出用户id，用户id查询该用户的所有角色id（用户角色表）
//		根据所有角色id查询所有权限id（角色权限表）
		List<Integer> permissionidList = getPerListByUserid(user.getUserid());
//		根据所有权限id查询所有操作id（权限操作表）
		PermissionOperateExample permissionOperateExample = new PermissionOperateExample();
		cn.zzpigt.bean.PermissionOperateExample.Criteria perOperateCriteria = permissionOperateExample.createCriteria();
		perOperateCriteria.andPermissionidIn(permissionidList);
		
		List<PermissionOperate> perOperateList = perOperateMapper.selectByExample(permissionOperateExample);
		List<Integer> operateidList = new ArrayList<>();
		if(perOperateList == null || perOperateList.size() == 0){
			return null;
		}
		for (PermissionOperate permissionOperate : perOperateList) {
			operateidList.add(permissionOperate.getOperateid());
		}
//		根据所有操作id查询操作信息（操作表）
		OperateExample operateExample = new OperateExample();
		cn.zzpigt.bean.OperateExample.Criteria operaterCriteria = operateExample.createCriteria();
		operaterCriteria.andOperateidIn(operateidList);
		
		List<Operate> operateList = operateMapper.selectByExample(operateExample);
		List<String> operateActionList = new ArrayList<>();
		for (Operate operate : operateList) {
			operateActionList.add(operate.getOperateaction());
		}
		System.out.println("operateActionList"+operateActionList);
		return operateActionList;
	}

	private List<Integer> getPerListByUserid(Integer userid) {
		UserRoleExample userRoleExample = new UserRoleExample();
		cn.zzpigt.bean.UserRoleExample.Criteria userRoleCriteria = userRoleExample.createCriteria();
		userRoleCriteria.andUseridEqualTo(userid);
		List<UserRole> userRoleList = userRoleMapper.selectByExample(userRoleExample);
		List<Integer> roleidList = new ArrayList<>();
		if(userRoleList == null || userRoleList.size() == 0){
			return null;
		}
		for (UserRole userRole : userRoleList) {
			roleidList.add(userRole.getRoleid());
		}
		System.out.println("所有角色id"+roleidList);
//		根据所有角色id查询所有权限id（角色权限表）
		RolePermissionExample rolePermissionExample = new RolePermissionExample();
		cn.zzpigt.bean.RolePermissionExample.Criteria roleperCriteria = rolePermissionExample.createCriteria();
		roleperCriteria.andRoleidIn(roleidList);
		List<RolePermission> roleperList = rolePermissionMapper.selectByExample(rolePermissionExample);
		List<Integer> permissionidList = new ArrayList<>();
		if(roleperList == null || roleperList.size() == 0){
			return null;
		}
		for (RolePermission rp : roleperList) {
			permissionidList.add(rp.getPermissionid());
		}
		System.out.println("所有权限id"+permissionidList);
		return permissionidList;
	}


}
