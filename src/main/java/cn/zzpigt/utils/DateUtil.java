package cn.zzpigt.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DateUtil {

	public static String getStartTime(String dutytime) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date startTime = null;
		try {
			startTime = new Date(sdf.parse(dutytime).getTime() - 30 * 60 * 1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sdf.format(startTime);
	}

	public static String getEndTime(String dutytime) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date endTime = null;
		try {
			endTime = new Date(sdf.parse(dutytime).getTime() + 30 * 60 * 1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sdf.format(endTime);
	}

	public static Boolean isAcceable(String dutytime, Date today) {
		Date now = new Date(Math.floorMod(today.getTime(), (long) (24 * 60 * 60 * 1000)));

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date startTime = null;
		Date endTime = null;
		try {
			startTime = new Date(sdf.parse(dutytime).getTime() + 30 * 60 * 1000);
			endTime = new Date(sdf.parse(dutytime).getTime() + 30 * 60 * 1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (now.after(startTime) && now.before(endTime))
			return true;

		return false;
	}

	public static String getDate(Date today) {
		return new SimpleDateFormat("yyyy-MM-dd").format(today);
	}

	public static Date getDatedStartTime(Date today, String dutytime) {
		String date = DateUtil.getDate(today);
		String startTime = DateUtil.getStartTime(dutytime);

		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date + " " + startTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Date getDatedEndTime(Date today, String dutytime) {
		String date = DateUtil.getDate(today);
		String endTime = DateUtil.getEndTime(dutytime);

		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date + " " + endTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}



	public static Date getStartTimeOfMonth(String month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, Integer.parseInt(month.split("-")[0]));
		c.set(Calendar.MONTH, Integer.parseInt(month.split("-")[1]) - 1);
		c.set(Calendar.DATE, 1);
		return c.getTime();
	}

	public static Date getEndTimeOfMonth(String month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, Integer.parseInt(month.split("-")[0]));
		c.set(Calendar.MONTH, Integer.parseInt(month.split("-")[1]));
		c.set(Calendar.DATE, 1);
		return c.getTime();
	}

}
