package com.cheer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {
	@RequestMapping("codeList.do")
	public String codeList() {
		return "code_list";
	}
}
