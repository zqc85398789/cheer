package com.cheer.dao.impl;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cheer.beans.User;
import com.cheer.dao.inter.IUserDAO;
import com.cheer.util.DateUtil;

public class UserDAOImplTest {
	ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"spring-context.xml"});
	IUserDAO dao = (IUserDAO)ctx.getBean("userDAO");
	
	@Test
	public void testAdd() {
		User user = new User("Nanami", "N0001", "Aoyama Nanami");
		user.setCreate_time(DateUtil.currentTime());
		user.setCreate_by(user.getUsername());
		int row = dao.addUser(user);
		System.out.println("插入了"+row+"条数据");
	}
	
	@Test
	public void testDelete() {
		String username = "Nanami";
		int row = dao.deleteUser(username);
		System.out.println("删除了"+row+"条数据");
	}
	
	@Test
	public void testUpdate() throws ParseException {
		User user = new User("Nanami", "N002", "Nanami Aoyama");
		user.setBirth_date(DateUtil.dateParse("1995-07-03",DateUtil.DATE_PATTERN));
		user.setGender("f");
		user.setTel_no("13100610945");
		user.setEmpno("N0001");
		user.setUpdate_by("admin");
		user.setUpdate_time(DateUtil.currentTime());
		int row = dao.updateUser(user);
		System.out.println("更新了"+row+"条数据");
	}
	
	@Test
	public void testQueryAll() {
		List<User> users = dao.queryAll();
		for(User user:users) {
			System.out.println(user.getUsername()+"-"+user.getPassword()+"-"+user.getLegal_name());
		}
	}
}
