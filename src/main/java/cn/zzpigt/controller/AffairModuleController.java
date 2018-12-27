package cn.zzpigt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zzpigt.bean.QueryVo;
import cn.zzpigt.service.AffairmodelService;

@Controller
@RequestMapping("AffairModule")
public class AffairModuleController {
	
	@Autowired
	private AffairmodelService affairmodelService;
	
	@RequestMapping("/list.action")
	public String list(){
		return "/jsp/affairmodel/list.jsp";
	}
	
	
	@RequestMapping("/AffairModuleAdd.action")
	public String add(QueryVo vo, HttpSession session){
		System.out.println("AffairModule---vo:"+vo);
		System.out.println("AffairModule---list:"+vo.getAffairmodelitemList());
		
		affairmodelService.addAffairmodel(vo,session);
		
		return "/Affair/list.action";
	}
	
	

}
