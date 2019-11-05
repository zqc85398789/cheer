package com.cheer.mapper;

import java.util.List;

import com.cheer.beans.Account;

public interface AccountStaffMapper {
	public List<Account> queryAccountStaff(Account account,int currentPage);
	
	public int countAccountStaff(Account account);
}
