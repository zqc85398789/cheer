package com.cheer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VacateController {
	@RequestMapping("vacateList.do")
	public String vacateList() {
		return "vacate_list";
	}
}
