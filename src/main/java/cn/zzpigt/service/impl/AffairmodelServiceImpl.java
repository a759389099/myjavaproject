package cn.zzpigt.service.impl;

import javax.servlet.http.HttpSession;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zzpigt.bean.AffairmodelExample;
import cn.zzpigt.bean.AffairmodelExample.Criteria;
import cn.zzpigt.bean.Affairmodelitem;
import cn.zzpigt.bean.QueryVo;
import cn.zzpigt.bean.User;
import cn.zzpigt.mybatis.mapper.AffairmodelMapper;
import cn.zzpigt.mybatis.mapper.AffairmodelitemMapper;
import cn.zzpigt.service.AffairmodelService;

@Service
public class AffairmodelServiceImpl implements AffairmodelService {
	
	@Autowired
	private AffairmodelMapper affairmodelMapper;
	@Autowired
	private AffairmodelitemMapper affairitemMapper;
	
	@Override
	public void addAffairmodel(QueryVo vo, HttpSession session) {
		User user = (User)session.getAttribute("user");
		vo.getAffairmodel().setUserid(user.getUserid());
		affairmodelMapper.insert(vo.getAffairmodel());
		
		Integer affairmodelid = vo.getAffairmodel().getAffairmodelid();
		for (Affairmodelitem aItem : vo.getAffairmodelitemList()) {
			aItem.setAffairmodelid(affairmodelid);
			affairitemMapper.insert(aItem);
		}
	}

}
