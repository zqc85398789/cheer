package com.cheer.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheer.controller.base.BaseController;

@Controller
public class IndexController extends BaseController {
	//首页
	@RequestMapping("homePage.do")
	public String index() {
		return "home_page";
	}
	
	@RequestMapping("404.do")
	public String missPage() {
		return "error/404";
	}
	
}
