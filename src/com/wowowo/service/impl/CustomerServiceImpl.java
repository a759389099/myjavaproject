package com.wowowo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wowowo.bean.CstCustomerVo;
import com.wowowo.bean.CstLinkman;
import com.wowowo.bean.BaseDict;
import com.wowowo.bean.CountInfo;
import com.wowowo.bean.CstCustomer;
import com.wowowo.bean.CstCustomerExample;
import com.wowowo.bean.CstCustomerExample.Criteria;
import com.wowowo.bean.PageBean;
import com.wowowo.bean.QueryVo;
import com.wowowo.mapper.BaseDictMapper;
import com.wowowo.mapper.CstCustomerMapper;
import com.wowowo.mapper.CstLinkmanMapper;
import com.wowowo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CstCustomerMapper customerMapper;
	@Autowired
	private BaseDictMapper baseDictMapper;
	@Autowired
	private CstLinkmanMapper cstLinkmanMapper;

	@Override
	public PageBean<CstCustomerVo> getCustomerList(QueryVo qvo) {
		CstCustomerExample example = new CstCustomerExample();
		Criteria criteria = example.createCriteria();
		if(qvo != null && qvo.getCustomer() != null && qvo.getCustomer().getCustName() != null && qvo.getCustomer().getCustName().length() > 0){
			criteria.andCustNameLike("%" + qvo.getCustomer().getCustName() + "%");
		}
		
		// 1. ���¼����
		int totalCount = customerMapper.countByExample(example);
		
		// 2. ��װpageBean
		PageBean<CstCustomerVo> pageBean = new PageBean<>(qvo.getPageNum(), qvo.getPageSize(), totalCount);
		
		// ��pagebean�Ĳ�������example
		example.setOff(pageBean.getStartPage());
		example.setLen(pageBean.getPageSize());
		
		// 3. LIMIT��ѯ
		List<CstCustomer> poList = customerMapper.selectByExample(example);
		List<CstCustomerVo> voList = new ArrayList<>();
		
		// 4. ��poListת��voList
		for (CstCustomer po : poList) {
			CstCustomerVo vo = new CstCustomerVo(po);
			// ��ѯ���ݿ�, ���������ֵ���ID��������ֵ����, ���ý�vo
			vo.setCustIndustry(baseDictMapper.selectByPrimaryKey(po.getCustIndustry()));
			vo.setCustSource(baseDictMapper.selectByPrimaryKey(po.getCustSource()));
			vo.setCustLevel(baseDictMapper.selectByPrimaryKey(po.getCustLevel()));
			
			voList.add(vo);
		}
		
		
		// �ŵ�pagebean
		pageBean.setList(voList);
		
		// 4. ����pagebean
		return pageBean;
	}

	@Override
	public void insert(CstCustomer customer) {
		customerMapper.insertSelective(customer);		
	}

	@Override
	public CstCustomerVo selectByCustId(Long custId) {
		//poתvo
		CstCustomer customerPo = customerMapper.selectByPrimaryKey(custId);
		CstCustomerVo vo=new CstCustomerVo(customerPo);
		//�ӿͻ��б��л�ȡ��ҵ����Դ���ȼ���id��ȥ���ݿ������ֵ���ѯ��Ӧ�������ֵ����
		vo.setCustIndustry(baseDictMapper.selectByPrimaryKey(customerPo.getCustIndustry()));
		vo.setCustSource(baseDictMapper.selectByPrimaryKey(customerPo.getCustSource()));
		vo.setCustLevel(baseDictMapper.selectByPrimaryKey(customerPo.getCustLevel()));
		
		
		return vo;
	}

	@Override
	public void update(CstCustomer customer) {
		customerMapper.updateByPrimaryKeySelective(customer);
		
		
	}

	@Override
	public void deleteByCustId(Long custId) {
		
		customerMapper.deleteByPrimaryKey(custId);
		
	}

	@Override
	public List<CountInfo> countIndustry() {
		
		List<CountInfo> list = customerMapper.groupByIndustry();
		for (CountInfo countInfo : list) {
			System.out.println(countInfo.getFid()+"countInfo.getFid");
			BaseDict baseDict = baseDictMapper.selectByPrimaryKey(countInfo.getFid());
			countInfo.setDictItemName(baseDict.getDictItemName());
		}
		
		return list;
	}

	@Override
	public List<CountInfo> countScource() {
		List<CountInfo> list = customerMapper.groupBySource();
		for (CountInfo countInfo : list) {
			System.out.println(countInfo.getFid()+"countInfo.getFid");
			BaseDict baseDict = baseDictMapper.selectByPrimaryKey(countInfo.getFid());
			countInfo.setDictItemName(baseDict.getDictItemName());
		}
		
		return list;
	}

}
