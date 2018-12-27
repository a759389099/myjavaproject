package com.wowowo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wowowo.bean.PageBean;
import com.wowowo.bean.QueryVo;
import com.wowowo.bean.SaleVisit;
import com.wowowo.bean.SaleVisitExample;
import com.wowowo.bean.SaleVisitExample.Criteria;
import com.wowowo.bean.SaleVisitVo;
import com.wowowo.mapper.CstCustomerMapper;
import com.wowowo.mapper.SaleVisitMapper;
import com.wowowo.mapper.SysUserMapper;
import com.wowowo.service.SaleVisitService;

@Service
public class SaleVisitServiceImpl implements SaleVisitService {
	@Autowired
	private SaleVisitMapper visitMapper;
	
	@Autowired
	private CstCustomerMapper customerMapper;
	
	@Autowired
	private SysUserMapper userMapper;

	@Override
	public void insert(SaleVisit sv) {
		visitMapper.insertSelective(sv);
	}

	@Override
	public PageBean<SaleVisitVo> getSaleVisitList(QueryVo queryvo) {
		
		SaleVisitExample saleVisitExample = new SaleVisitExample();
		
		if(queryvo!=null&&queryvo.getCustomer()!=null&&queryvo.getCustomer().getCustId()!=null&&queryvo.getCustomer().getCustId()>0)
		{
			Criteria criteria = saleVisitExample.createCriteria();
			criteria.andVisitCustIdEqualTo(queryvo.getCustomer().getCustId());
		}
		// 1. ���¼����
		int count = visitMapper.countByExample(saleVisitExample);
		// 2. ��װpageBean
		PageBean<SaleVisitVo> pageBean = new PageBean<>(queryvo.getPageNum(), queryvo.getPageSize(), count);
		// ��pagebean�Ĳ�������example
		saleVisitExample.setOff(pageBean.getStartPage());
		saleVisitExample.setLen(pageBean.getPageSize());
		// 3. LIMIT��ѯ
		List<SaleVisit> poList = visitMapper.selectByExample(saleVisitExample);
		List<SaleVisitVo> voList=new ArrayList<>();		
		// 4. ��poListת��voList
		for (SaleVisit po : poList) {
			
			SaleVisitVo vo= new	SaleVisitVo(po);
			vo.setCustomer(customerMapper.selectByPrimaryKey(po.getVisitCustId()));
			vo.setUser(userMapper.selectByPrimaryKey(po.getVisitUserId()));
			voList.add(vo);
		}
		//�ŵ�pagebean
		pageBean.setList(voList);
		return pageBean;
	}

}
