package com.cheer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaffController {
	@RequestMapping("staffList.do")
	public String staffList() {
		return "staff_list";
	}
}
