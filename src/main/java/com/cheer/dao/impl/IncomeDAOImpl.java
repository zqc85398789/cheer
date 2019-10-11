package com.cheer.dao.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cheer.beans.Income;
import com.cheer.dao.base.BaseDAO;
import com.cheer.dao.inter.IIncomeDAO;
import com.cheer.util.DateUtil;

@Repository("incomeDAO")
public class IncomeDAOImpl extends BaseDAO implements IIncomeDAO{

	@Override
	public int addIncome(Income income) {
		String sql = "insert into income (item,income_source,received_by,received_time,amount,"
				+ "create_by,create_time) values(?,?,?,?,?,?,?)";
		int row = getJdbcTemplate().update(sql,new Object[] {income.getItem(),income.getIncome_source(),income.getReceived_by(),
				DateUtil.dateFormat(income.getReceived_time(), DateUtil.DATETIME_PATTERN),income.getAmount(),income.getCreate_by(),
				DateUtil.dateFormat(income.getCreate_time(), DateUtil.DATETIME_PATTERN)});
		return row;
	}

	@Override
	public int deleteIncome(Integer id) {
		String sql = "delete from income where id=?";
		int row = getJdbcTemplate().update(sql,id);
		return row;
	}

	@Override
	public int updateIncome(Income income) {
		String sql = "update income set item=?,income_source=?,received_by=?,received_time=?,amount=?,update_by=?,update_time=?,version=version+1 where id=?";
		int row = getJdbcTemplate().update(sql,new Object[] {income.getItem(),income.getIncome_source(),income.getReceived_by(),DateUtil.dateFormat(income.getReceived_time(), DateUtil.DATETIME_PATTERN),
				income.getAmount(),income.getUpdate_by(),DateUtil.dateFormat(income.getUpdate_time(), DateUtil.DATETIME_PATTERN),income.getId()});
		return row;
	}

	@Override
	public List<Income> queryByDate(Date start, Date end) throws ParseException {
		String sql = "select id,item,income_source,received_by,received_time,amount,create_by,create_time,update_by,update_time,version from income where received_time between ? and ?";
		List<Map<String,Object>> queryList = getJdbcTemplate().queryForList(sql,new Object[] {DateUtil.dateFormat(start, DateUtil.DATETIME_PATTERN),DateUtil.dateFormat(end, DateUtil.DATETIME_PATTERN)});
		if(queryList.size()==0) {
			return null;
		}
		List<Income> list = new ArrayList<Income>();
		for(Map<String,Object> row:queryList) {
			Integer id = (Integer)row.get("id");
			String item = (String)row.get("item");
			String income_source = (String)row.get("income_source");
			String received_by = (String)row.get("received_by");
			Date received_time = DateUtil.dateParse((String)row.get("received_time"), DateUtil.DATETIME_PATTERN);
			BigDecimal amount = (BigDecimal)row.get("amount");
			String create_by = (String)row.get("create_by");
			Date create_time = DateUtil.dateParse((String)row.get("create_time"), DateUtil.DATETIME_PATTERN);
			String update_by = (String)row.get("update_by");
			Date update_time = DateUtil.dateParse((String)row.get("update_time"), DateUtil.DATETIME_PATTERN);
			Integer version = (Integer)row.get("version");
			Income income = new Income(item, income_source, received_by, amount, received_time);
			income.setId(id);
			income.setCreate_by(create_by);
			income.setCreate_time(create_time);
			income.setUpdate_by(update_by);
			income.setUpdate_time(update_time);
			income.setVersion(version);
			list.add(income);
		}
		return list;
	}

	@Override
	public List<Income> queryByItem(String keyword, Date start, Date end) throws ParseException {
		String sql = "select id,item,income_source,received_by,received_time,amount,create_by,create_time,update_by,update_time,version from income where received_time between ? and ? and item like ?";
		List<Map<String,Object>> queryList = getJdbcTemplate().queryForList(sql,new Object[] {DateUtil.dateFormat(start, DateUtil.DATETIME_PATTERN),DateUtil.dateFormat(end, DateUtil.DATETIME_PATTERN),"%"+keyword+"%"});
		if(queryList.size()==0) {
			return null;
		}
		List<Income> list = new ArrayList<Income>();
		for(Map<String,Object> row:queryList) {
			Integer id = (Integer)row.get("id");
			String item = (String)row.get("item");
			String income_source = (String)row.get("income_source");
			String received_by = (String)row.get("received_by");
			Date received_time = (Date)row.get("received_time");
			BigDecimal amount = (BigDecimal)row.get("amount");
			String create_by = (String)row.get("create_by");
			Date create_time = (Date)row.get("create_time");
			String update_by = (String)row.get("update_by");
			Date update_time = (Date)row.get("update_time");
			Integer version = (Integer)row.get("version");
			Income income = new Income(item, income_source, received_by, amount, received_time);
			income.setId(id);
			income.setCreate_by(create_by);
			income.setCreate_time(create_time);
			income.setUpdate_by(update_by);
			income.setUpdate_time(update_time);
			income.setVersion(version);
			list.add(income);
		}
		return list;
	}

	@Override
	public List<Income> queryAll() throws ParseException {
		String sql = "select id,item,income_source,received_by,received_time,amount,"
				+ "create_by,create_time,update_by,update_time,version from income where create_time between ? and ? and item like ?";
		List<Map<String,Object>> queryList = getJdbcTemplate().queryForList(sql);
		if(queryList.size()==0) {
			return null;
		}
		List<Income> list = new ArrayList<Income>();
		for(Map<String,Object> row:queryList) {
			Integer id = (Integer)row.get("id");
			String item = (String)row.get("item");
			String income_source = (String)row.get("income_source");
			String received_by = (String)row.get("received_by");
			Date received_time = DateUtil.dateParse((String)row.get("received_time"), DateUtil.DATETIME_PATTERN);
			BigDecimal amount = (BigDecimal)row.get("amount");
			String create_by = (String)row.get("create_by");
			Date create_time = DateUtil.dateParse((String)row.get("create_time"), DateUtil.DATETIME_PATTERN);
			String update_by = (String)row.get("update_by");
			Date update_time = DateUtil.dateParse((String)row.get("update_time"), DateUtil.DATETIME_PATTERN);
			Integer version = (Integer)row.get("version");
			Income income = new Income(item, income_source, received_by, amount, received_time);
			income.setId(id);
			income.setCreate_by(create_by);
			income.setCreate_time(create_time);
			income.setUpdate_by(update_by);
			income.setUpdate_time(update_time);
			income.setVersion(version);
			list.add(income);
		}
		return list;
	}

}
