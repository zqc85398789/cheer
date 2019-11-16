package com.cheer.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheer.mybatis.mapper.IAccountMapper;
import com.cheer.mybatis.mapper.IAccountPrivilegeMapper;
import com.cheer.mybatis.model.IAccount;
import com.cheer.mybatis.model.IPrivilege;

@Service
public class LoginService {
	@Autowired
	IAccountMapper iAccountMapper;
	@Autowired
	IAccountPrivilegeMapper iAccountPrivilegeMapper;
	
	public boolean loginCheck(IAccount iAccount) {
		try {
			List<IAccount> list = iAccountMapper.queryAccounts(iAccount);
			if(list.size()==0) {
				return false;
			}
			IAccount queryAccount = list.get(0);
			if(queryAccount.getAccountPassword().equals(iAccount.getAccountPassword())) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public IPrivilege getPrivilege(IAccount iAccount) {
		IPrivilege iPrivilege = iAccountPrivilegeMapper.queryPrivilegeByIAccount(iAccount);
		return iPrivilege;
	}
}
