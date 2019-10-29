package com.cheer.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheer.beans.Account;
import com.cheer.beans.Privilege;
import com.cheer.mapper.AccountMapper;
import com.cheer.mapper.AccountPrivilegeMapper;

@Service
public class LoginService {
	@Resource(name="accountDAO")
	private AccountMapper accountDAO;
	
	@Resource(name="accountPrivilegeDAO")
	private AccountPrivilegeMapper accountPrivilegeDAO;
	
	public boolean loginCheck(Account account) {
		try {
			List<Account> list = accountDAO.queryAccounts(account);
			if(list.size()==0) {
				return false;
			}
			Account queryAccount = list.get(0);
			if(queryAccount.getAccountPassword().equals(account.getAccountPassword())) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Privilege getPrivilege(Account account) {
		Privilege privilege = accountPrivilegeDAO.queryPrivilegeByAccount(account).get(0);
		return privilege;
	}
}
