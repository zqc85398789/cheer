package com.cheer.dao.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cheer.beans.Expense;
import com.cheer.dao.base.BaseDAO;
import com.cheer.dao.inter.IExpenseDAO;
import com.cheer.util.DateUtil;

@Repository("expenseDAO")
public class ExpenseDAOImpl extends BaseDAO implements IExpenseDAO{

	@Override
	public int addExpense(Expense expense) {
		String sql = "insert into expense (item,expensed_to,expensed_by,expensed_time,amount,"
				+ "create_by,create_time) values(?,?,?,?,?,?,?)";
		int row = getJdbcTemplate().update(sql,new Object[] {expense.getItem(),expense.getExpensed_to(),expense.getExpensed_by(),
				DateUtil.dateFormat(expense.getExpensed_time(), DateUtil.DATETIME_PATTERN),expense.getAmount(),expense.getCreate_by(),
				DateUtil.dateFormat(expense.getCreate_time(), DateUtil.DATETIME_PATTERN)});
		return row;
	}

	@Override
	public int deleteExpense(Integer id) {
		String sql = "delete from expense where id=?";
		int row = getJdbcTemplate().update(sql,id);
		return row;
	}

	@Override
	public int updateExpense(Expense expense) {
		String sql = "update expense set item=?,expensed_to=?,expensed_by=?,expensed_time=?,amount=?,update_by=?,update_time=?,version=version+1 where id=?";
		int row = getJdbcTemplate().update(sql,new Object[] {expense.getItem(),expense.getExpensed_to(),expense.getExpensed_by(),DateUtil.dateFormat(expense.getExpensed_time(), DateUtil.DATETIME_PATTERN),
				expense.getAmount(),expense.getUpdate_by(),DateUtil.dateFormat(expense.getUpdate_time(), DateUtil.DATETIME_PATTERN),expense.getId()});
		return row;
	}

	@Override
	public List<Expense> queryByDate(Date start, Date end) throws ParseException {
		String sql = "select id,item,expensed_to,expensed_by,expensed_time,amount,create_by,create_time,update_by,update_time,version from expense where expensed_time between ? and ?";
		List<Map<String,Object>> queryList = getJdbcTemplate().queryForList(sql,new Object[] {DateUtil.dateFormat(start, DateUtil.DATETIME_PATTERN),DateUtil.dateFormat(end, DateUtil.DATETIME_PATTERN)});
		if(queryList.size()==0) {
			return null;
		}
		List<Expense> list = new ArrayList<Expense>();
		for(Map<String,Object> row:queryList) {
			Integer id = (Integer)row.get("id");
			String item = (String)row.get("item");
			String expensed_to = (String)row.get("expensed_to");
			String expensed_by = (String)row.get("expensed_by");
			Date expensed_time = DateUtil.dateParse((String)row.get("expensed_time"), DateUtil.DATETIME_PATTERN);
			BigDecimal amount = (BigDecimal)row.get("amount");
			String create_by = (String)row.get("create_by");
			Date create_time = DateUtil.dateParse((String)row.get("create_time"), DateUtil.DATETIME_PATTERN);
			String update_by = (String)row.get("update_by");
			Date update_time = DateUtil.dateParse((String)row.get("update_time"), DateUtil.DATETIME_PATTERN);
			Integer version = (Integer)row.get("version");
			Expense expense = new Expense(item, expensed_to, expensed_by, amount, expensed_time);
			expense.setId(id);
			expense.setCreate_by(create_by);
			expense.setCreate_time(create_time);
			expense.setUpdate_by(update_by);
			expense.setUpdate_time(update_time);
			expense.setVersion(version);
			list.add(expense);
		}
		return list;
	}

	@Override
	public List<Expense> queryByItem(String keyword, Date start, Date end) throws ParseException {
		String sql = "select id,item,expensed_to,expensed_by,expensed_time,amount,create_by,create_time,update_by,update_time,version from expense where expensed_time between ? and ? and item like ?";
		List<Map<String,Object>> queryList = getJdbcTemplate().queryForList(sql,new Object[] {DateUtil.dateFormat(start, DateUtil.DATETIME_PATTERN),DateUtil.dateFormat(end, DateUtil.DATETIME_PATTERN),"%"+keyword+"%"});
		if(queryList.size()==0) {
			return null;
		}
		List<Expense> list = new ArrayList<Expense>();
		for(Map<String,Object> row:queryList) {
			Integer id = (Integer)row.get("id");
			String item = (String)row.get("item");
			String expensed_to = (String)row.get("expensed_to");
			String expensed_by = (String)row.get("expensed_by");
			Date expensed_time = (Date)row.get("expensed_time");
			BigDecimal amount = (BigDecimal)row.get("amount");
			String create_by = (String)row.get("create_by");
			Date create_time = (Date)row.get("create_time");
			String update_by = (String)row.get("update_by");
			Date update_time = (Date)row.get("update_time");
			Integer version = (Integer)row.get("version");
			Expense expense = new Expense(item, expensed_to, expensed_by, amount, expensed_time);
			expense.setId(id);
			expense.setCreate_by(create_by);
			expense.setCreate_time(create_time);
			expense.setUpdate_by(update_by);
			expense.setUpdate_time(update_time);
			expense.setVersion(version);
			list.add(expense);
		}
		return list;
	}

	@Override
	public List<Expense> queryAll() throws ParseException {
		String sql = "select id,item,expensed_to,expensed_by,expensed_time,amount,"
				+ "create_by,create_time,update_by,update_time,version from expense where create_time between ? and ? and item like ?";
		List<Map<String,Object>> queryList = getJdbcTemplate().queryForList(sql);
		if(queryList.size()==0) {
			return null;
		}
		List<Expense> list = new ArrayList<Expense>();
		for(Map<String,Object> row:queryList) {
			Integer id = (Integer)row.get("id");
			String item = (String)row.get("item");
			String expensed_to = (String)row.get("expensed_to");
			String expensed_by = (String)row.get("expensed_by");
			Date expensed_time = DateUtil.dateParse((String)row.get("expensed_time"), DateUtil.DATETIME_PATTERN);
			BigDecimal amount = (BigDecimal)row.get("amount");
			String create_by = (String)row.get("create_by");
			Date create_time = DateUtil.dateParse((String)row.get("create_time"), DateUtil.DATETIME_PATTERN);
			String update_by = (String)row.get("update_by");
			Date update_time = DateUtil.dateParse((String)row.get("update_time"), DateUtil.DATETIME_PATTERN);
			Integer version = (Integer)row.get("version");
			Expense expense = new Expense(item, expensed_to, expensed_by, amount, expensed_time);
			expense.setId(id);
			expense.setCreate_by(create_by);
			expense.setCreate_time(create_time);
			expense.setUpdate_by(update_by);
			expense.setUpdate_time(update_time);
			expense.setVersion(version);
			list.add(expense);
		}
		return list;
	}

}
