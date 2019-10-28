package com.cheer.dao.impl;

import org.springframework.stereotype.Repository;

import com.cheer.beans.AccountPrivilege;
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
		// TODO Auto-generated method stub
		return 0;
	}

}
