package cn.zzpigt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zzpigt.bean.Affair;
import cn.zzpigt.bean.AffairVo;
import cn.zzpigt.bean.Affairchain;
import cn.zzpigt.bean.AffairchainVo;
import cn.zzpigt.bean.Affairmodel;
import cn.zzpigt.bean.AffairmodelVo;
import cn.zzpigt.bean.AffairmodelitemVo;
import cn.zzpigt.bean.PageBean;
import cn.zzpigt.bean.QueryVo;
import cn.zzpigt.service.AffairService;

@Controller
@RequestMapping("Affair")
public class AffairController {
	
	@Autowired
	private AffairService affairService;
	
	@RequestMapping("/nextDo.action")
	public String nextDo(Affairchain affairchain){
		System.out.println("审批提交上来的affairchain：" +affairchain);
		affairService.updateAffairchain(affairchain);
		return "/Affair/needDoList.action";
	}
	
	@RequestMapping("/doList.action")
	public String doList(Integer affairchainid, Model model){	
		System.out.println("affairchainid"+ affairchainid);
		AffairVo vo = affairService.getAffairVoById(affairchainid);
		model.addAttribute("vo", vo);
		model.addAttribute("affairchainid", affairchainid);
		System.out.println("zhe shi vo :"+vo);
		return "/jsp/affair/doList.jsp";
	}
	
	@RequestMapping("/needDoList.action")
	public String needDoList(QueryVo vo, HttpSession session, Model model){	
		PageBean<AffairchainVo> pageBean = affairService.getAffairchain(vo,session);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("queryVo", vo);
		return "/jsp/affair/needDoList.jsp";
	}
	
	
	@RequestMapping("/doneList.action")
	public String doneList(QueryVo vo, HttpSession session, Model model){	
		PageBean<Affair> pageBean = affairService.getAffair(vo,session);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("queryVo", vo);
		return "/jsp/affair/doneList.jsp";
	}
	
	
	@RequestMapping("/edit.action")
	@ResponseBody
	public String edit(HttpSession session,@RequestParam ("affaircontent") String content, @RequestParam ("affairmodelid") Integer modelid){
		affairService.saveAffair(content, modelid, session);
		return null;
	}

	
	@RequestMapping("/toEdit.action")
	public String toEdit(Integer affairmodelid, Model model){
		System.out.println("点击公文模版编写：affairmodelid:"+affairmodelid);
		Affairmodel affairmodel = affairService.getaffairmodelById(affairmodelid);
		List<AffairmodelitemVo> list = affairService.getAffairmodelItemList(affairmodelid);
		System.out.println("affairmodel:"+affairmodel);
		System.out.println("list:"+list);
		model.addAttribute("list", list);
		model.addAttribute("affairmodel", affairmodel);
		return "/jsp/affair/form.jsp";
	}
	
	@RequestMapping("/list.action")
	public String list(QueryVo vo, Model model, HttpSession session){
		//这里加入session,是设计成，有权限的人才能设计公文和删除公文，
		//所以拿到的也是个人自己设计的公文模版
		System.out.println("进入了Affaircontroller了");
		PageBean<AffairmodelVo> pageBean = affairService.getAffairmodelList(vo,session);
		model.addAttribute("pageBean", pageBean);
		return "/jsp/affair/list.jsp";
	}
	
	

}
