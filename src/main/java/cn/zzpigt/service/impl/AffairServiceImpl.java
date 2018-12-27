package cn.zzpigt.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.zzpigt.bean.Affair;
import cn.zzpigt.bean.AffairExample;
import cn.zzpigt.bean.AffairVo;
import cn.zzpigt.bean.Affairchain;
import cn.zzpigt.bean.AffairchainExample;
import cn.zzpigt.bean.AffairchainVo;
import cn.zzpigt.bean.Affairmodel;
import cn.zzpigt.bean.AffairmodelExample;
import cn.zzpigt.bean.AffairmodelExample.Criteria;
import cn.zzpigt.bean.AffairmodelVo;
import cn.zzpigt.bean.Affairmodelitem;
import cn.zzpigt.bean.AffairmodelitemExample;
import cn.zzpigt.bean.AffairmodelitemVo;
import cn.zzpigt.bean.PageBean;
import cn.zzpigt.bean.QueryVo;
import cn.zzpigt.bean.User;
import cn.zzpigt.mybatis.mapper.AffairMapper;
import cn.zzpigt.mybatis.mapper.AffairchainMapper;
import cn.zzpigt.mybatis.mapper.AffairmodelMapper;
import cn.zzpigt.mybatis.mapper.AffairmodelitemMapper;
import cn.zzpigt.mybatis.mapper.UserMapper;
import cn.zzpigt.service.AffairService;

@Service
public class AffairServiceImpl implements AffairService {

	@Autowired
	private AffairmodelMapper aModelMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AffairmodelitemMapper affairModelitemMapper;
	@Autowired
	private AffairMapper affairMapper;
	@Autowired
	private AffairchainMapper affairchainMapper;

