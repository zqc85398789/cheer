package com.cheer.mapper;

import java.util.List;

import com.cheer.beans.Account;
import com.cheer.beans.AccountPrivilege;
import com.cheer.beans.Privilege;

public interface AccountPrivilegeMapper {
	public int insertAccountPrivilege(AccountPrivilege accountPrivilege);
	
	public int updateAccountPrivilege(AccountPrivilege accountPrivilege);
	
	public List<Privilege> queryPrivilegeByAccount(Account account);
}
