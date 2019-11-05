package com.cheer.dao.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cheer.beans.Account;
import com.cheer.beans.Staff;

public class TestAccountStaffDAOImpl {
	ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
	AccountStaffDAOImpl dao = (AccountStaffDAOImpl)context.getBean("accountStaffDAO");
	
	@Test
	public void testQueryAccountStaff() {
		Account account = new Account();
		account.setStaff(new Staff());
		account.setAccountName("");
		account.getStaff().setStaffName("");
		account.getStaff().setEmpno("");
		int currentPage = 1;
		List<Account> accounts = dao.queryAccountStaff(account, currentPage);
		for(Account ac:accounts) {
			System.out.println(ac.getAccountName());
		}
	}
}
