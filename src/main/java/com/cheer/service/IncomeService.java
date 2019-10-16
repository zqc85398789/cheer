package com.cheer.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheer.beans.Income;
import com.cheer.dao.inter.IIncomeDAO;

@Service
public class IncomeService {
	@Resource(name="incomeDAO")
	private IIncomeDAO incomeDAO;
	
	public boolean addRecord(Income income) {
		int row = incomeDAO.addIncome(income);
		return row>0?true:false;
	}
}
