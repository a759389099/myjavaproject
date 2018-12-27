package cn.zzpigt.service;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import cn.zzpigt.bean.Attendconfig;
import cn.zzpigt.bean.AttendconfigVo;
import cn.zzpigt.bean.User;
import cn.zzpigt.bean.UserAttendCountVo;
import cn.zzpigt.bean.UserAttendVo;

public interface AttendService {

	UserAttendVo getAttend(HttpSession session);

	void sign(HttpSession session) throws Exception;

	List<AttendconfigVo> getAttendConfig(HttpSession session);

	List<UserAttendCountVo> getcount(User user, String date);

}
