package com.cheer.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cheer.beans.Account;
import com.cheer.beans.AccountStaff;
import com.cheer.beans.Staff;
import com.cheer.dao.base.BaseDAO;
import com.cheer.mapper.AccountStaffMapper;

@Repository("accountStaffDAO")
public class AccountStaffDAOImpl extends BaseDAO implements AccountStaffMapper{

	@Override
	public List<Account> queryAccountStaff(Account account,int currentPage) {
		String sql = "select a.id,a.account_name,a.created_by,a.created_time,a.update_by,a.update_time,s.staff_name,s.empno from i_account a join i_account_staff ast on a.id = ast.account_id join i_staff s "
				+ "on ast.staff_id = s.id where a.account_name like ? and s.staff_name like ? and s.empno like ? limit ?,?";
		int start = 5*(currentPage-1);
		int quantity = 5;
		List<Map<String,Object>> queryList = getJdbcTemplate().queryForList(sql,new Object[] {"%"+account.getAccountName()+"%",
				"%"+account.getStaff().getStaffName()+"%","%"+account.getStaff().getEmpno()+"%",start,quantity});
		List<Account> accounts = new ArrayList<Account>();
		for(Map<String,Object> row:queryList) {
			Account ac = new Account();
			ac.setId((Integer)row.get("id"));
			ac.setAccountName((String)row.get("account_name"));
			ac.setCreatedBy((String)row.get("created_by"));
			ac.setCreatedTime((Date)row.get("created_time"));
			ac.setUpdateBy((String)row.get("update_by"));
			ac.setUpdateTime((Date)row.get("update_time"));
			Staff staff = new Staff();
			staff.setStaffName((String)row.get("staff_name"));
			staff.setEmpno((String)row.get("empno"));
			ac.setStaff(staff);
			accounts.add(ac);
		}
		return accounts;
	}

	@Override
	public int countAccountStaff(Account account) {
		String sql = "select count(a.id) as count from i_account a join i_account_staff ast on a.id = ast.account_id join i_staff s "
				+ "on ast.staff_id = s.id where a.account_name like ? and s.staff_name like ? and s.empno like ?";
		List<Map<String,Object>> queryList = getJdbcTemplate().queryForList(sql,new Object[] {"%"+account.getAccountName()+"%",
				"%"+account.getStaff().getStaffName()+"%","%"+account.getStaff().getEmpno()+"%"});
		long count = (Long)queryList.get(0).get("count");
		return (int)count;
	}

	@Override
	public int insertAccountStaff(AccountStaff accountStaff) {
		String sql = "insert into i_account_staff (account_id,staff_id,created_by,created_time) values"
				+ "(?,?,?,now())";
		int row = getJdbcTemplate().update(sql,new Object[] {accountStaff.getAccountId(),accountStaff.getStaffId(),
				accountStaff.getCreatedBy()});
		return row;
	}

}
