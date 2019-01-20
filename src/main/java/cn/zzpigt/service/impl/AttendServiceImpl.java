package cn.zzpigt.service.impl;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zzpigt.bean.Attendconfig;
import cn.zzpigt.bean.AttendconfigExample;
import cn.zzpigt.bean.AttendconfigVo;
import cn.zzpigt.bean.Attendduty;
import cn.zzpigt.bean.AttenddutyExample;
import cn.zzpigt.bean.Department;
import cn.zzpigt.bean.DepartmentExample;
import cn.zzpigt.bean.User;
import cn.zzpigt.bean.UserAttend;
import cn.zzpigt.bean.UserAttendCountVo;
import cn.zzpigt.bean.UserAttendExample;
import cn.zzpigt.bean.UserAttendExample.Criteria;
import cn.zzpigt.bean.UserAttendVo;
import cn.zzpigt.bean.UserExample;
import cn.zzpigt.mybatis.mapper.AttendconfigMapper;
import cn.zzpigt.mybatis.mapper.AttenddutyMapper;
import cn.zzpigt.mybatis.mapper.DepartmentMapper;
import cn.zzpigt.mybatis.mapper.UserAttendMapper;
import cn.zzpigt.mybatis.mapper.UserMapper;
import cn.zzpigt.service.AttendService;
import cn.zzpigt.utils.DateUtil;

@Service
public class AttendServiceImpl implements AttendService {

	@Autowired
	private UserAttendMapper uam;
	@Autowired
	private AttendconfigMapper acm;
	@Autowired
	private AttenddutyMapper adm;
	@Autowired
	private UserMapper um;
	@Autowired
	private DepartmentMapper dm;

	@Override
	public UserAttendVo getAttend(HttpSession session) {

		User user = (User) session.getAttribute("user");
		UserAttendVo userAttendVo = new UserAttendVo();
		userAttendVo.setUserid(user);
		UserAttendExample userAttendExample = new UserAttendExample();
		Criteria uaCriteria = userAttendExample.createCriteria();
		uaCriteria.andUseridEqualTo(user.getUserid());
		// 获取用户排版表
		List<UserAttend> userattendList = uam.selectByExample(userAttendExample);
		if (userattendList == null || userattendList.size() == 0) {
			return null;
		}
		UserAttend userAttend = userattendList.get(0);
		// 获取该用户的具体班次信息
		Attendconfig attendConfig = acm.selectByPrimaryKey(userAttend.getDutytype());
		userAttendVo.setDutytype(attendConfig);

		AttenddutyExample attenddutyExample = new AttenddutyExample();
		cn.zzpigt.bean.AttenddutyExample.Criteria adCriteria = attenddutyExample.createCriteria();
		adCriteria.andUseridEqualTo(user.getUserid());
		// 获取用户所有的打卡记录
		List<Attendduty> attenddutyList = adm.selectByExample(attenddutyExample);
		// 获取今天的打卡记录
		List<Attendduty> myList = new ArrayList<>();
		for (Attendduty attendduty : attenddutyList) {

			Date currentDate = new Date();
			SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
			String today = day.format(currentDate);
			String allDay = day.format(attendduty.getRegistertime());
			if (today.equals(allDay)) {
				myList.add(attendduty);
			}

		}
		// 按照上下班顺序排序
		Collections.sort(myList, new Comparator<Attendduty>() {
			@Override
			public int compare(Attendduty o1, Attendduty o2) {
				return Integer.parseInt(o1.getRegistertype()) - Integer.parseInt(o2.getRegistertype());
			}
		});
		System.out.println(myList);
		userAttendVo.setAttenddutyList(myList);

		return userAttendVo;
	}

