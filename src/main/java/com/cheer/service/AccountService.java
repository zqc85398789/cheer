package com.cheer.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheer.beans.Account;
import com.cheer.beans.AccountPrivilege;
import com.cheer.mapper.AccountMapper;
import com.cheer.mapper.AccountPrivilegeMapper;

@Service
public class AccountService {
	@Resource(name="accountDAO")
	AccountMapper accountDAO;
	@Resource(name="accountPrivilegeDAO")
	AccountPrivilegeMapper accountPrivilegeDAO;
	
	public boolean createAccount(Account account,String privilegeId) {
		try {
			accountDAO.insertAccount(account);
			Integer accountId = accountDAO.queryAccounts(account).get(0).getId();
			AccountPrivilege accountPrivilege = new AccountPrivilege(accountId.toString(),privilegeId);
			accountPrivilege.setCreatedBy("admin");//此处暂时实写，实际应从session中获取用户
			accountPrivilegeDAO.insertAccountPrivilege(accountPrivilege);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
