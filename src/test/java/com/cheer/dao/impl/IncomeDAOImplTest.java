package com.cheer.dao.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cheer.beans.Income;
import com.cheer.dao.inter.IIncomeDAO;
import com.cheer.util.DateUtil;

public class IncomeDAOImplTest {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
	IIncomeDAO incomeDAO = (IIncomeDAO)ctx.getBean("incomeDAO");
	
	@Test
	public void testAdd() throws ParseException {
		Income income = new Income("预付款", "甲方爸爸", "老板", new BigDecimal(100000), DateUtil.dateParse("2019-10-10 12:00:00", DateUtil.DATETIME_PATTERN));
		income.setCreate_by("王尼玛");
		income.setCreate_time(DateUtil.currentTime());
		int row = incomeDAO.addIncome(income);
		System.out.println("插入了"+row+"条数据");
	}
	
	@Test
	public void testDelete() {
		int id = 1;
		int row = incomeDAO.deleteIncome(id);
		System.out.println("删除了"+row+"条数据");
	}
	
	@Test
	public void testUpdate() throws ParseException {
		Income income = new Income("补款", "甲方爸爸", "老板娘", new BigDecimal(200000), DateUtil.dateParse("2019-10-10 12:00:00", DateUtil.DATETIME_PATTERN));
		income.setUpdate_by("张全蛋");
		income.setUpdate_time(DateUtil.currentTime());
		income.setId(2);
		int row = incomeDAO.updateIncome(income);
		System.out.println("更新了"+row+"条数据");
	}
	
	@Test
	public void testQuery() throws ParseException {
		List<Income> list = incomeDAO.queryByItem("款",DateUtil.dateParse("2019-01-11", DateUtil.DATE_PATTERN), DateUtil.currentTime());
		for(Income income:list) {
			System.out.println(income.toString());
		}
	}
}
