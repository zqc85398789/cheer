package com.cheer.mapper;

import java.util.List;

import com.cheer.beans.Account;

public interface AccountMapper {
	public int insertAccount(Account account);
	
	public int updateAccount(Account account);
	
	public List<Account> queryAccounts(Account account);

	public int lastInsertId();
}
