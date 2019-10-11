package com.cheer.dao.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cheer.beans.Expense;
import com.cheer.beans.Expense;
import com.cheer.beans.Expense;
import com.cheer.dao.inter.IExpenseDAO;
import com.cheer.util.DateUtil;

public class ExpenseDAOImplTest {
	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
	IExpenseDAO expenseDAO = (IExpenseDAO)ctx.getBean("expenseDAO");
	
	@Test
	public void testAdd() throws ParseException {
		Expense expense = new Expense("预付款", "甲方爸爸", "老板", new BigDecimal(100000), DateUtil.dateParse("2019-10-10 12:00:00", DateUtil.DATETIME_PATTERN));
		expense.setCreate_by("王尼玛");
		expense.setCreate_time(DateUtil.currentTime());
		int row = expenseDAO.addExpense(expense);
		System.out.println("插入了"+row+"条数据");
	}
	
	@Test
	public void testDelete() {
		int id = 1;
		int row = expenseDAO.deleteExpense(id);
		System.out.println("删除了"+row+"条数据");
	}
	
	@Test
	public void testUpdate() throws ParseException {
		Expense expense = new Expense("补款", "甲方爸爸", "老板娘", new BigDecimal(200000), DateUtil.dateParse("2019-10-10 12:00:00", DateUtil.DATETIME_PATTERN));
		expense.setUpdate_by("张全蛋");
		expense.setUpdate_time(DateUtil.currentTime());
		expense.setId(2);
		int row = expenseDAO.updateExpense(expense);
		System.out.println("更新了"+row+"条数据");
	}
	
	@Test
	public void testQuery() throws ParseException {
		List<Expense> list = expenseDAO.queryByItem("款",DateUtil.dateParse("2019-01-11", DateUtil.DATE_PATTERN), DateUtil.currentTime());
		for(Expense expense:list) {
			System.out.println(expense.toString());
		}
	}
}