	@Override
	public PageBean<AffairmodelVo> getAffairmodelList(QueryVo vo,HttpSession session) {
		User user = (User) session.getAttribute("user");
		// 拿到所有的affairmodel表中的数据
		AffairmodelExample affairmodelExample = new AffairmodelExample();
		Criteria affairmodelCriteria = affairmodelExample.createCriteria();
		affairmodelCriteria.andUseridEqualTo(user.getUserid());
		
		//pageBean
		int count = aModelMapper.countByExample(affairmodelExample);
		PageBean<AffairmodelVo> pList = new PageBean<>(vo.getPageNum(), vo.getPageSize(), count);
		PageHelper.startPage(pList.getPageNum(), pList.getPageSize());// 分页插件
		List<Affairmodel> list = aModelMapper.selectByExample(affairmodelExample);
		List<AffairmodelVo> voList = new ArrayList<>();
		for (Affairmodel po : list) {//测试
			//po的Affairchain需要转一下
			String[] strArr = po.getAffairchain().split(",");
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<strArr.length; i++) {
				if(Integer.parseInt(strArr[i]) == -1){
					sb.append("本人");
				}else{
					User u = userMapper.selectByPrimaryKey(Integer.parseInt(strArr[i]));
					if(u != null && u.getNickname() != null){
						sb.append(u.getNickname());
					}
				}
				if(i < strArr.length-1){
					sb.append("->");
				}
			}
			AffairmodelVo affairmodelVo = new AffairmodelVo(po,sb.toString());
			affairmodelVo.setUserid(user);
			voList.add(affairmodelVo);
		}
		pList.setList(voList);
		for (AffairmodelVo affairmodelVo : voList) {
			System.out.println("打印测试一下volist每个affairmodelVo"+affairmodelVo);
		}
		return pList;
	}

	@Override
	public List<AffairmodelitemVo> getAffairmodelItemList(Integer affairmodelid) {
		AffairmodelitemExample affairmodelitemExample = new AffairmodelitemExample();
		cn.zzpigt.bean.AffairmodelitemExample.Criteria affairmodelitemcriteria = affairmodelitemExample.createCriteria();
		//去affairmodelitem表中用给的affairmodelid获得所有对应item
		affairmodelitemcriteria.andAffairmodelidEqualTo(affairmodelid);
		List<Affairmodelitem> affmoditemlist = affairModelitemMapper.selectByExample(affairmodelitemExample);
		if(affmoditemlist == null || affmoditemlist.size() == 0){
			return null;
		}
		List<AffairmodelitemVo> affmoditemvolist = new ArrayList<>();
		for (Affairmodelitem affairmodelitem : affmoditemlist) {
			//先用构造把po的对象传进去，除了list
			AffairmodelitemVo affairmodelitemVo = new AffairmodelitemVo(affairmodelitem);
			//拿出vo里的list
//			List<String> modelitemoption = affairmodelitem.getModelitemoption();
			//判断是否为空，我感觉有点问题
			if(affairmodelitem.getModelitemoption() !=null && affairmodelitem.getModelitemoption().length() > 0){
				//拿出原来po里的————飞机，火车，汽车
				String modelitemop = affairmodelitem.getModelitemoption();
				//逗号分隔，出来是数组
				List<String> optionList = new ArrayList<>();
				String[] modelitemopArr = modelitemop.split(",");
				if(modelitemopArr!=null&&modelitemopArr.length>0){
					//遍历把它放到vo里的list
					for (String string : modelitemopArr) {
						optionList.add(string);
					}
					affairmodelitemVo.setModelitemoption(optionList);
				}
			}
			affmoditemvolist.add(affairmodelitemVo);
		}
		for (AffairmodelitemVo affairmodelitemVo : affmoditemvolist) {
			System.out.println("affairmodelitemVo: "+affairmodelitemVo);
		}
		return affmoditemvolist;
	}

	@Override
	public Affairmodel getaffairmodelById(Integer affairmodelid) {
		Affairmodel affairmodel = aModelMapper.selectByPrimaryKey(affairmodelid);
		
		return affairmodel;
	}

	String[] chainArr;
	int indexCount=0;
	@Override
	public void saveAffair(String content, Integer modelid, HttpSession session) {
		User user = (User) session.getAttribute("user");
		//affair表新增记录:affairstate - 1(流程没走完)
		Affair affair = new Affair();
		affair.setAffaircontent(content);
		affair.setAffairmodelid(modelid);
		affair.setAffairstate((byte) 1);
		affair.setAffairtime(new Date());
		affair.setUserid(user.getUserid());
		affairMapper.insert(affair);
		
		System.out.println("insert后拿到自增的id:" + affair);
		//affair表中有modelid, 查到affairmodel表中affairchain 
		//(第一项是-1, 表示自己, 往后走一个就是第一个审批人)
		Affairmodel affairmodel = aModelMapper.selectByPrimaryKey(modelid);
		String affairchain = affairmodel.getAffairchain();
		//这里拿到下一个审批人的id
		chainArr = affairchain.split(",");
		
		Affairchain affairChain = new Affairchain();
		affairChain.setAffairchainorder((byte) 1);
		affairChain.setAffairchainstate((byte) 1);
		affairChain.setUserid(Integer.parseInt(chainArr[++indexCount]));
		affairChain.setAffairid(affair.getAffairid());
		affairchainMapper.insert(affairChain);
	}

	@Override
	public PageBean<Affair> getAffair(QueryVo vo, HttpSession session) {
		User user = (User) session.getAttribute("user");
		AffairExample affairExample = new AffairExample();
		cn.zzpigt.bean.AffairExample.Criteria affairCriteria = affairExample.createCriteria();
		affairCriteria.andUseridEqualTo(user.getUserid());
		
		int countOfAffair = affairMapper.countByExample(affairExample);
		PageBean<Affair> pageBean = new PageBean<>(vo.getPageNum(),vo.getPageSize(),countOfAffair);
		
		PageHelper.startPage(pageBean.getPageNum(), pageBean.getPageSize());// 分页插件
		List<Affair> affairList = affairMapper.selectByExample(affairExample);
		pageBean.setList(affairList);
		System.out.println("这里拿到的是已办事项的pagebean: "+ pageBean);
		return pageBean;
	}

	@Override
	public PageBean<AffairchainVo> getAffairchain(QueryVo vo, HttpSession session) {
		User user = (User) session.getAttribute("user");
		//去affairchain表中拿待办的事项，userid和state状态取
		AffairchainExample affairchainExample = new AffairchainExample();
		cn.zzpigt.bean.AffairchainExample.Criteria aChainCriteria = affairchainExample.createCriteria();
		aChainCriteria.andUseridEqualTo(user.getUserid());
		aChainCriteria.andAffairchainstateEqualTo((byte) 1);
		//这里是拿到所有需要待办的事项，所以affairchain表中的userid和state都要固定
		int countOfaffairchain = affairchainMapper.countByExample(affairchainExample);
		System.out.println("一共多少条数据："+countOfaffairchain);
		PageBean<AffairchainVo> pageBean = new PageBean<>(vo.getPageNum(), vo.getPageSize(), countOfaffairchain);
		System.out.println("pageBean :"+ pageBean);
		
		List<Affairchain> affairchainList = affairchainMapper.selectByExample(affairchainExample);
		List<AffairchainVo> voList = new ArrayList<>();
		for (Affairchain affairchain : affairchainList) {
			AffairchainVo aChainVo = new AffairchainVo(affairchain);
			Affair affId = affairMapper.selectByPrimaryKey(affairchain.getAffairid());
			Affairmodel affModel = aModelMapper.selectByPrimaryKey(affId.getAffairmodelid());
			aChainVo.setAffairid(affModel);
			voList.add(aChainVo);
		}
		
		pageBean.setList(voList);
		System.out.println("这是待办事项中需要的pageBean:"+pageBean);
		return pageBean;
	}

	@Override
	public AffairVo getAffairVoById(Integer affairchainid) {
		// 从affairchain表中去affair
		Affairchain affairchain = affairchainMapper.selectByPrimaryKey(affairchainid);
		Affair affair = affairMapper.selectByPrimaryKey(affairchain.getAffairid());
		System.out.println("vo");
		AffairVo affairVo = new AffairVo(affair);
		//去拿user
		User user = userMapper.selectByPrimaryKey(affair.getUserid());
		affairVo.setUserid(user);
		return affairVo;
	}

	@Override
	public void updateAffairchain(Affairchain affairchain) {
		// 判断审批是批准还是驳回
		affairchain.setAffairchaintime(new Date());
		affairchainMapper.updateByPrimaryKeySelective(affairchain);
		//更新完，拿到完整的affairchain
		affairchain = affairchainMapper.selectByPrimaryKey(affairchain.getAffairchainid());
		if(affairchain != null && affairchain.getAffairchainstate() != null){
			if(affairchain.getAffairchainstate() == 2){
				//批准--那么affairchain表中的affairChainstate改成2 还要判断是否还有下一个审批人
				if(indexCount < chainArr.length-1){
					//下一个审批人
					Affairchain nextAffairchain = new Affairchain();
					nextAffairchain.setAffairchainorder((byte) (affairchain.getAffairchainorder()+1));
					nextAffairchain.setAffairchainstate((byte) 1);
					nextAffairchain.setAffairid(affairchain.getAffairid());
					nextAffairchain.setUserid(Integer.parseInt(chainArr[++indexCount]));
					affairchainMapper.insertSelective(nextAffairchain);
				}else{
					//没有下一个审批人
					Affair affair = affairMapper.selectByPrimaryKey(affairchain.getAffairid());
					affair.setAffairstate((byte) 2);
					affairMapper.updateByPrimaryKeySelective(affair);
				}
				
			}else if (affairchain.getAffairchainstate() == 3){
				//驳回--那么affairchain表中的affairChainstate改成3 affair表中也变成3
				Affair affair = affairMapper.selectByPrimaryKey(affairchain.getAffairid());
				affair.setAffairstate((byte) 3);
				affairMapper.updateByPrimaryKeySelective(affair);
			}
		}
		
	}

}
