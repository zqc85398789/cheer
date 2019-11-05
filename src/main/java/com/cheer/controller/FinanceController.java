package com.cheer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FinanceController {
	@RequestMapping("financePage.do")
	public String financePage() {
		return "finance_page";
	}
}
