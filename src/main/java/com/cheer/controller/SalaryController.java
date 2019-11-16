package com.cheer.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cheer.controller.base.BaseController;
import com.cheer.mybatis.model.IAccount;
import com.cheer.mybatis.model.ISalary;
import com.cheer.service.SalaryService;

@Controller
@RequestMapping("/salary")
public class SalaryController extends BaseController{
	@Autowired
	SalaryService salaryService;
	
	
	@ModelAttribute
	public void setEncoding(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
	}
	
	@RequestMapping("salaryPage.do")
	public String salaryPage(@ModelAttribute("iSalary") ISalary iSalary,Model model) {
		model.addAttribute("max_page",0);
		return "salary_list";
	}
	
	@RequestMapping("querySalary.do")
	public String querySalary(@ModelAttribute("iSalary") ISalary iSalary,@RequestParam int queryPage,Model model) {
		if(iSalary.getSalaryYear()==null || "".equals(iSalary.getSalaryYear())) {
			model.addAttribute("param_error","请输入年份");
			return "salary_list";
		}
		List<ISalary> iSalaryList = salaryService.querySalary(iSalary,queryPage);
		if(iSalaryList.size()==0) {
			model.addAttribute("max_page",0);
			return "salary_list";
		}
		int maxPage = salaryService.getMaxPage(iSalary);
		model.addAttribute("iSalaryList",iSalaryList);
		model.addAttribute("max_page",maxPage);
		model.addAttribute("current_page",queryPage);
		return "salary_list";
	}
	
	@RequestMapping("updateSalaryPage.do/{id}.do")
	public String updateSalary(@PathVariable int id,Model model) {
		ISalary iSalary = salaryService.queryISalaryById(id);
		model.addAttribute("iSalary",iSalary);
		return "salary_update";
	}

	@RequestMapping("updateSalary.do")
	public String updateAccount(@ModelAttribute("iSalary")ISalary iSalary,
			Model model, HttpSession session) {
		// 获取当前登录账户名
		iSalary.setUpdateBy(((IAccount) session.getAttribute("loginAccount")).getAccountName());
		// 修改信息
		if (salaryService.updateSalary(iSalary)) {
			model.addAttribute("salary_update_msg", "修改成功");
			return "salary_update";
		}
		model.addAttribute("salary_update_msg", "修改失败，请检查后重试");
		return "salary_update_msg";
	}
	
	
	@RequestMapping("createSalaryPage.do")
	public String createSalaryPage(@ModelAttribute("iSalary") ISalary iSalary) {
		return "salary_create";
	}
	
	@RequestMapping("createSalary.do")
	public String createAccount(@ModelAttribute("iSalary") @Valid ISalary iSalary, BindingResult br,
			 Model model, HttpSession session) {
		// 信息校验
		if (br.hasErrors()) {
			model.addAttribute("salary_create_msg", "新增记录失败，请检查后重试");
			return "salary_create";
		}
		// 检查条目是否重复
		if (salaryService.recordExists(iSalary)) {
			model.addAttribute("salary_create_msg", "新增记录失败，已存在对应记录");
			return "salary_create";
		}
		// 获取当前登录账户名
		iSalary.setCreatedBy(((IAccount) session.getAttribute("loginAccount")).getAccountName());
		// 尝试创建账号
		if (salaryService.createSalary(iSalary)) {
			model.addAttribute("salary_create_msg", "记录添加成功");
			return "salary_create";
		}
		model.addAttribute("salary_create_msg", "新增记录失败，请检查后重试");
		return "salary_create";
	}
}
