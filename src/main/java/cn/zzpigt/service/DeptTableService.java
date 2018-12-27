package cn.zzpigt.service;

import java.util.List;

import cn.zzpigt.bean.Department;
import cn.zzpigt.bean.PageBean;
import cn.zzpigt.bean.QueryVo;
import cn.zzpigt.bean.UserVo;

public interface DeptTableService {

	List<Department> getAllDepartment();
	
	PageBean<UserVo> getUserListOfDepartment(QueryVo vo);
	
}
