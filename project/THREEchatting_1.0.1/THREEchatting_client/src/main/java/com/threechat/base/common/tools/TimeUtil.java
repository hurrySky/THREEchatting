package com.threechat.base.common.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(getYYYYMMDDTime(date));
	}

	/**
	 * 获得 YYYYMMDD 格式的日期字符串
	 * @param Date date
	 * @return String eg: 20190106
	 */
	public static String getYYYYMMDDTime(Date date) {
		SimpleDateFormat sf = new SimpleDateFormat("YYYYMMDD");
		sf.format(date);
		return sf.format(date);
	}
}
