package com.wowowo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wowowo.bean.BaseDict;
import com.wowowo.bean.BaseDictExample;
import com.wowowo.bean.BaseDictExample.Criteria;
import com.wowowo.mapper.BaseDictMapper;
import com.wowowo.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService {
	@Autowired
	private BaseDictMapper bm;

	@Override
	public List<BaseDict> getByTypeCode(String typeCode) {

		BaseDictExample baseDictExample = new BaseDictExample();
		Criteria criteria = baseDictExample.createCriteria();
		criteria.andDictTypeCodeEqualTo(typeCode);

		List<BaseDict> selectByExample = bm.selectByExample(baseDictExample);

		return selectByExample;
	}

}
