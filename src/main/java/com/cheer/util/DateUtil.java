package com.cheer.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String DATEMINUTE_PATTERN = "yyyy-MM-dd HH:mm";
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	
	/**
	 * 获取当前系统时间
	 */
	public static Date currentTime() {
		Calendar c = Calendar.getInstance();
		return c.getTime();
	}
	
	/**
	 * Date转String
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String dateFormat(Date date,String pattern) {
		if(pattern == null || "".equals(pattern.trim())) {
			pattern = DATETIME_PATTERN;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	/**
	 * String转Date
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static Date dateParse(String dateString,String pattern) throws ParseException {
		if(pattern == null || "".equals(pattern.trim())) {
			pattern = DATETIME_PATTERN;
		}
		if(DATEMINUTE_PATTERN.equals(pattern)) {
			dateString = dateString.replace('T', ' ');
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(dateString);
	}
	
	/**
	 * 获取当年第一天的字符串形式
	 * @param date
	 * @return
	 */
	public static String getLastYear(Date date) {
		String today = dateFormat(date, DATE_PATTERN);
		String lastYear = today.substring(0,4)+"-01-01";
		return lastYear;
	}
	
	/**
	 * 获取当月第一天的字符串形式
	 * @param date
	 * @return
	 */
	public static String getLastMonth(Date date) {
		String today = dateFormat(date, DATE_PATTERN);
		String lastMonth = today.substring(0,7)+"-01";
		return lastMonth;
	}
	
	/**
	 * 获取当月第天的字符串形式
	 * @param date
	 * @return
	 */
	public static String getToday() {
		String today = dateFormat(currentTime(), DATE_PATTERN);
		return today;
	}
}
