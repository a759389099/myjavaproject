package cn.zzpigt.service.impl;

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
		List<UserAttend> userattendList = uam.selectByExample(userAttendExample);
		if (userattendList == null || userattendList.size() == 0) {
			return null;
		}
		UserAttend userAttend = userattendList.get(0);
		//
		Attendconfig attendConfig = acm.selectByPrimaryKey(userAttend.getDutytype());
		userAttendVo.setDutytype(attendConfig);

		AttenddutyExample attenddutyExample = new AttenddutyExample();
		cn.zzpigt.bean.AttenddutyExample.Criteria adCriteria = attenddutyExample.createCriteria();
		adCriteria.andUseridEqualTo(user.getUserid());
		List<Attendduty> attenddutyList = adm.selectByExample(attenddutyExample);
		// 获取今天的排班信息
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
	public void sign(HttpSession session) throws Exception {
		// 周末周日排除
		Date currentDate = new Date();
		SimpleDateFormat day = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat hour = new SimpleDateFormat("HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			throw new Exception("周末周日也来打卡?");
		}

		// 用id查班次类型
		User user = (User) session.getAttribute("user");
		UserAttendExample userAttendExample = new UserAttendExample();
		Criteria uaCriteria = userAttendExample.createCriteria();
		uaCriteria.andUseridEqualTo(user.getUserid());
		// 联合主键,虽然是一对一,但是不能用查主键的方式
		List<UserAttend> userattendList = uam.selectByExample(userAttendExample);
		// 检查班次是否存在，没有说明，没有该用户的排班
		if (userattendList == null || userattendList.size() == 0) {
			System.out.println("没有该用户的排班");
			throw new Exception("没有该用户的排班");
		}
		// 根据id拿到签到表
		AttenddutyExample attenddutyExample = new AttenddutyExample();
		cn.zzpigt.bean.AttenddutyExample.Criteria adCriteria = attenddutyExample.createCriteria();
		adCriteria.andUseridEqualTo(user.getUserid());
		List<Attendduty> attenddutyList = adm.selectByExample(attenddutyExample);
		// 签到表没有该用户的数据，说明是第一次签到
		if (attenddutyList == null || attenddutyList.size() == 0) {
			System.out.println("签到表没有该用户的数据，说明是第一次签到");
			// 获取对应的排班表
			Attendconfig attendconfig = acm.selectByPrimaryKey(userattendList.get(0).getDutytype());
			//
			String sdfFormat = hour.format(currentDate);
			String format = sdfFormat.replace(":", "");
			int time1 = Integer.parseInt(format);
			String dutytime1 = attendconfig.getDutytime1().replace(":", "");
			int time2 = Integer.parseInt(dutytime1);
			Attendduty attendduty = new Attendduty();
			// 没迟到
			if (time1 < time2 && time1 > time2 - 10000) {

			}
			// 迟到的情况
			else if (time1 > time2 && time1 < time2 + 10000) {
				attendduty.setRemark("迟到");
			}
			// 非正常时间打卡
			else {

				System.out.println("非正常时间打卡");
				throw new Exception("非正常时间打卡");
			}
			// 插入数据!

			attendduty.setDutytype(userattendList.get(0).getDutytype());
			attendduty.setRegistertime(currentDate);
			attendduty.setUserid(user.getUserid());
			attendduty.setRegistertype("1");
			adm.insertSelective(attendduty);
		}
		AttenddutyExample AttenddutyExample = new AttenddutyExample();
		cn.zzpigt.bean.AttenddutyExample.Criteria createCriteria = AttenddutyExample.createCriteria();
		createCriteria.andUseridEqualTo(user.getUserid());
		List<Attendduty> list = adm.selectByExample(AttenddutyExample);
		List<Attendduty> myList = new ArrayList<>();
		// myList里面的就是用户今天的打卡数据
		for (Attendduty attendduty : list) {
			Date registertime = attendduty.getRegistertime();
			if (day.format(registertime).equals(day.format(currentDate))) {
				myList.add(attendduty);
			}
		}

		// 区分行政班还是两头班
		if (userattendList.get(0).getDutytype() == 1) {
			Attendconfig attendconfig = acm.selectByPrimaryKey(userattendList.get(0).getDutytype());
			int size = myList.size();
			System.out.println("行政班获取实际打卡次数" + size);
			switch (size) {
			case 0:
				System.out.println("行政班的case0，也就是上班打卡");
				// 获取对应的排班表
				String sdfFormat = hour.format(currentDate);
				String format = sdfFormat.replace(":", "");
				int time1 = Integer.parseInt(format);
				String dutytime1 = attendconfig.getDutytime1().replace(":", "");
				int time2 = Integer.parseInt(dutytime1);
				Attendduty attendduty = new Attendduty();
				// 没迟到
				if (time1 < time2 && time1 > time2 - 10000) {

				}
				// 迟到的情况
				else if (time1 > time2 && time1 < time2 + 10000) {
					attendduty.setRemark("迟到");
				}
				// 非正常时间打卡
				else {
					System.out.println("非正常时间打卡");
					throw new Exception("非正常时间打卡");
				}
				// 插入数据!
				attendduty.setDutytype(userattendList.get(0).getDutytype());
				attendduty.setRegistertime(currentDate);
				attendduty.setUserid(user.getUserid());
				attendduty.setRegistertype("1");
				adm.insertSelective(attendduty);

				break;

			case 1:
				System.out.println("行政班的case1，也就是下班打卡");
				// 获取对应的排班表
				sdfFormat = hour.format(currentDate);
				format = sdfFormat.replace(":", "");
				time1 = Integer.parseInt(format);
				String dutytime2 = attendconfig.getDutytime2().replace(":", "");
				time2 = Integer.parseInt(dutytime2);
				attendduty = new Attendduty();
				// 下班
				// 早退
				if (time1 > time2 - 7000 && time1 < time2) {
					attendduty.setRemark("早退");
				} else if (time1 > time2 && time1 < time2 + 50000) {

				}
				// 非正常时间打卡
				else {
					System.out.println("非正常时间打卡");
					throw new Exception("非正常时间打卡");
				}
				// 插入数据!

				attendduty.setDutytype(userattendList.get(0).getDutytype());
				attendduty.setRegistertime(currentDate);
				attendduty.setUserid(user.getUserid());
				attendduty.setRegistertype("2");
				adm.insertSelective(attendduty);
				break;
			case 2:
				break;

			}
		}
		// 两头班
		else {
			Attendconfig attendconfig = acm.selectByPrimaryKey(userattendList.get(0).getDutytype());
			int size = myList.size();
			System.out.println("获取实际打卡次数" + size);
			switch (size) {
			case 0:
				System.out.println("两头班的case0，也就是第一头上班打卡");
				// 获取对应的排班表
				String sdfFormat = hour.format(currentDate);
				String format = sdfFormat.replace(":", "");
				int time1 = Integer.parseInt(format);
				String dutytime1 = attendconfig.getDutytime1().replace(":", "");
				int time2 = Integer.parseInt(dutytime1);
				Attendduty attendduty = new Attendduty();
				// 没迟到
				if (time1 < time2 && time1 > time2 - 10000) {

				}
				// 迟到的情况
				else if (time1 > time2 && time1 < time2 + 10000) {
					attendduty.setRemark("迟到");
				}
				// 非正常时间打卡
				else {
					System.out.println("非正常时间打卡");
					throw new Exception("非正常时间打卡");
				}
				// 插入数据!

				attendduty.setDutytype(userattendList.get(0).getDutytype());
				attendduty.setRegistertime(currentDate);
				attendduty.setUserid(user.getUserid());
				attendduty.setRegistertype("1");
				adm.insertSelective(attendduty);
				break;
			case 1:
				System.out.println("两头班的case1，也就是第一头下班打卡");
				// 获取对应的排班表
				sdfFormat = hour.format(currentDate);
				format = sdfFormat.replace(":", "");
				time1 = Integer.parseInt(format);
				String dutytime2 = attendconfig.getDutytime2().replace(":", "");
				time2 = Integer.parseInt(dutytime2);
				attendduty = new Attendduty();
				// 下班
				// 早退

				System.out.println(time2);
				System.out.println(time1);
				// 分钟是60进制,但是数值是十进制
				if (time1 > time2 - 7000 && time1 < time2) {
					attendduty.setRemark("早退");
				} else if (time1 > time2 && time1 < time2 + 3000) {

				}
				// 非正常时间打卡
				else {
					System.out.println("非正常时间打卡");
					throw new Exception("非正常时间打卡");
				}
				// 插入数据!
				attendduty.setDutytype(userattendList.get(0).getDutytype());
				attendduty.setRegistertime(currentDate);
				attendduty.setUserid(user.getUserid());
				attendduty.setRegistertype("2");
				adm.insertSelective(attendduty);
				break;
			case 2:
				System.out.println("两头班的case2，也就是第二头上班打卡");
				// 获取对应的排班表
				sdfFormat = hour.format(currentDate);
				format = sdfFormat.replace(":", "");
				time1 = Integer.parseInt(format);
				String dutytime3 = attendconfig.getDutytime3().replace(":", "");
				time2 = Integer.parseInt(dutytime3);
				attendduty = new Attendduty();
				// 没迟到
				if (time1 < time2 && time1 > time2 - 7000) {

				}
				// 迟到的情况
				else if (time1 > time2 && time1 < time2 + 3000) {
					attendduty.setRemark("迟到");
				}
				// 非正常时间打卡
				else {
					System.out.println("非正常时间打卡");
					throw new Exception("非正常时间打卡");
				}
				// 插入数据!
				attendduty.setDutytype(userattendList.get(0).getDutytype());
				attendduty.setRegistertime(currentDate);
				attendduty.setUserid(user.getUserid());
				attendduty.setRegistertype("3");
				adm.insertSelective(attendduty);
				break;
			case 3:
				System.out.println("两头班的case3，也就是第二头下班打卡");
				// 获取对应的排班表
				sdfFormat = hour.format(currentDate);
				format = sdfFormat.replace(":", "");
				time1 = Integer.parseInt(format);
				String dutytime4 = attendconfig.getDutytime4().replace(":", "");
				time2 = Integer.parseInt(dutytime4);
				attendduty = new Attendduty();
				// 下班
				if (time1 > time2 - 3000 && time1 < time2) {
					attendduty.setRemark("早退");
				} else if (time1 > time2 && time1 < time2 + 17000) {
				}
				// 非正常时间打卡
				else {
					System.out.println("非正常时间打卡");
					throw new Exception("非正常时间打卡");
				}
				// 插入数据!

				attendduty.setDutytype(userattendList.get(0).getDutytype());
				attendduty.setRegistertime(currentDate);
				attendduty.setUserid(user.getUserid());
				attendduty.setRegistertype("4");
				adm.insertSelective(attendduty);
				break;
			case 4:
				System.out.println("两头班的case4，也就是说都打卡完了");
				return;
			default:
				break;
			}
		}
	}

	@Override
	public List<AttendconfigVo> getAttendConfig(HttpSession session) {
		// 拿到当前用户的id去查到dutytypeid(user_attend表)
		User user = (User) session.getAttribute("user");
		UserAttendExample userAttendExample = new UserAttendExample();
		Criteria userAttendCriteria = userAttendExample.createCriteria();
		userAttendCriteria.andUseridEqualTo(user.getUserid());

		// 拿到了dutytypeid去拿config
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

		// 本月第一天
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

		while (cale.getTime().after(calBegin.getTime())) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
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
		if (flist.size() > 0)
			for (User follower : flist) {
				List<User> followers = getFollowers(follower);
				ulist.addAll(followers);
			}

		return ulist;
	}

	@Override
	public List<UserAttendCountVo> getcount(User user, String date) {

		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		// 没有筛选项默认为本月
		if (date == null) {
			date = dayFormat.format(new Date());
		}
		// 获取本月工作日
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		// 月份是从0开始计算，所以需要减1
		c.set(Calendar.MONTH, month - 1);
		// 当月最后一天的日期
		int max = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 开始日期为1号
		int start = 1;
		// 计数
		int maxDate = 0;
		while (start <= max) {
			c.set(Calendar.DAY_OF_MONTH, start);
			int week = c.get(Calendar.DAY_OF_WEEK);
			// 不是周六和周日的都认为是工作日
			if (week != Calendar.SUNDAY && week != Calendar.SATURDAY) {
				maxDate++;
			}
			start++;
		}

		List<User> userList = getFollowers(user);
		for (User user2 : userList) {
			System.out.println(user2.getNickname());
		}
		List<UserAttendCountVo> uacvl = new ArrayList<>();
		// 遍历每一个用户
		for (User user2 : userList) {
			UserAttendCountVo uacv = new UserAttendCountVo(user2);
			UserAttendExample userAttendExample = new UserAttendExample();
			Criteria userAttendCriteria = userAttendExample.createCriteria();
			userAttendCriteria.andUseridEqualTo(user2.getUserid());
			List<UserAttend> userAttendList = uam.selectByExample(userAttendExample);
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
			// 本月的天数
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
			int noCome = 0;
			int noBack = 0;
			// 有打卡,计算未打卡次数
			if (attendday > 0) {
				// 行政班
				if (userAttendList.get(0).getDutytype() == 1) {
					int m1=getSignCount(user2,date,"1");
					int m2=getSignCount(user2,date,"2");
					noCome = attendday   - m1 ;
					noBack = attendday   - m2 ;
					// 两头班
				} else {
					int m1=getSignCount(user2,date,"1");
					int m2=getSignCount(user2,date,"2");
					int m3=getSignCount(user2,date,"3");
					int m4=getSignCount(user2,date,"4");
					noCome = attendday * 2 - m1 - m3;
					noBack = attendday * 2 - m2 - m4;
				}
			}
			// 行政班
			uacv.setComesign(noCome);
			uacv.setBacksign(noBack);
			// 应全勤,实际,旷工,迟到,早退
			uacv.setDaycount(maxDate);
			uacv.setAttendday(attendday);
			uacv.setNevercount(maxDate - attendday);
			uacv.setLatecount(late);
			uacv.setEarlycount(early);
			uacvl.add(uacv);
		}
		return uacvl;
	}
	private int getSignCount(User user2,String date,String state){
		//获取打卡次数
		AttenddutyExample adExample = new AttenddutyExample();
		cn.zzpigt.bean.AttenddutyExample.Criteria adCriteria = adExample.createCriteria();
		adCriteria.andUseridEqualTo(user2.getUserid());
		adCriteria.andRegistertypeEqualTo(state);
		adCriteria.andRegistertimeBetween(DateUtil.getStartTimeOfMonth(date),
				DateUtil.getEndTimeOfMonth(date));
		return adm.countByExample(adExample);
	}

}
