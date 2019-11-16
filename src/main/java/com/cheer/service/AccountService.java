package com.cheer.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheer.mybatis.mapper.IAccountMapper;
import com.cheer.mybatis.mapper.IAccountPrivilegeMapper;
import com.cheer.mybatis.model.IAccount;
import com.cheer.mybatis.model.IAccountPrivilege;

@Service
public class AccountService {
	@Autowired
	IAccountMapper iAccountMapper;
	@Autowired
	IAccountPrivilegeMapper iAccountPrivilegeMapper;
	
	public boolean accountExists(IAccount iAccount) {
		if(iAccountMapper.queryAccounts(iAccount).size()!=0) {
			return true;
		}
		return false;
	}
	
	public boolean empnoExists(IAccount iAccount) {
		List<IAccount> list = iAccountMapper.queryAccountsByEmpno(iAccount);
		if(list.size()>0) {
			//若更新时，根据empno查到的记录是其本身，不干涉修改
			if(list.get(0).getId().equals(iAccount.getId())) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	public boolean createAccount(IAccount iAccount,Integer privilegeId) {
		try {
			iAccountMapper.insert(iAccount);
			int accountId = iAccount.getId();
			IAccountPrivilege iAccountPrivilege = new IAccountPrivilege();
			iAccountPrivilege.setAccountId(accountId);
			iAccountPrivilege.setPrivilegeId(privilegeId);
			iAccountPrivilege.setCreatedBy(iAccount.getCreatedBy());
			iAccountPrivilegeMapper.insert(iAccountPrivilege);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public IAccount queryAccountById(int id) {
		IAccount iAccount = iAccountMapper.selectByPrimaryKey(id);
		return iAccount;
	}

	public boolean updateAccount(IAccount iAccount, Integer privilegeId) {
		try {
			iAccountMapper.updateByPrimaryKey(iAccount);
			IAccountPrivilege iAccountPrivilege = new IAccountPrivilege();
			iAccountPrivilege.setAccountId(iAccount.getId());
			iAccountPrivilege.setPrivilegeId(privilegeId);
			iAccountPrivilege.setUpdateBy(iAccount.getUpdateBy());
			iAccountPrivilegeMapper.updateAccountPrivilege(iAccountPrivilege);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<IAccount> queryIAccount(IAccount iAccount, int currentPage) {
		int quantity = 5;
		int start = quantity*(currentPage-1);
		List<IAccount> list = iAccountMapper.queryIAccountInPage(iAccount, start,quantity);
		return list;
	}
	
	public int getMaxPage(IAccount iAccount) {
		try {
			int quantity = 5;
			int row = iAccountMapper.countIAccount(iAccount).intValue();
			return row%quantity==0?(row/quantity):(row/quantity+1);
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public boolean deleteAccount(int id) {
		int row = iAccountMapper.deleteByPrimaryKey(id);
		return row>0;
	}

}
