package com.cheer.dao.inter;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.cheer.beans.Income;

public interface IIncomeDAO {
	public int addIncome(Income income);

	public int deleteIncome(Integer id);

	public int updateIncome(Income income);

	public List<Income> queryByDate(Date start,Date end) throws ParseException;
	
	public List<Income> queryByItem(String keyword,Date start,Date end) throws ParseException;

	public List<Income> queryAll() throws ParseException;
}
