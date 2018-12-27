package com.wowowo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wowowo.bean.CstCustomer;
import com.wowowo.bean.CstLinkman;
import com.wowowo.bean.CstLinkmanExample;
import com.wowowo.bean.CstLinkmanExample.Criteria;
import com.wowowo.bean.CstLinkmanVo;
import com.wowowo.bean.PageBean;
import com.wowowo.bean.QueryVo;
import com.wowowo.mapper.CstCustomerMapper;
import com.wowowo.mapper.CstLinkmanMapper;
import com.wowowo.service.LinkmanService;

@Service
public class LinkmanServiceImpl implements LinkmanService {
	@Autowired
	private CstLinkmanMapper linkmanMapper;
	
	@Autowired
	private CstCustomerMapper customMapper;

	@Override
	public void save(CstLinkman linkman) {
		linkmanMapper.insertSelective(linkman);
	}

	@Override
	public PageBean<CstLinkmanVo> getCustomerList(QueryVo qvo) {
		
		CstLinkmanExample example = new CstLinkmanExample();
		Criteria criteria = example.createCriteria();
		if(qvo != null && qvo.getLinkman() != null && qvo.getLinkman().getLkmName() != null && qvo.getLinkman().getLkmName().length() > 0){
			criteria.andLkmNameLike("%" + qvo.getLinkman().getLkmName() + "%");
		}
		
		// 1. 查记录总数
		int totalCount = linkmanMapper.countByExample(example);
		// 2. 封装pageBean
		PageBean<CstLinkmanVo> pageBean = new PageBean<>(qvo.getPageNum(), qvo.getPageSize(), totalCount);
		
		// 把pagebean的参数放入example
		example.setOff(pageBean.getStartPage());
		example.setLen(pageBean.getPageSize());
		
		// 3. LIMIT查询
		List<CstLinkman> poList = linkmanMapper.selectByExample(example);
		System.out.println(poList);
		List<CstLinkmanVo> voList = new ArrayList<>();
		
		// 4. 把poList转成voList
		for (CstLinkman po : poList) {
			CstLinkmanVo vo = new CstLinkmanVo(po);
			
			// 查询数据库, 根据数据字典项ID查出数据字典对象, 设置进vo
			vo.setLkmCustomer(customMapper.selectByPrimaryKey(po.getLkmCustId()));
			
			voList.add(vo);
		}
		// 放到pagebean
		pageBean.setList(voList);
		
		// 4. 返回pagebean
		return pageBean;
		
	}

	@Override
	public CstLinkmanVo selectByLkmId(Long lkmId) {
		
		CstLinkman linkman = linkmanMapper.selectByPrimaryKey(lkmId);
		CstLinkmanVo vo=new CstLinkmanVo(linkman);
		vo.setLkmCustomer(customMapper.selectByPrimaryKey(linkman.getLkmCustId()));
		
		return vo;
	}

	@Override
	public void update(CstLinkman linkman) {
		//用来测试updateselective
		if(linkman.getLkmPhone().length()<=0){
			linkman.setLkmPhone(null);
		}
		System.out.println(linkman);
		linkmanMapper.updateByPrimaryKeySelective(linkman);
		//linkmanMapper.updateByPrimaryKey(linkman);
	}

	@Override
	public void deleteByLkmId(Long lkmId) {
		linkmanMapper.deleteByPrimaryKey(lkmId);
		
		
		
	}

}
