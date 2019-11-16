package com.cheer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheer.controller.base.BaseController;

@Controller
public class CodeController extends BaseController{
	@RequestMapping("codeList.do")
	public String codeList() {
		return "code_list";
	}
}
