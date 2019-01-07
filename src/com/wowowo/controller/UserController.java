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
			//���ɹ����ض��򵽵�¼ҳ��
			return "redirect:/login.jsp";
		} catch (Exception e) {
			//ע��ʧ�ܣ����쳣��ӡת����ע���jspҳ��
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
			//����service������ѯ
			SysUser u=us.getUserByUnameandUpwd(sysUser);
			//��¼�ɹ�,�Ͱ��û���id�ŵ�session��
			//��������ûд,�����û�ֱ�ӷ�����ҳʱ,��ʱû���ж��û��Ƿ��¼�ɹ�
			session.setAttribute("user",u);
			model.addAttribute("userId", u.getUserId());
			//ת������ҳ,Ϊ�˴���
			return "/index.jsp";
			
		} catch (Exception e) {
			//�����׽����service����쳣,��ô˵���û��������������,���Ƴ�session�е�uid
			//����:��ֹ��¼�ɹ����ٴε�¼,���ʧ�ܻ��ܽ�����ҳ,��ؼ�ƿ�
			session.removeAttribute("uid");
			//ģ�Ͷ�����Ӵ�����Ϣ
			model.addAttribute("error", e.getMessage());
			//Ĭ����ת��
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
		//��ȡ�û���ɫ����
		SysUserVo uservo=us.selectByUserId(userId);
		//��ȡ���еĽ�ɫ�б�
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
