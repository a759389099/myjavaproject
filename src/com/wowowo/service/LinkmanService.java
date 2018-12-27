package com.wowowo.service;

import com.wowowo.bean.CstCustomerVo;
import com.wowowo.bean.CstLinkman;
import com.wowowo.bean.CstLinkmanVo;
import com.wowowo.bean.PageBean;
import com.wowowo.bean.QueryVo;

public interface LinkmanService {

	void save(CstLinkman linkman);

	PageBean<CstLinkmanVo> getCustomerList(QueryVo queryvo);

	CstLinkmanVo selectByLkmId(Long lkmId);

	void update(CstLinkman linkman);

	void deleteByLkmId(Long lkmId);

}