	@Override
	public void sign(HttpSession session, String type) throws Exception {
		// 周末周日排除
		Date currentDate = new Date();
		SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
		// 用id查班次类型
		User user = (User) session.getAttribute("user");
		UserAttendExample userAttendExample = new UserAttendExample();
		Criteria uaCriteria = userAttendExample.createCriteria();
		uaCriteria.andUseridEqualTo(user.getUserid());
		// 联合主键,虽然是一对一,但是不能用查主键的方式
		List<UserAttend> userattendList = uam.selectByExample(userAttendExample);
		// 检查班次是否存在，没有说明，没有该用户的排班,前端已做处理
		if (userattendList == null || userattendList.size() == 0) {
			System.out.println("没有该用户的排班");
			throw new Exception("没有该用户的排班");
		}

		// 根据id拿到签到表
		AttenddutyExample attenddutyExample = new AttenddutyExample();
		cn.zzpigt.bean.AttenddutyExample.Criteria adCriteria = attenddutyExample.createCriteria();
		adCriteria.andUseridEqualTo(user.getUserid());
		Integer userattend = userattendList.get(0).getDutytype();
		Attendconfig attendconfig = acm.selectByPrimaryKey(userattend);
		String[] split = attendconfig.getGeneral().split(",");
		// 根据attendconfig表数据库general字段判断休息日
		Calendar today = Calendar.getInstance();
		today.setTime(currentDate);
		for (int i = 0; i < split.length; i++) {
			if (today.get(Calendar.DAY_OF_WEEK) != Integer.parseInt(split[i]) + 1) {
				throw new Exception("本日为假期！");
			}
		}
		// 反射调用set方法 datetime1，2，3，4
		Method method = attendconfig.getClass().getDeclaredMethod("getDutytime" + type);
		String dutyTime = (String) method.invoke(attendconfig);
		Attendduty attendduty = new Attendduty();
		// 要求时间
		String todayString = hour.format(currentDate);
		int intduty = Integer.parseInt(dutyTime.replace(":", ""));
		int intcurrent = Integer.parseInt(todayString.replace(":", ""));
		System.out.println(intduty);
		System.out.println(intcurrent);
		System.out.println(intduty + 10000);
		// 上班
		if (type.equals("1") || type.equals("3")) {
			if (intduty + 10000 > intcurrent && intduty < intcurrent) {
				System.out.println("迟到");
				attendduty.setRemark("迟到");
			}
		}
		// 下班
		else if (type.equals("2") || type.equals("4")) {
			if (intduty - 10000 > intcurrent && intduty > intcurrent) {
				System.out.println("早退");
				attendduty.setRemark("早退");
			}
		} else {
			throw new Exception("打卡类型异常");
		}
		if (intduty - 10000 > intcurrent || intduty + 10000 < intcurrent) {
			throw new Exception("打卡时间异常");
		}
		attendduty.setDutytype(userattend);
		attendduty.setRegistertype(type);
		attendduty.setRegistertime(currentDate);
		attendduty.setUserid(user.getUserid());
		adm.insertSelective(attendduty);
	}

