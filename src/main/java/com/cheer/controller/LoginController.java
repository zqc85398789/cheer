package com.cheer.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cheer.beans.Account;
import com.cheer.beans.Privilege;
import com.cheer.service.LoginService;

@Controller
public class LoginController {
	@Resource(name="loginService")
	private LoginService loginService;
	
	
	@ModelAttribute
	public void setEncoding(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;utf-8");
	}
	
	@RequestMapping("loginPage.do")
	public String loginPage(@ModelAttribute("account") Account account) {
		return "login";
	}
	
	@RequestMapping("login.do")
	public String login(@ModelAttribute("account") Account account,Model model,HttpSession session,RedirectAttributes redirect) {
		if(loginService.loginCheck(account)) {
			Privilege privilege = loginService.getPrivilege(account);
			session.setAttribute("loginAccount", account);
			session.setAttribute("loginPrivilege", privilege);
			return "redirect:homePage.do";
		}
		model.addAttribute("login_msg","登陆失败，请检查账户密码后重试");
		return "login";
	}
}
