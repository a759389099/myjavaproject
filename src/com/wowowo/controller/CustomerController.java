package com.wowowo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wowowo.bean.CountInfo;
import com.wowowo.bean.CstCustomer;
import com.wowowo.bean.CstCustomerVo;
import com.wowowo.bean.PageBean;
import com.wowowo.bean.QueryVo;
import com.wowowo.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private CustomerService cs;

	@RequestMapping(value = "list.action")
	public String list(QueryVo queryvo, Model model) {

		
		PageBean<CstCustomerVo> pageBean=cs.getCustomerList(queryvo);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("queryVo", queryvo);
		System.out.println(queryvo.getSelect());
		return "forward:/jsp/customer/list.jsp";

	}
	
	@RequestMapping(value = "add.action")
	public String list(CstCustomer customer) {
			cs.insert(customer);
		return "redirect:/customer/list.action";

	}

	@RequestMapping(value = "toEdit.action")
	public String toEdit(Long custId,Model model) {
			
			CstCustomerVo customer=cs.selectByCustId(custId);
			model.addAttribute("customer",customer);
			return "/jsp/customer/edit.jsp";
		}
		
	@RequestMapping(value = "edit.action")
	public String edit(CstCustomer customer) {
			cs.update(customer);
		return "redirect:/customer/list.action";

	}
	@RequestMapping(value = "delete.action")
	public String delete(Long custId) {
			cs.deleteByCustId(custId);
		return "redirect:/customer/list.action";

	}
	
@RequestMapping("/industryCount.action")
public String industryCount(Model model){
	
	List<CountInfo> list=cs.countIndustry();
	model.addAttribute("list", list);
	return "/jsp/statistic/industry.jsp";
}
	

@RequestMapping("/sourceCount.action")
public String sourceCount(Model model){
	
	List<CountInfo> list=cs.countScource();
	model.addAttribute("list", list);
	return "/jsp/statistic/source.jsp";
}
}
