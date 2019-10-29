package com.cheer.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cheer.beans.Account;
import com.cheer.beans.AccountPrivilege;
import com.cheer.beans.Privilege;
import com.cheer.dao.base.BaseDAO;
import com.cheer.mapper.AccountPrivilegeMapper;
import com.cheer.util.DateUtil;

@Repository("accountPrivilegeDAO")
public class AccountPrivilegeDAOImpl extends BaseDAO implements AccountPrivilegeMapper{

	@Override
	public int insertAccountPrivilege(AccountPrivilege accountPrivilege) {
		String sql = "insert into i_account_privilege (account_id,privilege_id,created_by,created_time) values(?,?,?,?)";
		int row = getJdbcTemplate().update(sql,new Object[] {accountPrivilege.getAccountId(),accountPrivilege.getPrivilegeId(),
				accountPrivilege.getCreatedBy(),DateUtil.dateFormat(DateUtil.currentTime(), DateUtil.DATETIME_PATTERN)});
		return row;
	}

	@Override
	public int updateAccountPrivilege(AccountPrivilege accountPrivilege) {
		return 0;
	}

	@Override
	public List<Privilege> queryPrivilegeByAccount(Account account) {
		String sql = "select p.privilege_name, p.privilege_url from i_privilege p join i_account_privilege ap"
				+ " on p.id = ap.privilege_id join i_account a "
				+ "on a.id = ap.account_id where a.account_name = ?";
		List<Map<String,Object>> queryList = getJdbcTemplate().queryForList(sql,new Object[] {account.getAccountName()});
		List<Privilege> list = new ArrayList<Privilege>();
		for(Map<String,Object> row:queryList) {
			String privilegeName = (String) row.get("privilege_name");
			String privilegeUrl = (String) row.get("privilege_url");
			Privilege privilege = new Privilege();
			privilege.setPrivilegeName(privilegeName);
			privilege.setPrivilegeUrl(privilegeUrl);
			list.add(privilege);
		}
		return list;
	}

}
