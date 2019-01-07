package cn.zzpigt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import cn.zzpigt.bean.AttendconfigVo;
import cn.zzpigt.bean.User;
import cn.zzpigt.bean.UserAttendCountVo;
import cn.zzpigt.bean.UserAttendVo;
import cn.zzpigt.service.AttendService;

@Controller
@RequestMapping("Attend")
public class AttendController {

	@Autowired
	private AttendService as;

	@RequestMapping("/count.action")
	public String count(String date, HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		List<UserAttendCountVo> list = as.getcount(user, date);
		model.addAttribute("list", list);
		model.addAttribute("date", date);
		return "/jsp/attend/count.jsp";
	}

	@RequestMapping("/list.action")
	public String list(HttpSession session, Model model) {
		UserAttendVo uavo = as.getAttend(session);
		System.out.println(uavo);
		model.addAttribute("uavo", uavo);
		return "/jsp/attend/signattend.jsp";
	}

	@RequestMapping(value="/sign.action", produces="application/json; charset=utf-8" )
	@ResponseBody
	public String sign(HttpSession session,HttpServletRequest request){
		try {
			String type = request.getParameter("type");
			//穿了用户id和type进来
			as.sign(session,type);
		} catch (Exception e) {
			String json = new Gson().toJson(e.getMessage());
			return json;
		}
		String json = new Gson().toJson("打卡成功");
		return json;
	}

	@RequestMapping("/myAttend.action")
	public String myattend(Model model, HttpSession session) {
		List<AttendconfigVo> config = as.getAttendConfig(session);
		model.addAttribute("config", config);
		return "/jsp/attend/myAttend.jsp";
	}

}
