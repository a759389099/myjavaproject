package cn.zzpigt.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.zzpigt.bean.Affair;
import cn.zzpigt.bean.AffairVo;
import cn.zzpigt.bean.Affairchain;
import cn.zzpigt.bean.AffairchainVo;
import cn.zzpigt.bean.Affairmodel;
import cn.zzpigt.bean.AffairmodelVo;
import cn.zzpigt.bean.AffairmodelitemVo;
import cn.zzpigt.bean.PageBean;
import cn.zzpigt.bean.QueryVo;

public interface AffairService {

	PageBean<AffairmodelVo> getAffairmodelList(QueryVo vo, HttpSession session);

	List<AffairmodelitemVo> getAffairmodelItemList(Integer affairmodelid);

	Affairmodel getaffairmodelById(Integer affairmodelid);

	void saveAffair(String content, Integer modelid, HttpSession session);

	PageBean<Affair> getAffair(QueryVo vo, HttpSession session);

	PageBean<AffairchainVo> getAffairchain(QueryVo vo, HttpSession session);

	AffairVo getAffairVoById(Integer affairchainid);

	void updateAffairchain(Affairchain affairchain);

}
