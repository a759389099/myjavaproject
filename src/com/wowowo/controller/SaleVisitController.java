package com.wowowo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wowowo.bean.CstCustomerVo;
import com.wowowo.bean.PageBean;
import com.wowowo.bean.QueryVo;
import com.wowowo.bean.SaleVisit;
import com.wowowo.bean.SaleVisitVo;
import com.wowowo.bean.SysUser;
import com.wowowo.service.SaleVisitService;

@Controller
@RequestMapping("salevisit")
public class SaleVisitController {

	@Autowired
	private SaleVisitService svs;

	@RequestMapping("/add.action")
	public String add(SaleVisit sv, HttpSession session) {
		SysUser u = (SysUser) session.getAttribute("user");
		sv.setVisitUserId(u.getUserId());
		System.out.println(sv);
		svs.insert(sv);
		return "redirect:/salevisit/list.action";

	}

	@RequestMapping("/list.action")
	public String list(QueryVo queryvo,Model model) {
		System.out.println(queryvo);
		PageBean<SaleVisitVo> pageBean=svs.getSaleVisitList(queryvo);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("queryVo", queryvo);
		System.out.println(pageBean);
		System.out.println(queryvo);
		return "/jsp/salevisit/list.jsp";

	}

}
