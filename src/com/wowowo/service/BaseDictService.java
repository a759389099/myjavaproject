package com.wowowo.service;

import java.util.List;

import com.wowowo.bean.BaseDict;

public interface BaseDictService {

	List<BaseDict> getByTypeCode(String typeCode);

}
