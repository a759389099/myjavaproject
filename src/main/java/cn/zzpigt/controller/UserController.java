package cn.zzpigt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.zzpigt.bean.MenuVo;
import cn.zzpigt.bean.PageBean;
import cn.zzpigt.bean.QueryVo;
import cn.zzpigt.bean.User;
import cn.zzpigt.bean.UserVo;
import cn.zzpigt.service.UserService;


@Controller
@RequestMapping("User")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@RequestMapping(value="/login.action", method=RequestMethod.GET)
	public String login(){
		System.out.println("get方式进入！");
		return "redirect:/login.jsp";
	}
	
	
	@RequestMapping(value="/login.action", method=RequestMethod.POST)
	public String login(QueryVo vo,HttpSession session, Model model){
		System.out.println(vo);
		try {
			//去业务逻辑层判断数据是否正确 
			User user = us.checkUserAndCode(vo, session);
			//权限认证，返回的是菜单信息
			List<MenuVo> list = us.getMenuVo(user); 
			System.out.println("list:"+list);
			//授权，返回List<String>
			List<String> perActionList = us.getPermissionOp(user);
			//登入成功后，进入main.jsp页面
			session.setAttribute("perActionList", perActionList);
			session.setAttribute("list", list);
			session.setAttribute("user", user);
			return "redirect:/main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("queryVo", vo);
			model.addAttribute("errorMeg", e.getMessage());
			return "/login.jsp";
		}
	}

	@RequestMapping(value="/checkCode.action", produces="application/json; charset=utf-8")
	@ResponseBody
	public String checkCode(HttpSession session){
		System.out.println("checkCode");
		session.removeAttribute("user");
		//在业务逻辑层拿到随机的Code
		String code = us.getCode();
		//把这code放到session中保存，后面登入判断需要，key==code
		if(session.getAttribute("code") != null){
			session.removeAttribute("code");
		}
		session.setAttribute("code", code);
		
		String json = new Gson().toJson(code);
		return json;
	}
	
}
