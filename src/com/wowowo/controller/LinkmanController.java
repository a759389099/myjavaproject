package com.wowowo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wowowo.bean.CstCustomerVo;
import com.wowowo.bean.CstLinkman;
import com.wowowo.bean.CstLinkmanVo;
import com.wowowo.bean.PageBean;
import com.wowowo.bean.QueryVo;
import com.wowowo.service.LinkmanService;

@Controller
@RequestMapping("linkman")
public class LinkmanController {
	@Autowired
	private LinkmanService linkmanservice;
	//添加和修改公用一个action
	@RequestMapping("/addOrEdit.action")
	public String addOrEdit(CstLinkman linkman) {
		System.out.println(linkman);
		//根据是否携带联系人id判断是添加还是修改
		if(linkman.getLkmId()!=null){
			
			linkmanservice.update(linkman);
		}else{
			
			linkmanservice.save(linkman);
		}

		return "redirect:/linkman/list.action";

	}

	@RequestMapping("/list.action")

	public String list(QueryVo queryvo, Model model) {
		System.out.println(queryvo);
		PageBean<CstLinkmanVo> pageBean = linkmanservice.getCustomerList(queryvo);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("queryVo", queryvo);
		System.out.println(pageBean);
		return "forward:/jsp/linkman/list.jsp";
	}
	
	
	@RequestMapping("/toEdit.action")
	public String toEdit(Long lkmId, Model model){
		
		CstLinkmanVo linkmanvo=linkmanservice.selectByLkmId(lkmId);
		model.addAttribute("linkman", linkmanvo);
		return "/jsp/linkman/add.jsp";
	}
	
	
	@RequestMapping("/delete.action")
	public String delete(Long lkmId){
		
		linkmanservice.deleteByLkmId(lkmId);
		return "redirect:/linkman/list.action";
		
	}
}
