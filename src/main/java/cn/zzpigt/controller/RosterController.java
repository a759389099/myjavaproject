package cn.zzpigt.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Roster")
public class RosterController {
	
	@RequestMapping("/list.action")
	public void list(HttpServletResponse response){
		System.out.println("没有别拦截到啊！！！");
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write("假装这里是/Roster/list.action");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
