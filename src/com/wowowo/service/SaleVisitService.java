package com.wowowo.service;

import com.wowowo.bean.PageBean;
import com.wowowo.bean.QueryVo;
import com.wowowo.bean.SaleVisit;
import com.wowowo.bean.SaleVisitVo;

public interface SaleVisitService {

	void insert(SaleVisit sv);

	PageBean<SaleVisitVo> getSaleVisitList(QueryVo queryvo);

}
