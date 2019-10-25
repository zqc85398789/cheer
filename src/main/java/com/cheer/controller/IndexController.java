package com.cheer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheer.controller.base.BaseController;

@Controller
public class IndexController extends BaseController {
	//首页
	@RequestMapping("index.do")
	public String index() {
		return "index";
	}
}