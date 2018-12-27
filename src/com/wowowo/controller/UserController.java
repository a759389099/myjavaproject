package com.wowowo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wowowo.bean.PageBean;
import com.wowowo.bean.QueryVo;
import com.wowowo.bean.SysRole;
import com.wowowo.bean.SysUser;
import com.wowowo.bean.SysUserVo;
import com.wowowo.service.SysRoleService;
import com.wowowo.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService us;
	@Autowired
	private SysRoleService srs;
	
	
	
	@RequestMapping(value = "/regist.action")
	public String regist(SysUser u,Model model){
		try {
			us.regist(u);
			//逐层成功，重定向到登录页面
			return "redirect:/login.jsp";
		} catch (Exception e) {
			//注册失败，把异常打印转发到注册的jsp页面
			model.addAttribute("error", e.getMessage());
			return "/regist.jsp";
		}
		
	}
	
	
	@RequestMapping(value = "/login.action", method = RequestMethod.GET)
	public String login(HttpServletRequest request){
		return "/login.jsp"; 
	}
	
	
	
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(SysUser sysUser,HttpSession session,Model model) {
		
		try {
			//调用service方法查询
			SysUser u=us.getUserByUnameandUpwd(sysUser);
			//登录成功,就把用户的id放到session中
			//过滤器还没写,所以用户直接访问首页时,暂时没法判断用户是否登录成功
			session.setAttribute("user",u);
			model.addAttribute("userId", u.getUserId());
			//转发到首页,为了带参
			return "/index.jsp";
			
		} catch (Exception e) {
			//如果捕捉到了service层的异常,那么说明用户名或者密码错了,并移除session中的uid
			//功能:防止登录成功后再次登录,如果失败还能进入首页,有丶绕口
			session.removeAttribute("uid");
			//模型对象添加错误信息
			model.addAttribute("error", e.getMessage());
			//默认是转发
			return "/login.jsp";
			
		}
			
	}
	@RequestMapping("/list.action")
	public String list(QueryVo qvo,Model model){
		PageBean<SysUserVo> pageBean=us.getUserList(qvo);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("queryVo", qvo);
		System.out.println(pageBean);
		
		return "/jsp/system/userlist.jsp";
	}
	@RequestMapping("/toEdit.action")
	public String toEdit(Long userId,Model model){
		SysUserVo uservo=us.selectByUserId(userId);
		List<SysRole> list=srs.getRoleList2();
		model.addAttribute("user",uservo);
		model.addAttribute("allRole", list);
		System.out.println(uservo);
		return "/jsp/system/useredit.jsp";
	}
	
	
	@RequestMapping("/edit.action")
	public String edit(QueryVo qvo,Model model){
			us.updateUser(qvo);
		
		return "redirect:/user/list.action";
	}
	
	@RequestMapping("/exit.action")
	public String exit(HttpSession session){
		
		session.removeAttribute("user");
		return "redirect:/login.jsp";
	}

}
