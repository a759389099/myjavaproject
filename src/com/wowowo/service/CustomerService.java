package com.wowowo.service;

import java.util.List;

import com.wowowo.bean.CountInfo;
import com.wowowo.bean.CstCustomer;
import com.wowowo.bean.CstCustomerVo;
import com.wowowo.bean.PageBean;
import com.wowowo.bean.QueryVo;

public interface CustomerService {

	PageBean<CstCustomerVo> getCustomerList(QueryVo vo);

	void insert(CstCustomer customer);

	CstCustomerVo selectByCustId(Long custId);

	void update(CstCustomer customer);

	void deleteByCustId(Long custId);

	List<CountInfo> countIndustry();

	List<CountInfo> countScource();


}
