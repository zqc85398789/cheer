package com.cheer.dao.inter;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.cheer.beans.Expense;

public interface IExpenseDAO {
	public int addExpense(Expense expense);

	public int deleteExpense(Integer id);

	public int updateExpense(Expense expense);

	public List<Expense> queryByDate(Date start,Date end) throws ParseException;
	
	public List<Expense> queryByItem(String keyword,Date start,Date end) throws ParseException;

	public List<Expense> queryAll() throws ParseException;
}
