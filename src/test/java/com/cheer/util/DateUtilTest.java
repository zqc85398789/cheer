package com.cheer.util;

import java.util.Date;

import org.junit.Test;

public class DateUtilTest {
	@Test
	public void testGetLastMonth() {
		Date date = DateUtil.currentTime();
		String lastMonth = DateUtil.getLastMonth(date);
		System.out.println(lastMonth);
	}
	
	@Test
	public void testGetLastYear() {
		Date date = DateUtil.currentTime();
		String lastYear = DateUtil.getLastYear(date);
		System.out.println(lastYear);
	}
}
