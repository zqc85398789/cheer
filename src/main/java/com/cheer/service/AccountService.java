package com.cheer.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheer.beans.Account;
import com.cheer.beans.AccountPrivilege;
import com.cheer.mapper.AccountMapper;
import com.cheer.mapper.AccountPrivilegeMapper;
import com.cheer.mapper.AccountStaffMapper;

@Service
public class AccountService {
	@Resource(name="accountDAO")
	AccountMapper accountDAO;
	@Resource(name="accountPrivilegeDAO")
	AccountPrivilegeMapper accountPrivilegeDAO;
	@Resource(name="accountStaffDAO")
	AccountStaffMapper accountStaffDAO;
	
	public boolean accountExists(Account account) {
		if(accountDAO.queryAccounts(account).size()>0) {
			return true;
		}
		return false;
	}
	
	public boolean createAccount(Account account,String privilegeId) {
		try {
			accountDAO.insertAccount(account);
			Integer accountId = accountDAO.queryAccounts(account).get(0).getId();
			AccountPrivilege accountPrivilege = new AccountPrivilege(accountId.toString(),privilegeId);
			accountPrivilege.setCreatedBy(account.getCreatedBy());
			accountPrivilegeDAO.insertAccountPrivilege(accountPrivilege);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public Account queryAccountById(int id) {
		Account account = new Account();
		account.setId(id);
		List<Account> list = accountDAO.queryAccounts(account);
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	public boolean updateAccount(Account account, String privilegeId) {
		try {
			accountDAO.updateAccount(account);
			AccountPrivilege accountPrivilege = new AccountPrivilege(account.getId().toString(),privilegeId);
			accountPrivilege.setUpdateBy(account.getUpdateBy());
			accountPrivilegeDAO.updateAccountPrivilege(accountPrivilege);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Account> queryAccountStaff(Account account, int currentPage) {
		List<Account> list = accountStaffDAO.queryAccountStaff(account, currentPage);
		return list;
	}
	
	public int getMaxPage(Account account) {
		try {
			int row = accountStaffDAO.countAccountStaff(account);
			return row%5==0?(row/5):(row/5+1);
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
