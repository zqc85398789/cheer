package com.cheer.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheer.beans.Account;
import com.cheer.beans.AccountPrivilege;
import com.cheer.beans.AccountStaff;
import com.cheer.beans.Staff;
import com.cheer.mapper.AccountMapper;
import com.cheer.mapper.AccountPrivilegeMapper;
import com.cheer.mapper.AccountStaffMapper;
import com.cheer.mapper.StaffMapper;
import com.cheer.util.DateUtil;

@Service
public class StaffService {
	@Resource(name="accountDAO")
	AccountMapper accountDAO;
	@Resource(name="accountPrivilegeDAO")
	AccountPrivilegeMapper accountPrivilegeDAO;
	@Resource(name="accountStaffDAO")
	AccountStaffMapper accountStaffDAO;
	@Resource(name="staffDAO")
	StaffMapper staffDAO;
	
/*	public boolean accountExists(Account account) {
		if(accountDAO.queryAccounts(account).size()>0) {
			return true;
		}
		return false;
	}
	
	public boolean createAccount(Account account,String privilegeId) {
		try {
			accountDAO.insertAccount(account);
			int accountId = accountDAO.lastInsertId();
			AccountPrivilege accountPrivilege = new AccountPrivilege(String.valueOf(accountId),privilegeId);
			accountPrivilege.setCreatedBy(account.getCreatedBy());
			accountPrivilegeDAO.insertAccountPrivilege(accountPrivilege);
			Staff staff = new Staff();
			staff.setCreatedBy(account.getCreatedBy());
			staff.setCreatedTime(DateUtil.currentTime());
			staffDAO.defaultInsert(staff);
			int staffId = staffDAO.lastInsertId();
			AccountStaff as = new AccountStaff();
			as.setAccountId(String.valueOf(accountId));
			as.setStaffId(String.valueOf(staffId));
			as.setCreatedBy(account.getCreatedBy());
			accountStaffDAO.insertAccountStaff(as);
		} catch (Exception e) {
			e.printStackTrace();
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
	}*/
	
	public int getMaxPage(Staff staff) {
		try {
			int row = staffDAO.countStaff(staff);
			return row%5==0?(row/5):(row/5+1);
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public List<Account> queryStaff(Staff staff, int queryPage) {
		// TODO Auto-generated method stub
		return null;
	}

}
