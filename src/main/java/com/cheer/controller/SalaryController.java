package com.cheer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SalaryController {
	@RequestMapping("salaryPage.do")
	public String salaryPage() {
		return "salary_page";
	}
}
