package com.cheer.dao.impl;

import java.text.ParseException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cheer.beans.Staff;
import com.cheer.mapper.StaffMapper;
import com.cheer.util.DateUtil;

public class TestStaffDAOImpl {
	ApplicationContext context = new ClassPathXmlApplicationContext(new String("spring-context.xml"));
	StaffMapper staffDAO = (StaffMapper)context.getBean("staffDAO");
	
	@Test
	public void testInsertStaff() throws ParseException {
		Staff staff = new Staff();
		staff.setStaffName("Asuna");
		staff.setBirthDate(DateUtil.dateParse("1995-12-01", "yyyy-MM-dd"));
		staff.setTelephoneNo("17095051111");
		staff.setIdCard("320681199512010213");
		staff.setGender("F");
		staff.setEmergencyContact("yui");
		staff.setTelephoneNo("17095052222");
		staff.setEmpno("T00001");
		staff.setCreatedBy("admin");
		staff.setCreatedTime(DateUtil.currentTime());
		int row = staffDAO.insertStaff(staff);
		int id = staffDAO.lastInsertId();
		System.out.println(row);
		System.out.println(id);
	}
}
