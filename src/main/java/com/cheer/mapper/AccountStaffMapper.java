package com.cheer.mapper;

import java.util.List;

import com.cheer.beans.Account;
import com.cheer.beans.AccountStaff;

public interface AccountStaffMapper {
	public int insertAccountStaff(AccountStaff accountStaff);
	
	public List<Account> queryAccountStaff(Account account,int currentPage);
	
	public int countAccountStaff(Account account);
}
