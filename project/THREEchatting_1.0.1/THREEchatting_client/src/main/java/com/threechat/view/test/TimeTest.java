package com.threechat.view.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTest {

	public static void main(String[] args) throws ParseException {
		System.out.println(getWeek("2018-11-20"));
		getWeek2("2018-11-25");
	}
	/**
	 *  给定时间得到是周几
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static Integer getWeek(String time) throws ParseException {
		Date date = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		date = df.parse(time);
		String wheekWhat = date.toString().substring(0, 3);
		if ("Fri".equals(wheekWhat)) {
			return 5;
		} else if ("Mon".equals(wheekWhat)) {
			return 1;
		} else if ("Tue".equals(wheekWhat)) {
			return 2;
		} else if ("Wed".equals(wheekWhat)) {
			return 3;
		} else if ("Thu".equals(wheekWhat)) {
			return 4;
		} else if ("Sat".equals(wheekWhat)) {
			return 6;
		} else if ("Sun".equals(wheekWhat)) {
			return 7;
		}
		return -1;
	}

	/**
	 * 给定时间得到是一周第几天
	 * 
	 * @param time
	 * @return
	 * @throws ParseException
	 */
	public static Integer getWeek2(String time) throws ParseException {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		date = df.parse(time);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		return -1;
	}
}
