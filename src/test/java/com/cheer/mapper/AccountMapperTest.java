package com.cheer.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.cheer.beans.Account;

public class AccountMapperTest extends BaseTest {
	SqlSession session;

	@Test
	public void testInsertAccount() {
		session = sqlSessionFactroy.openSession();
		try {
			AccountMapper mapper = session.getMapper(AccountMapper.class);
			Account account = new Account();
			account.setAccountName("admin");
			account.setAccountPassword("a123456");
			int row = mapper.insertAccount(account);
			session.commit();
			System.out.println(account);
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
}
