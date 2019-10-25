package com.cheer.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cheer.beans.User;
import com.cheer.service.LoginRegistService;
import com.cheer.util.DateUtil;

@Controller
public class LoginRegistController {
	
	private static Logger logger = Logger.getLogger(LoginRegistController.class);
	
	@Resource(name="loginRegistService")
	private LoginRegistService loginRegistService;
	
	@ModelAttribute
	public void setEncoding(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("UTF-8");
	}
	
	@RequestMapping("loginPage.do")
	public String loginPage(@ModelAttribute("user")User user,HttpSession session) {
		if(session.getAttribute("loginUser")!=null) {
			return "index";
		}
		return "login";
	}
	
	@RequestMapping("login.do")
	public String login(@ModelAttribute("user")User user,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws UnsupportedEncodingException {
		if(loginRegistService.loginCheck(user)) {
			session.setAttribute("loginUser", user);
			return "redirect:index.do";
		}
		request.setAttribute("login_msg", "登录信息不正确，请检查后重试");
		logger.info("用户登录失败");
		return "login";
	}

	@RequestMapping("registPage.do")
	public String registPage(@ModelAttribute("user")User user) {
		return "regist";
	}
	
	@RequestMapping("regist.do")
	public String regist(@ModelAttribute("user") @Valid User user,BindingResult bindResult,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes) throws UnsupportedEncodingException, ParseException {
		if(bindResult.hasErrors()) {
			return "regist";
		}
		if(loginRegistService.registCheck(user)) {
			redirectAttributes.addFlashAttribute("login_msg","注册成功，请登录");
			return "redirect:loginPage.do";
		}
		request.setAttribute("user", user);
		request.setAttribute("msg", "该账号已经存在");
		return "regist";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		if(session.getAttribute("loginUser")!=null){
			session.removeAttribute("loginUser");
		}
		return "redirect:loginPage.do";
	}
}
