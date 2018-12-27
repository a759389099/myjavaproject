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
		
		// 1. 查记录总数
		int totalCount = customerMapper.countByExample(example);
		
		// 2. 封装pageBean
		PageBean<CstCustomerVo> pageBean = new PageBean<>(qvo.getPageNum(), qvo.getPageSize(), totalCount);
		
		// 把pagebean的参数放入example
		example.setOff(pageBean.getStartPage());
		example.setLen(pageBean.getPageSize());
		
		// 3. LIMIT查询
		List<CstCustomer> poList = customerMapper.selectByExample(example);
		List<CstCustomerVo> voList = new ArrayList<>();
		
		// 4. 把poList转成voList
		for (CstCustomer po : poList) {
			CstCustomerVo vo = new CstCustomerVo(po);
			// 查询数据库, 根据数据字典项ID查出数据字典对象, 设置进vo
			vo.setCustIndustry(baseDictMapper.selectByPrimaryKey(po.getCustIndustry()));
			vo.setCustSource(baseDictMapper.selectByPrimaryKey(po.getCustSource()));
			vo.setCustLevel(baseDictMapper.selectByPrimaryKey(po.getCustLevel()));
			
			voList.add(vo);
		}
		
		
		// 放到pagebean
		pageBean.setList(voList);
		
		// 4. 返回pagebean
		return pageBean;
	}

	@Override
	public void insert(CstCustomer customer) {
		customerMapper.insertSelective(customer);		
	}

	@Override
	public CstCustomerVo selectByCustId(Long custId) {
		//po转vo
		CstCustomer customerPo = customerMapper.selectByPrimaryKey(custId);
		CstCustomerVo vo=new CstCustomerVo(customerPo);
		//从客户列表中获取行业，来源，等级的id，去数据库数据字典表查询对应的数据字典对象
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
