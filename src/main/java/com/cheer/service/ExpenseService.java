package com.cheer.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cheer.beans.Expense;
import com.cheer.dao.inter.IExpenseDAO;

@Service
public class ExpenseService {
	@Resource(name="expenseDAO")
	private IExpenseDAO expenseDAO;
	
	public boolean addRecord(Expense expense) {
		int row = expenseDAO.addExpense(expense);
		return row>0?true:false;
	}
}
