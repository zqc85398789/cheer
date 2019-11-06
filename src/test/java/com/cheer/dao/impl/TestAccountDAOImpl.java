package com.cheer.dao.impl;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cheer.beans.Account;
import com.cheer.mapper.AccountMapper;
import com.cheer.util.DateUtil;

public class TestAccountDAOImpl{
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
	private AccountMapper accountDAO = (AccountMapper)context.getBean("accountDAO");
	
	@Test
	public void testInsert() {
		Account account = new Account();
		account.setAccountName("Nanami");
		account.setAccountPassword("N123456");
		account.setCreatedTime(DateUtil.currentTime());
		account.setCreatedBy("admin");
		int row = accountDAO.insertAccount(account);
		System.out.println("插入了"+row+"行数据");
	}
	
	@Test
	public void testUpdate() {
		Account account = new Account();
		account.setId(2);
		account.setAccountPassword("N0001");
		account.setUpdateBy("admin");
		account.setUpdateTime(DateUtil.currentTime());
		int row = accountDAO.updateAccount(account);
		System.out.println("更新了"+row+"行数据");
	}
	
}