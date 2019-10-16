package com.cheer.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cheer.beans.Expense;
import com.cheer.beans.Income;
import com.cheer.beans.User;
import com.cheer.service.ExpenseService;
import com.cheer.service.IncomeService;
import com.cheer.util.DateUtil;

@Controller
public class IncomeExpenseController {
	@Resource(name="incomeService")
	IncomeService incomeService;
	
	@Resource(name="expenseService")
	ExpenseService expenseService;

	@RequestMapping("incomePage.do")
	public String incomePage() {
		return "income";
	}
	
	@RequestMapping("income.do")
	public String income(HttpServletRequest request,HttpServletResponse response,HttpSession session,
			RedirectAttributes redirectAttributes) throws UnsupportedEncodingException, ParseException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("UTF-8");
		Income income=null;
		try {
			String item = (String) request.getParameter("item");
			String income_source = (String) request.getParameter("income_source");
			String expensed_by = (String) request.getParameter("expensed_by");
			Date expensed_time = DateUtil.dateParse((String) request.getParameter("expensed_time"), DateUtil.DATEMINUTE_PATTERN);
			BigDecimal amount = new BigDecimal((String) request.getParameter("amount"));
			income = new Income(item, income_source, expensed_by, amount, expensed_time);
			income.setCreate_by(((User)session.getAttribute("loginUser")).getUsername());
			income.setCreate_time(DateUtil.currentTime());
		}catch(Exception e) {
			request.setAttribute("income", income);
			request.setAttribute("expense_msg", "添加失败，请检查是否有错误项");
			return "income";
		}
		if(incomeService.addRecord(income)) {
			redirectAttributes.addFlashAttribute("expense_msg","添加记录成功");
			return "redirect:incomePage.do";
		}
		else {
			request.setAttribute("income", income);
			request.setAttribute("expense_msg", "添加失败，请检查是否有错误项");
			return "income";
		}
	}
	
	
	@RequestMapping("expensePage.do")
	public String expensePage() {
		return "expense";
	}
	
	@RequestMapping("expense.do")
	public String expense(HttpServletRequest request,HttpServletResponse response,HttpSession session,
			RedirectAttributes redirectAttributes) throws UnsupportedEncodingException, ParseException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("UTF-8");
		Expense expense=null;
		try {
			String item = (String) request.getParameter("item");
			String expensed_to = (String) request.getParameter("expensed_to");
			String expensed_by = (String) request.getParameter("expensed_by");
			Date expensed_time = DateUtil.dateParse((String) request.getParameter("expensed_time"), DateUtil.DATEMINUTE_PATTERN);
			BigDecimal amount = new BigDecimal((String) request.getParameter("amount"));
			expense = new Expense(item, expensed_to, expensed_by, amount, expensed_time);
			expense.setCreate_by(((User)session.getAttribute("loginUser")).getUsername());
			expense.setCreate_time(DateUtil.currentTime());
		}catch(Exception e) {
			request.setAttribute("expense", expense);
			request.setAttribute("expense_msg", "添加失败，请检查是否有错误项");
			return "expense";
		}
		if(expenseService.addRecord(expense)) {
			redirectAttributes.addFlashAttribute("expense_msg","添加记录成功");
			return "redirect:expensePage.do";
		}
		else {
			request.setAttribute("expense", expense);
			request.setAttribute("expense_msg", "添加失败，请检查是否有错误项");
			return "expense";
		}
	}
}
