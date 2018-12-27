package com.wowowo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wowowo.bean.PageBean;
import com.wowowo.bean.QueryVo;
import com.wowowo.bean.SysRole;
import com.wowowo.service.SysRoleService;

@Controller
@RequestMapping("role")
public class RoleController {
	@Autowired
	private SysRoleService srs;
	
	@RequestMapping("/list.action")
	public String list(QueryVo qvo, Model model) {

		PageBean<SysRole> pageBean=srs.getRoleList(qvo);
		
		model.addAttribute("pageBean",pageBean);
		model.addAttribute("queryVo",qvo);
		return ("/jsp/system/rolelist.jsp");
	}
	@RequestMapping("/delete.action")
	public String delete(Long roleId) {

		srs.delete(roleId);
		return ("redirect:/role/list.action");
	}
	
	@RequestMapping("/addOrEditRole.action")
	public String add(SysRole role) {
		
		if(role.getRoleId()!=null){
			srs.update(role);
			
		}else{
			srs.insert(role);
		}
		return ("redirect:/role/list.action");
	}
	@RequestMapping("/toEdit.action")
	public String toEdit(Long roleId,Model model) {
		SysRole role=srs.selectByRoleId(roleId);
		model.addAttribute("role", role);
		return ("/jsp/system/addOrEditRole.jsp");
	}
	
	

}
