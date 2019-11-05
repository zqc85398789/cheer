package com.cheer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LaborHourController {
	@RequestMapping("laborHourList.do")
	public String laborHourList() {
		return "laborHour_list";
	}
}
