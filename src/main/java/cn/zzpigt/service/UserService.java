package cn.zzpigt.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.zzpigt.bean.MenuVo;
import cn.zzpigt.bean.PageBean;
import cn.zzpigt.bean.QueryVo;
import cn.zzpigt.bean.User;
import cn.zzpigt.bean.UserVo;

public interface UserService {

	String getCode();

	User checkUserAndCode(QueryVo vo, HttpSession session) throws Exception;

	List<MenuVo> getMenuVo(User user);

	List<String> getPermissionOp(User user);

}
