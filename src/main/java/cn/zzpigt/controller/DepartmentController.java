package cn.zzpigt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Department")
public class DepartmentController {
	
@RequestMapping("list.action")
public String list(){
	return null;
}
}