	@Override
	public List<AttendconfigVo> getAttendConfig(HttpSession session) {
		// 拿到当前用户的id去查到dutytypeid(user_attend表)
		User user = (User) session.getAttribute("user");
		UserAttendExample userAttendExample = new UserAttendExample();
		Criteria userAttendCriteria = userAttendExample.createCriteria();
		userAttendCriteria.andUseridEqualTo(user.getUserid());

		// 拿到了dutytypeid去拿排版信息
		List<UserAttend> ualist = uam.selectByExample(userAttendExample);
		Attendconfig config = null;
		if (ualist == null || ualist.size() <= 0) {
			return null;

		}
		System.out.println(ualist);
		config = acm.selectByPrimaryKey(ualist.get(0).getDutytype());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal_1 = Calendar.getInstance();// 获取当前日期
		cal_1.add(Calendar.MONTH, 0);
		cal_1.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		// 获取前月的最后一天
		Calendar cale = Calendar.getInstance();
		cale.set(Calendar.DAY_OF_MONTH, cale.getActualMaximum(Calendar.DAY_OF_MONTH));

		Calendar calBegin = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calBegin.setTime(cal_1.getTime());
		Calendar calEnd = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calEnd.setTime(cale.getTime());
		// 测试此日期是否在指定日期之后

		List<AttendconfigVo> list = new ArrayList<>();
		String[] split = config.getGeneral().split(",");

		// 本月第一天，当时获取一个月所有的天就是拿不到第一天啊啊啊啊啊啊
		// 去除休息天
		if (calBegin.get(Calendar.DAY_OF_WEEK) != Integer.parseInt(split[0]) + 1
				&& calBegin.get(Calendar.DAY_OF_WEEK) != Integer.parseInt(split[1]) + 1) {
			AttendconfigVo attendconfigVo = new AttendconfigVo(config);
			attendconfigVo.setDate(sdf.format(calBegin.getTime()));
			list.add(attendconfigVo);
		} else {
			// 第一天
			AttendconfigVo attendconfigVo = new AttendconfigVo();
			attendconfigVo.setDate(sdf.format(calBegin.getTime()));
			attendconfigVo.setDutytype(config.getDutytype());
			attendconfigVo.setDutytime1("休息");
			attendconfigVo.setDutytime2("休息");
			attendconfigVo.setDutytime3("休息");
			attendconfigVo.setDutytime4("休息");
			list.add(attendconfigVo);

		}

		while (cale.getTime().after(calBegin.getTime())) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			// 去除休息天
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			if (calBegin.get(Calendar.DAY_OF_WEEK) != Integer.parseInt(split[0]) + 1
					&& calBegin.get(Calendar.DAY_OF_WEEK) != Integer.parseInt(split[1]) + 1) {
				AttendconfigVo attendconfigVo = new AttendconfigVo(config);
				attendconfigVo.setDate(sdf.format(calBegin.getTime()));
				list.add(attendconfigVo);
			} else {
				AttendconfigVo attendconfigVo = new AttendconfigVo();
				attendconfigVo.setDate(sdf.format(calBegin.getTime()));
				attendconfigVo.setDutytype(config.getDutytype());
				attendconfigVo.setDutytime1("休息");
				attendconfigVo.setDutytime2("休息");
				attendconfigVo.setDutytime3("休息");
				attendconfigVo.setDutytime4("休息");
				list.add(attendconfigVo);

			}

		}

