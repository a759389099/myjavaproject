package com.wowowo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.wowowo.bean.BaseDict;
import com.wowowo.service.BaseDictService;

@Controller
@RequestMapping("basedict")
public class BaseDictController {
	
	@Autowired
	private BaseDictService bs;

	@RequestMapping(value = "list.action", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String list(String typeCode) {

		List<BaseDict> list=bs.getByTypeCode(typeCode);
		String json = new Gson().toJson(list);
		System.out.println(json);
		return json;
		
	}

}
