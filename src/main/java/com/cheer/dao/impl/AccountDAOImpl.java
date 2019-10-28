package com.cheer.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.cheer.beans.Account;
import com.cheer.dao.base.BaseDAO;
import com.cheer.mapper.AccountMapper;

@Repository("accountDAO")
public class AccountDAOImpl extends BaseDAO implements AccountMapper{

	@Override
	public int insertAccount(Account account) {
		String sql = "insert into i_account (account_name,account_password,created_by,created_time) values(?,?,?,?)";
		int row = getJdbcTemplate().update(sql,new Object[] {account.getAccountName(),account.getAccountPassword(),
				account.getCreatedBy(),account.getCreatedTimeAsStr()});
		return row;
	}

	@Override
	public int updateAccount(Account account) {
		String sql = "update i_account set account_password=?,update_by=?,update_time=?,version=version+1 where id=?";
		int row = getJdbcTemplate().update(sql,new Object[] {account.getAccountPassword(),account.getUpdateBy(),
				account.getUpdateTime(),account.getId()});
		return row;
	}

	@Override
	public List<Account> queryAccounts(Account account) {
		String sql = "select id,account_name,account_password,created_by,created_time,update_by,update_time,version from"
				+ " i_account where 1=1 and";
		if(!StringUtils.isEmpty(account.getAccountName())) {
			sql = sql + " account_name=?";
		}
		List<Map<String,Object>> result = getJdbcTemplate().queryForList(sql,new Object[] {account.getAccountName()});
		List<Account> accounts = new ArrayList<Account>();
		for(Map<String,Object> row:result) {
			Integer id = (Integer) row.get("id");
			String accountName = (String) row.get("account_name");
			String accountPassword = (String) row.get("account_password");
			String createdBy = (String) row.get("created_by");
			Date createdTime = (Date) row.get("created_time");
			String updateBy = (String) row.get("update_by");
			Date updateTime = (Date) row.get("update_time");
			Integer version = (Integer) row.get("version");
			Account ac = new Account();
			ac.setId(id);
			ac.setAccountName(accountName);
			ac.setAccountPassword(accountPassword);
			ac.setCreatedBy(createdBy);
			ac.setCreatedTime(createdTime);
			ac.setUpdateBy(updateBy);
			ac.setUpdateTime(updateTime);
			ac.setVersion(version);
			accounts.add(ac);
		}
		return accounts;
	}
	
}