		return list;

	}

	// 递归获取下属
	public List<User> getFollowers(User user) {
		List<User> ulist = new ArrayList<>();
		ulist.add(user);
		UserExample uExample = new UserExample();
		cn.zzpigt.bean.UserExample.Criteria userCriteria = uExample.createCriteria();
		userCriteria.andLeaderidEqualTo(user.getUserid());
		List<User> flist = um.selectByExample(uExample);
		if (flist.size() > 0) {
			for (User follower : flist) {
				List<User> followers = getFollowers(follower);
				ulist.addAll(followers);
			}
		}
		return ulist;
	}

	@Override
	public List<UserAttendCountVo> getcount(User user, String date) throws Exception {

		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 没有筛选项默认为本月
		if (date == null) {
			date = dayFormat.format(new Date());
		}
		Date parse = dayFormat.parse(date);
		// 获取本月工作日
		Calendar c = Calendar.getInstance();
		c.setTime(parse);
		int max = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 开始日期为1号
		int maxDate = 0;
		for (int start = 1; start <= max; start++) {
			// 把这一天设置进日历
			c.set(Calendar.DAY_OF_MONTH, start);
			// 获取这一天是周几
			int week = c.get(Calendar.DAY_OF_WEEK);
			// 不是周六和周日的都认为是工作日
			if (week != Calendar.SUNDAY && week != Calendar.SATURDAY) {
				maxDate++;
			}
		}
		// 递归获取下属
		List<User> userList = getFollowers(user);
		// po转vo准备
		List<UserAttendCountVo> uacvList = new ArrayList<>();
		// 遍历每一个用户
		for (User user2 : userList) {

			// 迟到
			AttenddutyExample lateExample = new AttenddutyExample();
			cn.zzpigt.bean.AttenddutyExample.Criteria lateCriteria = lateExample.createCriteria();
			lateCriteria.andRegistertimeBetween(DateUtil.getStartTimeOfMonth(date), DateUtil.getEndTimeOfMonth(date));
			lateCriteria.andRemarkEqualTo("迟到");
			lateCriteria.andUseridEqualTo(user2.getUserid());
			int late = adm.countByExample(lateExample);

			// 早退
			AttenddutyExample earlyExample = new AttenddutyExample();
			cn.zzpigt.bean.AttenddutyExample.Criteria earlyCriteria = earlyExample.createCriteria();
			earlyCriteria.andRegistertimeBetween(DateUtil.getStartTimeOfMonth(date), DateUtil.getEndTimeOfMonth(date));
			earlyCriteria.andRemarkEqualTo("早退");
			earlyCriteria.andUseridEqualTo(user2.getUserid());
			int early = adm.countByExample(earlyExample);

			// 出勤
			int attendday = 0;
			Calendar startDate = Calendar.getInstance();
			startDate.set(Calendar.YEAR, Integer.parseInt(date.split("-")[0]));
			startDate.set(Calendar.MONTH, Integer.parseInt(date.split("-")[1]) - 1);
			startDate.set(Calendar.HOUR_OF_DAY, 0);
			startDate.set(Calendar.MINUTE, 0);
			startDate.set(Calendar.SECOND, 0);
			Calendar endDate = Calendar.getInstance();
			endDate.set(Calendar.YEAR, Integer.parseInt(date.split("-")[0]));
			endDate.set(Calendar.MONTH, Integer.parseInt(date.split("-")[1]) - 1);
			endDate.set(Calendar.HOUR_OF_DAY, 0);
			endDate.set(Calendar.MINUTE, 0);
			endDate.set(Calendar.SECOND, 0);
			// 本月的天数,利用sql语句between条件，获取2个时间段之间是否打卡了
			for (int i = 1; i <= startDate.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
				startDate.set(Calendar.DAY_OF_MONTH, i);
				Date time1 = startDate.getTime();
				endDate.set(Calendar.DAY_OF_MONTH, i + 1);
				Date time2 = endDate.getTime();
				AttenddutyExample adExample = new AttenddutyExample();
				cn.zzpigt.bean.AttenddutyExample.Criteria adCriteria = adExample.createCriteria();
				adCriteria.andRegistertimeBetween(time1, time2);
				adCriteria.andUseridEqualTo(user2.getUserid());
				List<Attendduty> selectByExample = adm.selectByExample(adExample);
				// 有打卡
				if (selectByExample.size() > 0) {
					attendday++;
				}
			}
			//上班未登记天数
			int noCome = 0;
			//下班未登记天数
			int noBack = 0;
			UserAttendCountVo uacv = new UserAttendCountVo(user2);
			UserAttendExample userAttendExample = new UserAttendExample();
			Criteria userAttendCriteria = userAttendExample.createCriteria();
			userAttendCriteria.andUseridEqualTo(user2.getUserid());
			// po转vo，把user对象放进
			List<UserAttend> userAttendList = uam.selectByExample(userAttendExample);
			// 有打卡,计算未打卡次数
			if (attendday > 0) {
				// 行政班
				if (userAttendList.get(0).getDutytype() == 1) {
					int m1 = getSignCount(user2, date, "1");
					int m2 = getSignCount(user2, date, "2");
					noCome = attendday - m1;
					noBack = attendday - m2;
					// 两头班
				} else {
					int m1 = getSignCount(user2, date, "1");
					int m2 = getSignCount(user2, date, "2");
					int m3 = getSignCount(user2, date, "3");
					int m4 = getSignCount(user2, date, "4");
					noCome = attendday * 2 - m1 - m3;
					noBack = attendday * 2 - m2 - m4;
				}
			}
			uacv.setComesign(noCome);
			uacv.setBacksign(noBack);
			// 应全勤,实际,旷工,迟到,早退
			uacv.setDaycount(maxDate);
			uacv.setAttendday(attendday);
			uacv.setNevercount(maxDate - attendday);
			uacv.setLatecount(late);
			uacv.setEarlycount(early);
			uacvList.add(uacv);
		}
		return uacvList;
	}

	private int getSignCount(User user2, String date, String state) {
		// 获取打卡次数
		AttenddutyExample adExample = new AttenddutyExample();
		cn.zzpigt.bean.AttenddutyExample.Criteria adCriteria = adExample.createCriteria();
		adCriteria.andUseridEqualTo(user2.getUserid());
		adCriteria.andRegistertypeEqualTo(state);
		adCriteria.andRegistertimeBetween(DateUtil.getStartTimeOfMonth(date), DateUtil.getEndTimeOfMonth(date));
		return adm.countByExample(adExample);
	}

}
