package cn.zzpigt.service;

import javax.servlet.http.HttpSession;

import cn.zzpigt.bean.QueryVo;

public interface AffairmodelService {

	void addAffairmodel(QueryVo vo, HttpSession session);

}
